package pomodoro.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;

//import static javax.persistence.FetchType.LAZY;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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

    @OneToMany(mappedBy = "pomID")
    private Set<User> users;
    
    public Pomodoro() {
        super();
    }

    public Pomodoro(int pomID, String pName, Set<User> users) {
        super();
        this.pomID = pomID;
        this.pName = pName;
        this.users = users;
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

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }	
}