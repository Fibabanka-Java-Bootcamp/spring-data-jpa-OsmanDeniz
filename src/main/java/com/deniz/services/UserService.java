package com.deniz.services;

import com.deniz.entities.*;
import com.deniz.repositories.UserRepo;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Collections;
import java.util.UUID;

@Component
public class UserService {

    private final UserRepo repo;

    public UserService(UserRepo repo) {
        this.repo = repo;
    }

    public void userOperations() {

        User u = new User();
        u.setName("user");

        Address address = new Address();
        address.setStreet("Gazi sokak");
        address.setNumber("7");
        address.setCity("Istanbul");

        u.setAddress(address);

        Category c = new Category();
        c.setName("Category1");

        Authors a = new Authors();
        a.setName("Osman DENIZ");

        Book b = new Book();
        b.setName("asdasadfsa");
        b.setIsbn(UUID.randomUUID().toString());
        b.setCategory(c);
        b.setAuthors(Collections.singletonList(a));

        Orders o = new Orders();
        o.setCreated_at(LocalDate.now());
        o.setTotal(23.54);
        o.setOrderBooks(Collections.singletonList(b));

        u.setOrders(Collections.singletonList(o));

        repo.save(u);

        System.out.println(u);

        System.out.println(repo.findByAddressStreetIsContaining("Gazi"));

//        System.out.println(u.getId());

//        System.out.println(repo.findAllByNameContainingIgnoreCase("se"));

    }

}
