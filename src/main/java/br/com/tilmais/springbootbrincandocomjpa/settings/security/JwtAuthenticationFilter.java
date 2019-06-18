package br.com.tilmais.springbootbrincandocomjpa.settings.security;

import br.com.tilmais.springbootbrincandocomjpa.service.jwt.JwtDecoder;
import br.com.tilmais.springbootbrincandocomjpa.settings.ApplicationProperties;
import io.jsonwebtoken.JwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private ApplicationProperties applicationProperties;

    @Autowired
    public JwtAuthenticationFilter(ApplicationProperties applicationProperties) {
        this.applicationProperties = applicationProperties;
    }

    @Override
    public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException, JwtException {

        String token = this.getToken(request);

        JwtDecoder jwtDecoder = new JwtDecoder(
                token,
                this.applicationProperties.getToken().getKey(),
                this.applicationProperties.getToken().getClaimsName()
        );

        String subJwt = jwtDecoder.getSubJwt();

        List<GrantedAuthority> listGrantedAuthority = jwtDecoder.getListGrantedAuthority();

        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                subJwt, null, listGrantedAuthority
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        chain.doFilter(request, response);
    }

    private String getToken(HttpServletRequest request) throws JwtException {
        String header = request.getHeader(this.applicationProperties.getToken().getHeader());

        if (header == null || header.isEmpty()) throw new JwtException("Token in authentication header not found");

        return header.replace(this.applicationProperties.getToken().getPrefix(), "").trim();
    }
}
