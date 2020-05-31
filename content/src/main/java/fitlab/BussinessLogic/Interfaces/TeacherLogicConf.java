package fitlab.BussinessLogic.Interfaces;

import fitlab.Data.Model.Teacher;
import org.springframework.ui.Model;

import java.util.List;

/**
 * Interface for all operations with teachers
 */
public interface TeacherLogicConf {
     /**
      * The method is used to get the list of teachers
      * @return Method returns a list of teachers from the database
      */
     List<Teacher> GetTeachersList();

     /**
      * The method is used to add a teacher to the database
      * @param name This is name of the teacher
      * @param surname This is surname of the teacher
      * @param username This is username of the teacher
      */
     void addTeacher(String name, String surname, String username);

     /**
      * The method is used to delete a teacher from the database
      * @param id This is id of the teacher which is to be deleted
      */
     void delTeacher(int  id);
}
