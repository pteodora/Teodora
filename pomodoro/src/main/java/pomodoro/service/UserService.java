package pomodoro.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pomodoro.dto.UserDTO;
import pomodoro.entity.User;
import pomodoro.repository.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    @Transactional
    public User saveOrUpdate(UserDTO userDTO){
        User user = userRepository.findOne(userDTO.getEmail());
        if(user == null) {
            user = new User();
        }
        user.setEmail(userDTO.getEmail());
        user.setfName(userDTO.getfName());
        user.setlName(userDTO.getlName());
        return userRepository.save(user);
    }
    
    @Transactional(readOnly = true )
    public UserDTO getById(String email){
        User user =  userRepository.findOne(email);
        UserDTO userDTO = new UserDTO();
        userDTO.setEmail(user.getEmail());
        userDTO.setfName(user.getfName());
        userDTO.setlName(user.getlName());
        return userDTO;
    }
    
    @Transactional(readOnly = true )
    public List<UserDTO> getAll(){
        List<User> users = userRepository.findAll();
        List<UserDTO> usersDTO = new ArrayList<UserDTO>();
        for (User user : users) {
            UserDTO userDTO = new UserDTO();
            userDTO.setEmail(user.getEmail());
            userDTO.setfName(user.getfName());
            userDTO.setlName(user.getlName());
            usersDTO.add(userDTO);
        }
        return usersDTO;
    }
    
    public void delete(String email){
        userRepository.delete(email);
    }
}