package pomodoro.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pomodoro.dto.PomodoroDto;
import pomodoro.entity.Pomodoro;
import pomodoro.repository.PomodoroRepository;

@Service
public class PomodoroService {

    @Autowired
    private PomodoroRepository pomodoroRepository;

    @Transactional(readOnly = true)
    public List<PomodoroDto> getAll() {
        List<Pomodoro> pomodoros = pomodoroRepository.findAll();
        List<PomodoroDto> pomodorosDto = new ArrayList<>();
        pomodoros.stream().forEach(pomodoro -> {
            PomodoroDto pomodoroDto = new PomodoroDto();
            pomodoroDto.setPomId(pomodoro.getPomId());
            pomodoroDto.setName(pomodoro.getName());
            pomodoroDto.setEmail(pomodoro.getUser().getEmail());
            pomodorosDto.add(pomodoroDto);
        });
        return pomodorosDto;
    }

    @Transactional(readOnly = true)
    public PomodoroDto getById(Long pomId) {
        Pomodoro pomodoro = pomodoroRepository.findOne(pomId);
        PomodoroDto pomodoroDto = new PomodoroDto();
        pomodoroDto.setPomId(pomodoro.getPomId());
        pomodoroDto.setName(pomodoro.getName());
        pomodoroDto.setEmail(pomodoro.getUser().getEmail());
        return pomodoroDto;
    }

    @Transactional
    public Pomodoro saveOrUpdate(PomodoroDto pomodoroDto) {
        Pomodoro pomodoro = pomodoroRepository.findOne(pomodoroDto.getPomId());
        if (pomodoro == null) {
            pomodoro = new Pomodoro();
        }
        pomodoro.setPomId(pomodoroDto.getPomId());
        pomodoro.setName(pomodoroDto.getName());
        return pomodoroRepository.save(pomodoro);
    }

    @Transactional
    public void delete(Long pomId) {
        pomodoroRepository.delete(pomId);
    }

}
