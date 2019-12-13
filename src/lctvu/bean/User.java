package lctvu.bean;

import java.util.Date;

public class User {
    private int id;
    private String username;
    private String password;
    private String email;

    private Date tdate;
    public User(){

    }
    public User(int id, String username, String password, String email, Date tdate) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.tdate = tdate;
    }
    public User(String username,  String password,String email, Date tdate) {

        this.username = username;
        this.email = email;
        this.password = password;
        this.tdate = tdate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getTdate() {
        return tdate;
    }

    public void setTdate(Date tdate) {
        this.tdate = tdate;
    }
}
