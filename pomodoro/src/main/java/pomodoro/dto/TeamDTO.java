package pomodoro.dto;

public class TeamDto {

    private Long teamId;
    private String name;

    public TeamDto(Long teamId, String name) {
        this.teamId = teamId;
        this.name = name;
    }

    public TeamDto() {
        super();
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

}
