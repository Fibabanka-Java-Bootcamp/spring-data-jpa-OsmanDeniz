package com.hkarabakla.services;

import com.hkarabakla.entities.*;
import com.hkarabakla.repositories.UserRepo;
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
        //        NonUsed();
    }
//
//    private void NonUsed() {
//        User u = new User();
//        u.setName("user");
//
//        Address address = new Address();
//        address.setStreet("Gazo sokak");
//        address.setNumber("7");
//        address.setCity("Istanbul");
//
//        u.setAddress(address);
//
//        Orders o = new Orders();
//        o.setCreated_at(LocalDate.now());
//        o.setTotal(23.54);
//
//        u.setOrders(Collections.singletonList(o));
//
//
//        repo.save(u);
//        System.out.println(u);
//
//        System.out.println(u.getId());
//
//        System.out.println(repo.findAllByNameContainingIgnoreCase("se"));
//    }
}
