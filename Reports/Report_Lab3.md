# Structural Design Patterns


## Author: Afteni Maria

----

## Objectives:
&ensp; &ensp; __1. Study and understand the Structural Design Patterns.__

&ensp; &ensp; __2. As a continuation of the previous laboratory work, think about the functionalities that your system will need to provide to the user.__

&ensp; &ensp; __3. Implement some additional functionalities, or create a new project using structural design patterns.__

## Theoretical background:
&ensp; &ensp; Structural design patterns are a category of design patterns that focus on the composition of classes and objects to form larger structures and systems. They provide a way to organize objects and classes in a way that is both flexible and efficient, while allowing for the reuse and modification of existing code. Structural design patterns address common problems encountered in the composition of classes and objects, such as how to create new objects that inherit functionality from existing objects, how to create objects that share functionality without duplicating code, or how to define relationships between objects in a flexible and extensible way.

&ensp; &ensp; Some examples of from this category of design patterns are:

* Adapter
* Bridge
* Composite
* Decorator
* Facade
* Flyweight
* Proxy


## Implementation
The Proxy Pattern is a structural design pattern that provides a surrogate or placeholder for another object to control 
access to it. It acts as an intermediary, allowing to add additional functionality or control when interacting with the 
real object.

```
public interface IBookstoreAccess {
    void accessProgram();
}

public class BookstoreProxy implements IBookstoreAccess {
    private boolean isAdmin;
    private Bookstore bookstore;

    public BookstoreProxy(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    @Override
    public void accessProgram() {
        if (isAdmin) {
            if (bookstore == null) {
                bookstore = new Bookstore();
            }
            try {
                bookstore.accessProgram();
                System.out.println("Admin access granted.");
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        } else {
            System.out.println("Access denied. You are not an admin.");
        }
    }
}
```

To implement the Proxy patter, I developed an interface, IBookstoreAccess, to outline the access functionality for a 
bookstore system. I then constructed a BookstoreProxy class that acts as a gateway to manage access to the bookstore. 
It verifies the user's admin status before allowing access and takes advantage of lazy initialization, ensuring that the 
real Bookstore object is only created when necessary for admin access. To enhance the reliability of the system, I 
incorporated error handling to capture and display any exceptions that might arise during the access process, offering 
a more robust and informative user experience.


The Facade Pattern simplifies complex systems by providing a unified, high-level interface that hides the underlying 
intricacies, making it easier for clients to interact with the system. It acts as a user-friendly "entry point" to access 
the system's functionality while shielding users from its internal complexities.

```
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
```

The `BookstoreFacade` class serves as a user-friendly interface to access the bookstore system. It starts by authenticating 
the user and then provides a menu for interacting with the system. The user can choose between ebooks and physical books 
or exit. The actual operations are handled by the `bookstoreService`, making it a bridge between user interaction and 
underlying bookstore functionality. If the user decides to exit, the system logs them out and gracefully terminates. 
This separation of concerns and clean structure enhances the user experience and code maintainability.


The Composite Pattern is a structural design pattern that allows you to compose objects into tree-like structures to 
represent part-whole hierarchies. It enables clients to treat individual objects and compositions of objects uniformly, 
simplifying complex hierarchies and providing a unified interface for interacting with them.

```
abstract class OrderComponent {
    abstract double getTotalPrice();
    abstract void display();
}

public class BookOrder extends OrderComponent {
    private String title;
    private double price;

    public BookOrder(String title, double price) {
        this.title = title;
        this.price = price;
    }

    @Override
    double getTotalPrice() {
        return price;
    }

    @Override
    void display() {
        System.out.println(title + " - $" + price);
    }
}

ublic class CompositeOrder extends OrderComponent {
    private List<OrderComponent> orders = new ArrayList<>();

    @Override
    public void display() {
        for (OrderComponent order : orders) {
            order.display();
        }
    }

    @Override
    public double getTotalPrice() {
        double totalPrice = 0;
        for (OrderComponent order : orders) {
            totalPrice += order.getTotalPrice();
        }
        return totalPrice;
    }

    public void addOrder(OrderComponent order) {
        orders.add(order);
    }

    void removeOrder(OrderComponent order) {
        orders.remove(order);
    }
}
```

Using this patter, I have defined a set of classes for handling orders in a bookstore. The OrderComponent is an abstract
class serving as the base for both individual book orders and composite (multiple book) orders. The BookOrder class 
represents an individual book order, storing information about the book's title and price. It provides methods to 
calculate and display the total price of the book order.
The CompositeOrder class, on the other hand, represents composite orders that can contain multiple book orders. It 
maintains a list of OrderComponent objects and provides methods for displaying the entire order hierarchy and calculating 
the total price of the composite order. It allows you to add and remove individual book orders from the composite order, 
making it a versatile structure for managing complex orders in a bookstore.

The Bridge Pattern is a structural design pattern that separates an object's abstraction from its implementation, 
allowing them to vary independently. It's like a bridge that connects two different components, enabling changes in one 
side to not impact the other, promoting flexibility and extensibility in software design.

```
public interface IPaymentProcessor {
    void processPayment(double amount);
}
public class CreditCardPaymentProcessor implements IPaymentProcessor{
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing credit card payment of $" + amount);
    }
}
public class PayPalPaymentProcessor implements IPaymentProcessor{
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing PayPal payment of $" + amount);
    }
}
public abstract class PaymentMethod {
    protected IPaymentProcessor paymentProcessor;

    public PaymentMethod(IPaymentProcessor paymentProcessor) {
        this.paymentProcessor = paymentProcessor;
    }

    public abstract void makePayment(double amount);
}
public class CreditCardPayment extends PaymentMethod {
    public CreditCardPayment(IPaymentProcessor paymentProcessor) {
        super(paymentProcessor);
    }

    @Override
    public void makePayment(double amount) {
        paymentProcessor.processPayment(amount);
    }
}
public class PayPalPayment extends PaymentMethod {
    public PayPalPayment(IPaymentProcessor paymentProcessor) {
        super(paymentProcessor);
    }

    @Override
    public void makePayment(double amount) {
        paymentProcessor.processPayment(amount);

    }
}
```
I have defined a payment processing system using the Bridge pattern.
First, there is an interface called `IPaymentProcessor`, which defines a method `processPayment` to process payments. 
This interface serves as a contract for any payment processor implementation.
Next, there are two concrete payment processor classes, `CreditCardPaymentProcessor` and `PayPalPaymentProcessor`. Each 
of these classes implements the `IPaymentProcessor` interface and provides specific implementations for processing credit 
card and PayPal payments.
Then, there is an abstract class called `PaymentMethod`. It has a protected field for holding an instance of an `IPaymentProcessor`. 
The constructor of this class allows you to specify the payment processor to use. Subclasses of `PaymentMethod` are expected 
to implement the `makePayment` method, which delegates the payment processing to the associated payment processor.
Finally, there are two concrete payment method classes, `CreditCardPayment` and `PayPalPayment`, which inherit from `PaymentMethod`. 
They take an `IPaymentProcessor` as a parameter in their constructors and implement the `makePayment` method. When `makePayment` 
is called, it delegates the payment processing to the provided payment processor, resulting in the appropriate payment method 
being used for a given transaction.

## Conclusion
During this laboratory work, I had the opportunity to delve into the practical application of several important structural 
design patterns: Proxy, Bridge, Composite, and Facade. This experience helped me understand the significance of design 
patterns in software development.
Firstly, I explored the Proxy Pattern, which allowed me to create a proxy object that controls access to another object. 
I realized its utility in scenarios where I needed to add an additional layer of control or functionality before accessing 
the real object. It became evident that the Proxy Pattern is a valuable tool for managing access, implementing lazy 
initialization, and adding security checks.
Next, I worked with the Bridge Pattern, which was instrumental in decoupling abstractions from their implementations. 
This pattern showed me the power of separating what an object does from how it does it. By implementing the Bridge Pattern, 
I was able to facilitate the management of different payment methods and payment processors, offering greater flexibility and maintainability.
The Composite Pattern was another intriguing pattern I explored. It enabled me to represent part-whole hierarchies of 
objects as a unified structure. I found this pattern particularly valuable for building complex structures from simple 
components. It was a key component in designing an ordering system for a bookstore, where I could seamlessly work with 
individual book orders and composite orders.
Lastly, the Facade Pattern provided a high-level interface that simplified the interactions with a complex system. I 
observed how the Facade Pattern can encapsulate intricate subsystems, making it easier for clients to use the system 
without needing to understand its internal complexities.
Overall, this laboratory work enriched my understanding of structural design patterns and their practical applications. 