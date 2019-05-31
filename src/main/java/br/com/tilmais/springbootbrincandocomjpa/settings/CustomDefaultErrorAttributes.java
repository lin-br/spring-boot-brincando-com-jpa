package br.com.tilmais.springbootbrincandocomjpa.settings;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

@Component
public class CustomDefaultErrorAttributes extends DefaultErrorAttributes {

    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {

        Map<String, Object> errorAttributes = super.getErrorAttributes(webRequest, includeStackTrace);

        errorAttributes.remove("status");
        errorAttributes.remove("error");
        errorAttributes.remove("path");

        return errorAttributes;
    }
}
