package com.deniz.services;

import com.deniz.entities.Book;
import com.deniz.entities.Category;
import com.deniz.repositories.CategoryRepo;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.UUID;

@Component
public class CategoryService {

    private final CategoryRepo categoryRepo;

    public CategoryService(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    public void categoryOperations() {

        Book b1 = new Book();
        b1.setIsbn(UUID.randomUUID().toString());
        b1.setName("Spring in Action");

        Category c1 = new Category();
        c1.setName("Computer Science");
        c1.setBooks(Collections.singletonList(b1));

        categoryRepo.save(c1);

        System.out.println(c1);
    }
}
