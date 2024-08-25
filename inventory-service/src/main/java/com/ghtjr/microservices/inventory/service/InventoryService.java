package com.ghtjr.microservices.inventory.service;

import com.ghtjr.microservices.inventory.repository.InventoryRespository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class InventoryService {

    private final InventoryRespository inventoryRespository;

    public boolean isInStock(String skuCode, Integer quantity) {
        try {
            boolean inStock = inventoryRespository.existsBySkuCodeAndQuantityIsGreaterThanEqual(skuCode, quantity);
            log.info("Checked stock for SKU: {} with quantity: {} - In stock: {}", skuCode, quantity, inStock);

            return inStock;
        } catch (Exception e) {
            log.error("Failed to check stock for SKU: {} with quantity: {}", skuCode, quantity, e);
            return false;
        }
    }
}
