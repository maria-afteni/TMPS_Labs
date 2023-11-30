package Domain.Production.Patterns.Behavioral.Strategy;

public interface IPayStrategy {
    boolean pay(boolean payed);
    void collectPaymentDetails(boolean pay, String payMethod);
}
