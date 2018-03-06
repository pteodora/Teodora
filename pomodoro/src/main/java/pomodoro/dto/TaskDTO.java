package pomodoro.dto;

public class TaskDTO {

    private int taskID;
    private String taskName;

    public TaskDTO(int taskID, String taskName) {
        super();
        this.taskID = taskID;
        this.taskName = taskName;
    }

    public TaskDTO() {
        super();
    }

    public int getTaskID() {
        return taskID;
    }

    public void setTaskID(int taskID) {
        this.taskID = taskID;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

}
