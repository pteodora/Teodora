package pomodoro.controller;

import java.security.Principal;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
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
    
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/userTeams", method = RequestMethod.GET)
    public ResponseEntity<?> getUserTeams(Principal principal) {
        Map<String, String> details = (Map<String, String>) ((OAuth2Authentication) principal).getUserAuthentication()
                .getDetails();
        String email = details.get("email");
        return new ResponseEntity<>(teamService.findUserTeams(email), HttpStatus.OK);
    }

    @RequestMapping(value = "/selectedTeam/{teamId}", method = RequestMethod.GET)
    public ResponseEntity<?> getTeam(@PathVariable("teamId") Long teamId) {
        return new ResponseEntity<>(teamService.getById(teamId), HttpStatus.OK);
    }

    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/saveTeam", method = RequestMethod.POST)
    public ResponseEntity<?> saveTeam(@RequestBody TeamDto newTeam, Principal principal) {
        Map<String, String> details = (Map<String, String>) ((OAuth2Authentication) principal).getUserAuthentication()
                .getDetails();
        String email = details.get("email");
        teamService.saveOrUpdate(newTeam, email);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/inviteUser/{teamId}/{email}", method = RequestMethod.POST)
    public ResponseEntity<?> inviteUser(@PathVariable("teamId") Long teamId, @PathVariable("email") String email) {
        teamService.inviteUser(teamId, email);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/leaveTeam/{teamId}", method = RequestMethod.GET)
    public ResponseEntity<?> leaveTeam(@PathVariable Long teamId, Principal principal) {
        Map<String, String> details = (Map<String, String>) ((OAuth2Authentication) principal).getUserAuthentication()
                .getDetails();
        String email = details.get("email");
        teamService.leaveTeam(teamId, email);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @RequestMapping(value = "/deleteTeam/{teamId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteTeam(@PathVariable("teamId") Long teamId) {
        teamService.delete(teamId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
