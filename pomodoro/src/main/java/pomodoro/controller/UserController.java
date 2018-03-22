package pomodoro.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pomodoro.service.UserService;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public Map<String, String> getUser(Principal principal) {
        @SuppressWarnings("unchecked")
        Map<String, String> details = (Map<String, String>) ((OAuth2Authentication) principal).getUserAuthentication()
                .getDetails();
        Map<String, String> user = new HashMap<>();
        user.put("email", details.get("email"));
        user.put("firstName", details.get("given_name"));
        user.put("lastName", details.get("family_name"));

        return user;
    }

    @RequestMapping(value = "/allUsers", method = RequestMethod.GET)
    public ResponseEntity<?> getAllUsers() {
        return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
    }

}