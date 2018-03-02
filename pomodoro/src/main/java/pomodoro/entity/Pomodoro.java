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
    @Column(name = "pomID", unique = true, nullable = false)
    private int pomID;
    
    @Column(name = "pName", unique = false, nullable = false)
    private String pName;

    @ManyToOne
    @JoinColumn(name = "email", referencedColumnName = "email", nullable = false)
    private User user;
    
    @ManyToOne
    @JoinColumn(name = "taskID", referencedColumnName = "taskID", nullable = false)
    private Task tasks;
    
    public Pomodoro() {
        super();
    }

    public Pomodoro(int pomID, String pName, User user, Task tasks) {
        super();
        this.pomID = pomID;
        this.pName = pName;
        this.user = user;
        this.tasks = tasks;
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