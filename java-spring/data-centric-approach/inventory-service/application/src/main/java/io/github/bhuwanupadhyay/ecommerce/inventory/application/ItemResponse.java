package io.github.bhuwanupadhyay.ecommerce.inventory.application;

import lombok.Data;

@Data
public class ItemResponse {

    private String inventoryId;

    private String itemId;

    private String itemName;

    private Integer quantity;

    private Double price;

    private Integer discount;

}
