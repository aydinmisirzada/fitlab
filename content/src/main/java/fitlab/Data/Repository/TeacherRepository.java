package fitlab.Data.Repository;

import fitlab.Data.Model.Subject;
import fitlab.Data.Model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
    Teacher findByUsername(String name);
    Teacher findById(int id);
}
