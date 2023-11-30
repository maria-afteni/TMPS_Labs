package Domain.Production.Patterns.Creational;

import Domain.Production.Patterns.Behavioral.Command.AddToWishlist;
import Domain.Production.Patterns.Behavioral.Command.IWishlistCommand;
import Domain.Production.Patterns.Behavioral.Command.RemoveFromWishlist;
import Domain.Production.Patterns.Behavioral.Command.Wishlist;

import java.util.Map;
import java.util.Scanner;

public class EBookPrototype implements BookPrototype {
    @Override
    public BookPrototype clone() {
        return new EBookPrototype();
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
            System.out.println("Ebook successfully added to database.");
        } else {
            System.out.println("Failed to add Ebook to database.");
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

    @Override
    public void viewOrders() {
    }

    @Override
    public void wishlist() {
        Wishlist wishlist = new Wishlist();

        IWishlistCommand addToWishlist = new AddToWishlist(wishlist, "Orlando");
        IWishlistCommand removeFromWishlist = new RemoveFromWishlist(wishlist, "The Stranger");

        addToWishlist.execute();
        removeFromWishlist.execute();
    }
}
