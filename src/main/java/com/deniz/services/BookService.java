package com.deniz.services;

import com.deniz.entities.Authors;
import com.deniz.entities.Book;
import com.deniz.entities.Category;
import com.deniz.repositories.BookRepo;
import org.springframework.stereotype.Controller;

import java.util.Collections;
import java.util.UUID;

@Controller
public class BookService {
    BookRepo repo;

    public BookService(BookRepo repo) {
        this.repo = repo;
    }

    public void bookOperations() {
        Category c = new Category();
        c.setName("Turk Marslari");

        Authors a = new Authors();
        a.setName("Mehmet Akif Ersoy");

        Book b = new Book();
        b.setName("Istiklal Marsi");
        b.setIsbn(UUID.randomUUID().toString());
        b.setCategory(c);
        b.setAuthors(Collections.singleton(a));

        repo.save(b);
//        System.out.println(repo.findByCategory_Name("Turk Marslari"));
        System.out.println(repo.findByAuthors_Name("Mehmet Akif Ersoy"));

    }
}
