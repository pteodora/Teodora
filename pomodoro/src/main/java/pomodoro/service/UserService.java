package pomodoro.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pomodoro.entity.User;
import pomodoro.repository.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    public User save(User user){
        return userRepository.save(user);
    }
    
    public User getById(Serializable id){
        return userRepository.findOne((int)id);
    }
    
    public List<User> getAll(){
        return userRepository.findAll();
    }
    
    public void delete(Serializable id){
        userRepository.delete((int) id);
    }
}