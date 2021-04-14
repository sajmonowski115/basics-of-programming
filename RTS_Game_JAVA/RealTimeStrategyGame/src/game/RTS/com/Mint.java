/*
 part of the RealTimeStrategyGame project
 project's authors~ Szymon Bobrowski && Marek Kwak
 date: 01.02.2021
*/

package game.RTS.com;

public class Mint extends Building{
    int goldProduction = level;

    public int upgradeStoneCost = 30*level + (int)Math.pow(level, 2.42);
    public int upgradeWoodCost = 30*level + (int)Math.pow(level, 2.42);

    @Override
    public void upgrade() {
        if(TownHall.amountOfStone < upgradeStoneCost || TownHall.amountOfWood < upgradeWoodCost) {
            return;
        } else {
            super.upgrade();
            goldProduction = level;

            TownHall.amountOfWood -= upgradeWoodCost;
            TownHall.amountOfStone -= upgradeStoneCost;

            upgradeStoneCost = 30*level + (int)Math.pow(level, 2.42);
            upgradeWoodCost = 30*level + (int)Math.pow(level, 2.42);

            if(level > 8) {
                upgradeStoneCost = 30*level + (int)Math.pow(level, 2.42) + (level-8)*40;
                upgradeWoodCost = 30*level + (int)Math.pow(level, 2.42) + (level-8)*40;
            }
        }
    }

    public void produceGold() {
        TownHall.amountOfGold = TownHall.amountOfGold + goldProduction;
    }
}
