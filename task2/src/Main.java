import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int a;
        int b;
        int c;
        int result = 0;
        Scanner in = new Scanner(System.in);
        System.out.print("Input a, b, c: ");
        a = in.nextInt();
        b = in.nextInt();
        c = in.nextInt();

        int [] mas = {a, b, c};

        boolean isSorted = false;
        int buf;
        while(!isSorted) {
            isSorted = true;
            for (int i = 0; i < mas.length-1; i++) {
                if(mas[i] < mas[i+1]){
                    isSorted = false;

                    buf = mas[i];
                    mas[i] = mas[i+1];
                    mas[i+1] = buf;
                }
            }
        }
        System.out.println(Arrays.toString(mas));
    }
}
