package fitlab.Data.Repository;

import fitlab.Data.Model.Review;
import fitlab.Data.Model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {
}
