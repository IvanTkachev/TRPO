import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Input max value of Counter: ");
        int maxValue = in.nextInt();
        System.out.println();

        Counter counter = new Counter(maxValue);

        boolean isEnd = true;
        while (isEnd){
            System.out.println("Counter: " + counter.getValue());

            System.out.println("Please, choose number of action: ");
            System.out.println("1.  inc1");
            System.out.println("2.  inc10");
            System.out.println("3.  inc100");
            System.out.println("4.  inc1000");
            System.out.println("5.  reset");
            System.out.println("6.  is overflow");
            System.out.println("7.  end");

            int actionNumber = in.nextInt();
            System.out.println();
            switch (actionNumber){
                case 1:
                    counter.inc1();
                    break;
                case 2:
                    counter.inc10();
                    break;
                case 3:
                    counter.inc100();
                    break;
                case 4:
                    counter.inc1000();
                    break;
                case 5:
                    counter.reset();
                    break;
                case 6:
                    System.out.println("Overflow: " + counter.isOverflow());
                    break;
                case 7:
                    isEnd = false;
                    break;
                default:
                    System.out.println("Unexpected value: " + actionNumber);
                    System.out.println();
            }
        }
    }
}
