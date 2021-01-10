package fitlab.BussinessLogic.services;

import fitlab.Data.Model.OwnUserDetails;
import fitlab.Data.Model.Role;
import fitlab.Data.Model.User;
import fitlab.Data.Repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

class UserDetailServiceTest {
    @InjectMocks
    private UserDetailService userDetailService;

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @DisplayName("loadUserByUsername Should Throw Exception")
    void loadUserByUsernameShouldThrowException() {

        when(userRepository.findByUsername(anyString())).thenReturn(Optional.empty());

        Assertions.assertThrows(UsernameNotFoundException.class,
                () -> userDetailService.loadUserByUsername("root"));
    }

    @Test
    @DisplayName("loadUserByUsername Should Not Throw Exception")
    void loadUserByUsernameShouldNotThrowException() {
        User u = new User();
        u.setPathId("root");
        u.setRole(Role.ADMIN);
        u.setId(1);
        u.setName("root");
        u.setEmail("test@test");
        u.setUsername("root");
        u.setPassword("123");
        u.setActivationCode("");
        when(userRepository.findByUsername(anyString())).thenReturn(Optional.of(u));

        Assertions.assertDoesNotThrow(()->userDetailService.loadUserByUsername("root"));
    }

    @Test
    @DisplayName("loadUserByUsername Should Return User Details And No Exception")
    void loadUserByUsernameShouldReturnUserDetailsAndNoException() {
        User u = new User();
        u.setPathId("root");
        u.setRole(Role.ADMIN);
        u.setId(1);
        u.setName("root");
        u.setEmail("test@test");
        u.setUsername("root");
        u.setPassword("123");
        u.setActivationCode("");
        when(userRepository.findByUsername(anyString())).thenReturn(Optional.of(u));

        Assertions.assertDoesNotThrow(()->userDetailService.loadUserByUsername("root"));
        Assertions.assertTrue(userDetailService.loadUserByUsername("root") instanceof OwnUserDetails);
    }
}
