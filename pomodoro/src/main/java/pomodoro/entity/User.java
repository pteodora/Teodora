package pomodoro.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "User")
public class User {

    @Id
    @Column(name = "email", unique = true, nullable = false)
    private String email;
    
    @Column(name = "fName", unique = false, nullable = false)
    private String fName;
    
    @Column(name = "lName", unique = false, nullable = false)
    private String lName;
    
    private Set<Team> teams;
    
    @ManyToOne
    @JoinColumn(name = "pomID", referencedColumnName = "pomID", nullable = false)
    private Pomodoro pomodoro;
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "UserTeam", joinColumns = @JoinColumn(name = "email", referencedColumnName = "email"), inverseJoinColumns = @JoinColumn(name = "teamID", referencedColumnName = "teamID"))
    public Set<Team> getTeams(){
        return teams;
    }
    
    public User(String email, String fName, String lName) {
        super();
        this.email = email;
        this.fName = fName;
        this.lName = lName;
    }

    public User() {
        super();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

	public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public Pomodoro getPomodoro() {
        return pomodoro;
    }

    public void setPomodoro(Pomodoro pomodoro) {
        this.pomodoro = pomodoro;
    }

    public void setTeams(Set<Team> teams) {
        this.teams = teams;
    }
}