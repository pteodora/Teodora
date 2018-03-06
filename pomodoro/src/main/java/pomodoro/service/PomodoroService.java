package pomodoro.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pomodoro.dto.PomodoroDTO;
import pomodoro.entity.Pomodoro;
import pomodoro.repository.PomodoroRepository;

@Service
public class PomodoroService {

    @Autowired
    private PomodoroRepository pomodoroRepository;

    @Transactional(readOnly = true)
    public List<PomodoroDTO> getAll() {
        List<Pomodoro> pomodoros = pomodoroRepository.findAll();
        List<PomodoroDTO> pomodorosDTO = new ArrayList<PomodoroDTO>();
        for (Pomodoro pomodoro : pomodoros) {
            PomodoroDTO pomodoroDTO = new PomodoroDTO();
            pomodoroDTO.setPomID(pomodoro.getPomID());
            pomodoroDTO.setpName(pomodoro.getpName());
            pomodorosDTO.add(pomodoroDTO);
        }
        return pomodorosDTO;
    }

    @Transactional(readOnly = true)
    public PomodoroDTO getById(int pomID) {
        Pomodoro pomodoro = pomodoroRepository.findOne(pomID);
        PomodoroDTO pomodoroDTO = new PomodoroDTO();
        pomodoroDTO.setPomID(pomodoro.getPomID());
        pomodoroDTO.setpName(pomodoro.getpName());
        return pomodoroDTO;
    }

    @Transactional
    public Pomodoro saveOrUpdate(PomodoroDTO pomodoroDTO) {
        Pomodoro pomodoro = pomodoroRepository.findOne(pomodoroDTO.getPomID());
        if (pomodoro == null) {
            pomodoro = new Pomodoro();
        }
        pomodoro.setPomID(pomodoroDTO.getPomID());
        pomodoro.setpName(pomodoroDTO.getpName());
        return pomodoroRepository.save(pomodoro);
    }

    @Transactional
    public void delete(int pomID) {
        pomodoroRepository.delete(pomID);
    }

}
