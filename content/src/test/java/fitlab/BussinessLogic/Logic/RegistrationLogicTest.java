package fitlab.BussinessLogic.Logic;

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

    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @DisplayName("addUser Should Return If Found Username")
    void addUserShouldReturnIfFoundUsername() {
        User u = new User();
        u.setUsername("root");
        when(userRepository.findByUsername(anyString())).thenReturn(Optional.of(u));
        Assertions.assertEquals("username", registrationLogic.addUser(u));
        verify(mailSender, never()).send(anyString(),anyString(),anyString());
        verify(userRepository, never()).save(u);
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
        verify(mailSender, never()).send(anyString(),anyString(),anyString());
        verify(userRepository, never()).save(u);
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
        verify(userRepository, times(1)).save(u);
        verify(mailSender, times(1)).send(anyString(),anyString(),anyString());

    }

    @Test
    @DisplayName("addAdmin Should Add New Admin")
    void addAdminShouldAddNewAdmin() {
        User u = new User();
        u.setName("root");
        u.setEmail("test@test");
        u.setUsername("root");
        u.setPassword("123");
        when(userRepository.findByUsername(anyString())).thenReturn(Optional.empty());
        when(userRepository.findByEmail(anyString())).thenReturn(Optional.empty());
        when(passwordEncoder.encode(anyString())).thenReturn("123");

        registrationLogic.addAdmin(u);
        verify(passwordEncoder, times(1)).encode(anyString());
        verify(userRepository, times(1)).save(u);
        Assertions.assertDoesNotThrow(() -> registrationLogic.addAdmin(u));
    }

    @Test
    @DisplayName("addAdmin Should Not Add When Email Exist")
    void addAdminShouldNotAddWhenEmailExist() {
        User u = new User();
        u.setUsername("root");
        u.setEmail("root");
        u.setPassword("root");
        when(userRepository.findByUsername(anyString())).thenReturn(Optional.empty());
        when(userRepository.findByEmail(anyString())).thenReturn(Optional.of(u));
        registrationLogic.addAdmin(u);
        verify(passwordEncoder, never()).encode(anyString());
    }

    @Test
    @DisplayName("addAdmin Should Not Add When Username Exist")
    void addAdminShouldNotAddWhenUsernameExist() {
        User u = new User();
        u.setUsername("root");
        u.setEmail("root");
        u.setPassword("root");
        when(userRepository.findByUsername(anyString())).thenReturn(Optional.of(u));
        when(userRepository.findByEmail(anyString())).thenReturn(Optional.empty());
        registrationLogic.addAdmin(u);
        verify(passwordEncoder, never()).encode(anyString());
    }

    @Test
    @DisplayName("checkActivation Should Return False")
    void checkActivationShouldReturnFalse() {
        when(userRepository.findByActivationCode(anyString())).thenReturn(Optional.empty());
        Assertions.assertFalse(registrationLogic.checkActivation("string"));
    }

    @Test
    @DisplayName("checkActivation Should Return True")
    void checkActivationShouldReturnTrue() {
        User u = new User();
        u.setName("root");
        when(userRepository.findByActivationCode(anyString())).thenReturn(Optional.of(u));
        Assertions.assertTrue(registrationLogic.checkActivation("string"));
    }
}