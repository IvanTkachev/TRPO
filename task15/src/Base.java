public class Base {

    protected String s1;
    protected String s2;

    public Base(String s1, String s2){
        this.s1 = s1;
        this.s2 = s2;
    }

    public void show() {
        System.out.println("s1: " + s1);
        System.out.println("s2: " + s2);
    }
}
