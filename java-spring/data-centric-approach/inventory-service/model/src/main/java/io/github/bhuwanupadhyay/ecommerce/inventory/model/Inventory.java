package io.github.bhuwanupadhyay.ecommerce.inventory.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Table(name = "inventory")
@Entity
@Getter
@Setter
@ToString
public class Inventory implements Serializable {

    @Id
    @Column(name = "inventory_id")
    private String inventoryId;

    @Column(name = "inventory_name", nullable = false, length = 500)
    private String inventoryName;

    @OneToMany(mappedBy = "inventory", cascade = {CascadeType.REMOVE})
    @ToString.Exclude
    private List<InventoryItem> inventoryItems;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Inventory inventory = (Inventory) o;
        return Objects.equals(inventoryId, inventory.inventoryId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(inventoryId);
    }
}
