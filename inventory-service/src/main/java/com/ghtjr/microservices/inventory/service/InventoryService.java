package com.ghtjr.microservices.inventory.service;

import com.ghtjr.microservices.inventory.repository.InventoryRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRespository inventoryRespository;

    public boolean isInStock(String skuCode, Integer quantity) {
        return inventoryRespository.existsBySkuCodeAndQuantityIsGreaterThanEqual(skuCode, quantity);
    }
}
