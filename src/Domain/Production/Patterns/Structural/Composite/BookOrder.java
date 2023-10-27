package Domain.Production.Patterns.Structural.Composite;

public class BookOrder extends OrderComponent {
    private String title;
    private double price;

    public BookOrder(String title, double price) {
        this.title = title;
        this.price = price;
    }

    @Override
    double getTotalPrice() {
        return price;
    }

    @Override
    void display() {
        System.out.println(title + " - $" + price);
    }
}
