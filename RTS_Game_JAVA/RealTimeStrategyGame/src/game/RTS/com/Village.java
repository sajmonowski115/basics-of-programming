/*
 part of the RealTimeStrategyGame project
 project's authors~ Szymon Bobrowski && Marek Kwak
 date: 01.02.2021
*/

package game.RTS.com;

public class Village extends Colony{
    Barbarian barbarian = new Barbarian();

    public Village(int level, String name){
        this.level = level;
        numberOfBarbarians = 240 + (level*60);
        this.name = name;

        if(level > 1) {
            numberOfBarbarians += 45;
        }
    }

    private final int level;
    private int numberOfBarbarians;
    protected Boolean independent = true;
    private int timeOfAttack;
    private final String name;

    public void sendAttack(Town target){
        CombatField combatField = new CombatField();
        combatField.BarbarianAttack(this, target);
    }

    public void takeOver(){ independent = false; }

    public void setTimeOfAttack(int timeOfAttack) {
        this.timeOfAttack = timeOfAttack;
    }
    public int getTimeOfAttack() { return timeOfAttack; }

    public String getTimeOfAttackStr() {

        int inverseTimeOfAttack = 3600 - timeOfAttack;

        int minutes = (int)(inverseTimeOfAttack/60);
        int seconds = inverseTimeOfAttack - minutes*60;

        String timeOfAttackStr;

        if(seconds < 10) {
            timeOfAttackStr = minutes + ":0" + seconds;
        } else {
            timeOfAttackStr = minutes + ":" + seconds;
        }

        return timeOfAttackStr;
    }

    public String getVillageName() {
        return name;
    }

    public void lostInAttack(){ numberOfBarbarians = (int)(numberOfBarbarians/3); }

    public Boolean isIndependent() {
        return independent;
    }

    public int getLevel() {
        return level;
    }

    public int getNumberOfBarbarians() {
        return numberOfBarbarians;
    }

}
