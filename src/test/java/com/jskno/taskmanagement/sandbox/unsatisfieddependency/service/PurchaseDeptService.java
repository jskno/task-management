package com.jskno.taskmanagement.sandbox.unsatisfieddependency.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class  PurchaseDeptService {

    @Autowired
    private InventoryRepository shoeRepository;

    @Autowired
    @Qualifier(value = "runnerRepository")
    private InventoryRepository runnerRepository;

    @Autowired
    @Qualifier("dressRepository")
    private InventoryRepository inventoryRepository;

}
