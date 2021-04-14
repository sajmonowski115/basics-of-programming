/*
 part of the RealTimeStrategyGame project
 project's authors~ Szymon Bobrowski && Marek Kwak
 date: 01.02.2021
*/

package game.RTS.com;

public class Cavalier extends CombatUnit {
    public Cavalier() {
        attackValue = 130;
        defenceValue = 25;
        recruitmentCost = 65 + (int)Barracks.numberOfCavaliers/4;
    }
}
