package io.github.bhuwanupadhyay.ecommerce.inventory.infrastructure;

import io.github.bhuwanupadhyay.ecommerce.inventory.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, String> {
}
