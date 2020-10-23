package fitlab.Data.Model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.function.Supplier;
@Entity
@Table(name="teacher")
public class Teacher  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    private String surname;
    private String username;

    @OneToMany(mappedBy = "teacher")
    private List<Review> reviewList;

    public List<Review> getReviewList() {
        return reviewList;
    }

    public void setReviewList(List<Review> reviewList) {
        this.reviewList = reviewList;
    }

    @OneToOne(mappedBy = "teacher")
    private Content content;

    public void addReview(Review review) {
        reviewList.add(review);
    }

    public int averageRating() {
        int x = 0;
        for (Review y : reviewList) {
            x += y.getRating();
        }
        if(reviewList.size() > 0)
            x /= reviewList.size();

        return  x;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }



    public String getName() {
        return name;
    }

    public void setName(String name1) {
        name = name1;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname1) {
        surname = surname1;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username1) {
        username = username1;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Teacher() {
    }

    public Teacher(String name, String surname, String username ) {
        this.name = name;
        this.surname = surname;
        this.username = username;
    }



}
