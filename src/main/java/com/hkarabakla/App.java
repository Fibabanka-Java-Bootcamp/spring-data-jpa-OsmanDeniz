package com.hkarabakla;

import com.hkarabakla.services.OrderService;
import com.hkarabakla.services.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
        appContext.scan("com.hkarabakla");
        appContext.refresh();

        UserService userService = (UserService) appContext.getBean("userService");
        userService.userOperations();

//        CategoryService categoryService = (CategoryService) appContext.getBean("categoryService");
//        categoryService.categoryOperations();

//        AuthorService authorService = (AuthorService) appContext.getBean("authorService");
//        authorService.authorOperations();

        OrderService orderService = (OrderService) appContext.getBean("orderService");
        try {
            orderService.orderOperations();
        } catch (Exception e) {
            e.printStackTrace();
        }

        appContext.close();
    }
}
