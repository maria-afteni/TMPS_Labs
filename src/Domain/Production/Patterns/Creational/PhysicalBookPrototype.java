package Domain.Production.Patterns.Creational;

import java.util.Map;
import java.util.Scanner;

public class PhysicalBookPrototype implements BookPrototype {

    @Override
    public BookPrototype clone() {
        return new PhysicalBookPrototype();
    }

    @Override
    public Map<String, String> addBook(Map<String, String> bookDatabase) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Adding book to database");
        System.out.println("Book Name");
        String Name = scanner.nextLine();
        System.out.println("Book Author");
        String Author = scanner.nextLine();
        if (!bookExists(bookDatabase)) {
            bookDatabase.put(Name, Author);
            System.out.println("Physical book added to database.");
        } else {
            System.out.println("Failed to add physical book to database.");
        }

        return bookDatabase;
    }

    @Override
    public boolean bookExists(Map<String, String> bookDatabase) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Book Name");
        String Name = scanner.nextLine();
        System.out.println("Book Author");
        String Author = scanner.nextLine();
        return bookDatabase.containsKey(Name) && bookDatabase.get(Name).equals(Author);
    }

    @Override
    public void viewBooks(Map<String, String> bookDatabase) {
        int id = 1;
        for (String i : bookDatabase.keySet()) {
            System.out.println("\n" + id + " -> " + i + " by " + bookDatabase.get(i));
            id++;
        }
    }
}
