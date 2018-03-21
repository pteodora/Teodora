package pomodoro.controller;

import java.security.Principal;

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
public class TeamController {

    @Autowired
    private TeamService teamService;

    @RequestMapping(value = "/allTeams", method = RequestMethod.GET)
    public ResponseEntity<?> getAllTeams() {
        return new ResponseEntity<>(teamService.getAll(), HttpStatus.OK);
    }
    
    @RequestMapping(value = "/userTeams", method = RequestMethod.GET)
    public ResponseEntity<?> getUserTeams(Principal principal) {
        return new ResponseEntity<>(teamService.findUserTeams(principal), HttpStatus.OK);
    }

    @RequestMapping(value = "/selectedTeam/{teamId}", method = RequestMethod.GET)
    public ResponseEntity<?> getTeam(@PathVariable("teamId") Long teamId) {
        return new ResponseEntity<>(teamService.getById(teamId), HttpStatus.OK);
    }

    @RequestMapping(value = "/saveTeam", method = RequestMethod.POST)
    public ResponseEntity<?> saveTeam(@RequestBody TeamDto newTeam, Principal principal) {
        teamService.saveOrUpdate(newTeam, principal);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/inviteUser/{teamId}/{email}", method = RequestMethod.POST)
    public ResponseEntity<?> inviteUser(@PathVariable("teamId") Long teamId, @PathVariable("email") String email) {
        teamService.inviteUser(teamId, email);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/leaveTeam/{teamId}", method = RequestMethod.GET)
    public ResponseEntity<?> leaveTeam(@PathVariable Long teamId, Principal principal) {
        teamService.leaveTeam(teamId, principal);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @RequestMapping(value = "/deleteTeam/{teamId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteTeam(@PathVariable("teamId") Long teamId) {
        teamService.delete(teamId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
