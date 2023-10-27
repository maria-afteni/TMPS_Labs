package Domain.Production.Patterns.Structural.Facade;

import Domain.Models.Book;
import Domain.Production.Patterns.Creational.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BookstoreService {
    private Map<String, String> eBooks;
    private Map<String, String> physicalBooks;
    private boolean logged;

    public BookstoreService() {
        eBooks = new HashMap<>();
        physicalBooks = new HashMap<>();
        eBooks.put("Orlando", "Virginia Woolf");
        eBooks.put("The Stranger", "Albert Camus");
        eBooks.put("The Bell Jar", "Sylvia Plath");
        physicalBooks.put("Orlando", "Virginia Woolf");
        physicalBooks.put("The Stranger", "Albert Camus");
        physicalBooks.put("The Bell Jar", "Sylvia Plath");
        logged = false;
    }

    public void authenticate() {
        logged = ClientSingleton.getInstance().getStatus();
    }

    public void logout() {
        logged = false;
    }

    public boolean isUserLoggedIn() {
        return logged;
    }

    public void handleEbookMenu() {
        Scanner scanner = new Scanner(System.in);
        BookPrototype ebookManager = new EBookPrototype();

        System.out.println("""
            1. Add Ebook to database
            2. Verify if book is in database
            3. View Ebooks database
            4. Back""");
        int option = scanner.nextInt();

        switch (option) {
            case 1 -> {
                Book book = BookFactory.getBookType(option);
                assert book != null;
                ebookManager.addBook(eBooks);
            }
            case 2 -> {
                Book book = BookFactory.getBookType(option);
                assert book != null;
                boolean exists = ebookManager.bookExists(eBooks);
                if (exists) {
                    System.out.println("\nEBook is in the database");
                } else {
                    System.out.println("EBook not found in the database");
                }
            }
            case 3 -> ebookManager.viewBooks(eBooks);
        }
    }

    public void handlePhysicalBookMenu() {
        Scanner scanner = new Scanner(System.in);
        BookPrototype physicalBookManager = new PhysicalBookPrototype();

        System.out.println("""
            1. Add physical book to database
            2. Verify if book is in database
            3. View physical books database
            4. View pending order
            5. Back""");
        int option = scanner.nextInt();

        switch (option) {
            case 1 -> {
                Book book = BookFactory.getBookType(option);
                assert book != null;
                physicalBookManager.addBook(physicalBooks);
            }
            case 2 -> {
                Book book = BookFactory.getBookType(option);
                assert book != null;
                boolean exists = physicalBookManager.bookExists(physicalBooks);
                if (exists) {
                    System.out.println("\nBook is in the database");
                } else {
                    System.out.println("Book not found in the database");
                }
            }
            case 3 -> physicalBookManager.viewBooks(physicalBooks);
            case 4 -> physicalBookManager.viewOrders();
        }
    }
}
