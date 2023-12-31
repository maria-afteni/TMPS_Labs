package Domain.Models;

import java.util.Map;
import java.util.Scanner;

public class EBook extends Book {
    @Override
    public Map<String, String> addBook(Map<String, String> Books) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Adding book to database");
        System.out.println("Book Name");
        Name = scanner.nextLine();
        System.out.println("Book Author");
        Author = scanner.nextLine();
        if (!bookExists(Books)){
            Books.put(Name, Author);
            System.out.println("Ebook successfully added to database.");
        }else{
            System.out.println("Failed to add Ebook to database.");
        }

        return Books;
    }

    @Override
    public boolean bookExists(Map<String, String> Books) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Book Name");
        Name = scanner.nextLine();
        System.out.println("Book Author");
        Author = scanner.nextLine();
        return Books.containsKey(Name) && Books.get(Name).equals(Author);
    }

}
