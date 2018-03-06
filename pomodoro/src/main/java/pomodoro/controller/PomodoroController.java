package pomodoro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pomodoro.dto.PomodoroDTO;
import pomodoro.service.PomodoroService;

@RestController
@RequestMapping("/pomodoros")
public class PomodoroController {

    @Autowired
    PomodoroService pomodoroService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getAllPomodoros() {
        return new ResponseEntity<>(pomodoroService.getAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{pomID}", method = RequestMethod.GET)
    public ResponseEntity<?> getPomodoro(@PathVariable("pomID") int pomID) {
        return new ResponseEntity<>(pomodoroService.getById(pomID),
                HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> savePomodoro(@RequestBody PomodoroDTO pomodoroDTO) {
        pomodoroService.saveOrUpdate(pomodoroDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/{pomID}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deletePomodoro(@PathVariable("pomID") int pomID) {
        pomodoroService.delete(pomID);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
