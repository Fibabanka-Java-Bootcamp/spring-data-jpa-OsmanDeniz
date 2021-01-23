package com.deniz.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Entity
public class Orders {

    @Id
    @GeneratedValue
    private int id;

    private LocalDate created_at;
    private Double total;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "order_book",
            joinColumns = {@JoinColumn(name = "order_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "book_isbn", referencedColumnName = "book_isbn")})
    private Set<Book> orderBooks = new HashSet<>();

    public Orders(LocalDate created_at, Double total, User user, Set<Book> orderBooks) {
        this.created_at = created_at;
        this.total = total;
        this.user = user;
        this.orderBooks = orderBooks;
    }

    public Orders() {
    }

    public Set<Book> getOrderBooks() {
        return orderBooks;
    }

    public void setOrderBooks(Set<Book> orderBooks) {
        this.orderBooks = orderBooks;
    }

    @Override
    public String toString() {
        return "\n\t\tOrders{" +
                "id=" + id +
                ", created_at=" + created_at +
                ", total=" + total +
                ", orderBooks=" + orderBooks +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDate created_at) {
        this.created_at = created_at;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Orders)) return false;
        Orders orders = (Orders) o;
        return id == orders.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
