package ge.tsotne.nsdi;

import ge.tsotne.nsdi.repository.MyUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NsdiApplication{
	@Autowired
	MyUserRepository myUserRepository;
	public static void main(String[] args) {
		SpringApplication.run(NsdiApplication.class, args);
	}
}
