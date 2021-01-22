package com.deniz.repositories;

import com.deniz.entities.Orders;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepo extends CrudRepository<Orders, Integer> {
}
