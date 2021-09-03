package io.github.bhuwanupadhyay.ecommerce.inventory.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.List;

@Table(name = "purchase")
@Entity
@Getter
@Setter
@ToString
public class Purchase implements Serializable {

    @Id
    @Column(name = "purchase_id")
    private String purchaseId;

    @Column(name = "purchase_date", nullable = false)
    private Instant purchaseDate;

    @Column(name = "account_id", nullable = false)
    @ToString.Exclude
    private String accountId;

    @Column(name = "total_price", nullable = false)
    @ToString.Exclude
    private Double totalPrice;

    @Column(name = "total_discount")
    @ToString.Exclude
    private Double totalDiscount;

    @Column(name = "final_price")
    @ToString.Exclude
    private Double finalPrice;

    @OneToMany(mappedBy = "purchase", cascade = {CascadeType.REMOVE})
    @ToString.Exclude
    private List<PurchaseItem> items;

}
