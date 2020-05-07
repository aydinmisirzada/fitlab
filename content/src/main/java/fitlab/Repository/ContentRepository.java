package fitlab.Repository;

import fitlab.Model.Content;
import fitlab.Model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ContentRepository extends JpaRepository<Content, Integer> {
    Content findById(int id);

}
