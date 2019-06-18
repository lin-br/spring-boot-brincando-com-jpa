package br.com.tilmais.springbootbrincandocomjpa.service.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class JwtDecoder {

    private String nameOfListGrantedAuthority;
    private String keySecret;
    private Claims claims;

    public JwtDecoder(String jwt, String keySecret, String nameOfListGrantedAuthority) throws JwtException {
        this.claims = Jwts.parser().setSigningKey(keySecret).parseClaimsJws(jwt).getBody();
        this.nameOfListGrantedAuthority = nameOfListGrantedAuthority;
    }

    public List<GrantedAuthority> getListGrantedAuthority() {
        if (this.claims.containsKey(this.nameOfListGrantedAuthority)) {
            @SuppressWarnings("unchecked")
            List<String> list =
                    (List<String>) this.claims.get(this.nameOfListGrantedAuthority, List.class);

            return list.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
        }

        return new ArrayList<>();
    }

    public String getSubJwt() {
        return this.claims.getSubject();
    }
}
