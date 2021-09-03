package io.github.bhuwanupadhyay.ecommerce.inventory.application.core;

public class EntityNotFound extends RuntimeException {

    public EntityNotFound(String message) {
        super(message);
    }

}
