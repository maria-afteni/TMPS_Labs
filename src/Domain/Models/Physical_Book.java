package Domain.Models;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Physical_Book extends Book {

    String Name;
    String Author;



    @Override
    public Map<String, String> Add_Book(Map<String, String> Books) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Adding book to database");
        System.out.println("Book Name");
        Name = scanner.nextLine();
        System.out.println("Book Author");
        Author = scanner.nextLine();
        if (!Book_exists(Books)){
            Books.put(Name, Author);
            System.out.println("Physical book added to database.");
        }else{
            System.out.println("Failed to add physical book to database.");
        }

        return Books;
    }

    @Override
    public boolean Book_exists( Map<String, String> Books) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Book Name");
        Name = scanner.nextLine();
        System.out.println("Book Author");
        Author = scanner.nextLine();
        return Books.containsKey(Name) && Books.get(Name).equals(Author);
    }

    public void Books_Available(Map<String, String> Books){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Book Name");
        Name = scanner.nextLine();
        System.out.println("Book Author");
        Author = scanner.nextLine();
        Random rand = new Random();
        if (Books.containsKey(Name) && Books.get(Name).equals(Author)){
            int available = rand.nextInt(100);
            System.out.println("Available copies: " + available);
        }
        else{
            System.out.println("No available copies.");
        }
    }
}
