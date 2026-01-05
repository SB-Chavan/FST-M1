package activities;

class Bicycle implements BicycleParts, BicycleOperations {

	protected int gears;
    protected int currentSpeed;

    // Constructor
    public Bicycle(int gears, int currentSpeed) {
        this.gears = gears;
        this.currentSpeed = currentSpeed;
    }

    // Implement applyBrake
    @Override
    public void applyBrake(int decrement) {
        currentSpeed = currentSpeed - decrement;
        if (currentSpeed < 0) {
            currentSpeed = 0;
        }
    }

    // Implement speedUp
    @Override
    public void speedUp(int increment) {
        currentSpeed = currentSpeed + increment;
        if (currentSpeed > maxSpeed) {
            currentSpeed = maxSpeed;
        }
    }

    // Description method
    public String bicycleDesc() {
        return ("No of gears are " + gears +
                "\nSpeed of bicycle is " + maxSpeed);
    }
}