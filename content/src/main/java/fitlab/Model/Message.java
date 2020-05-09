package fitlab.Model;
import java.time.LocalDate;
import javax.persistence.*;

@Entity
@Table(name = "message")
public class Message {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String text;


    private String author;

    private String filename;

    public Message() {
    }
    LocalDate myObj;

    @ManyToOne
    @JoinColumn(name = "content_id")
    private Content content;

    public Content getContent() {

        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    public String getMyObj() {
        return myObj != null ?  myObj.toString() : "null" ;
    }

    public void setMyObj(LocalDate myObj) {
        this.myObj = myObj;
    }

    public Message(String text, String user, Content content) {

        myObj = LocalDate.now();
        this.content = content;
        this.author = user;
        this.text = text;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}
