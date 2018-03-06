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
    @Column(name = "taskId", unique = true, nullable = false)
    private Long taskId;

    @Column(name = "name", unique = false, nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "email", referencedColumnName = "email", nullable = false)
    private User user;

    @OneToMany(mappedBy = "tasks")
    private Set<Pomodoro> pomodoros;

    public Task() {
    }

    public Task(Long taskId, String name) {
        this.taskId = taskId;
        this.name = name;
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