package pomodoro.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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

    @ManyToOne
    @JoinColumn(name = "email", referencedColumnName = "email", nullable = false)
    private User user;

    @OneToMany(mappedBy = "tasks")
    private Set<Pomodoro> pomodoros;
    
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Pomodoro> getPomodoros() {
        return pomodoros;
    }

    public void setPomodoros(Set<Pomodoro> pomodoros) {
        this.pomodoros = pomodoros;
    }
}