import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Input count of cars: ");
        int count = in.nextInt();
        in.nextLine();

        Parking parking = new Parking();

        List<Car> cars = new ArrayList<Car>();
        for (int i = 0; i < count; i++) {
            System.out.println("Enter license plate number...");
            String licensePlate = in.nextLine();
            System.out.println("Enter color...");
            String color = in.nextLine();
            System.out.println("Enter full name...");
            String fullName = in.nextLine();
            System.out.println("Is car present on parking (Y/N)...");
            String yesNo = in.nextLine();
            boolean isOnParking = false;
            if(!yesNo.equals("Y")){
                isOnParking = true;
            }
            Car car = new Car(licensePlate, color, fullName, isOnParking);
            cars.add(car);
            if(isOnParking){
                parking.getCarsOnParking().add(new Pair<>(i, car));
            }
        }

        showCarsOnParking(parking);
        showCarsNotOnParking(cars);

        parking.infoAboutPlace(1);

        boolean isEnd = true;
        System.out.println();
        while(isEnd){
            System.out.println("Do you want to start filtering (Y/N)?");
            if(in.nextLine().equals("Y")){
                findCarsByCriteria(in, cars);
            } else isEnd = false;
        }
    }

    private static List<Car> findCarsByCriteria(Scanner in, List<Car> cars){
        List<Pair<String, String>> criteria = new ArrayList<Pair<String, String>>();

        System.out.println("Find cars by criteria (write 'skip' to avoid current criterion)");

        System.out.println("License plate number...");
        String licensePlate = in.nextLine();
        if(!"skip".equals(licensePlate)){
            criteria.add(new Pair<>("licencePlate", licensePlate));
        }
        System.out.println("Color...");
        String color = in.nextLine();
        if(!"skip".equals(color)){
            criteria.add(new Pair<>("color", color));
        }
        System.out.println("Full name...");
        String fullName = in.nextLine();
        if(!"skip".equals(fullName)){
            criteria.add(new Pair<>("fullName", fullName));
        }
        System.out.println("Is car present on parking (Y/N)...");
        String yesNo = in.nextLine();
        boolean isOnParking = false;
        if(!yesNo.equals("Y")){
            isOnParking = true;
        }
        if(!"skip".equals(yesNo)){
            criteria.add(new Pair<>("isOnParking", String.valueOf(isOnParking)));
        }

        List<Car> result = new ArrayList<>();
        for (Car car : cars) {
            boolean check = true;
            for (Pair<String, String> criterion: criteria) {
                switch (criterion.getKey()){
                    case "licencePlate":
                        if(!car.getLicensePlate().contains(criterion.getValue())){
                            check = false;
                        }
                        break;
                    case "color":
                        if(!car.getColor().contains(criterion.getValue())){
                            check = false;
                        }
                        break;
                    case "fullName":
                        if(!car.getFullName().contains(criterion.getValue())){
                            check = false;
                        }
                        break;
                    case "isOnParking":
                        if(!String.valueOf(car.isOnParking()).contains(criterion.getValue())){
                            check = false;
                        }
                        break;
                }
                if(!check) break;
            }
            if(check){
                result.add(car);
            }

            System.out.println("After filtering: ");
            for (Car car1: result) {
                System.out.println(car.getLicensePlate() + " " + car.getColor() + " " + car.getFullName() + " " + car.isOnParking());
            }
        }
        return result;
    }

    private static void showCarsOnParking(Parking parking){
        System.out.println("Cars with license plate number on parking now: ");
        for (Pair<Integer, Car> carPlace: parking.getCarsOnParking()) {
            System.out.print(carPlace.getValue().getLicensePlate() + " ");
        }
        System.out.println();
    }

    private static void showCarsOnParking(List<Car> cars){
        System.out.println("Cars with license plate number on parking now: ");
        for (Car car: cars) {
            if(!car.isOnParking()){
                System.out.print(car.getLicensePlate() + " ");
            }
        }
        System.out.println();
    }

    private static void showCarsNotOnParking(List<Car> cars){
        System.out.println("Cars with license plate number not on parking now: ");
        for (Car car: cars) {
            if(!car.isOnParking()){
                System.out.print(car.getLicensePlate() + " ");
            }
        }
        System.out.println();
    }
}
