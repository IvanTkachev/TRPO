import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int n;
        int result = 0;
        Scanner in = new Scanner(System.in);
        System.out.print("Input a year: ");
        n = in.nextInt();

        int count = getCountsOfDigits(n);
        if (count >= 3) {
            int val1 = n % 10;
            int val2 = (n / 10) % 10;
            if (val1 == 0 && val2 == 0) {
                result = n / 100;
            } else {
                result = n / 100 + 1;
            }
        } else if (n != 0) {
            result = 1;
        }

        System.out.println("It's " + result + " century");
    }

    public static int getCountsOfDigits(int number) {
        return String.valueOf(Math.abs(number)).length();
    }
}
