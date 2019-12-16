import java.util.Scanner;

public class X {

    protected int x1;
    protected int x2;

    public X(int a, int b){
        this.x1 = a;
        this.x2 = b;
    }

    public void enter(){
        System.out.println("Enter x1 and x2");
        Scanner in = new Scanner(System.in);
        x1 = in.nextInt();
        x2 = in.nextInt();
    }

    public void show(){
        System.out.println("x1 = " + x1 + ", x2 = " + x2 + "\n\n");
    }
}
