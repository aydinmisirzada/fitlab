package fitlab.Data.Model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "tags")
public class Tags {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    private Tags parent;
    @OneToMany(mappedBy="parent")
    private Collection<Tags> children;


    public Tags() {
    }
}
