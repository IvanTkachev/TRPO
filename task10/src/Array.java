import java.util.Arrays;

public class Array {
    private int size;
    private int currPos;
    private int[] mass;

    public Array() {
        this.size = 10;
        mass = new int[size];
        currPos = 0;
    }

    public Array(int size){
        this.size = size;
        mass = new int[size];
        currPos = 0;
    }

    public Array(int size, int defaultValue){
        this.size = size;
        mass = new int[size];
        Arrays.fill(mass, defaultValue);
        currPos = size-1;
    }

    public int getSize() {
        return currPos;
    }

    public int[] getMass() {
        return mass;
    }

    public void clear(){
        this.size = 10;
        mass = new int[size];
        currPos = 0;
    }

    public void addValue(int value){
        if(currPos == size) {
            size = size * 2;
            System.out.println("UP size from " + currPos + " to " + size);
            int[] newMass = new int[size];
            for (int i = 0; i < currPos; i++) {
                newMass[i] = mass[i];
            }
            newMass[currPos] = value;
            mass = newMass;
            currPos++;
        } else {
            mass[currPos] = value;
            currPos++;
        }
    }

    public void removeValue(){
        if(currPos != 0){
            mass[currPos-1] = 0;
            currPos--;
        }
    }

    public void setValue(int index, int value){
        if(index > size - 1){
            System.out.println("Out of bounds!");
        } else {
            mass[index] = value;
        }
    }

    public int getValue(int index){
        return mass[index];
    }

    public void print(){
        System.out.println("Array: ");
        for (int i = 0; i < currPos; i++) {
            if(i % 10 == 0){
                System.out.println();
            }
            System.out.print(mass[i] + " ");
        }
        System.out.println();
    }
}
