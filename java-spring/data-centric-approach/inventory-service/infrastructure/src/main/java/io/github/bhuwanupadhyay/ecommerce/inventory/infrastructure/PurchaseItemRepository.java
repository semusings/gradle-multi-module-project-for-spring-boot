package io.github.bhuwanupadhyay.ecommerce.inventory.infrastructure;

import io.github.bhuwanupadhyay.ecommerce.inventory.model.PurchaseItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseItemRepository extends JpaRepository<PurchaseItem, String> {

}
