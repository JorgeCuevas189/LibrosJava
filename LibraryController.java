package com.example.library.controller;

import com.example.library.service.GutenbergService;
import com.example.library.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.List;
import java.util.Scanner;

@ShellComponent
public class LibraryController {

    @Autowired
    private LibraryService libraryService;

    @ShellMethod("Display menu options")
    public void displayMenu() {
        System.out.println("Elija la opción a través de su número:");
        System.out.println("1- buscar libro por título");
        System.out.println("2- listar libros registrados");
        System.out.println("3- listar autores registrados");
        System.out.println("4- listar autores vivos en un determinado año");
        System.out.println("5- listar libros por idioma");
        System.out.println("0 - salir");

        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        handleOption(option);
    }

    public void handleOption(int option) {
        Scanner scanner = new Scanner(System.in);
        switch (option) {
            case 1:
                System.out.print("Ingrese el título del libro: ");
                String title = scanner.nextLine();
                List<GutenbergService.GutenbergBook> books = libraryService.searchBookByTitle(title);
                books.forEach(book -> System.out.println("Titulo: " + book.getTitle() + ", Autor: " + String.join(", ", book.getAuthors()) + ", Idioma: " + book.getLanguages()));
                break;
            case 2:
                // Implementar lógica para listar libros registrados
                break;
            case 3:
                // Implementar lógica para listar autores registrados
                break;
            case 4:
                System.out.print("Ingrese el año: ");
                int year = scanner.nextInt();
                // Implementar lógica para listar autores vivos en un determinado año
                break;
            case 5:
                System.out.print("Ingrese el idioma: ");
                String language = scanner.nextLine();
                // Implementar lógica para listar libros por idioma
                break;
            case 0:
                System.exit(0);
                break;
            default:
                System.out.println("Opción no válida");
                break;
        }
    }
}
