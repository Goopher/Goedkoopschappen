package security.security.token;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import security.model.SecurityUser;

import java.util.HashMap;
import java.util.Map;

// https://stackoverflow.com/questions/28492116/can-i-include-user-information-while-issuing-an-access-token
public class CustomTokenEnhancer implements TokenEnhancer {

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        SecurityUser securityUser = (SecurityUser) authentication.getPrincipal();
        final Map<String, Object> additionalInfo = new HashMap<>();

        // Plaatst extra informatie in de token die de browser ontvangt na inloggen. Zo hebben we de naam van de user zonder dat we die moeten opvragen
        additionalInfo.put("id", securityUser.getId() );
        additionalInfo.put("name", securityUser.getName() );
        additionalInfo.put("userRole", securityUser.getRole().name() );
        additionalInfo.put("language", securityUser.getLanguage() );

        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);

        return accessToken;
    }

}
