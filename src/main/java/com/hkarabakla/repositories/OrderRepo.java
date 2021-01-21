package com.hkarabakla.repositories;

import com.hkarabakla.entities.Orders;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepo extends CrudRepository<Orders, Integer> {
}
