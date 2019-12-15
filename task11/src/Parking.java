import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class Parking {

    private List<Pair<Integer, Car>> carsOnParking;

    public Parking() {
        carsOnParking = new ArrayList<Pair<Integer, Car>>();
    }

    public List<Pair<Integer, Car>> getCarsOnParking() {
        return carsOnParking;
    }

    public void setCarsOnParking(List<Pair<Integer, Car>> carsOnParking) {
        this.carsOnParking = carsOnParking;
    }

    public void infoAboutPlace(int placeNumber){
        for (Pair<Integer, Car> carPlace: carsOnParking) {
            if(carPlace.getKey() == placeNumber){
                System.out.print(carPlace.getValue().getLicensePlate() + " is on this place: " + placeNumber);
                return;
            }
        }
        System.out.print("There is no cars on this place: " + placeNumber);
    }

}
