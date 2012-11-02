package pe.proyecto.managed;

import javax.faces.context.FacesContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.RememberMeAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.RememberMeServices;
import org.springframework.stereotype.Controller;

@Controller
public class AuthenticationManaged {

	private String user = null;
	private String password = null;
	private String rememberMe = null;

	@Autowired
	private AuthenticationManager authenticationManager = null;

	@Autowired
	private RememberMeServices rememberMeServices = null;

	@Autowired
	private UserDetailsService userDetailsService = null;

	public String login() {
		try {
			Authentication result = null;
			if ("TRUE".equalsIgnoreCase(this.rememberMe)) {
				UserDetails userDetails = userDetailsService
						.loadUserByUsername(getUser());
				RememberMeAuthenticationToken rememberMeAuthenticationToken = new RememberMeAuthenticationToken(
						"jsfspring-sec", userDetails,
						userDetails.getAuthorities());
				HttpServletRequest httpServletRequest = (HttpServletRequest) FacesContext
						.getCurrentInstance().getExternalContext().getRequest();
				HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext
						.getCurrentInstance().getExternalContext()
						.getResponse();
				rememberMeServices.loginSuccess(httpServletRequest,
						httpServletResponse, rememberMeAuthenticationToken);
				result = rememberMeAuthenticationToken;
			} else {
				Authentication request = new UsernamePasswordAuthenticationToken(
						this.getUser(), this.getPassword());
				result = authenticationManager.authenticate(request);
			}
			SecurityContextHolder.getContext().setAuthentication(result);
		} catch (AuthenticationException e) {
			e.printStackTrace();
		}		
		return "admin";
	}

	public String logout() {
		SecurityContextHolder.clearContext();
		HttpServletRequest httpServletRequest = (HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest();
		HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext
				.getCurrentInstance().getExternalContext().getResponse();
		Cookie cookie = new Cookie("SPRING_SECURITY_REMEMBER_ME_COOKIE", null);
		cookie.setMaxAge(0);
		cookie.setPath(httpServletRequest.getContextPath().length() > 0 ? httpServletRequest
				.getContextPath() : "/");
		httpServletResponse.addCookie(cookie);

		return "loggedout";
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

	public AuthenticationManager getAuthenticationManager() {
		return authenticationManager;
	}

	public void setAuthenticationManager(
			AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

	public RememberMeServices getRememberMeServices() {
		return rememberMeServices;
	}

	public void setRememberMeServices(RememberMeServices rememberMeServices) {
		this.rememberMeServices = rememberMeServices;
	}

	public UserDetailsService getUserDetailsService() {
		return userDetailsService;
	}

	public void setUserDetailsService(UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}

	public String getRememberMe() {
		return rememberMe;
	}

	public void setRememberMe(String rememberMe) {
		this.rememberMe = rememberMe;
	}

}
