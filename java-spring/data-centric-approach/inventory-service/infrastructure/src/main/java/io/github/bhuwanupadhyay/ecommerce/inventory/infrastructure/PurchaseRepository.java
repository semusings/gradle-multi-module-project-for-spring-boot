package io.github.bhuwanupadhyay.ecommerce.inventory.infrastructure;

import io.github.bhuwanupadhyay.ecommerce.inventory.model.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends JpaRepository<Purchase, String> {

}
