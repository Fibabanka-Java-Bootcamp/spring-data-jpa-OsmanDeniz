package com.deniz.entities;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.Set;

@Entity

public class User {
    @Id
    @GeneratedValue
    private int id;

    private String name;


    @OneToOne(cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private Set<Orders> orders;

    public Set<Orders> getOrders() {
        return orders;
    }

    public void setOrders(Set<Orders> orders) {
        this.orders = orders;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "\n\nUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                ", orders=" + orders +
                '}';
    }
}
