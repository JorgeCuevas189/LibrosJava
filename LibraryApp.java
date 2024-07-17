package com.example.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class LibraryApp {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(LibraryApp.class, args);
        LibraryController controller = context.getBean(LibraryController.class);
        controller.displayMenu();
    }
}
