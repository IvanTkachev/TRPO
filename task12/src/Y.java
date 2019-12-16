public class Y extends X {

    protected int y;

    public Y(int a, int b, int c) {
        super(a, b);
        this.y = c;

    }

    public void run(){
        System.out.println("x1/y + x2*y = " + ((double)x1/y + x2*y) + "\n\n");
    }
}
