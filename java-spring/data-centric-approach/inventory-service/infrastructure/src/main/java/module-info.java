module microservice.architecture.patterns.java.spring.data.centric.approach.inventory.service.infrastructure.main {
    requires lombok;
    requires spring.data.jpa;
    requires microservice.architecture.patterns.java.spring.data.centric.approach.inventory.service.model.main;

    exports io.github.bhuwanupadhyay.ecommerce.inventory.infrastructure;
}
