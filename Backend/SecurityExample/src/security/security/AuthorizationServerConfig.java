package security.security;


@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Value("${oauth.tokenTimeout:3600}")
	private int expiration;

	@Value("${oauth.client:''}")
	private String oauthClient;

	@Value("${oauth.secret:''}")
	private String oauthSecret;

	// https://stackoverflow.com/questions/26750999/spring-security-oauth2-check-token-endpoint
	@Bean
	public TokenEnhancer tokenEnhancer() {
		return new CustomTokenEnhancer();
	}

	@Bean
	public TokenStore tokenStore() {
		return new InMemoryTokenStore();
	}

	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		security.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()")
				.allowFormAuthenticationForClients();
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory().withClient(this.oauthClient).secret(this.oauthSecret)
				.authorizedGrantTypes("client-credentials", "password", "refresh_token")
				.authorities("ROLE_USER", "ROLE_ADMIN").scopes("read", "write", "trust")
				.resourceIds(ResourceServerConfig.RESOURCE_ID).accessTokenValiditySeconds(expiration)
				.refreshTokenValiditySeconds(50000);
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer configurer) throws Exception {
		configurer.tokenEnhancer(tokenEnhancer());
		configurer.authenticationManager(authenticationManager);
	}

}
