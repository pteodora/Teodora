package pomodoro.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import pomodoro.entity.Pomodoro;

public class UserDto {

    private String email;
    private String firstName;
    private String lastName;
    private List<PomodoroDto> pomodoros = new ArrayList<PomodoroDto>();

    public UserDto(String email, String firstName, String lastName) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public UserDto() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<PomodoroDto> getPomodoros() {
        return pomodoros;
    }

    public void setPomodoros(List<PomodoroDto> pomodoros) {
        this.pomodoros = pomodoros;
    }

}
