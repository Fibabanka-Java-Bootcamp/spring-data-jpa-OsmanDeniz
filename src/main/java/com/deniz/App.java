package com.deniz;

import com.deniz.services.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
        appContext.scan("com.deniz");
        appContext.refresh();

//        BookService bookService = (BookService) appContext.getBean("bookService");
//        bookService.bookOperations();

        UserService userService = (UserService) appContext.getBean("userService");
        userService.userOperations();

//        CategoryService categoryService = (CategoryService) appContext.getBean("categoryService");
//        categoryService.categoryOperations();

//        AuthorService authorService = (AuthorService) appContext.getBean("authorService");
//        authorService.authorOperations();

//        OrderService orderService = (OrderService) appContext.getBean("orderService");
//        try {
//            orderService.orderOperations();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        appContext.close();
    }
}
