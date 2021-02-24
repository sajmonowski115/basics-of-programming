package simonovsky.car;


public class Engine extends Component {
    protected int maxEngineSpeed;
    protected int currentEngineSpeed=0;
    protected boolean active = false;

    public Engine(int maxEngineSpeed) {
        this.maxEngineSpeed = maxEngineSpeed/1000;
        weight = 800;
        price = 4000;
    }

    public void turnOn() {
        currentEngineSpeed = 0;
        active = true;
    }

    public void turnOff() {
        currentEngineSpeed = 0;
        active = false;
    }

    public void increaseEngineSpeed() {
        if(currentEngineSpeed >= maxEngineSpeed) {
            System.out.println("Max engine speed achieved");
        } else if(!active) {
            System.out.println("You need to turn on the engine first");
        } else {
            currentEngineSpeed += 1;
        }
    }

    public void decreaseEngineSpeed() {
        if(currentEngineSpeed <= 1) {
            System.out.println("Minimum engine speed achieved");
        } else if (!active) {
            System.out.println("You need to turn on the engine first");
        } else {
            currentEngineSpeed -= 1;
        }
    }

    public int getMaxEngineSpeed() {
        return maxEngineSpeed;
    }
}
