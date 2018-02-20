package security.controller;


@RestController
public class UserController {

	@Autowired
	private IUserService iUserService;

	@PostMapping("/api/user/register")
	public ResponseDto<Void> register( @RequestBody RegisterDto registerDto ) {
		User user = new User();
		user.setEmail(registerDto.getEmail());
		user.setEnabled(true);
		user.setFirstName(registerDto.getFirstName());
		user.setLastName(registerDto.getLastName());
		user.setLanguage(registerDto.getLanguage());
		user.setRole(UserRole.ROLE_USER);

		UserCredential userCredential = new UserCredential();
		userCredential.setPassword(registerDto.getPassword());
		userCredential.setUser(user);

		this.iUserService.register(user, userCredential);

		return new ResponseDto<Void>(true, null);
	}

}
