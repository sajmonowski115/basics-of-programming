/*
 part of the RealTimeStrategyGame project
 project's authors~ Szymon Bobrowski && Marek Kwak
 date: 01.02.2021
*/

package game.RTS.com;

public class TownHall extends Building{
    public TownHall() { start(); }

    static protected int amountOfWood = 0;
    static protected int amountOfStone = 0;
    static protected int amountOfGold = 0;

    static Quarry quarry = new Quarry();
    static Sawmill sawmill = new Sawmill();
    static Mint mint = new Mint();
    Barracks barracks = new Barracks();

    void sendAttack(Village target, Town invader, int swordsmen, int cavaliers, int archers) {
        if (!(target.isIndependent())) { return; }
        if (swordsmen > barracks.getNumberOfSwordsmen()){ return; }
        if (cavaliers > barracks.getNumberOfCavaliers()){ return; }
        if (archers > barracks.getNumberOfArchers()){ return; }
        CombatField combatField = new CombatField();
        combatField.PlayerAttack(target, invader, swordsmen, cavaliers, archers);
    }

    public void run(){
        while(true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            quarry.produceStone();
            sawmill.produceWood();
            mint.produceGold();
        }
    }

    public static int getAmountOfWood() { return amountOfWood; }

    public static int getAmountOfStone() { return amountOfStone; }

    public static int getAmountOfGold() { return amountOfGold; }
}
