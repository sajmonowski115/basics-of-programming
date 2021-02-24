/*
 part of the RealTimeStrategyGame project
 project's authors~ Szymon Bobrowski && Marek Kwak
 date: 01.02.2021
*/

package game.RTS.com;

public abstract class CombatUnit {
    protected int attackValue;
    protected int defenceValue;
    protected int recruitmentCost;

    public int getAttackValue() {
        return attackValue;
    }

    public int getDefenceValue() {
        return defenceValue;
    }

    public int getRecruitmentCost() {
        return recruitmentCost;
    }
}
