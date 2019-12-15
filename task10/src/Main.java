public class Main {

    public static void main(String[] args) {
        Array mass = new Array();
        for (int i = 0; i < 5; i++) {
            mass.addValue((int) (Math.random() * 30));
        }

        mass.setValue(1, 30);
        mass.setValue(3, 30);
        mass.print();
        updateValues(mass);
        mass.print();
    }

    private static void updateValues(Array mass){
        int maxValue = 0;
        Array maxValuePos = new Array();
        for (int i = 0; i < mass.getSize(); i++) {
            if(mass.getValue(i) > maxValue){
                maxValue = mass.getValue(i);
                maxValuePos.clear();
                maxValuePos.addValue(i);
            } else if(mass.getValue(i) == maxValue){
                maxValuePos.addValue(i);
            }
        }

        for (int i = 0; i < maxValuePos.getSize(); i++) {
            int index = maxValuePos.getValue(i);
            mass.setValue(index, mass.getValue(index) * 2);
        }
    }
}
