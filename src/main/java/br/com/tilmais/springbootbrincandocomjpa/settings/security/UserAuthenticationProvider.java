package br.com.tilmais.springbootbrincandocomjpa.settings.security;

import br.com.tilmais.springbootbrincandocomjpa.model.entity.User;
import br.com.tilmais.springbootbrincandocomjpa.model.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;

@Component
public class UserAuthenticationProvider implements AuthenticationProvider {

    private static final Logger logger = LoggerFactory.getLogger(UserAuthenticationProvider.class);
    private UserRepository userRepository;

    @Autowired
    public UserAuthenticationProvider(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        if (authentication.isAuthenticated()) return authentication;

        String email = authentication.getName();
        String password = authentication.getCredentials().toString();

        String msg =
                String.format("Authentication requested with the username = %s and password = %s", email, password);
        logger.info(msg);

        User user = this.userRepository.findByEmail(email);

        if (BCrypt.checkpw(password, user.getPassword())) {
            return new UsernamePasswordAuthenticationToken(user.getName(), user.getPassword());
        }
        throw new BadCredentialsException("Username and password not found");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
