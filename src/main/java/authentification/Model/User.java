package authentification.Model;

import java.time.LocalDateTime;

public class User {

    private int id;
    private String name;
    private String email;
    private String password;
    private String role;
    private LocalDateTime createdAt;




    public User(String name, String email) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.createdAt = LocalDateTime.now();
    }

    public User(String name, String email, String password, String role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public User(String name, String email, String password){
    }

    public User(int id, String name, String email) {

    }


    //Getter and Setter
    public int getId() {

        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
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

    public String getRole() {

        return role;
    }

    public void setRole() {

        this.role = role;
    }

    public LocalDateTime getCreatedAt() {

        return createdAt;
    }
}
