package fitlab.BussinessLogic.Logic;

import fitlab.BussinessLogic.services.MailSenderService;
import fitlab.Data.Model.Role;
import fitlab.Data.Model.Semester;
import fitlab.Data.Model.Subject;
import fitlab.Data.Model.User;
import fitlab.Data.Repository.SubjectRepository;
import fitlab.Data.Repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.Optional;

import static org.mockito.Mockito.*;

class SubjectLogicTest {

    @InjectMocks
    SubjectLogic subjectLogic;

    @Mock
    SubjectRepository subjectRepository;

    @Mock
    UserRepository userRepository;

    @InjectMocks
    private RegistrationLogic registrationLogic;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }


    @Test
    @DisplayName("assignedSubject Should Return True When User Is Assigned To A Subject")
    void assignedSubjectShouldReturnTrueWhenUserIsAssignedToASubject() {
        User u = new User();
        u.setUsername("root");

        Subject sub = new Subject("BIE-SP2","Software Engineering", Semester.SUMMER);
        sub.AddUser(u);

        when(userRepository.findByUsername(anyString())).thenReturn(Optional.of(u));

        Assertions.assertTrue(subjectLogic.assignedSubejct(sub,u.getUsername()));
    }

    @Test
    @DisplayName("assignedSubject Should Return False When User Is Not Assigned")
    void assignedSubjectShouldReturnFalseWhenUserIsNotAssigned() {
        User u = new User();
        u.setUsername("root");

        Subject sub = new Subject("BIE-SP2","Software Engineering", Semester.SUMMER);

        when(userRepository.findByUsername(anyString())).thenReturn(Optional.of(u));

        Assertions.assertFalse(subjectLogic.assignedSubejct(sub,u.getUsername()));
    }

    @Test
    @DisplayName("AssingSubject Should Assign A Subject To A User")
    void assignSubjectShouldAssignASubjectToAUser() {
        User u = new User();
        u.setUsername("root");
        when(userRepository.findByUsername(anyString())).thenReturn(Optional.of(u));

        Subject sub = new Subject("BIE-SP2","Software Engineering", Semester.SUMMER);
        when(subjectRepository.findByCode(anyString())).thenReturn(sub);

        subjectLogic.assignSubject(u.getUsername(),sub.getCode());
        Assertions.assertEquals("root",sub.getUsers().get(0).getUsername());
    }


    @Test
    @DisplayName("AssingSubject Should Return False If There Is No User")
    void assignSubjectShouldReturnFalseIfThereIsNoUser() {
        Subject sub = new Subject("BIE-SP2","Software Engineering", Semester.SUMMER);
        when(subjectRepository.findByCode(anyString())).thenReturn(sub);

        subjectLogic.assignSubject("tmp",sub.getCode());
        Assertions.assertEquals(0,sub.getUsers().size());
    }

    @Test
    @DisplayName("editSubjectDetails Should Change Code Of A Subject")
    void editSubjectDetailsShouldChangeCodeOfASubject() {
        Subject sub = new Subject("BIE-SP2","Software Engineering", Semester.SUMMER);
        when(subjectRepository.findById(anyInt())).thenReturn(sub);
        subjectLogic.editSubjectDetails(0,"BIE-PA2",sub.getName(),0);
        Assertions.assertEquals("BIE-PA2",sub.getCode());
        Assertions.assertEquals("Software Engineering",sub.getName());
        Assertions.assertEquals(Semester.SUMMER,sub.getSemester());
    }
    @Test
    @DisplayName("editSubjectDetails Should Change Name Of A Subject")
    void editSubjectDetailsShouldChangeNameOfASubject() {
        Subject sub = new Subject("BIE-SP2","Software Engineering", Semester.SUMMER);
        when(subjectRepository.findById(anyInt())).thenReturn(sub);
        subjectLogic.editSubjectDetails(0,sub.getCode(),"Programming",0);
        Assertions.assertEquals("Programming",sub.getName());
        Assertions.assertEquals("BIE-SP2",sub.getCode());
        Assertions.assertEquals(Semester.SUMMER,sub.getSemester());
    }
    @Test
    @DisplayName("editSubjectDetails Should Change Semester Of A Subject")
    void editSubjectDetailsShouldChangeSemesterOfASubject() {
        Subject sub = new Subject("BIE-SP2","Software Engineering", Semester.SUMMER);
        when(subjectRepository.findById(anyInt())).thenReturn(sub);
        subjectLogic.editSubjectDetails(0,sub.getCode(),sub.getName(),1);
        Assertions.assertEquals(Semester.WINTER,sub.getSemester());
        Assertions.assertEquals("BIE-SP2",sub.getCode());
        Assertions.assertEquals("Software Engineering",sub.getName());

    }


    @Test
    @DisplayName("SubjectEditDescription Should Return A Subject With New Description")
    void SubjectEditDescriptionShouldReturnASubjectWithNewDescription() {
        Subject sub = new Subject("BIE-SP2","Software Engineering", Semester.SUMMER);
        sub.setDescription("SOME");
        when(subjectRepository.findByCode(anyString())).thenReturn(sub);
        sub = subjectLogic.SubjectEditDescription(sub.getCode(),"TMP");
        Assertions.assertEquals("TMP",sub.getDescription());
    }

}
