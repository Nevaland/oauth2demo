package nevaland.oauth2demo.config;

import nevaland.oauth2demo.oauth2.KakaoOAuth2User;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class OAuthConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.oauth2Login(
                oauth2Login -> oauth2Login.userInfoEndpoint(
                        userInfoEndpoint -> userInfoEndpoint.customUserType(KakaoOAuth2User.class, "kakao")
                )
            )
            .logout()
            .logoutRequestMatcher(new AntPathRequestMatcher("/user/logout"))
            .logoutSuccessUrl("/")
            .invalidateHttpSession(true)
//        .and()
//            .rememberMe()
//                .key("myAppKey")
//                .rememberMeParameter("remember-me")
//                .tokenValiditySeconds(86400) // 1 day
//                .tokenRepository(persistentTokenRepository());
            .and()
                .exceptionHandling().accessDeniedPage("/");

    }

}
