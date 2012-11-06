package pe.proyecto.managed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import pe.proyecto.service.LoginService;

@Controller
public class AuthenticationManaged {

	private String user = null;
	private String password = null;
	private String rememberMe = null;

	@Autowired
	@Qualifier("loginServiceImpl")
	private LoginService loginService;
	
	public String login() {		
		return loginService.login(user, password, rememberMe);
	}

	public String logout() {
		return loginService.logout();
	}

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

	public String getRememberMe() {
		return rememberMe;
	}

	public void setRememberMe(String rememberMe) {
		this.rememberMe = rememberMe;
	}

	public LoginService getLoginService() {
		return loginService;
	}

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

}
