package com.deniz.repositories;

import com.deniz.entities.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepo extends CrudRepository<Book, Integer> {

    List<Book> findByCategory_Name(String name);

    List<Book> findByAuthors_Name(String name);

}
