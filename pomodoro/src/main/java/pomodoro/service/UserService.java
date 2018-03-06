package pomodoro.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pomodoro.dto.UserDto;
import pomodoro.entity.User;
import pomodoro.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional(readOnly = true)
    public List<UserDto> getAll() {
        List<User> users = userRepository.findAll();
        List<UserDto> usersDto = new ArrayList<UserDto>();
        users.stream().forEach(user -> {
            UserDto userDto = new UserDto();
            userDto.setEmail(user.getEmail());
            userDto.setFirstName(user.getFirstName());
            userDto.setLastName(user.getLastName());
            usersDto.add(userDto);
        });
        return usersDto;
    }

    @Transactional(readOnly = true)
    public UserDto getById(String email) {
        User user = userRepository.findOne(email);
        UserDto userDto = new UserDto();
        userDto.setEmail(user.getEmail());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        return userDto;
    }

    @Transactional
    public User saveOrUpdate(UserDto userDto) {
        User user = userRepository.findOne(userDto.getEmail());
        if (user == null) {
            user = new User();
        }
        user.setEmail(userDto.getEmail());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        return userRepository.save(user);
    }

    public void delete(String email) {
        userRepository.delete(email);
    }
}
