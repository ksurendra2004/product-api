package com.productapi.controller;

import com.productapi.model.Inventory;
import com.productapi.service.IInventoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class InventoryController {

    @Autowired
    IInventoryService iInventoryService;

    private final Logger logger = LoggerFactory.getLogger(InventoryController.class);

    @PostMapping("/getInvPicture")
    public Inventory getInvPicture(@RequestBody Inventory inventoryList) {
        logger.info("In getInvPicture method");
        return iInventoryService.getInvDetails(inventoryList);
    }
}
