package Domain.Production.Patterns.Structural.Bridge;

public class CreditCardPaymentProcessor implements IPaymentProcessor{
    @Override
    public boolean processPayment(double amount) {
        System.out.println("Processing credit card payment of $" + amount);
        return true;
    }
}
