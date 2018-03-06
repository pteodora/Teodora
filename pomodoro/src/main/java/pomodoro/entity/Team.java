package pomodoro.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Team")
public class Team {

    @Id
    @GeneratedValue
    @Column(name = "teamId", unique = true, nullable = false)
    private Long teamId;

    @Column(name = "name", unique = false, nullable = false)
    private String name;

    @ManyToMany(mappedBy = "teams")
    private Set<User> users = new HashSet<User>();

    public Team() {
    }

    public Team(Long teamId, String name, Set<User> users) {
        this.teamId = teamId;
        this.name = name;
        this.users = users;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

}
