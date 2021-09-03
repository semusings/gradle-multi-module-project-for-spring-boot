module microservice.architecture.patterns.java.spring.data.centric.approach.inventory.service.application.main {
    requires lombok;
    requires spring.context;
    requires spring.boot;
    requires spring.web;
    requires spring.tx;
    requires java.validation;
    requires spring.boot.autoconfigure;

    requires microservice.architecture.patterns.java.spring.data.centric.approach.inventory.service.infrastructure.main;
    requires microservice.architecture.patterns.java.spring.data.centric.approach.inventory.service.model.main;

    exports io.github.bhuwanupadhyay.ecommerce.inventory.application;
    exports io.github.bhuwanupadhyay.ecommerce.inventory.application.core;
    exports io.github.bhuwanupadhyay.ecommerce.inventory.application.inventory;
}
