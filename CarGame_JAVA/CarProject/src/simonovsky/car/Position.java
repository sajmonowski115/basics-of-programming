package simonovsky.car;

import java.lang.*;

public class Position {
    protected double x;
    protected double y;

    public Position(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // calculate delta x and delta y
    public void move(Position destiny, double time, double velocity) {
        double divider = Math.sqrt(Math.pow((destiny.x+this.x), 2) + Math.pow((destiny.y+this.y), 2));
        time = time/1000;

        double delta_x = (Math.pow(velocity, 1.5)*time*(destiny.x-this.x)) / divider;
        double delta_y = (Math.pow(velocity, 1.5)*time*(destiny.y-this.y)) / divider;

        // when a car gets closer towards its destination it starts slowing down
        // because the difference between destination and current position is decreasing
        // the below code aims at making the movement smooth at any moment
        if(Math.abs(destiny.x - this.x) > 40 && Math.abs(destiny.y - this.y) > 40) {
            this.x += delta_x/100;
            this.y += delta_y/100;
        } else if (Math.abs(destiny.x - this.x) > 30 && Math.abs(destiny.y - this.y) > 30) {
            this.x += delta_x / 40;
            this.y += delta_y / 40;
        } else if (Math.abs(destiny.x - this.x) > 20 && Math.abs(destiny.y - this.y) > 20) {
            this.x += delta_x/20;
            this.y += delta_y/20;
        } else if (Math.abs(destiny.x - this.x) > 15 && Math.abs(destiny.y - this.y) > 15) {
            this.x += delta_x/12;
            this.y += delta_y/12;
        } else if (Math.abs(destiny.x - this.x) > 10 && Math.abs(destiny.y - this.y) > 10) {
            this.x += delta_x/8;
            this.y += delta_y/8;
        } else if (Math.abs(destiny.x - this.x) > 5 && Math.abs(destiny.y - this.y) > 5) {
            this.x += delta_x/5;
            this.y += delta_y/5;
        }

    }
}
