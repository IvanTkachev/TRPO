public class Counter {

    private int maxValue;

    private int value;

    private boolean overflow;

    public Counter(int maxValue) {
        this.maxValue = maxValue;
        this.value = 0;
    }

    public void reset(){
        overflow = false;
        value = 0;
    }

    public void inc1(){
        if(value + 1 >= maxValue){
            overflow = true;
            System.out.println("Counter overflow. Current value: " + maxValue);
            value = maxValue;
        } else
        value = value + 1;
    }

    public void inc10(){
        if(value + 10 >= maxValue){
            overflow = true;
            System.out.println("Counter overflow. Current value: " + maxValue);
            value = maxValue;
        } else
        value = value + 10;
    }

    public void inc100(){
        if(value + 100 >= maxValue){
            overflow = true;
            System.out.println("Counter overflow. Current value: " + maxValue);
            value = maxValue;
        } else
        value = value + 100;
    }

    public void inc1000(){
        if(value + 1000 >= maxValue){
            overflow = true;
            System.out.println("Counter overflow. Current value: " + maxValue);
            value = maxValue;
        } else
        value = value + 1000;
    }

    public boolean isOverflow(){
        return overflow;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public int getValue() {
        return value;
    }

}
