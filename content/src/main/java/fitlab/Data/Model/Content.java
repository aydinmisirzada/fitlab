package fitlab.Data.Model;


import javax.persistence.*;
import java.util.List;

// Assignment entity ( name will be changed from content to assignment )
@Entity
@Table(name = "content")
public class Content {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(mappedBy = "content")
    private List<Message> messageList;

    public ContentType type;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;



    private String title;

    public Content(){}

    public Content(String Title, ContentType Type) {
        type = Type;
        title = Title;
    }

    public ContentType getType() {
        return type;
    }



    public void setType(ContentType type) {
        this.type = type;
    }

    public List<Message> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<Message> messageList) {
        this.messageList = messageList;
    }




    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }




}
