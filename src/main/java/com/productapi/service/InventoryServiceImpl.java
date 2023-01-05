package com.productapi.service;

import com.productapi.exception.InvalidRequestDateException;
import com.productapi.model.Inventory;
import com.productapi.utils.DateUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class InventoryServiceImpl implements IInventoryService {

    private final Logger logger = LoggerFactory.getLogger(InventoryServiceImpl.class);
    private final List<Inventory> invList = Arrays.asList(
            new Inventory("Prod1","Shirt","EACH", 10d,
                    DateUtility.localDateFormatter("2021-03-19")),
            new Inventory ("Prod1","Shirt","EACH", 20d,
                    DateUtility.localDateFormatter("2021-03-21")),
            new Inventory ("Prod1","Shirt","EACH", 20d,
                    DateUtility.localDateFormatter("2021-03-28"))
    );
    @Override
    public Inventory getInvDetails(Inventory inventoryList) {

        if(DateUtility.isValidDate(inventoryList, invList)) {
            logger.debug("Requested date is not valid");
            throw new InvalidRequestDateException("Invalid Requested Date.");
        } else {
            logger.info("Valid Requested Date.");
            inventoryList.setAvailQty(invList
                            .stream()
                            .filter(i -> i.getAvailDate().isEqual(inventoryList.getAvailDate())
                                    || i.getAvailDate().isAfter(inventoryList.getAvailDate()))
                            .mapToDouble(Inventory::getAvailQty)
                            .sum());
            return inventoryList;
        }
    }
}
