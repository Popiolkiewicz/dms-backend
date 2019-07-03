package pl.dms.config;

import java.util.Arrays;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import pl.dms.api.rest.LoginServiceRestController;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().configurationSource(createCordConfigurationSource());
        http.authorizeRequests()
            .antMatchers(LoginServiceRestController.LOGIN_URL + "/testRequest").permitAll()
            .antMatchers("/").permitAll()
            .anyRequest().authenticated();
    }

    private CorsConfigurationSource createCordConfigurationSource() {
        return request -> {
            CorsConfiguration config = new CorsConfiguration();
            config.setAllowCredentials(false);
            // TODO add appropriate origins
            config.setAllowedOrigins(Arrays.asList("*"));
            config.addAllowedHeader("*");
            config.addAllowedMethod("*");
            return config;
        };
    }

}
