package pomodoro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pomodoro.service.TeamService;

@RestController
@RequestMapping("/teams")
public class TeamController {
    
    @Autowired
    TeamService teamService;
    
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getAllTeams() {
        return new ResponseEntity<>(teamService.getAll(), HttpStatus.OK);
    }
    
}
