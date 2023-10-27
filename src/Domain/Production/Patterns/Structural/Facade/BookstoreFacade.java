package Domain.Production.Patterns.Structural.Facade;

import java.util.Scanner;

public class BookstoreFacade {
    private BookstoreService bookstoreService;

    public BookstoreFacade(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }

    public void menu() {
        Scanner scanner = new Scanner(System.in);
        authenticate();

        while (bookstoreService.isUserLoggedIn()) {
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
        bookstoreService.authenticate();
    }

    private void logout() {
        bookstoreService.logout();
    }

    private void handleEbookMenu() {
        bookstoreService.handleEbookMenu();
    }

    private void handlePhysicalBookMenu() {
        bookstoreService.handlePhysicalBookMenu();
    }
}
