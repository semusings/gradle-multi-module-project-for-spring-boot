package io.github.bhuwanupadhyay.ecommerce.inventory.application;

import lombok.Data;

@Data
public class ItemRequest {

    private String itemName;

    private Integer quantity;

    private Double price;

    private Integer discount;

}
