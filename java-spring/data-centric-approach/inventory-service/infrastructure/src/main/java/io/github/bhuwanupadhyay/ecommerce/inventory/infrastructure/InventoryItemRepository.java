package io.github.bhuwanupadhyay.ecommerce.inventory.infrastructure;

import io.github.bhuwanupadhyay.ecommerce.inventory.model.InventoryItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryItemRepository extends JpaRepository<InventoryItem, String> {

}
