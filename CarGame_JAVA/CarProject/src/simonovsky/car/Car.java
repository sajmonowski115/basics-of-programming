package simonovsky.car;

import java.lang.*;

public class Car extends Thread {
    protected boolean active=false;
    protected boolean arrived=true;
    private final String registrationNumber;
    private final String model;
    private final int maxVelocity = 2000;
    protected double currentVelocity = 0;
    protected Position currentPosition = new Position(0,0);
    protected Position destiny = new Position(0,0);
    private final int wheelCircuit = 1;
    private Engine engine;
    private Gearbox gearbox;
    private Clutch clutch;
    private int weight;

    public Car(String registrationNumber, String model, Engine engine, Gearbox gearbox, Clutch clutch) {
        System.out.println(registrationNumber + " has been created");
        this.registrationNumber = registrationNumber;
        this.model = model;
        this.engine = engine;
        this.gearbox = gearbox;
        this.clutch = clutch;
        this.currentPosition = new Position(0,0);
        this.weight = gearbox.weight + engine.weight + clutch.weight;
        start();
    }

    public void run() {
        int time = 400; // time in milliseconds to refresh the thread
        int count = 0;
        while(true) {

            if(Math.abs(destiny.x-currentPosition.x) > 5 && Math.abs(destiny.y-currentPosition.y) > 5) {
                arrived = false;

                currentPosition.move(destiny, time, calculateVelocity());
                System.out.print("Current position of " + registrationNumber + ": "); displayCurrentPosition();

                count = 0;
            } else {  // if the car has arrived, stop and stay at the same position
                arrived = true;
                if(count == 0) {
                    System.out.println("The car has arrived");
                }
                count++;
            }

            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }

    @Override
    public String toString() {
        return registrationNumber + ", " + model;
    }

    public void turnOn() {
        if(active) {
            System.out.println("Car already on!");
        } else {
            System.out.println("The car has been turned on");
            engine.turnOn();
            active = true;
        }
    }

    public void turnOff() {
        if(!active) {
            System.out.println("Car already off!");
        } else if(!arrived) {
            System.out.println("Cannot turn off the car while driving");
        } else {
            System.out.println("The car has been turned off");
            currentVelocity = 0;
            active = false;
            gearbox.currentGear = 1;
            engine.turnOff();
        }
    }

    public void goTo(Position destiny) {
        if(!active) {
            System.out.println("You need to turn on the car before moving");
        } else {
            this.destiny = destiny;
            arrived = false;
        }
    }

    public boolean hasArrived() {
        return arrived;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public double calculateVelocity() {
        // calculate velocity according to its formula
        if(!active || arrived) {
            currentVelocity = 0;
        } else {
            currentVelocity = Math.pow(engine.currentEngineSpeed, 2)*Math.pow(gearbox.currentGearRatio, 1.5)*wheelCircuit;
            if(currentVelocity > maxVelocity) {
                currentVelocity = maxVelocity;
            }
        }

        return currentVelocity;
    }

    public String getModel() {
        return model;
    }

    public Position getCurrentPosition() {
        return currentPosition;
    }

    public void displayCurrentPosition() {
        System.out.println(currentPosition.x + " " + currentPosition.y);
    }

    public int getWeight() {
        return weight;
    }

    public Gearbox getGearbox() {
        return gearbox;
    }

    public Engine getEngine() {
        return engine;
    }

    public Clutch getClutch() {
        return clutch;
    }

}
