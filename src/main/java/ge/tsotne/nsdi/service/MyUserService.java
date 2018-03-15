package ge.tsotne.nsdi.service;

import ge.tsotne.nsdi.model.MyUser;
import ge.tsotne.nsdi.model.User;
import ge.tsotne.nsdi.repository.MyUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserService implements UserDetailsService {
	private MyUserRepository myUserRepository;

	@Autowired
	public MyUserService(MyUserRepository myUserRepository) {
		this.myUserRepository = myUserRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		MyUser user = myUserRepository.getByUsername(username);
		if (user == null) {
			return null;
		}
		return new User(user);
	}

	public static User getUser(){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return (User) auth.getPrincipal();
	}
}
