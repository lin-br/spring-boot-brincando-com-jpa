package br.com.tilmais.springbootbrincandocomjpa.settings.security;

import br.com.tilmais.springbootbrincandocomjpa.dto.request.LoginRequestDTO;
import br.com.tilmais.springbootbrincandocomjpa.service.jwt.JwtCreator;
import br.com.tilmais.springbootbrincandocomjpa.settings.ApplicationProperties;
import br.com.tilmais.springbootbrincandocomjpa.util.UnauthorizedUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Date;

public class LoginFilter extends AbstractAuthenticationProcessingFilter {

    private final ApplicationProperties applicationProperties;

    public LoginFilter(AuthenticationManager authenticationManager, ApplicationProperties applicationProperties) {
        super(new AntPathRequestMatcher("/login", HttpMethod.POST.name()));
        this.setAuthenticationManager(authenticationManager);
        this.applicationProperties = applicationProperties;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response)
            throws AuthenticationException, IOException {

        LoginRequestDTO loginRequestDTO = new ObjectMapper().readValue(request.getInputStream(), LoginRequestDTO.class);

        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                loginRequestDTO.getUsername(),
                loginRequestDTO.getPassword()
        );

        return getAuthenticationManager().authenticate(authentication);
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request,
                                              HttpServletResponse response,
                                              AuthenticationException failed) {

        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.setCharacterEncoding(StandardCharsets.UTF_8.toString());
        response.setHeader(UnauthorizedUtil.WWWAuthenticate, UnauthorizedUtil.getWWWAuthenticate(request, failed));
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) {

        JwtCreator jwtCreator = new JwtCreator(
                this.applicationProperties.getToken().getClaimsName(),
                this.applicationProperties.getToken().getKey()
        );

        Date exp = new Date(System.currentTimeMillis() +
                this.applicationProperties.getToken().getDurationInMilliseconds()
        );

        String jwt = jwtCreator.getJwt(authResult.getName(), exp, authResult.getAuthorities());

        response.addHeader(
                this.applicationProperties.getToken().getHeader(),
                this.applicationProperties.getToken().getPrefix() + " " + jwt
        );
    }
}
