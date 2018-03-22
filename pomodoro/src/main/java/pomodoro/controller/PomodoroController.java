package pomodoro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pomodoro.dto.PomodoroDto;
import pomodoro.service.PomodoroService;

@RestController
@RequestMapping("/pomodoros")
public class PomodoroController {

    @Autowired
    private PomodoroService pomodoroService;

    @RequestMapping(value = "/getPomodoros", method = RequestMethod.GET)
    public ResponseEntity<?> getAllPomodoros() {
        return new ResponseEntity<>(pomodoroService.getAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/getPomodoro/{pomId}", method = RequestMethod.GET)
    public ResponseEntity<?> getPomodoro(@PathVariable("pomId") Long pomId) {
        return new ResponseEntity<>(pomodoroService.getById(pomId), HttpStatus.OK);
    }

    @RequestMapping(value = "/savePomodoro", method = RequestMethod.POST)
    public ResponseEntity<?> savePomodoro(@RequestBody PomodoroDto pomodoroDto) {
        pomodoroService.saveOrUpdate(pomodoroDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/deletePomodoro/{pomId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deletePomodoro(@PathVariable("pomId") Long pomId) {
        pomodoroService.delete(pomId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
