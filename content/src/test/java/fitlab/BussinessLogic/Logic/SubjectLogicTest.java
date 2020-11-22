package fitlab.BussinessLogic.Logic;

import fitlab.Data.Model.Subject;
import fitlab.Data.Model.User;
import fitlab.Data.Repository.SubjectRepository;
import fitlab.Data.Repository.UserRepository;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class SubjectLogicTest {

    @Mock
    SubjectRepository subjectRepository;

    @InjectMocks
    SubjectLogic subjectLogic;

    @Mock
    UserRepository userRepository;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }


    @Test
    @DisplayName("assignedSubejct Should Return True When User Is Assigned To A Subject")
    void assignedSubejctShouldReturnTrueWhenUserIsAssignedToASubject() {
        User u = new User();

        Subject sub ;//= new Subject("BIE-");

        subjectLogic.assignSubject(u.getUsername(),sub.getCode());

        Assertions.assertEquals(true, subjectLogic.assignedSubejct(sub,u.getUsername()));
    }

    @Test
    @DisplayName("AssingSubject Should Assign A Subject To A User")
    void assignSubjectShouldAssignASubjectToAUser() {
        User u = new User();


    }

    @Test
    void assignedSubejct() {
    }
}