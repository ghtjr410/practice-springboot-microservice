package com.ghtjr.microservices.inventory.controller;

import com.ghtjr.microservices.inventory.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public boolean isInStock(@RequestParam String skuCode, @RequestParam Integer quantity) {
//                try{
//            Thread.sleep(5000);
//        } catch (InterruptedException e){
//            throw new RuntimeException(e);
//        }
        return inventoryService.isInStock(skuCode, quantity);
    }
}
