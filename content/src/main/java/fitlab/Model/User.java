package fitlab.Model;

import javax.jws.soap.SOAPBinding;
import javax.persistence.*;

// User entity
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String Username;
    private String Email;
    private String Password;
    private String Phone;
    private String Role;

    public User() {
    }

    public User(String username, String email, String password, String phone, String role) {
        Username = username;
        Email = email;
        Password = password;
        Phone = phone;
        Role = role;
    }

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }


    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}

