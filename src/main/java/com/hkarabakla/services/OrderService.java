package com.hkarabakla.services;

import com.hkarabakla.entities.*;
import com.hkarabakla.repositories.OrderRepo;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;
import java.util.Collections;
import java.util.UUID;

@Controller
public class OrderService {
    private OrderRepo orderRepo;

    public OrderService(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

    public void orderOperations() {
        User u = new User();
        Address a = new Address();
        Orders o = new Orders();
        Book b = new Book();
        Category c = new Category();
        Authors auth = new Authors();

        u.setName("OsmanDENIZ");
        a.setCity("Ankara");
        a.setNumber("12/12");
        a.setZipcode(06132);
        u.setAddress(a);

        c.setName("Computer Science");


        auth.setName("OsmanDENIZ");

        b.setIsbn(UUID.randomUUID().toString());
        b.setName("Spring in Action");
        b.setCategory(c);
        b.setAuthors(Collections.singletonList(auth));


        o.setCreated_at(LocalDate.now());
        o.setTotal(23.54);
        o.setOrderBooks(Collections.singletonList(b));


        u.setOrders(Collections.singletonList(o));

        orderRepo.save(o);
        System.out.println(u);


    }
}
