package br.com.tilmais.springbootbrincandocomjpa.util;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class GeneratorURI {

    public static URI getUriAddId(Long id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
    }

    public static URI getUriWithoutResources() throws URISyntaxException {
        final Pattern pattern = Pattern.compile("(^http:\\/\\/\\w+)([?=:|\\/][?=\\d]+)?(\\/api\\/)(\\w+\\/)(\\d)?");
        final RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
        final HttpServletRequest teste = ((ServletRequestAttributes) requestAttributes).getRequest();
        final StringBuffer requestURL = teste.getRequestURL();

        final Matcher matcher = pattern.matcher(requestURL.toString());

        if (matcher.find()) {
            final String group = matcher.group();
            return new URI(group);
        }
        throw new URISyntaxException(requestURL.toString(), "there was no match in the request URL");
    }
}
