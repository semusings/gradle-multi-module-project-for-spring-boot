package io.github.bhuwanupadhyay.ecommerce.inventory.application;

public class EntityNotFound extends RuntimeException {

    public EntityNotFound(String message) {
        super(message);
    }

}
