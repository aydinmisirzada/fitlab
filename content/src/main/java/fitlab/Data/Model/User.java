package fitlab.Data.Model;

import javax.persistence.*;
import java.util.Set;

// User entity
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String Name;

    private String Surname;
    private String username;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    private String Email;
    private String Password;
    private String Phone;
    private String Role;

    public User() {
    }

    public User(Integer id, String name, String surname, String username, String email, String password, String phone, String role) {
        this.id = id;
        Name = name;
        Surname = surname;
        this.username = username;
        Email = email;
        Password = password;
        Phone = phone;
        Role = role;
    }

    public Integer getId() {
        return id;
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

    public void setId(Integer id) {
        this.id = id;
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

