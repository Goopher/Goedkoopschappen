package security.security.token;


import security.security.model.SecurityUser;

public class Oauth2ImprovedAuthenticationToken extends UsernamePasswordAuthenticationToken {

	private static final long serialVersionUID = -9054199564089303731L;

	public Oauth2ImprovedAuthenticationToken(SecurityUser securityUser, Object credentials) {
		super(securityUser, credentials, securityUser.getAuthorities());
	}

//	public Oauth2ImprovedAuthenticationToken(Object principal, Object credentials) {
//		super(principal, credentials);
//	}
//
//	public Oauth2ImprovedAuthenticationToken(Object principal, Object credentials, GrantedAuthority authority) {
//		super(principal, credentials, Arrays.asList(authority));
//	}

}
