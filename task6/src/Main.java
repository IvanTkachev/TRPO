import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int x;
        int y;

        int[][] mass;

        Scanner in = new Scanner(System.in);
        System.out.println("Input line count");
        x = in.nextInt();
        System.out.println("Input column count");
        y = in.nextInt();

        mass = new int[x][y];

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                mass[i][j] = (int)(Math.random() * 10);
            }
        }
        int shift;
        System.out.println("Input shift number");
        shift = in.nextInt();
        int mod;
        System.out.println("Input right(1)/down(0) mod: ");
        mod = in.nextInt();

        showMatrix(mass);
        if(mod == 0){
            shiftDown(mass, shift, x, y);
        } else if(mod == 1){
            shiftRight(mass, shift, x, y);
        }
    }

    private static void shiftRight(int[][] array, int step, int x, int y) {
        int count = 0;
        while (count < step) {
            int temp, j;
            for (int i = 0; i < x; i++) {
                temp = array[i][y - 1];
                for (j = y - 1; j > 0; j--) {
                    array[i][j] = array[i][j - 1];
                }
                array[i][j] = temp;
            }
            count++;
        }
        showMatrix(array);
    }

    private static void shiftDown(int[][] array, int step, int x, int y) {
        int[] temp;
        for (int i = 0; i < step; i++) {
            temp = array[array.length - 1];
            System.arraycopy(array, 0, array, 1, array.length - 1);
            array[0] = temp;
        }
        showMatrix(array);
    }


    public static void showMatrix(int[][] m) {
        for (int[] s : m) {
            for (int k : s) {
                System.out.print(k + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
