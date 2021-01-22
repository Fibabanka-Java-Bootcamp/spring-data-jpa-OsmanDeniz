package com.deniz.services;

import com.deniz.entities.Authors;
import com.deniz.entities.Book;
import com.deniz.entities.Category;
import com.deniz.repositories.AuthorRepo;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class AuthorService {
    AuthorRepo repo;


    public AuthorService(AuthorRepo repo) {
        this.repo = repo;
    }

    public void authorOperations() {
        Category c = new Category();
        Category c2 = new Category();
        c.setName("Software");
        c2.setName("Hacking");

        Book b = new Book();
        b.setName("Spring in Action");
        b.setIsbn(UUID.randomUUID().toString());
        b.setCurrency("TRY");

        Book b2 = new Book();
        b2.setName("Spring in Hacking");
        b2.setIsbn(UUID.randomUUID().toString());
        b2.setCurrency("TRY");

        b.setCategory(c);
        b2.setCategory(c2);

        List<Book> bList = new ArrayList<>();
        bList.add(b);
        bList.add(b2);

        Authors a = new Authors();
        a.setName("OsmanDENIZ");
        a.setBooks(bList);
        repo.save(a);
        System.out.println(a);


    }

}
