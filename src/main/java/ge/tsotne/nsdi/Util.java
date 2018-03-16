package ge.tsotne.nsdi;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class Util {
	private static final int WORKLOAD = 12;

	public static String hashPassword(String passwordPlaintext) {
		String salt = BCrypt.gensalt(WORKLOAD);
		return(BCrypt.hashpw(passwordPlaintext, salt));
	}

}
