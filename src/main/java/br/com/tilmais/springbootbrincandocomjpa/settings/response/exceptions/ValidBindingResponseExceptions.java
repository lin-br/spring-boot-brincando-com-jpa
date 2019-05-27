package br.com.tilmais.springbootbrincandocomjpa.settings.response.exceptions;

import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ValidBindingResponseExceptions {

    private Calendar timestamp;
    private Map<String, String> errorsBinding = new HashMap<>();

    public ValidBindingResponseExceptions(Calendar timestamp) {
        this.timestamp = timestamp;
    }

    public Calendar getTimestamp() {
        return timestamp;
    }

    public Map<String, String> getErrorsBinding() {
        return Collections.unmodifiableMap(errorsBinding);
    }

    public void setErrorsBinding(String field, String message) {
        this.errorsBinding.put(field, message);
    }
}
