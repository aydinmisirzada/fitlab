package fitlab.BussinessLogic.Interfaces;

import fitlab.Data.Model.Teacher;
import org.springframework.ui.Model;

import java.util.List;

public interface TeacherLogicConf {
     List<Teacher> GetTeachersList();
     void addTeacher(String name, String surname, String username);
     void delTeacher(int  id);
}
