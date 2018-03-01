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
    @Column(name = "teamID", unique = true, nullable = false)
    private int teamID;
    
    @Column(name = "teamName", unique = false, nullable = false)
    private String teamName;
    
    @ManyToMany(mappedBy = "teams")
    private Set<User> users = new HashSet<User>();	
    
    public Team() {
        super();
	}

    public Team(int teamID, String teamName, Set<User> users) {
        super();
        this.teamID = teamID;
        this.teamName = teamName;
        this.users = users;
    }

    public int getTeamID() {
        return teamID;
    }

    public void setTeamID(int teamID) {
        this.teamID = teamID;
    }

    public String getTeamName() {
        return teamName;
    }
    
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
	}
}