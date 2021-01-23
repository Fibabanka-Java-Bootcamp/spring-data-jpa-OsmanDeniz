package com.deniz.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Authors {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    @ManyToMany(mappedBy = "authors", cascade = CascadeType.ALL)
    private Set<Book> books;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "\n\t\tAuthors{" +
                "id=" + id +
                ", name='" + name + '\'' +
//                ", books=" + books +
                '}';
    }
}
