package fitlab.BussinessLogic.Logic;

import fitlab.BussinessLogic.services.MailSenderService;
import fitlab.Data.Model.*;
import fitlab.Data.Repository.SubjectRepository;
import fitlab.Data.Repository.TeacherRepository;
import fitlab.Data.Repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.Optional;

import static org.mockito.Mockito.*;
class TeacherLogicTest {
    @InjectMocks
    TeacherLogic teacherLogic;

    @Mock
    TeacherRepository teacherRepository;


    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @DisplayName("tecDuplicate Should Return False If There Is No Duplicate Of Teachers")
    void tecDuplicateShouldReturnFalseIfThereIsNoDuplicateOfTeachers(){
        Teacher teacher = new Teacher();
        teacher.setUsername("Tec");

        when(teacherRepository.findByUsername(anyString())).thenReturn(teacher);

        Assertions.assertFalse(teacherLogic.tecDuplicate(teacher.getUsername()));
    }

    @Test
    @DisplayName("tecDuplicate Should Return True If There Is No Duplicate Of Teachers")
    void tecDuplicateShouldReturnTrueIfThereIsNoDuplicateOfTeachers(){
        Teacher teacher = new Teacher();
        teacher.setUsername("Tec");

        Assertions.assertTrue(teacherLogic.tecDuplicate(teacher.getUsername()));
    }

    @Test
    @DisplayName("editTeacherDetails Should Change Name Of A Teacher")
    void editTeacherDetailsShouldChangeNameOfATeacher() {
        Teacher teacher = new Teacher("Mike","Sainter","misaint");

        when(teacherRepository.findById(anyInt())).thenReturn(teacher);
        teacherLogic.editTeacherDetails(0,"Elvis",teacher.getSurname(),teacher.getUsername());
        Assertions.assertEquals("Elvis",teacher.getName());
        Assertions.assertEquals("Sainter",teacher.getSurname());
        Assertions.assertEquals("misaint",teacher.getUsername());
    }
    @Test
    @DisplayName("editTeacherDetails Should Change Surname Of A Teacher")
    void editTeacherDetailsShouldChangeSurnameOfATeacher() {
        Teacher teacher = new Teacher("Mike","Sainter","misaint");

        when(teacherRepository.findById(anyInt())).thenReturn(teacher);
        teacherLogic.editTeacherDetails(0,teacher.getName(),"Lews",teacher.getUsername());
        Assertions.assertEquals("Mike",teacher.getName());
        Assertions.assertEquals("Lews",teacher.getSurname());
        Assertions.assertEquals("misaint",teacher.getUsername());
    }
    @Test
    @DisplayName("editTeacherDetails Should Change Username Of A Teacher")
    void editTeacherDetailsShouldChangeUsernameOfATeacher() {
        Teacher teacher = new Teacher("Mike","Sainter","misaint");

        when(teacherRepository.findById(anyInt())).thenReturn(teacher);
        teacherLogic.editTeacherDetails(0,teacher.getName(),teacher.getSurname(),"xxx");
        Assertions.assertEquals("Mike",teacher.getName());
        Assertions.assertEquals("Sainter",teacher.getSurname());
        Assertions.assertEquals("xxx",teacher.getUsername());

    }




}
