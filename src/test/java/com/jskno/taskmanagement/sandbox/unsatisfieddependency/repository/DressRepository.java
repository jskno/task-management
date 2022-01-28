package com.jskno.taskmanagement.sandbox.unsatisfieddependency.repository;

import com.jskno.taskmanagement.sandbox.unsatisfieddependency.service.InventoryRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "dressRepository")
public class DressRepository implements InventoryRepository {
}
