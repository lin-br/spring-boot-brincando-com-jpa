package br.com.tilmais.springbootbrincandocomjpa.settings.security;

import br.com.tilmais.springbootbrincandocomjpa.settings.ApplicationProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecutiryConfig extends WebSecurityConfigurerAdapter {

    private UserAuthenticationProvider userAuthenticationProvider;
    private ApplicationProperties applicationProperties;
    private ExceptionHandlerFilter exceptionHandlerFilter;
    private MethodNotAllowedFilter methodNotAllowedFilter;
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    @Autowired
    public SecutiryConfig(UserAuthenticationProvider userAuthenticationProvider,
                          ApplicationProperties applicationProperties,
                          ExceptionHandlerFilter exceptionHandlerFilter,
                          MethodNotAllowedFilter methodNotAllowedFilter,
                          JwtAuthenticationFilter jwtAuthenticationFilter) {
        this.userAuthenticationProvider = userAuthenticationProvider;
        this.applicationProperties = applicationProperties;
        this.exceptionHandlerFilter = exceptionHandlerFilter;
        this.methodNotAllowedFilter = methodNotAllowedFilter;
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(this.userAuthenticationProvider);
    }

    private LoginFilter getLoginFilter() throws Exception {
        return new LoginFilter(this.authenticationManager(), this.applicationProperties);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .addFilterBefore(this.methodNotAllowedFilter, UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(this.exceptionHandlerFilter, UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(this.getLoginFilter(), UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(this.jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers(HttpMethod.POST, "/login").permitAll()
                .anyRequest()
                .authenticated();
    }
}
