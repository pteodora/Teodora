package pomodoro.dto;

public class TaskDto {

    private Long taskId;
    private String name;
    private String email;

    public TaskDto(Long taskId, String name, String email) {
        this.taskId = taskId;
        this.name = name;
        this.email = email;
    }

    public TaskDto() {
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
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
