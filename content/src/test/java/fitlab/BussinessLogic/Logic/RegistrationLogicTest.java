package fitlab.BussinessLogic.Logic;

import fitlab.BussinessLogic.config.RegistrationLogicTestConfig;
import fitlab.Data.Model.User;
import fitlab.Data.Repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
/*@ContextConfiguration(classes = RegistrationLogicTestConfig.class,
        loader = AnnotationConfigContextLoader.class)*/
@ContextConfiguration(classes = RegistrationLogicTestConfig.class)
class RegistrationLogicTest {

    @Autowired
    private RegistrationLogic registrationLogic;

    @Autowired
    private UserRepository userRepository;

    private static final User user = mock(User.class);

    @BeforeAll
    public static void setup(){
        when(user.getUsername()).thenReturn("user");
    }

    /*@Test
    @DisplayName("Test should pass if user added correctly to db")
    void addUser() {
        registrationLogic = new RegistrationLogic();
        String response = registrationLogic.addUser(new User());

        Assertions.assertFalse();
    }*/

    @Test
    void addAdminShouldAddAdmin() {
//        User u = mock(User.class);
        when(userRepository.findByUsername("user")).thenReturn(null);
        when(userRepository.findByEmail("user")).thenReturn(null);
//        verify(Exception.class, never());
    }

    @Test
    @DisplayName("addAdmin Should Throw Exeption When Admin exist")
    void addAdminShouldThrowExeptionWhenFindUsername() {
        User u = mock(User.class);
        u.setName("user");
//        when(userRepository.findByUsername("user")).thenReturn(Optional.of(u));
//        when(userRepository.findByEmail("user")).thenReturn(null);

        Exception exception = Assertions.assertThrows(
                Exception.class,
                () -> registrationLogic.addAdmin(user));

        Assertions.assertTrue(exception.getMessage().contains("Admin with same Username already exist"));
    }

    @Test
    void checkActivation() {
//        Assertions.assertFalse();
    }
}