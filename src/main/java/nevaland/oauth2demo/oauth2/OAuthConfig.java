package nevaland.oauth2demo.oauth2;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class OAuthConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.oauth2Login(
                oauth2Login -> oauth2Login.userInfoEndpoint(
                        userInfoEndpoint -> userInfoEndpoint.customUserType(KakaoOAuth2User.class, "kakao")
                )
        );
    }
}