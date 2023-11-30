package Domain.Production.Patterns.Behavioral.Command;
public class AddToWishlist implements IWishlistCommand{

    private Wishlist wishlist;
    private String bookName;

    public AddToWishlist(Wishlist wishlist, String bookName) {
        this.wishlist = wishlist;
        this.bookName = bookName;
    }
    @Override
    public void execute() {
        wishlist.addToWishlist(bookName);
    }
}
