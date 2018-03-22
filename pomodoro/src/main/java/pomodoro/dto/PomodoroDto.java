package pomodoro.dto;

import pomodoro.entity.Pomodoro;

public class PomodoroDto {

    private Long pomId;
    private String name;
    private String email;

    public PomodoroDto(Long pomId, String name, String email) {
        this.pomId = pomId;
        this.name = name;
        this.email = email;
    }

    public PomodoroDto(Pomodoro pomodoro) {
        this.pomId = pomodoro.getPomId();
        this.name = pomodoro.getName();
    }

    public PomodoroDto() {
    }

    public Long getPomId() {
        return pomId;
    }

    public void setPomId(Long pomId) {
        this.pomId = pomId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
