/*
 part of the RealTimeStrategyGame project
 project's authors~ Szymon Bobrowski && Marek Kwak
 date: 01.02.2021
*/

package game.RTS.com;

public class Archer extends CombatUnit {
    public Archer() {
        attackValue = 12;
        defenceValue = 80;
        recruitmentCost = 38 + (int)(Barracks.numberOfArchers/4);
    }
}
