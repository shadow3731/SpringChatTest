package local.chat.springchattest.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

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

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)
            throws Exception {
        http
                .headers()
                .frameOptions()
                .sameOrigin()
                .and()
                .authorizeHttpRequests()
                .requestMatchers("/", "/login")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin(form -> form
                        .loginPage("/login")
                        .loginProcessingUrl("/login2")
                        .defaultSuccessUrl("/", true)
                        .failureForwardUrl("/login?error=true"));
        return http.build();
    }

}
