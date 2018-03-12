package pomodoro.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Pomodoro")
public class Pomodoro {

    @Id
    @GeneratedValue
    @Column(name = "pomId", unique = true, nullable = false)
    private Long pomId;

    @Column(name = "name", unique = false, nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "email", referencedColumnName = "email", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "taskId", referencedColumnName = "taskId", nullable = false)
    private Task tasks;

    public Pomodoro() {
    }

    public Pomodoro(Long pomId, String name, User user, Task tasks) {
        this.pomId = pomId;
        this.name = name;
        this.user = user;
        this.tasks = tasks;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Task getTasks() {
        return tasks;
    }

    public void setTasks(Task tasks) {
        this.tasks = tasks;
    }
}