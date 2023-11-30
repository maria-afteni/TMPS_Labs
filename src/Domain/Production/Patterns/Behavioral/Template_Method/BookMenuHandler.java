package Domain.Production.Patterns.Behavioral.Template_Method;

import Domain.Models.Book;
import Domain.Production.Patterns.Creational.BookFactory;
import Domain.Production.Patterns.Creational.BookPrototype;

import java.util.Map;
import java.util.Scanner;

abstract class BookMenuHandler {

    protected abstract BookPrototype getBookManager();

    public void handleMenu(Map<String, String> books) {
        Scanner scanner = new Scanner(System.in);
        BookPrototype bookManager = getBookManager();

        System.out.println("""
            1. Add book to database
            2. Verify if book is in database
            3. View books database
            4. Wishlist
            5. Back""");
        int option = scanner.nextInt();

        switch (option) {
            case 1 -> {
                Book book = BookFactory.getBookType(option);
                assert book != null;
                bookManager.addBook(books);
            }
            case 2 -> {
                Book book = BookFactory.getBookType(option);
                assert book != null;
                boolean exists = bookManager.bookExists(books);
                if (exists) {
                    System.out.println("\nBook is in the database");
                } else {
                    System.out.println("Book not found in the database");
                }
            }
            case 3 -> bookManager.viewBooks(books);
            case 4 -> bookManager.wishlist();
        }
    }
}