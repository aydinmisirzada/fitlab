package fitlab.Data.Model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class OwnUserDetails implements UserDetails {
    private String username;
    private String password;
    private String pathId;
    private boolean activated;
    private boolean isAdmin;
    private Role role;

    public OwnUserDetails(User user) {
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.pathId = user.getPathId();
        this.activated = user.getActivationCode().isEmpty();
        this.role = user.getRole();
        this.isAdmin = user.getRole().equals(Role.ADMIN);
    }

    public void setOwnUserDetails(User user) {
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.pathId = user.getPathId();
        this.activated = user.getActivationCode().isEmpty();
        this.role = user.getRole();
        this.isAdmin = user.getRole().equals(Role.ADMIN);
    }

    public OwnUserDetails() {
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();
        list.add(new SimpleGrantedAuthority(role.getAuthority()));

        return list;
    }


    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public String getPathId() {
        return pathId;
    }

    public boolean isActivated() {
        return activated;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return activated;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
