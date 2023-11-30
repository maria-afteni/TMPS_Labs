package Domain.Production.Patterns.Behavioral.Strategy;

import java.util.Random;

public class PayStrategy implements IPayStrategy {
    @Override
    public boolean pay(boolean payed) {
        return payed;
    }

    @Override
    public void collectPaymentDetails(boolean payed, String payMethod) {
        if(payed){
            Random rand = new Random();

            System.out.println("\nTransaction finished on " + rand.nextInt(31) + "." + rand.nextInt(12) + ".2023");
            System.out.println("\nPayment done at " + rand.nextInt(0,25) + ":" + rand.nextInt(61 ));

            System.out.println("\nPayment method: " + payMethod);
        }

    }
}
