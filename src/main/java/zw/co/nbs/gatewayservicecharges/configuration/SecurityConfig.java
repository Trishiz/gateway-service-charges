package zw.co.nbs.gatewayservicecharges.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsUtils;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

    @Value("${basic.user.username}")
    private String userUserName;

    @Value("${basic.user.password}")
    private String userPassword;

    @Value("${basic.user.role}")
    private String userRole;

    public SecurityConfig(final ApplicationContext context) {
        this.passwordEncoder = context.getBean(PasswordEncoder.class);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .requestMatchers(CorsUtils::isPreFlightRequest).permitAll()
                .antMatchers(AUTH_WHITELIST).permitAll()
                .antMatchers(AUTH_PROTECTED).authenticated()
                .anyRequest().permitAll()
                .and()
                .httpBasic();
    }


    @Override
    public void configure(final AuthenticationManagerBuilder auth)
            throws Exception {
        auth.inMemoryAuthentication()
                .withUser(userUserName).password(passwordEncoder.encode(userPassword)).roles(userRole);
    }

    private static final String[] AUTH_WHITELIST = {
            // -- swagger ui
            "/swagger-resources/**",
            "/swagger-ui.html",
            "/v2/api-docs",
            "/webjars/**"
    };

    private static final String[] AUTH_PROTECTED = {
            "/authorization/login",
            "/authorization/validate-token",
            "/authorization/users",
            "/authorization/users/**",
            "/notifications",
            "/notifications/**",
            "/vao"
    };

}