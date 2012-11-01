package pe.proyecto.managed;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

@Controller
public class AuthenticationManaged {

	private String user = null;
	private String password = null;

	@Autowired
	private AuthenticationManager authenticationManager = null;

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public AuthenticationManager getAuthenticationManager() {
		return authenticationManager;
	}

	public void setAuthenticationManager(
			AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

	public String login() {

		try {

			Authentication request = new UsernamePasswordAuthenticationToken(
					this.getUser(), this.getPassword());

			Authentication result = authenticationManager.authenticate(request);

			SecurityContextHolder.getContext().setAuthentication(result);

		} catch (AuthenticationException e) {

			e.printStackTrace();

		}

		return "admin";

	}

}
