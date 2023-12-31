package Domain.Production.Patterns.Creational;

import Domain.Production.Patterns.Behavioral.Command.AddToWishlist;
import Domain.Production.Patterns.Behavioral.Command.IWishlistCommand;
import Domain.Production.Patterns.Behavioral.Command.RemoveFromWishlist;
import Domain.Production.Patterns.Behavioral.Command.Wishlist;
import Domain.Production.Patterns.Behavioral.Strategy.IPayStrategy;
import Domain.Production.Patterns.Behavioral.Strategy.PayStrategy;
import Domain.Production.Patterns.Structural.Bridge.*;
import Domain.Production.Patterns.Structural.Composite.BookOrder;
import Domain.Production.Patterns.Structural.Composite.CompositeOrder;

import java.util.Map;
import java.util.Scanner;
import java.util.WeakHashMap;

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

    @Override
    public void viewOrders() {
        BookOrder book1 = new BookOrder("Orlando", 15.99);
        BookOrder book2 = new BookOrder("The Stranger", 12.49);
        boolean payed = false;

        CompositeOrder cart = new CompositeOrder();
        cart.addOrder(book1);
        cart.addOrder(book2);


        System.out.println("\nOrder Contents:");
        cart.display();

        double totalPrice = cart.getTotalPrice();
        System.out.println("\nTotal Price: $" + totalPrice);


        IPaymentProcessor creditCardProcessor = new CreditCardPaymentProcessor();
        IPaymentProcessor paypalProcessor = new PayPalPaymentProcessor();

        PaymentMethod creditCardPayment = new CreditCardPayment(creditCardProcessor);
        PaymentMethod paypalPayment = new PayPalPayment(paypalProcessor);

        IPayStrategy payStrategy = new PayStrategy();

        System.out.println("\nPayments:");

        payed = creditCardPayment.makePayment(15.99);
        if(payStrategy.pay(payed)){
            payStrategy.collectPaymentDetails(payed, "Credit Card");
        }

        payed = paypalPayment.makePayment(12.48);
        if(payStrategy.pay(payed)){
            payStrategy.collectPaymentDetails(payed, "PayPal");
        }
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
