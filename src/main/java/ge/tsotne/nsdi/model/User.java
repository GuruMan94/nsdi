package ge.tsotne.nsdi.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

public class User implements UserDetails {
	private final long id;
	private final String username;
	private final String password;
	private final boolean enabled;
	private Collection<GrantedAuthority> authorities;


	public User(MyUser user){
		this.id = user.getId();
		this.username = user.getUsername();
		this.password = user.getPassword();
		this.enabled = user.getActive();
		this.authorities = new ArrayList<>();
	}

	public long getId() {
		return id;
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
		return enabled;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", username='" + username + '\'' +
				", password='" + password + '\'' +
				", enabled=" + enabled +
				", authorities=" + authorities +
				'}';
	}
}

