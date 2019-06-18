package br.com.tilmais.springbootbrincandocomjpa.settings.security;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.server.MethodNotAllowedException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

@Component
public class MethodNotAllowedFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        final String method = request.getMethod();
        final String requestURI = request.getRequestURI();

        if (!method.equals(HttpMethod.POST.name()) && requestURI.equals("/api/login"))
            throw new MethodNotAllowedException(method, Collections.singleton(HttpMethod.POST));

        filterChain.doFilter(request, response);
    }
}
