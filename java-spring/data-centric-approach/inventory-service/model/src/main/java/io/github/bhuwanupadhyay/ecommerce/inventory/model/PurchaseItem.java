package io.github.bhuwanupadhyay.ecommerce.inventory.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "purchase_item")
@Entity
@Getter
@Setter
@ToString
public class PurchaseItem implements Serializable {

    @Id
    @Column(name = "item_id")
    private String itemId;

    @Column(name = "quantity", nullable = false)
    @ToString.Exclude
    private Integer quantity;

    @Column(name = "price", nullable = false)
    @ToString.Exclude
    private Double price;

    @Column(name = "discount_percentage")
    @ToString.Exclude
    private Integer discountPercentage;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "purchase_purchase_id")
    private Purchase purchase;

}
