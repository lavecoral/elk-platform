package me.lavecoral.elk.auth.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

/**
 * @author lave
 * @date 2021/4/1 03:30
 */
public class ObjectNotFoundException extends ResponseStatusException {
    private static final long serialVersionUID = 6926423065433667648L;

    public ObjectNotFoundException() {
        super(HttpStatus.NOT_FOUND);
    }
}
