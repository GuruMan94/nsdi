package ge.tsotne.nsdi.configurarion;

import ge.tsotne.nsdi.service.MyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	private MyUserService myUserService;

	@Autowired
	public WebSecurityConfig(MyUserService myUserService) {
		this.myUserService = myUserService;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(myUserService).passwordEncoder(new BCryptPasswordEncoder());
	}

//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		User.withDefaultPasswordEncoder().username("user").password("user").roles("USER").build();
//	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
				.antMatchers("/login.html", "/registration", "/css/*").permitAll()
                .anyRequest().authenticated()
				.and()
				.formLogin()
				.loginPage("/login.html")
				.loginProcessingUrl("/login");
	}
}
