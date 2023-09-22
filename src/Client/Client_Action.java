package Client;

import Domain.Factory.ClientAuthorization;
import Domain.Models.EBook;
import Domain.Models.Physical_Book;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Client_Action {
    public void Menu(){
        ClientAuthorization c1 = new ClientAuthorization();
        Map<String, String> Credentials = new HashMap<>(){{
            put("Admin", c1.Hash_Password("admin32"));
            put("Nicu", c1.Hash_Password("angel"));
        }};
        Map<String, String> EBooks = new HashMap<>(){{
            put("Orlando", "Virginia Woolf");
            put("The Stranger", "Albert Campus");
            put("The Bell Jar", "Sylvia Plath");
        }};
        Map<String, String> Physical_Books = new HashMap<>(){{
            put("Orlando", "Virginia Woolf");
            put("The Stranger", "Albert Campus");
            put("The Bell Jar", "Sylvia Plath");
        }};


        Scanner scanner = new Scanner(System.in);
        boolean logged = false;
        while(!logged) {
            System.out.println("\n1. Sign in \n2. Log in");
            int option = scanner.nextInt();
            switch (option) {
                case 1 -> Credentials = c1.Sing_In(Credentials);
                case 2 -> {
                    assert Credentials != null;
                    logged = c1.Log_in(Credentials);
                }
            }
        }

        EBook eBook = new EBook();
        Physical_Book physical_book = new Physical_Book();

        while(logged){
            System.out.println("\nChose book type \n1. Ebook \n2. Physical book \n3. Exit");
            int option = scanner.nextInt();
            switch (option) {
                case 1 -> {
                    System.out.println("""
                            1. Add Ebook to database\s
                            2. Verify if book is in database\s
                            3. View Ebooks database\s
                            4. Back\s""");
                    int option_ebook = scanner.nextInt();
                    switch (option_ebook) {
                        case 1 -> EBooks = eBook.Add_Book(EBooks);
                        case 2 -> {
                            assert EBooks != null;
                            boolean exists = eBook.Book_exists( EBooks);
                            if (exists) {
                                System.out.println("\nEBook is in the database");
                            } else {
                                System.out.println("EBook not found in the database");
                            }
                        }
                        case 3 -> {
                            int id = 1;
                            for (String i : EBooks.keySet()) {
                                System.out.println("\n" + id + " -> " + i + " by " + EBooks.get(i));
                                id++;
                            }
                        }
                        case 4 -> {

                        }
                    }
                }
                case 2 -> {
                    System.out.println("""
                            1. Add physical book to database\s
                            2. Verify if book is in database\s
                            3. Verify number of available copies\s
                            4. View physical books database\s
                            5. Back\s""");
                    int option_physical = scanner.nextInt();
                    switch (option_physical) {
                        case 1 -> Physical_Books = physical_book.Add_Book(Physical_Books);
                        case 2 -> {

                            assert Physical_Books != null;
                            boolean exists = physical_book.Book_exists( Physical_Books);
                            if (exists) {
                                System.out.println("\nBook is in the database");
                            } else {
                                System.out.println("Book not found in the database");
                            }
                        }
                        case 3 -> physical_book.Books_Available(Physical_Books);

                        case 4 -> {
                            int id = 0;
                            for (String i : Physical_Books.values()) {
                                System.out.println("\n" + id + " -> " + i + " by " + Physical_Books.get(i));
                                id++;
                            }
                        }
                        case 5 -> {

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
