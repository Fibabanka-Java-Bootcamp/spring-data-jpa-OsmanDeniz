package com.deniz.repositories;

import com.deniz.entities.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoryRepo extends CrudRepository<Category, Integer> {
    List<Category> findAllByName(String name);
}
