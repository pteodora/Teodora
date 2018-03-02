package pomodoro.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pomodoro.dto.UserDTO;
import pomodoro.entity.User;
import pomodoro.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
    
    @Autowired
    UserService userService;
    
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<User> addUser(@RequestBody User user){
        userService.save(user);
        return new ResponseEntity<User>(user, HttpStatus.CREATED);
    }
    
    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Void> updateUser(@RequestBody User user){
        User existingUser = userService.getById(user.getEmail());
        if (existingUser == null) {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        } else {
            userService.save(user);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
    }
    @Transactional
    @RequestMapping(value = "/{email}", method = RequestMethod.GET) 
    public ResponseEntity<User> getUser(@PathVariable("email") Long id) {
        User user = userService.getById(id);
        if (user == null) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
    @Transactional(readOnly = true)
    @RequestMapping(method = RequestMethod.GET)
    public List<UserDTO> getAllUsers(){
        List<User> userDB = userService.getAll();
        List<UserDTO> userDTO = new ArrayList<>();

        for(User u: userDB) {
            UserDTO ud = new UserDTO();
            ud.setEmail(u.getEmail());
            ud.setfName(u.getfName());
            ud.setlName(u.getlName());
            userDTO.add(ud);
        }
        return userDTO;
    }
    
    @RequestMapping(value = "/{email}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteUser(@PathVariable("email") Long id) {
        User user = userService.getById(id);
        if (user == null) {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        } else {
            userService.delete(id);
            return new ResponseEntity<Void>(HttpStatus.GONE);
        }
    }
}