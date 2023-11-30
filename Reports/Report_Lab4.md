# Behavioral Design Patterns


## Author: Afteni Maria

----

## Objectives:
&ensp; &ensp; __1. Study and understand the Behavioral Design Patterns.__

&ensp; &ensp; __2. As a continuation of the previous laboratory work, think about what communication between software entities might be involed in your system.__

&ensp; &ensp; __3. Create a new Project or add some additional functionalities using behavioral design patterns.__

## Theoretical background:
&ensp; &ensp; Behavioral design patterns are a category of design patterns that focus on the interaction and communication between objects and classes. They provide a way to organize the behavior of objects in a way that is both flexible and reusable, while separating the responsibilities of objects from the specific implementation details. Behavioral design patterns address common problems encountered in object behavior, such as how to define interactions between objects, how to control the flow of messages between objects, or how to define algorithms and policies that can be reused across different objects and classes.

&ensp; &ensp; Some examples from this category of design patterns are :

* Chain of Responsibility
* Command
* Interpreter
* Iterator
* Mediator
* Observer
* Strategy


## Implementation
Firstly, I implemented the Strategy behavioral pattern. I created an interface named `IPayStrategy`. 
```
public interface IPayStrategy {
    boolean pay(boolean payed);
    void collectPaymentDetails(boolean pay, String payMethod);
}
```
The interface is implemented by the `PayStrategy` class. 
```
public class PayStrategy implements IPayStrategy {
    @Override
    public boolean pay(boolean payed) {
        return payed;
    }

    @Override
    public void collectPaymentDetails(boolean payed, String payMethod) {
        if(payed){
            Random rand = new Random();

            System.out.println("\nTransaction finished on " + rand.nextInt(31) + "." + rand.nextInt(12) + ".2023");
            System.out.println("\nPayment done at " + rand.nextInt(0,25) + ":" + rand.nextInt(61 ));

            System.out.println("\nPayment method: " + payMethod);
        }

    }
}
```
It overrides two methods: `pay(boolean payed)` and `collectPaymentDetails(boolean payed, String payMethod)`. The `boolean pay(boolean payed)`
method takes a boolean parameter `payed`, indicating whether the payment was successful or not. It returns a boolean value, 
that represents the success or failure of the payment. The second method, `void collectPaymentDetails(boolean payed, String payMethod)` 
takes two parameters: `payed`, a boolean indicating whether the payment was successful, and`payMethod`, a String representing 
the payment method used. Inside the method, if the payment was successful, it generates random transaction details using 
the Random class. These details include the transaction date, payment time, and the chosen payment method. The generated 
details are then printed to the console.

To implement the Command design patter I created an interface named `IWishlistCommand` with a single method execute(). 
```
public interface IWishlistCommand {
    void execute();
}
```
I implemented the `AddToWishlist` an `RemoveFromWishlist` classes that implement the `IWishlistCommand` interface. They 
take a `Wishlist` instance and a `bookName` as parameters during initialization. Then `execute` method, when called, 
adds or removes the specified book to/from the wishlist using the specialized methods in the `Wishlist` class.

```
public class AddToWishlist implements IWishlistCommand{

    private Wishlist wishlist;
    private String bookName;

    public AddToWishlist(Wishlist wishlist, String bookName) {
        this.wishlist = wishlist;
        this.bookName = bookName;
    }
    @Override
    public void execute() {
        wishlist.addToWishlist(bookName);
    }
}
```

I created the `Wishlist` class that contains a list of books `booksWishlist`. The `addToWishlist` method implemented there
adds a book to the wishlist if it's not already present, printing a corresponding message. The `removeFromWishlist` method 
removes a book from the wishlist if it exists, also printing a corresponding message.

```
public class Wishlist {
    private List<String> booksWishlist = new ArrayList<>();

    public void addToWishlist(String bookName) {
        if (!booksWishlist.contains(bookName)) {
            booksWishlist.add(bookName);
            System.out.println(bookName + " added to wishlist.");
        } else {
            System.out.println(bookName + " is already in the wishlist.");
        }
    }

    public void removeFromWishlist(String bookName) {
        if (booksWishlist.contains(bookName)) {
            booksWishlist.remove(bookName);
            System.out.println(bookName + " removed from wishlist.");
        } else {
            System.out.println(bookName + " is not in the wishlist.");
        }
    }
}
```

The last pattern that I implemented is the Template Method design pattern. I created an abstract class `BookMenuHandler` 
that defines a template method. The `handleMenu` method outlines a series of steps for handling book-related actions, 
allowing subclasses to implement specific behaviors.

```
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
```
I extended the template class with `EbookMenuHandler` and `PhysicalBookMenuHandler` classes. They provide concrete 
implementations of the abstract method `getBookManager`, returning instances of `EBookPrototype` and `PhysicalBookPrototype`, 
respectively.
```
class EbookMenuHandler extends BookMenuHandler {
    @Override
    protected BookPrototype getBookManager() {
        return new EBookPrototype();
    }
}
```
Lastly, I created a class named `BookstoreServiceTemplate`, containing maps for eBooks and physical books, and a boolean
flag to track user login status. The authenticate method checks and sets the login status using a singleton instance of 
`ClientSingleton`. The `handleEbookMenu` and `handlePhysicalBookMenu` methods instantiate `EbookMenuHandler` and 
`PhysicalBookMenuHandler`, respectively, and call their `handleMenu` methods, managing ebook and physical book actions.

## Conclusion
In this laboratory work, I successfully implemented three  behavioral design patterns—Strategy, Command, and Template 
Method—for a bookstore service. The Strategy pattern allowed me to encapsulate various payment strategies, providing 
flexibility in handling transactions. With the Command pattern, I modularized wishlist operations through commands, 
enhancing maintainability and extensibility. Lastly, the Template Method pattern provided a structured approach for 
handling different book types, ensuring a consistent user experience across eBooks and physical books.
These design patterns not only improved code organization and readability but also facilitated future modifications and 
additions to the bookstore service.