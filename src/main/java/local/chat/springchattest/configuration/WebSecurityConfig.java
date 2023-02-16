package local.chat.springchattest.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@EnableWebSecurity
public class WebSecurityConfig {
    //https://spring.io/blog/2022/02/21/spring-security-without-the-websecurityconfigureradapter

    private final DataSource dataSource;

    public WebSecurityConfig(@Autowired DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public UserDetailsManager users() {
        return new JdbcUserDetailsManager(dataSource);
    }

    /*@Bean
    public SecurityFilterChain filterChain(HttpSecurity http)
            throws Exception {
        http.authorizeHttpRequests()
                .requestMatchers(HttpMethod.POST, "/login")
                .permitAll().anyRequest().authenticated()
                .requestMatchers("/", "/login")
                .permitAll()
                .requestMatchers("/rooms/1", "/users")
                .hasAnyRole("REGULAR", "ADMINISTRATOR")
                .and().exceptionHandling()
                .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
                .and().formLogin().permitAll()
                .loginProcessingUrl("/login");
        return http.build();
    }*/

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http)
            throws Exception {
        http
                .authorizeHttpRequests()
                .requestMatchers("/rooms/**", "/users/**")
                .hasAnyAuthority("REGULAR", "ADMINISTRATOR")
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/login2")
                .permitAll();


        return http.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web
                .ignoring()
                .requestMatchers("/css/**", "/js/**");
    }
}
