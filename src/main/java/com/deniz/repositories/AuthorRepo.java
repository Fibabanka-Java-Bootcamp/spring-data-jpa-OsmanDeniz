package com.deniz.repositories;

import com.deniz.entities.Authors;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepo extends CrudRepository<Authors, Integer> {
}
