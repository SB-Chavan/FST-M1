package activities;

class MountainBike extends Bicycle {

    private int seatHeight;

    // Constructor
    public MountainBike(int gears, int currentSpeed, int seatHeight) {
        super(gears, currentSpeed);
        this.seatHeight = seatHeight;
    }

    // Setter for seat height
    public void setHeight(int newValue) {
        seatHeight = newValue;
    }

    // Override bicycleDesc
    @Override
    public String bicycleDesc() {
        return ("No of gears are " + gears +
                "\nSpeed of bicycle is " + maxSpeed +
                "\nSeat height is " + seatHeight);
    }
}
