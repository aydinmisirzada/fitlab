package fitlab.Data.Repository;

import fitlab.Data.Model.Content;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ContentRepository extends JpaRepository<Content, Integer> {
    Content findById(int id);

}
