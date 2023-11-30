package Domain.Production.Patterns.Structural.Bridge;

public class PayPalPayment extends PaymentMethod {
    public PayPalPayment(IPaymentProcessor paymentProcessor) {
        super(paymentProcessor);
    }

    @Override
    public boolean makePayment(double amount) {
        return paymentProcessor.processPayment(amount);

    }
}
