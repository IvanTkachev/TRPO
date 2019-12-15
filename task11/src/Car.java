public class Car {

    private String licensePlate;
    private String color;
    private String fullName;
    private boolean isOnParking;

    public Car(String licensePlate, String color, String fullName, boolean isOnParking) {
        this.licensePlate = licensePlate;
        this.color = color;
        this.fullName = fullName;
        this.isOnParking = isOnParking;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public boolean isOnParking() {
        return isOnParking;
    }

    public void setOnParking(boolean onParking) {
        isOnParking = onParking;
    }
}
