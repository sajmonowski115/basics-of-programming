/*
 part of the RealTimeStrategyGame project
 project's authors~ Szymon Bobrowski && Marek Kwak
 date: 01.02.2021
*/

package game.RTS.com;

public abstract class Building extends Thread {

    protected int level=1;

    public void upgrade() {
        level++;
    }

    public void run(){}

    public int getLevel() {
        return level;
    }

}
