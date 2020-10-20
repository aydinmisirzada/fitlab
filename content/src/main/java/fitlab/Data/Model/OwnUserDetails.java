package fitlab.Data.Model;

import org.springframework.security.core.GrantedAuthority;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class OwnUserDetails implements UserDetails {

    private String username;
    private String password;
    private List<GrantedAuthority> authorities;

    public OwnUserDetails(User user) {
        this.username = user.getUsername();
        this.password = user.getPassword();
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

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
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
