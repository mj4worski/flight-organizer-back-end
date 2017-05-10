package infrastructure.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final SpringDataJpaUserDetailsService userDetailsService;

    public SecurityConfiguration(SpringDataJpaUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(this.userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers( "/public/**","/console/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .csrf().disable();
        http
                .headers()
                .frameOptions()
                .sameOrigin();
        http
                .formLogin()
                .loginProcessingUrl("/login").permitAll()
                .and()
                .logout().permitAll()
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID");
    }

}
