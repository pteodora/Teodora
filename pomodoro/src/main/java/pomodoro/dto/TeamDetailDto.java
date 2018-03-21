package pomodoro.dto;

import java.util.ArrayList;
import java.util.List;

import pomodoro.entity.Pomodoro;
import pomodoro.entity.Team;
import pomodoro.entity.User;

public class TeamDetailDto {

    private Long teamId;
    private String name;
    private List<UserDto> users = new ArrayList<UserDto>();

    public TeamDetailDto(Long teamId, String name) {
        this.teamId = teamId;
        this.name = name;
    }

    public TeamDetailDto() {
    }

    public TeamDetailDto(Team team) {
        this.teamId = team.getTeamId();
        this.name = team.getName();
        for (User user : team.getUsers()) {
            UserDto userDto = new UserDto();
            userDto.setEmail(user.getEmail());
            userDto.setFirstName(user.getFirstName());
            userDto.setLastName(user.getLastName());
            for (Pomodoro pomodoro : user.getPomodoro()) {
                PomodoroDto pomodoroDto = new PomodoroDto(pomodoro);
                userDto.getPomodoros().add(pomodoroDto);
            }
            users.add(userDto);
        }
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<UserDto> getUsers() {
        return users;
    }

    public void setUsers(List<UserDto> users) {
        this.users = users;
    }
}
