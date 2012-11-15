package pe.proyecto.service.impl;

import javax.faces.context.FacesContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.RememberMeAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.RememberMeServices;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.proyecto.service.LoginService;

@Service
@Repository
@Transactional
public class LoginServiceImpl implements LoginService{

	@Autowired
	private AuthenticationManager authenticationManager = null;

	@Autowired
	private RememberMeServices rememberMeServices = null;

	@Autowired
	private UserDetailsService userDetailsService = null;

	public String login(String user, String password, String rememberMe) {
		Authentication result = null;
		if ("TRUE".equalsIgnoreCase(rememberMe)) {
			UserDetails userDetails = userDetailsService
					.loadUserByUsername(user);
			RememberMeAuthenticationToken rememberMeAuthenticationToken = new RememberMeAuthenticationToken(
					"jsfspring-sec", userDetails, userDetails.getAuthorities());
			HttpServletRequest httpServletRequest = (HttpServletRequest) FacesContext
					.getCurrentInstance().getExternalContext().getRequest();
			HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext
					.getCurrentInstance().getExternalContext().getResponse();
			rememberMeServices.loginSuccess(httpServletRequest,
					httpServletResponse, rememberMeAuthenticationToken);
			result = rememberMeAuthenticationToken;
		} else {
			Authentication request = new UsernamePasswordAuthenticationToken(
					user, password);
			result = authenticationManager.authenticate(request);
		}
		SecurityContextHolder.getContext().setAuthentication(result);
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
}
