package fitlab.Data.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


// Subject model is called a "course" in the documentation
@Entity
@Table(name = "subject")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private Semester semester;
    @Lob
    private String Description;
    private String code;
    @OneToMany(mappedBy = "subject")
    private List<Content> contentList;

    @ManyToMany(mappedBy = "subjects")
    private List<User> users = new ArrayList<User>();

    public Subject() {
    }

    public List<User> getUsers() {
        return users;
    }
    public void AddUser(User u){
        users.add(u);
    }
    public void delUser(User u){
        users.remove(u);
    }
    public Subject(String Code, String Name, Semester Semester) {
        semester = Semester;
        name = Name;
        code = Code;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Content> getContentList() {
        return contentList;
    }

    public void setContentList(List<Content> contentList) {
        this.contentList = contentList;
    }

    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }

    public String getDescription() {
        return Description;

    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
