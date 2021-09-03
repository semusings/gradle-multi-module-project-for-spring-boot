package io.github.bhuwanupadhyay.ecommerce.inventory.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Table(name = "inventory_item")
@Entity
@Getter
@Setter
@ToString
public class InventoryItem implements Serializable {

    @Id
    @Column(name = "item_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String itemId;

    @Column(name = "item_name", nullable = false, length = 500)
    private String itemName;

    @Column(name = "quantity", nullable = false)
    @ToString.Exclude
    private Integer quantity;

    @Column(name = "price", nullable = false)
    @ToString.Exclude
    private Double price;

    @Column(name = "discount")
    @ToString.Exclude
    private Integer discount;

    @ManyToOne
    @JoinColumn(name = "inventory_id", nullable = false)
    @ToString.Exclude
    private Inventory inventory;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InventoryItem item = (InventoryItem) o;
        return Objects.equals(itemId, item.itemId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemId);
    }
}
