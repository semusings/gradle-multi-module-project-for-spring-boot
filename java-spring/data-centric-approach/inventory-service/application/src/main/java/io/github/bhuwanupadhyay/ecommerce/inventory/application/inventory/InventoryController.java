package io.github.bhuwanupadhyay.ecommerce.inventory.application.inventory;

import io.github.bhuwanupadhyay.ecommerce.inventory.model.Inventory;
import io.github.bhuwanupadhyay.ecommerce.inventory.model.InventoryItem;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/inventories")
public class InventoryController {

    private final InventoryService inventoryService;

    @PostMapping
    public InventoryResponse createInventory(@Valid @RequestBody InventoryRequest request) {
        return buildInventoryResponse(inventoryService.newInventory(request));
    }

    @PutMapping("{inventoryId}")
    public InventoryResponse updateInventory(@NotBlank @PathVariable("inventoryId") String inventoryId,
                                             @Valid @RequestBody InventoryRequest request) {
        return buildInventoryResponse(inventoryService.updateInventory(inventoryId, request));
    }

    @PostMapping("{inventoryId}/items")
    public InventoryItemResponse addItem(@NotBlank @PathVariable("inventoryId") String inventoryId,
                                         @Valid @RequestBody InventoryItemRequest request) {
        return buildItemResponse(inventoryService.addItem(inventoryId, request));
    }

    @PutMapping("{inventoryId}/items/{itemId}")
    public InventoryItemResponse updateItem(@NotBlank @PathVariable("inventoryId") String inventoryId,
                                            @NotBlank @PathVariable("itemId") String itemId,
                                            @Valid @RequestBody InventoryItemRequest request) {
        return buildItemResponse(inventoryService.updateItem(inventoryId, itemId, request));
    }

    @DeleteMapping("{inventoryId}/items/{itemId}")
    public void deleteItem(@NotBlank @PathVariable("inventoryId") String inventoryId,
                           @NotBlank @PathVariable("itemId") String itemId) {
        inventoryService.deleteItem(inventoryId, itemId);
    }

    @DeleteMapping("{inventoryId}")
    public void deleteInventory(@NotBlank @PathVariable("inventoryId") String inventoryId) {
        inventoryService.deleteInventory(inventoryId);
    }

    private InventoryResponse buildInventoryResponse(Inventory inventory) {
        InventoryResponse response = new InventoryResponse();
        response.setInventoryId(inventory.getInventoryId());
        response.setInventoryName(inventory.getInventoryName());
        return response;
    }

    private InventoryItemResponse buildItemResponse(InventoryItem inventoryItem) {
        InventoryItemResponse response = new InventoryItemResponse();
        response.setInventoryId(inventoryItem.getInventory().getInventoryId());
        response.setItemId(inventoryItem.getItemId());
        response.setDiscount(inventoryItem.getDiscountPercentage());
        response.setPrice(inventoryItem.getPrice());
        response.setQuantity(inventoryItem.getQuantity());
        response.setItemName(inventoryItem.getItemName());
        return response;
    }

}
