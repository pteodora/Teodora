package pomodoro.dto;

public class PomodoroDTO {

    private int pomID;
    private String pName;

    public PomodoroDTO(int pomID, String pName) {
        super();
        this.pomID = pomID;
        this.pName = pName;
    }

    public PomodoroDTO() {
        super();
    }

    public int getPomID() {
        return pomID;
    }

    public void setPomID(int pomID) {
        this.pomID = pomID;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

}
