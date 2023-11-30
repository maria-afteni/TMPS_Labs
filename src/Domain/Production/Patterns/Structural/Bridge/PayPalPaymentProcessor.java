package Domain.Production.Patterns.Structural.Bridge;

public class PayPalPaymentProcessor implements IPaymentProcessor{
    @Override
    public boolean processPayment(double amount) {
        System.out.println("Processing PayPal payment of $" + amount);
        return true;
    }
}
