package bj.uac.ine.webdev.exceptions;

import lombok.Getter;

@Getter
public class EntityNotFoundException extends RuntimeException {
    private String entity;
    private String fieldName;
    private String fieldValue;

    public EntityNotFoundException(
            String entity, String fieldName, String fieldValue
    ) {
        super("Any entity " + entity + " was found with value " + fieldValue + " in field " + fieldName);
        this.entity = entity;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}
