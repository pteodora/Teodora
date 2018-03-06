package pomodoro.dto;

public class TaskDto {

    private Long taskId;
    private String name;

    public TaskDto(Long taskId, String name) {
        this.taskId = taskId;
        this.name = name;
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

}
