package bartosz.szablewski.cache.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EntityNotFound extends RuntimeException{

    public EntityNotFound(String entityName, long id) {
        super(String.format("Entity: %s by id %s not found.", entityName, id));
    }
}
