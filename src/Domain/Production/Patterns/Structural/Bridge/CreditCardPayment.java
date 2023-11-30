package Domain.Production.Patterns.Structural.Bridge;

public class CreditCardPayment extends PaymentMethod {
    public CreditCardPayment(IPaymentProcessor paymentProcessor) {
        super(paymentProcessor);
    }

    @Override
    public boolean makePayment(double amount) {
        return paymentProcessor.processPayment(amount);
    }
}
