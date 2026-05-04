package petsavvy.pet.model;

import jakarta.persistence.*;


// Jason
// UID: 757001356

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userID;

    @Column(name = "username", length = 100, nullable = false)
    private String username;

    @Column(name = "password", length = 200, nullable = false)
    private String password;

    @Column(name = "usermail", length = 100, nullable = false)
    private String userMail;

    public User() {}

    public User(int userID, String userMail, String username) {
        this.userID = userID;
        this.userMail = userMail;
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }
}
