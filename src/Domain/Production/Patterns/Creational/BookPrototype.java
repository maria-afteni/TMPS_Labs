package Domain.Production.Patterns.Creational;

import java.util.Map;

public interface BookPrototype{
    BookPrototype clone();
    Map<String, String> addBook(Map<String, String> bookDatabase);
    boolean bookExists(Map<String, String> bookDatabase);
    void viewBooks(Map<String, String> bookDatabase);

    void viewOrders();
}

