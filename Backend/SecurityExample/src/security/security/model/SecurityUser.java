package security.security.model;


public class SecurityUser extends User implements UserDetails {

	private static final long serialVersionUID = 2110085871278467800L;

	private String password;

    public SecurityUser() {
    	
    }

    public SecurityUser( User user, String password ) {
    	this.id = user.getId();
    	this.firstName = user.getFirstName();
    	this.lastName = user.getLastName();
    	this.email = user.getEmail();
    	this.password = password;
    	this.language = user.getLanguage();
    	this.role = user.getRole();
    	this.enabled = user.isEnabled();
    }
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority(this.role.name()));
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }

	public Long getId() {
		return id;
	}

	public String getName() {
		return this.getFullName();
	}

	public String getEmail() {
		return email;
	}

	public String getLanguage() {
		return language;
	}
    
}
