package pomodoro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pomodoro.dto.TaskDTO;
import pomodoro.service.TaskService;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    TaskService taskService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getAllTasks() {
        return new ResponseEntity<>(taskService.getAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{taskID}", method = RequestMethod.GET)
    public ResponseEntity<?> getTask(int taskID) {
        return new ResponseEntity<>(taskService.getById(taskID), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> saveTask(@RequestBody TaskDTO taskDTO) {
        taskService.saveOrUpdate(taskDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/{taskID}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteTask(@PathVariable("taskID") int taskID) {
        taskService.delete(taskID);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
