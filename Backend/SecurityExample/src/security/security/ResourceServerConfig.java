package security.security;


public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

	public static final String RESOURCE_ID = "JeEigenResourceId";

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http
		.csrf()
		.disable()
		.anonymous()
		.and()
		.authorizeRequests()
		.antMatchers("/api/user/register").permitAll() // Register dat mag iedereen. Dan is er nog geen access token dus register url is permitAll 
		.antMatchers("/api/**")
		.authenticated()
		.and().exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler());
	}

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) {
		resources.resourceId(RESOURCE_ID);
	}

}
