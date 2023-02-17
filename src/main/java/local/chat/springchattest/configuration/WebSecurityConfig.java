/*package local.chat.springchattest.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    //https://spring.io/blog/2022/02/21/spring-security-without-the-websecurityconfigureradapter

    /*@Bean
    public SecurityFilterChain filterChain(HttpSecurity http)
            throws Exception {
        http
                .csrf()
                .disable()
                .authorizeHttpRequests()
                .requestMatchers("/css/**", "/js/**", "/", "/login")
                .permitAll()
                .requestMatchers(HttpMethod.POST, "/login")
                .permitAll()
                .requestMatchers("/rooms/**", "/users/**")
                .hasAnyRole("REGULAR", "ADMINISTRATOR")
                .and()
                .formLogin(form -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/")
                        .loginProcessingUrl("/login")
                        .failureUrl("/login?error=true")
                        .permitAll()
                );
        return http.build();
    }*/

/*import org.springframework.context.annotation.Bean;

@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)
            throws Exception {
        http
                .csrf()
                .csrfTokenRepository(CookieCsrfTokenRepository
                        .withHttpOnlyFalse())
                .and()
                .authorizeHttpRequests()
                .requestMatchers("/js/**", "/", "/login")
                .permitAll()
                .requestMatchers(HttpMethod.POST, "/login2")
                .permitAll()
                .and()
                .formLogin(form -> form
                        .loginPage("/login")
                        .loginProcessingUrl("/login2")
                        .defaultSuccessUrl("/", true)
                        .failureForwardUrl("/login?error=true")
                );
        return http.build();
    }

}*/
