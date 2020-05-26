package fitlab.Data.Model;


import javax.persistence.*;

@Entity
@Table(name = "teacher")
public class Teacher extends Person {


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Teacher() {
    }

    public Teacher(String name, String surname, String username ) {
        Name = name;
        Surname = surname;
        Username = username;
    }



}
