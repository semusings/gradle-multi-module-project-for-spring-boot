package io.github.bhuwanupadhyay.ecommerce.inventory.application.inventory;

import io.github.bhuwanupadhyay.ecommerce.inventory.application.core.EntityNotFound;
import io.github.bhuwanupadhyay.ecommerce.inventory.infrastructure.InventoryRepository;
import io.github.bhuwanupadhyay.ecommerce.inventory.infrastructure.ItemRepository;
import io.github.bhuwanupadhyay.ecommerce.inventory.model.Inventory;
import io.github.bhuwanupadhyay.ecommerce.inventory.model.InventoryItem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    private final ItemRepository itemRepository;

    public InventoryItem addItem(String inventoryId, InventoryItemRequest request) {
        Inventory inventory = getInventory(inventoryId);
        InventoryItem item = new InventoryItem();
        item.setItemId(UUID.randomUUID().toString());
        item.setInventory(inventory);
        item.setItemName(request.getItemName());
        item.setPrice(request.getPrice());
        item.setQuantity(request.getQuantity());
        item.setDiscount(request.getDiscount());
        return itemRepository.save(item);
    }

    public InventoryItem updateItem(String inventoryId, String itemId, InventoryItemRequest request) {
        Inventory inventory = getInventory(inventoryId);
        InventoryItem item = getItem(itemId);
        item.setInventory(inventory);
        item.setItemName(request.getItemName());
        item.setPrice(request.getPrice());
        item.setQuantity(request.getQuantity());
        item.setDiscount(request.getDiscount());
        return itemRepository.save(item);
    }

    public void deleteItem(String inventoryId, String itemId) {
        Inventory inventory = getInventory(inventoryId);
        assert inventory != null;
        InventoryItem item = getItem(itemId);
        itemRepository.delete(item);
    }

    public Inventory newInventory(InventoryRequest request) {
        Inventory inventory = new Inventory();
        inventory.setInventoryId(UUID.randomUUID().toString());
        inventory.setInventoryName(request.getInventoryName());
        return inventoryRepository.save(inventory);
    }

    public Inventory updateInventory(String inventoryId, InventoryRequest request) {
        Inventory inventory = getInventory(inventoryId);
        inventory.setInventoryName(request.getInventoryName());
        return inventoryRepository.save(inventory);
    }

    public void deleteInventory(String inventoryId) {
        Inventory inventory = getInventory(inventoryId);
        inventoryRepository.delete(inventory);
    }


    private Inventory getInventory(String inventoryId) {
        return inventoryRepository.findById(inventoryId)
                .orElseThrow(() -> new EntityNotFound(String.format("Inventory [%s] does not exist", inventoryId)));
    }

    private InventoryItem getItem(String itemId) {
        return itemRepository.findById(itemId)
                .orElseThrow(() -> new EntityNotFound(String.format("Item [%s] does not exist", itemId)));
    }
}
