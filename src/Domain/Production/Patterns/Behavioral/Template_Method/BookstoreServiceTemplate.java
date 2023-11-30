package Domain.Production.Patterns.Behavioral.Template_Method;

import Domain.Production.Patterns.Creational.ClientSingleton;

import java.util.HashMap;
import java.util.Map;

public class BookstoreServiceTemplate {

    private Map<String, String> eBooks;
    private Map<String, String> physicalBooks;
    private boolean logged;

    public BookstoreServiceTemplate() {
        eBooks = new HashMap<>();
        physicalBooks = new HashMap<>();
        eBooks.put("Orlando", "Virginia Woolf");
        eBooks.put("The Stranger", "Albert Camus");
        eBooks.put("The Bell Jar", "Sylvia Plath");
        physicalBooks.put("Orlando", "Virginia Woolf");
        physicalBooks.put("The Stranger", "Albert Camus");
        physicalBooks.put("The Bell Jar", "Sylvia Plath");
        logged = false;
    }

    public void authenticate() {
        logged = ClientSingleton.getInstance().getStatus();
    }

    public void logout() {
        logged = false;
    }

    public boolean isUserLoggedIn() {
        return logged;
    }


    public void handleEbookMenu() {
        EbookMenuHandler ebookMenuHandler = new EbookMenuHandler();
        ebookMenuHandler.handleMenu(eBooks);
    }

    public void handlePhysicalBookMenu() {
        PhysicalBookMenuHandler physicalBookMenuHandler = new PhysicalBookMenuHandler();
        physicalBookMenuHandler.handleMenu(physicalBooks);
    }
}