package br.com.tilmais.springbootbrincandocomjpa.dto.response.exceptions;

import java.util.Calendar;

public class BasicResponseForExceptions {

    private Calendar timestamp;
    private String message;

    public BasicResponseForExceptions(Calendar timestamp, String message) {
        this.timestamp = timestamp;
        this.message = message;
    }

    public Calendar getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }
}
