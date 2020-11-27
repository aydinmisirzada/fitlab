package fitlab.BussinessLogic.Logic;

import fitlab.Data.Model.OwnUserDetails;
import fitlab.Data.Model.Role;
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
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

class UsersLogicTest {

    @InjectMocks
    private UsersLogic usersLogic;

    @Mock
    private UserRepository userRepository;

    @Mock
    private SubjectRepository subjectRepository;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @DisplayName("getUserByPath Should Not Find User And Return Null")
    void getUserByPathShouldNotFindUserAndReturnNull() {
        when(userRepository.findByPathId(anyString())).thenReturn(Optional.empty());
        Assertions.assertNull(usersLogic.getUserByPath("a"));
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

        Assertions.assertNull(usersLogic.getUserByPath("a"));
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
    @DisplayName("editUserById Should Not Find User And Return User Not Exist")
    void editUserByIdShouldNotFindUserAndReturnUserNotExist() {
        when(userRepository.findById(anyInt())).thenReturn(Optional.empty());
        Assertions.assertEquals("une", usersLogic.editUserById(new User(), true));
    }

    @Test
    @DisplayName("editUserById Should Not Find Path And Return Path Exist")
    void editUserByIdShouldFindPathAndReturnPathExist() {
        User u1 = new User();
        User u = new User();
        u.setPathId("root");
        u.setId(1);

        u1.setPathId("roota");
        when(userRepository.findById(1)).thenReturn(Optional.of(u1));
        when(userRepository.findByPathId(anyString())).thenReturn(Optional.of(u));
        Assertions.assertEquals("path", usersLogic.editUserById(u, true));
    }

    @Test
    @DisplayName("editUserById Should Save User")
    void editUserByIdShouldSaveUser() {
        User u1 = new User();
        User u = new User();
        u.setPathId("root");
        u.setRole(Role.ADMIN);
        u.setId(1);
        u.setName("root");
        u.setEmail("test@test");
        u.setUsername("root");
        u.setPassword("123");
        u.setActivationCode("");

        u1.setPathId("root");
        u1.setRole(Role.USER);
        u1.setId(2);
        u1.setName("roota");
        u1.setEmail("test@testa");
        u1.setUsername("root");
        u1.setPassword("1232");
        u1.setActivationCode("");

        OwnUserDetails oud = new OwnUserDetails(u);

        when(userRepository.findById(anyInt())).thenReturn(Optional.of(u1));
        when(userRepository.findByUsername(anyString())).thenReturn(Optional.of(u1));

        Authentication authentication = mock(Authentication.class);
        SecurityContext securityContext = mock(SecurityContext.class);
        when(securityContext.getAuthentication()).thenReturn(authentication);
        SecurityContextHolder.setContext(securityContext);
        when(SecurityContextHolder.getContext().getAuthentication().getPrincipal()).thenReturn(oud);

        Assertions.assertEquals("true", usersLogic.editUserById(u, true));

        verify(userRepository, times(1)).save(u1);
    }

    @Test
    @DisplayName("editUserById Should Save User And Change Authentication")
    void editUserByIdShouldSaveUserAndChangeAuthentication() {
        User u1 = new User();
        User u = new User();
        u.setPathId("root");
        u.setRole(Role.ADMIN);
        u.setId(1);
        u.setName("root");
        u.setEmail("test@test");
        u.setUsername("root");
        u.setPassword("123");
        u.setActivationCode("");

        u1.setPathId("root");
        u1.setRole(Role.USER);
        u1.setId(2);
        u1.setName("roota");
        u1.setEmail("test@testa");
        u1.setUsername("root");
        u1.setPassword("1232");
        u1.setActivationCode("");

        OwnUserDetails oud = mock(OwnUserDetails.class);

        when(userRepository.findById(anyInt())).thenReturn(Optional.of(u1));
        when(userRepository.findByUsername(anyString())).thenReturn(Optional.of(u1));

        Authentication authentication = mock(Authentication.class);
        SecurityContext securityContext = mock(SecurityContext.class);
        when(securityContext.getAuthentication()).thenReturn(authentication);
        SecurityContextHolder.setContext(securityContext);

        when(SecurityContextHolder.getContext().getAuthentication()).thenReturn(authentication);
        when(authentication.getPrincipal()).thenReturn(oud);
        when(oud.getUserId()).thenReturn(2);

        Assertions.assertEquals("true", usersLogic.editUserById(u, true));

        verify(oud, times(1)).setOwnUserDetails(u1);
    }

    @Test
    @DisplayName("editUserById Should Not Find Username And Return Username Exist")
    void editUserByIdShouldFindUsernameAndReturnUsernameExist() {
        User u1 = new User();
        User u = new User();
        u.setPathId("root");
        u.setId(1);
        u.setEmail("test@test");
        u.setUsername("root");

        u1.setPathId("root");
        u1.setId(1);
        u1.setUsername("roota");
        when(userRepository.findById(anyInt())).thenReturn(Optional.of(u1));
        when(userRepository.findByUsername(anyString())).thenReturn(Optional.of(u1));
        Assertions.assertEquals("username", usersLogic.editUserById(u, true));
    }

    @Test
    @DisplayName("getAllUsers Should Return Null")
    void getAllUsersShouldReturnNull() {
        when(userRepository.findAll()).thenReturn(null);
        Assertions.assertNull(usersLogic.getAllUsers());
    }

    @Test
    @DisplayName("getAllUsers Should Return Users")
    void getAllUsersShouldReturnUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User());
        users.add(new User());
        users.add(new User());
        when(userRepository.findAll()).thenReturn(users);
        Assertions.assertNotNull(usersLogic.getAllUsers());
    }

    @Test
    @DisplayName("delAssingment Should Delete Subject From User")
    void delAssingmentShouldDeleteSubjectFromUser(){
        User u = new User();
        Subject sub  = new Subject();
        u.addSubject(sub);
        when(subjectRepository.findById(anyInt())).thenReturn(sub);
        usersLogic.delAssignment(u,0);
        Assertions.assertEquals(0,u.getSubjects().size());
    }

    @Test
    @DisplayName("delAssingment Should Not Change List Of Subjects From User If There Is No Such Subject")
    void delAssingmentShouldChangeListOfSubjectsFromUserIfThereIsNoSuchSubject(){
        User u = new User();
        Subject sub  = new Subject();
        u.addSubject(sub);
        usersLogic.delAssignment(u,5);
        Assertions.assertEquals(1,u.getSubjects().size());
    }

}