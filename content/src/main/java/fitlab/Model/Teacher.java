package fitlab.Model;


import javax.persistence.*;

@Entity
@Table(name = "teacher")
public class Teacher extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

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
