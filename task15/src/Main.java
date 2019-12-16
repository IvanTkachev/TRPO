public class Main {

    public static void main(String[] args) {
        Base base = new First("asdas", "asdasdasda", "asdasdasd");

        base.show();
        ((First)base).replace();

        base.show();
    }
}
