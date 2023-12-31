package Domain.Production.Patterns.Structural.Bridge;

public abstract class PaymentMethod {
    protected IPaymentProcessor paymentProcessor;

    public PaymentMethod(IPaymentProcessor paymentProcessor) {
        this.paymentProcessor = paymentProcessor;
    }

    public abstract boolean makePayment(double amount);
}