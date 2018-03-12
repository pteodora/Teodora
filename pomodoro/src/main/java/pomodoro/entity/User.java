package pomodoro.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "User")
public class User {

    @Id
    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "firstName", unique = false, nullable = false)
    private String firstName;

    @Column(name = "lastName", unique = false, nullable = false)
    private String lastName;

    @OneToMany(mappedBy = "user")
    private Set<Pomodoro> pomodoro;

    @OneToMany(mappedBy = "user")
    private Set<Task> tasks;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "UserTeam", joinColumns = @JoinColumn(name = "email", referencedColumnName = "email"), inverseJoinColumns = @JoinColumn(name = "teamId", referencedColumnName = "teamId"))
    private Set<Team> teams;

    public User(String email, String firstName, String lastName) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public User() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setTeams(Set<Team> teams) {
        this.teams = teams;
    }

    public Set<Team> getTeams() {
        return teams;
    }

    public Set<Pomodoro> getPomodoro() {
        return pomodoro;
    }

    public void setPomodoro(Set<Pomodoro> pomodoro) {
        this.pomodoro = pomodoro;
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }
}