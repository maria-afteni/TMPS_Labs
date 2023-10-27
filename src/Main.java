import Domain.Production.Patterns.Structural.Facade.BookstoreFacade;
import Domain.Production.Patterns.Structural.Facade.BookstoreService;

public class Main {
    public static void main(String[] args) {
        BookstoreService service = new BookstoreService();
        BookstoreFacade facade = new BookstoreFacade(service);
        facade.menu();
    }
}