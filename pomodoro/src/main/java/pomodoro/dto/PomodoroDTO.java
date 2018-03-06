package pomodoro.dto;

public class PomodoroDto {

    private Long pomId;
    private String name;

    public PomodoroDto(Long pomId, String name) {
        this.pomId = pomId;
        this.name = name;
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

}
