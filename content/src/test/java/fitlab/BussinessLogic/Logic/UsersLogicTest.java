package fitlab.BussinessLogic.Logic;

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
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class UsersLogicTest {

    @InjectMocks
    private UsersLogic usersLogic;

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @DisplayName("getUserByPath Should Not Find User And Return Null")
    void getUserByPathShouldNotFindUserAndReturnNull() {
        when(userRepository.findByPathId(anyString())).thenReturn(Optional.empty());
        Assertions.assertEquals(null, usersLogic.getUserByPath("a"));
    }

    @Test
    @DisplayName("getUserByPath Should Find Different User And Return Null")
    void getUserByPathShouldFindDifferentUserAndReturnNull() {
        User u = new User();
        u.setPathId("root");
        u.setRole(Role.USER);
        u.setId(1);
        u.setName("root");
        u.setEmail("test@test");
        u.setUsername("root");
        u.setPassword("123");
        u.setActivationCode("");
        OwnUserDetails oud = new OwnUserDetails(u);
        u.setId(2);

        when(userRepository.findByPathId(anyString())).thenReturn(Optional.of(u));

        Authentication authentication = mock(Authentication.class);
        SecurityContext securityContext = mock(SecurityContext.class);
        when(securityContext.getAuthentication()).thenReturn(authentication);
        SecurityContextHolder.setContext(securityContext);

        when(SecurityContextHolder.getContext().getAuthentication().getPrincipal()).thenReturn(oud);

        Assertions.assertEquals(null, usersLogic.getUserByPath("a"));
    }

    @Test
    @DisplayName("getUserByPath Should Find Admin And Return User")
    void getUserByPathShouldFindAdminAndReturnUser(){
        User u = new User();
        u.setPathId("root");
        u.setRole(Role.ADMIN);
        u.setId(1);
        u.setName("root");
        u.setEmail("test@test");
        u.setUsername("root");
        u.setPassword("123");
        u.setActivationCode("");
        OwnUserDetails oud = new OwnUserDetails(u);
        u.setId(2);

        when(userRepository.findByPathId(anyString())).thenReturn(Optional.of(u));

        Authentication authentication = mock(Authentication.class);
        SecurityContext securityContext = mock(SecurityContext.class);
        when(securityContext.getAuthentication()).thenReturn(authentication);
        SecurityContextHolder.setContext(securityContext);

        when(SecurityContextHolder.getContext().getAuthentication().getPrincipal()).thenReturn(oud);

        Assertions.assertEquals(u, usersLogic.getUserByPath("a"));
    }

    @Test
    void editUserById() {
    }

    @Test
    void getAllUsers() {
    }
}