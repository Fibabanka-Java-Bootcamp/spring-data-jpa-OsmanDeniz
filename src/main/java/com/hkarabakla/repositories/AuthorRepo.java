package com.hkarabakla.repositories;

import com.hkarabakla.entities.Authors;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepo extends CrudRepository<Authors, Integer> {
}
