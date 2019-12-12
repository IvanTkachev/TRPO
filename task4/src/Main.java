import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        BigInteger n;
        Scanner in = new Scanner(System.in);
        System.out.println("Input data! ");
        System.out.print("Deposit value (rub): ");
        BigDecimal deposit = in.nextBigDecimal();
        System.out.print("Time in month: ");
        int timeInMonth = in.nextInt();
        System.out.print("Rate (%): ");
        double rate = in.nextDouble()/100;


        System.out.println(profit(deposit, rate, timeInMonth));
    }

    private static BigDecimal profit(BigDecimal deposit, double rate, int timeInMonth){
        BigDecimal result = BigDecimal.ZERO;
        double rateInMonth = rate / 12;
        for (int i = 0; i < timeInMonth; i++) {
            BigDecimal val = deposit.multiply(BigDecimal.valueOf(rateInMonth));
            result = result.add(val);
            deposit = deposit.add(val);
        }
        return result;
    }
}
