package pomodoro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pomodoro.dto.TeamDto;
import pomodoro.service.TeamService;

@RestController
@RequestMapping("/teams")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getAllTeams() {
        return new ResponseEntity<>(teamService.getAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{teamId}", method = RequestMethod.GET)
    public ResponseEntity<?> getTeam(@PathVariable("teamId") Long teamId) {
        return new ResponseEntity<>(teamService.getById(teamId), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> saveTeam(@RequestBody TeamDto teamDto) {
        teamService.saveOrUpdate(teamDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/{teamId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteTeam(@PathVariable("teamId") Long teamId) {
        teamService.delete(teamId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
