package Domain.Models;

import java.util.Map;

public abstract class Book {
    String Name;
    String Author;


    public abstract Map<String, String> addBook(Map<String, String> Books);
    public abstract boolean bookExists(Map<String, String> Books);
}
