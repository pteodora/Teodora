package pomodoro.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Task")
public class Task {

    @Id
    @GeneratedValue
    @Column(name = "taskID", unique = true, nullable = false)
    private int taskID;
    
    @Column(name = "taskName", unique = false, nullable = false)
    private String taskName;
    
    public Task() {
        super();
    }

    public Task(int taskID, String taskName) {
        super();
        this.taskID = taskID;
        this.taskName = taskName;
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