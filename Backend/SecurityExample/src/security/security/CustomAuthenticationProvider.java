package security.security;


@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private IUserService iUserService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getPrincipal().toString();
        Object credentials = authentication.getCredentials();
        String password = credentials == null ? null : credentials.toString();

        Optional<User> userOptional = this.iUserService.authenticate(username, password);
        if ( userOptional.isPresent() ) {
        	User user = userOptional.get();
        	SecurityUser securityUser = new SecurityUser(user, user.getUserCredentials().getPassword());

        	return new Oauth2ImprovedAuthenticationToken(securityUser, credentials);
        }

        throw new BadCredentialsException("Could not find user");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

}
