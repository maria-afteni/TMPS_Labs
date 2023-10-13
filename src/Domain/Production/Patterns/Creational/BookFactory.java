package Domain.Production.Patterns.Creational;

import Domain.Models.Book;
import Domain.Models.EBook;
import Domain.Models.PhysicalBook;

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
//Add dictionary