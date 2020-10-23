package fitlab.Data.Model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class OwnUserDetails implements UserDetails {

    private String username;
    private String password;
    private String pathId;
    private boolean activated;
    private List<GrantedAuthority> authorities;

    public OwnUserDetails(User user) {
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.pathId = user.getPathId();
        this.activated = user.getActivationCode().isEmpty();
        this.authorities = Arrays.stream(user.getRole().split(","))
                                    .map(SimpleGrantedAuthority::new)
                                    .collect(Collectors.toList());
    }

    public OwnUserDetails() {
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
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
