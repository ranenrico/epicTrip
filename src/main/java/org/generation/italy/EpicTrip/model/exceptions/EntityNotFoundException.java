package org.generation.italy.EpicTrip.model.exceptions;

public class EntityNotFoundException extends Exception {

    public EntityNotFoundException(Class<?> entityClass, long id) {
        super(String.format("La entity %s con id %d non esiste", entityClass.getSimpleName(), id));
    }
}
