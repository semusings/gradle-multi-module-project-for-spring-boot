package io.github.bhuwanupadhyay.ecommerce.inventory.application.inventory;

import lombok.Data;

@Data
public class InventoryItemResponse {

    private String inventoryId;

    private String itemId;

    private String itemName;

    private Integer quantity;

    private Double price;

    private Integer discount;

}
