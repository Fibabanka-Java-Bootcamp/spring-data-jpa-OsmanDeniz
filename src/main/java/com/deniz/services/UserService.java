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


        User u = createOperations("Osman DENIZ","Turk Tarihi", "Mustafa Kemal Ataturk", "Nutuk");
        repo.save(u);
        u = createOperations("Huseyin Karabakla","Turk Marslari", "Mehmet Akif Ersoy", "Istiklal Marsi");
        repo.save(u);

//        System.out.println(repo.findAll());

//        System.out.println(repo.findByAddressStreetIsContaining("Gazi"));

//        System.out.println(repo.findAllByNameContainingIgnoreCase("se"));

        System.out.println(repo.findAllByOrdersTotal(23.45));
    }

    private User createOperations(String userName,String categoryName, String authorName, String bookName) {
        User u = new User();
        u.setName(userName);

        Address address = new Address();
        address.setStreet("Gazi sokak");
        address.setNumber("7");
        address.setCity("Istanbul");

        u.setAddress(address);

        Category c = new Category();
        c.setName(categoryName);

        Authors a = new Authors();
        a.setName(authorName);

        Book b = new Book();
        b.setName(bookName);
        b.setIsbn(UUID.randomUUID().toString());
        b.setCategory(c);
        b.setAuthors(Collections.singleton(a));

        Orders o = new Orders(LocalDate.now(), 23.45, u, Collections.singleton(b));
//        o.setCreated_at(LocalDate.now());
//        o.setTotal(23.54);
//       // o.setUser(u);
//        o.setOrderBooks(Collections.singleton(b));

        u.setOrders(Collections.singleton(o));
        return u;
    }

}
