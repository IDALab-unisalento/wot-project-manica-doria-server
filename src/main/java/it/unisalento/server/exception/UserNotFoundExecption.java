package it.unisalento.server.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class UserNotFoundExecption extends Exception {

    public UserNotFoundExecption() {
        super();
    }

    public UserNotFoundExecption(String message) {
        super(message);
    }

}
