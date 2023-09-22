package Domain.Models;

import java.util.Map;

abstract class Book {

    abstract Map<String, String> Add_Book(Map<String, String> Books);
    abstract boolean Book_exists(Map<String, String> Books);
}
