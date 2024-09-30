package com.uiudevelopershub.thinktanku.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class DuplicateEmailException extends RuntimeException {

    String message;

    public DuplicateEmailException(String message) {

        super(message);
        this.message = message;

    }

}
