/*
 part of the RealTimeStrategyGame project
 project's authors~ Szymon Bobrowski && Marek Kwak
 date: 01.02.2021
*/

package game.RTS.com;

public class BarbariansAttack extends Thread {
    public BarbariansAttack(Town town, Village village){
        this.town = town;
        this.village = village;
    }
    Town town;
    Village village;

    public void run() {
        try {
            Thread.sleep(village.getTimeOfAttack()*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (village.isIndependent()){
            village.sendAttack(town);
        }
    }
}
