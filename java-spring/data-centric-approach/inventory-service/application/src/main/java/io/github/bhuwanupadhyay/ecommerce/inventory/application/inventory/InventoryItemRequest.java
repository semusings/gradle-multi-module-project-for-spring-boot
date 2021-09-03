package io.github.bhuwanupadhyay.ecommerce.inventory.application.inventory;

import lombok.Data;

@Data
public class InventoryItemRequest {

    private String itemName;

    private Integer quantity;

    private Double price;

    private Integer discount;

}
