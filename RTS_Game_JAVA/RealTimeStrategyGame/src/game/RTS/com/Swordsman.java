/*
 part of the RealTimeStrategyGame project
 project's authors~ Szymon Bobrowski && Marek Kwak
 date: 01.02.2021
*/

package game.RTS.com;

public class Swordsman extends CombatUnit {
    public Swordsman() {
        attackValue = 24;
        defenceValue = 24;
        recruitmentCost = 14 + (int)(Barracks.numberOfSwordsmen/8);
    }
}
