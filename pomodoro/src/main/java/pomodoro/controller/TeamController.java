package pomodoro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pomodoro.dto.TeamDTO;
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

    @RequestMapping(value = "/{teamID}", method = RequestMethod.GET)
    public ResponseEntity<?> getTeam(@PathVariable("teamID") int teamID) {
        return new ResponseEntity<>(teamService.getById(teamID), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> saveTeam(@RequestBody TeamDTO team) {
        teamService.saveOrUpdate(team);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @RequestMapping(value = "/{teamID}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteTeam(@PathVariable("teamID") int teamID){
        teamService.delete(teamID);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
