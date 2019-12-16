public class First extends Base {

    protected String s3;

    public First(String s1, String s2, String s3) {
        super(s1, s2);
        this.s3 = s3;
    }

    public void show(){
        System.out.println("s1: " + s1);
        System.out.println("s2: " + s2);
        System.out.println("s3: " + s3);
    }

    public void replace(){
        s1 = replace(s1);
        s2 = replace(s2);
        s3 = replace(s3);
    }

    private String replace(String s){
        if(s.length() % 2 == 0){
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if(i % 2 == 0) {
                    stringBuilder.append("*");
                } else {
                    stringBuilder.append(s.charAt(i));
                }
            }
           return stringBuilder.toString();
        }
        return s;
    }

}
