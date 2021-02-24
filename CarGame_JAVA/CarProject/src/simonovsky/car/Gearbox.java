package simonovsky.car;


public class Gearbox extends Component {
    protected int currentGear=1;
    protected int numberOfGears;
    protected double currentGearRatio=1;
    protected Clutch clutch;


    public Gearbox(int numberOfGears, Clutch clutch) {
        this.numberOfGears = numberOfGears;
        this.clutch = clutch;
        weight = 300;
        price = 1100;
    }

    // higher gear -> higher ratio
    public void calculateGearRatio() {
        currentGearRatio = 1 + 0.3 * currentGear;
    }

    public void increaseGear() {
        if(currentGear == numberOfGears) {
            System.out.println("You're on the highest gear");
        } else if(!clutch.pressed) {
            System.out.println("You first need to press the clutch to increase gear");
        } else {
            currentGear += 1;
        }
        calculateGearRatio();
    }

    public void decreaseGear() {
        if(currentGear <= 1) {
            System.out.println("You're on the lowest gear");
        } else if(!clutch.pressed) {
            System.out.println("You first need to press the clutch to decrease gear");
        } else {
            currentGear -= 1;
        }
        calculateGearRatio();
    }

    public int getCurrentGear() {
        return currentGear;
    }

    public int getNumberOfGears() {
        return numberOfGears;
    }
}
