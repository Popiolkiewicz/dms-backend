package pl.dms.config;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import pl.dms.model.User;

public class CustomTokenEnhancer extends JwtAccessTokenConverter {

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        User user = (User) authentication.getPrincipal();

        Map<String, Object> additionalInformation = new LinkedHashMap<>(accessToken.getAdditionalInformation());

        additionalInformation.put("email", user.getEmail());

        DefaultOAuth2AccessToken customAccessToken = new DefaultOAuth2AccessToken(accessToken);
        customAccessToken.setAdditionalInformation(additionalInformation);

        return super.enhance(customAccessToken, authentication);
    }

}
