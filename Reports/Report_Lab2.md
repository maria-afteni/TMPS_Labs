# Creational Design Patterns


## Author: Afteni Maria

----

## Objectives:
&ensp; &ensp;
__1. Study and understand the Creational Design Patterns.__

&ensp; &ensp;
__2. Choose a domain, define its main classes/models/entities and choose the appropriate instantiation mechanisms.__

&ensp; &ensp;
__3. Use some creational design patterns for object instantiation in a sample project.__


## Theory:
Creational design patterns are a specific category of design patterns that primarily deal with the process of creating 
objects. They provide solutions to manage and control object creation, enabling developers to create objects in a more 
organized and efficient manner. Some well-known creational patterns include Singleton, Factory, and Prototype, each 
serving different purposes in object creation and management.


## Implementation
In this laboratory work I implemented four creational patterns. 
The first one is the Singleton design pattern. The Singleton design pattern ensures that a class has only one instance 
throughout the program. It also offers a global access point to this instance, which is useful for managing shared 
resources or settings.

```
public class ClientSingleton {
    private static ClientSingleton instance = null;
    boolean logged;
    ClientAuthorization c1 = new ClientAuthorization();
    Map<String, String> credentials = new HashMap<>(){{
        put("Admin", c1.hashPassword("admin32"));
        put("Nicu", c1.hashPassword("angel"));
    }};

    private ClientSingleton(){
        Scanner scanner = new Scanner(System.in);
        this.logged = false;
        while(!logged) {
            System.out.println("\n1. Sign in \n2. Log in");
            int option = scanner.nextInt();
            switch (option) {
                case 1 -> credentials = c1.singIn(credentials);
                case 2 -> {
                    assert credentials != null;
                    this.logged = c1.logIn(credentials);
                }
            }
        }
    }

    public static synchronized ClientSingleton getInstance(){
        if (instance == null){
            instance = new ClientSingleton();
        }

        return instance;
    }
}
```

I've created a class called "ClientSingleton" following the Singleton design pattern, which ensures there's just one 
instance of a clients in the entire program. This class handles client authorization, allowing users to sign in and 
log in. I've set up a map to store client credentials, which includes usernames and their corresponding hashed passwords. 
To access this class, I've implemented a "getInstance" method that provides a global entry point. It also manages the 
client authorization process through a simple console interface, where clients can choose to either sign in or log in.

The second implemented pattern is Factory. The Factory design pattern is a creational pattern that encapsulates object 
creation by providing a dedicated method to create and return objects, enhancing code modularity and maintainability.

```
public class BookFactory {
    public static Book getBookType(int option){
        if (option == 1){
            return new EBook();
        }
        else if(option == 2){
            return new PhysicalBook();
        }
        else{
            return null;
        }
    }
}
```

I've designed a "BookFactory" class with a static method called "getBookType" to facilitate the creation of book objects. 
This method takes an "option" parameter, and based on the provided option (1 for eBook or 2 for PhysicalBook), it 
returns the corresponding type of book object. This approach streamlines the process of creating book instances and 
makes the code more modular and maintainable.

The Builder pattern is a creational pattern that separates the construction of complex objects, enabling step-by-step 
building with clear, customizable steps.

```
public static class clientBuilder {
        private String username;
        private String password;

        public clientBuilder setUsername(String user){
            this.username = user;
            return this;
        }

        public clientBuilder setPassword(String password){
            this.password = password;
            return this;
        }
    }
```

This class is designed to help construct client objects. It has two fields, "username" and "password," which are 
attributes of the client object.
The "clientBuilder" class offers two methods, "setUsername" and "setPassword," which allow you to set the "username" 
and "password" properties of the client. These methods return the builder object itself, which means you can chain these 
methods together to set multiple properties in a clear and concise manner.

The Prototype design pattern is a creational pattern that allows objects to be created by duplicating an existing 
object, reducing the overhead of creating new objects from scratch.

```
public interface BookPrototype{
    BookPrototype clone();
    Map<String, String> addBook(Map<String, String> bookDatabase);
    boolean bookExists(Map<String, String> bookDatabase);
    void viewBooks(Map<String, String> bookDatabase);
}
```
the BookPrototype interface acts as a blueprint for implementing various book management classes, whether for eBooks, 
physical books, or other book-related operations. It offers a consistent way to interact with different implementations 
without changing the client code, thanks to the principles of the Prototype design pattern.


```
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
```
    
For exemple, I've implemented a class named EBookPrototype that implements the BookPrototype interface. This class is 
responsible for managing eBook-related operations. t demonstrates how to add eBooks to the database by taking user input
for the book's name and author, checking for existing entries, and updating the database accordingly. It's a concrete 
implementation of the BookPrototype interface, providing specific functionality for managing eBooks within a book 
database.

## Conclusion 
This laboratory work allowed me to explore four fundamental creational design patterns: Singleton, Builder, Factory, 
and Prototype. These patterns are vital for creating objects in software development.
The Singleton pattern ensures there's only one instance of a class, which is useful for managing shared resources.
The Builder pattern simplifies the creation of complex objects with many attributes, making code more readable and 
maintainable.
The Factory pattern provides a flexible way to create objects without specifying their exact types, which helps in 
extending the application with new object types.
The Prototype pattern allows for creating new objects by cloning existing ones, reducing the effort required for 
object creation.
This experience enhanced my understanding of these patterns and their practical applications in software development, 
which will benefit my future work in designing efficient and maintainable software systems.