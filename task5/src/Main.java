public class Main {

    public static void main(String[] args) {
        double[] x = new double[40];
        double[] y = new double[40];
        double[] z = new double[40];

        for (int i = 0; i < 40; i++) {
            x[i] = Math.random() * 100;
            y[i] = Math.random() * 100;
            z[i] = Math.random() * 100;
        }

        double var1 = 0;
        for (int j = 0; j < 40; j++) {
            double v = 1 - Math.pow(y[j], 2);
            if(j == 0){
                var1 = v;
            } else {
                var1 = var1 * v;
            }
        }
        double w = 0;
        for (int i = 0; i < 40; i++) {
            double v = 0;
            if(var1 > 0.5){
                v = Math.sin(x[i]) + 2;
            } else {
                v = 1 - Math.pow(z[i], 2);
            }
            if(i == 0){
                w = v;
            } else {
                w = w * v;
            }
        }
        System.out.println(w);
    }
}
