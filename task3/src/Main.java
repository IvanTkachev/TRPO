import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BigInteger n;

        Scanner in = new Scanner(System.in);
        System.out.print("Input n: ");
        n = new BigInteger(String.valueOf(in.nextInt()));
        String val = n.toString();
        BigInteger n2 = n.pow(2);
        System.out.println("n^2: " + n2);

        boolean check = false;
        for (int i = 0; i < getCountsOfDigits(n2); i++) {
            if(n2.mod(BigInteger.TEN).equals(new BigInteger("3"))){
                check = true;
                System.out.println("1. 3 is present");
                break;
            }
            n2 = n2.divide(BigInteger.TEN);
        }
        if(!check) {
            System.out.println("1. 3 is not present");
        }


        StringBuilder result2 = new StringBuilder();
        for (int i = val.length() - 1; i >= 0; i--) {
            result2.append(val.charAt(i));
        }
        System.out.println("2. " + result2.toString());

        StringBuilder result3 = new StringBuilder();
        result3.append(val.charAt(val.length()-1));
        for (int i = 1; i < val.length()-1; i++) {
            result3.append(val.charAt(i));
        }
        result3.append(val.charAt(0));
        System.out.println("3. " + result3.toString());

        StringBuilder result4 = new StringBuilder();
        result4.append("1");
        for (int i = 0; i < val.length(); i++) {
            result4.append(val.charAt(i));
        }
        result4.append("1");
        System.out.println("4. " + result4.toString());
    }

    public static int getCountsOfDigits(BigInteger number) {
        return number.bitLength();
    }
}
