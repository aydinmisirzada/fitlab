package fitlab.Model;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "tags")
public class Tags {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    public Tags() {
    }
    @ManyToOne
    private Tags parent;
    @OneToMany(mappedBy="parent")
    private Collection<Tags> children;


}
