package Domain.Production.Patterns.Structural.Bridge;

public class PayPalPayment extends PaymentMethod {
    public PayPalPayment(IPaymentProcessor paymentProcessor) {
        super(paymentProcessor);
    }

    @Override
    public void makePayment(double amount) {
        paymentProcessor.processPayment(amount);

    }
}
