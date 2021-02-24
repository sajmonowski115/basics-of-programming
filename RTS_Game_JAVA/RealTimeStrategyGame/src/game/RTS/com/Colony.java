/*
 part of the RealTimeStrategyGame project
 project's authors~ Szymon Bobrowski && Marek Kwak
 date: 01.02.2021
*/

package game.RTS.com;

public class Colony extends Thread{
    private int coordinateX;
    private int coordinateY;

    public int getCoordinateX() {
        return coordinateX;
    }

    public int getCoordinateY() { return coordinateY; }
}
