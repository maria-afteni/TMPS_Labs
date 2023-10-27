package Domain.Production.Patterns.Structural.Bridge;

public class CreditCardPayment extends PaymentMethod {
    public CreditCardPayment(IPaymentProcessor paymentProcessor) {
        super(paymentProcessor);
    }

    @Override
    public void makePayment(double amount) {
        paymentProcessor.processPayment(amount);
    }
}
