package com.deniz;

import com.deniz.services.BookService;
import com.deniz.services.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
        appContext.scan("com.deniz");
        appContext.refresh();

        BookService bookService = (BookService) appContext.getBean("bookService");
        bookService.bookOperations();

//        UserService userService = (UserService) appContext.getBean("userService");
//        userService.userOperations();


        appContext.close();
    }
}
