package Domain.Production.Patterns.Structural.Facade;

import Domain.Production.Patterns.Behavioral.Template_Method.BookstoreServiceTemplate;

import java.util.Scanner;

public class BookstoreFacade {
    private BookstoreService bookstoreService;
    private BookstoreServiceTemplate bookstoreServiceTemplate;

    public BookstoreFacade(BookstoreServiceTemplate bookstoreServiceTemplate) {
        this.bookstoreServiceTemplate = bookstoreServiceTemplate;
    }

    public void menu() {
        Scanner scanner = new Scanner(System.in);
        authenticate();

        while (bookstoreServiceTemplate.isUserLoggedIn()) {
            System.out.println("\nChoose book type:\n1. Ebook\n2. Physical book\n3. Exit");
            int option = scanner.nextInt();

            switch (option) {
                case 1 -> handleEbookMenu();
                case 2 -> handlePhysicalBookMenu();
                case 3 -> {
                    logout();
                    System.out.println("Exiting the system...");
                }
            }
        }
    }

    private void authenticate() {
        bookstoreServiceTemplate.authenticate();
    }

    private void logout() {
        bookstoreServiceTemplate.logout();
    }

    private void handleEbookMenu() {
        bookstoreServiceTemplate.handleEbookMenu();
    }

    private void handlePhysicalBookMenu() {
        bookstoreServiceTemplate.handlePhysicalBookMenu();
    }
}
