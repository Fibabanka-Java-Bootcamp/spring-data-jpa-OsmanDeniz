package com.deniz.repositories;

import com.deniz.entities.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepo extends CrudRepository<Book, Integer> {


}
