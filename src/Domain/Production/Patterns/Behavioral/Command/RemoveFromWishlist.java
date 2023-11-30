package Domain.Production.Patterns.Behavioral.Command;

public class RemoveFromWishlist implements IWishlistCommand{
    private Wishlist wishlist;
    private String bookName;

    public RemoveFromWishlist(Wishlist wishlist, String bookName){
        this.wishlist = wishlist;
        this.bookName = bookName;
    }

    @Override
    public void execute() {
        wishlist.removeFromWishlist(bookName);
    }
}
