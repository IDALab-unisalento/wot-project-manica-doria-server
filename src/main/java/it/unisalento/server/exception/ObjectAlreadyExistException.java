package it.unisalento.server.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class ObjectAlreadyExistException extends Exception {

    public ObjectAlreadyExistException() {
        super();
    }

    public ObjectAlreadyExistException(String message) {
        super(message);
    }

}
