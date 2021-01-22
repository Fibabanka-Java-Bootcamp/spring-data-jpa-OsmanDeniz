package com.deniz.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Orders {

    @Id
    @GeneratedValue
    private int id;

    private LocalDate created_at;
    private Double total;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "order_book",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "book_isbn"))
    private List<Book> orderBooks;

    public List<Book> getOrderBooks() {
        return orderBooks;
    }

    public void setOrderBooks(List<Book> orderBooks) {
        this.orderBooks = orderBooks;
    }

    @Override
    public String toString() {
        return "\n\t\tOrders{" +
                "id=" + id +
                ", created_at=" + created_at +
                ", total=" + total +
//                ", user=" + user +
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
}
