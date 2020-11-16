package fitlab.BussinessLogic.Logic;

import fitlab.BussinessLogic.exeptions.AdminWasFoundException;
import fitlab.BussinessLogic.services.MailSenderService;
import fitlab.Data.Model.User;
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

class RegistrationLogicTest {

    @InjectMocks
    private RegistrationLogic registrationLogic;

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private MailSenderService mailSender;


    private static final User user = mock(User.class);

    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
        when(user.getUsername()).thenReturn("user");
    }

    @Test
    @DisplayName("addUser Should Return If Found Username")
    void addUserShouldReturnIfFoundUsername() {
        User u = new User();
        u.setUsername("root");
        when(userRepository.findByUsername(anyString())).thenReturn(Optional.of(u));
        Assertions.assertEquals("username", registrationLogic.addUser(u));
    }

    @Test
    @DisplayName("addUser Should Return If Found Email")
    void addUserShouldReturnIfFoundEmail() {
        User u = new User();
        u.setUsername("root");
        u.setEmail("test@test");
        when(userRepository.findByUsername(anyString())).thenReturn(Optional.empty());
        when(userRepository.findByEmail(anyString())).thenReturn(Optional.of(u));

        Assertions.assertEquals("email", registrationLogic.addUser(u));
    }

    @Test
    @DisplayName("addUser Should Return If Save")
    void addUserShouldReturnIfSave() {
        User u = new User();
        u.setName("root");
        u.setEmail("test@test");
        u.setUsername("root");
        u.setPassword("123");
        when(userRepository.findByUsername(anyString())).thenReturn(Optional.empty());
        when(userRepository.findByEmail(anyString())).thenReturn(Optional.empty());
        when(passwordEncoder.encode(anyString())).thenReturn("123");
        ReflectionTestUtils.setField(registrationLogic, "message", "m");

        Assertions.assertEquals("t", registrationLogic.addUser(u));
    }

    @Test
    @DisplayName("addAdmin Should Not Throw Exeption")
    void addAdminShouldNotThrowExeption() {
        User u = new User();
        u.setName("root");
        u.setEmail("test@test");
        u.setUsername("root");
        u.setPassword("123");
        when(userRepository.findByUsername(anyString())).thenReturn(Optional.empty());
        when(userRepository.findByEmail(anyString())).thenReturn(Optional.empty());
        when(passwordEncoder.encode(anyString())).thenReturn("123");
        Assertions.assertDoesNotThrow(() -> registrationLogic.addAdmin(u));
    }

    @Test
    @DisplayName("addAdmin Should Throw Exeption When Username exist")
    void addAdminShouldThrowExeptionWhenFindUsername() {
        User u = new User();
        u.setName("root");
        u.setEmail("test@test");
        u.setUsername("root");
        when(userRepository.findByUsername(anyString())).thenReturn(Optional.of(u));
        when(userRepository.findByEmail(anyString())).thenReturn(Optional.empty());
        Exception e = Assertions.assertThrows(
                AdminWasFoundException.class,
                () -> registrationLogic.addAdmin(u));

        Assertions.assertTrue(e.getMessage().contains("Admin was found by username, cannot create a new one"));
    }

    @Test
    @DisplayName("addAdmin Should Throw Exeption When Email exist")
    void addAdminShouldThrowExeptionWhenFindEmail() {
        User u = new User();
        u.setName("root");
        u.setEmail("test@test");
        u.setUsername("root");
        when(userRepository.findByUsername(anyString())).thenReturn(Optional.empty());
        when(userRepository.findByEmail(anyString())).thenReturn(Optional.of(u));
        Exception e = Assertions.assertThrows(
                AdminWasFoundException.class,
                () -> registrationLogic.addAdmin(u));

        Assertions.assertTrue(e.getMessage().contains("Admin was found by email, cannot create a new one"));
    }

    @Test
    @DisplayName("checkActivation Should Return False")
    void checkActivationShouldReturnFalse() {
        when(userRepository.findByActivationCode(anyString())).thenReturn(Optional.empty());
        Assertions.assertEquals(false, registrationLogic.checkActivation("string"));
    }

    @Test
    @DisplayName("checkActivation Should Return True")
    void checkActivationShouldReturnTrue() {
        User u = new User();
        u.setName("root");
        when(userRepository.findByActivationCode(anyString())).thenReturn(Optional.of(u));
        Assertions.assertEquals(true, registrationLogic.checkActivation("string"));
    }
}