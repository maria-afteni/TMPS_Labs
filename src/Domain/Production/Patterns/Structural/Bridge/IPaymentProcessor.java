package Domain.Production.Patterns.Structural.Bridge;

public interface IPaymentProcessor {
    boolean processPayment(double amount);
}
