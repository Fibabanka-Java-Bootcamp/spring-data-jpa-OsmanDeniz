package com.deniz.services;

import com.deniz.entities.Authors;
import com.deniz.entities.Book;
import com.deniz.entities.Category;
import com.deniz.entities.Orders;
import com.deniz.repositories.BookRepo;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Controller
public class BookService {
    BookRepo repo;

    public BookService(BookRepo repo) {
        this.repo = repo;
    }

    public void bookOperations() {
        Orders o = new Orders();
        Book b = new Book();
        Category c = new Category();
        Authors a = new Authors();

        a.setName("Osman DENIZ");


        b.setName("Spring in Action");
        b.setIsbn(UUID.randomUUID().toString());
        b.setCurrency("TRY");

        c.setName("UserBookCategory");

        b.setCategory(c);
        b.setAuthors(Collections.singletonList(a));


        o.setCreated_at(LocalDate.now());
        o.setTotal(23.42);

        List<Orders> orderBooks = new ArrayList<>();
        orderBooks.add(o);

        b.setOrders(orderBooks);
        repo.save(b);
        System.out.println(b);

    }
}
