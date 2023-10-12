package Client;

import Domain.Models.Book;
import Domain.Production.Patterns.Creational.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ClientAction {
    public void menu(){
        boolean logged = false;
        Map<String, String> eBooks = new HashMap<>(){{
            put("Orlando", "Virginia Woolf");
            put("The Stranger", "Albert Campus");
            put("The Bell Jar", "Sylvia Plath");
        }};
        Map<String, String> physicalBooks = new HashMap<>(){{
            put("Orlando", "Virginia Woolf");
            put("The Stranger", "Albert Campus");
            put("The Bell Jar", "Sylvia Plath");
        }};


        Scanner scanner = new Scanner(System.in);

        ClientSingleton client = ClientSingleton.getInstance();
        if (client != null){
            logged = true;
        }


        while(logged){
            System.out.println("\nChose book type \n1. Ebook \n2. Physical book \n3. Exit");
            int option = scanner.nextInt();
            Book book = BookFactory.getBookType(option);
            BookPrototype ebookManager = new EBookPrototype();
            BookPrototype physicalBookManager = new PhysicalBookPrototype();

            switch (option) {
                case 1 -> {
                    System.out.println("""
                1. Add Ebook to database\s
                2. Verify if book is in database\s
                3. View Ebooks database\s
                4. Back\s""");
                    int option_ebook = scanner.nextInt();
                    switch (option_ebook) {
                        case 1 -> {
                            assert book != null;
                            ebookManager.addBook(eBooks);
                        }
                        case 2 -> {
                            assert book != null;
                            boolean exists = ebookManager.bookExists(eBooks);
                            if (exists) {
                                System.out.println("\nEBook is in the database");
                            } else {
                                System.out.println("EBook not found in the database");
                            }
                        }
                        case 3 -> {
                            ebookManager.viewBooks(eBooks);
                        }
                        case 4 -> {
                        }
                    }
                }
                case 2 -> {
                    System.out.println("""
                1. Add physical book to database\s
                2. Verify if book is in database\s
                3. View physical books database\s
                4. Back\s""");
                    int option_physical = scanner.nextInt();
                    switch (option_physical) {
                        case 1 -> {
                            assert book != null;
                            physicalBookManager.addBook(physicalBooks);
                        }
                        case 2 -> {
                            assert physicalBooks != null;
                            assert book != null;
                            boolean exists = physicalBookManager.bookExists(physicalBooks);
                            if (exists) {
                                System.out.println("\nBook is in the database");
                            } else {
                                System.out.println("Book not found in the database");
                            }
                        }
                        case 3 -> {
                            physicalBookManager.viewBooks(physicalBooks);
                        }
                        case 4 -> {

                        }
                    }
                }
                case 3 -> {
                    logged = false;
                    System.out.println("Exiting the system...");
                }
            }


        }
    }
}
