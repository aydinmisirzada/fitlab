package fitlab.Data.Repository;

import fitlab.Data.Model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer> {
    Subject findByCode(String name);
    Subject findById(int id);
    Subject findByName(String name);
}
