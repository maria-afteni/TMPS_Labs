import Domain.Production.Patterns.Behavioral.Template_Method.BookstoreServiceTemplate;
import Domain.Production.Patterns.Structural.Facade.BookstoreFacade;
import Domain.Production.Patterns.Structural.Facade.BookstoreService;

public class Main {
    public static void main(String[] args) {
        BookstoreService service = new BookstoreService();
        BookstoreServiceTemplate serviceTemplate = new BookstoreServiceTemplate();
        BookstoreFacade facade = new BookstoreFacade(serviceTemplate);
        facade.menu();
    }
}