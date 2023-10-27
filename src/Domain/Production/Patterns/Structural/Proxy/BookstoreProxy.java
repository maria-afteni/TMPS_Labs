package Domain.Production.Patterns.Structural.Proxy;

import Domain.Models.Bookstore;

public class BookstoreProxy implements IBookstoreAccess {
    private boolean isAdmin;
    private Bookstore bookstore;

    public BookstoreProxy(boolean isAdmin) {
        this.isAdmin = isAdmin;
        this.bookstore = new Bookstore();
    }

    @Override
    public void accessProgram() {
        if (isAdmin) {
            if (bookstore == null) {
                System.out.println("Admin access granted.");
                bookstore.accessProgram();
            }
        } else {
            System.out.println("Access denied. You are not an admin.");
        }
    }
}
