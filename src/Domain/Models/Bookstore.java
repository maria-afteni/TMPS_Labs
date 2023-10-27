package Domain.Models;

import Domain.Production.Patterns.Structural.Proxy.IBookstoreAccess;

public class Bookstore implements IBookstoreAccess {
    @Override
    public void accessProgram() {
        System.out.println("Accessing the system...");
    }
}
