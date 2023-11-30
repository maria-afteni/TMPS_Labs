package Domain.Production.Patterns.Behavioral.Command;

import java.util.ArrayList;
import java.util.List;

public class Wishlist {
    private List<String> booksWishlist = new ArrayList<>();

    public void addToWishlist(String bookName) {
        if (!booksWishlist.contains(bookName)) {
            booksWishlist.add(bookName);
            System.out.println(bookName + " added to wishlist.");
        } else {
            System.out.println(bookName + " is already in the wishlist.");
        }
    }

    public void removeFromWishlist(String bookName) {
        if (booksWishlist.contains(bookName)) {
            booksWishlist.remove(bookName);
            System.out.println(bookName + " removed from wishlist.");
        } else {
            System.out.println(bookName + " is not in the wishlist.");
        }
    }
}
