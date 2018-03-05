package pomodoro.dto;

public class TeamDTO {

    private int teamID;
    private String teamName;

    public int getTeamID() {
        return teamID;
    }

    public void setTeamID(int teamID) {
        this.teamID = teamID;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public TeamDTO(int teamID, String teamName) {
        super();
        this.teamID = teamID;
        this.teamName = teamName;
    }

    public TeamDTO() {
        super();
    }
}
