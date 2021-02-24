/*
 part of the RealTimeStrategyGame project
 project's authors~ Szymon Bobrowski && Marek Kwak
 date: 01.02.2021
*/

package game.RTS.com;

public class Sawmill extends Building {
    int woodProduction = level;

    public int upgradeStoneCost = 20*level + (int)Math.pow(level, 2.38);
    public int upgradeWoodCost = 20*level + (int)Math.pow(level, 2.38);

    @Override
    public void upgrade() {
        if(TownHall.amountOfStone < upgradeStoneCost || TownHall.amountOfWood < upgradeWoodCost) {
            return;
        } else {
            super.upgrade();
            woodProduction = level;

            TownHall.amountOfWood -= upgradeWoodCost;
            TownHall.amountOfStone -= upgradeStoneCost;

            upgradeStoneCost = 20*level + (int)Math.pow(level, 2.38);
            upgradeWoodCost = 20*level + (int)Math.pow(level, 2.38);

            if(level > 9) {
                upgradeStoneCost = 20*level + (int)Math.pow(level, 2.38) + (level-9)*30;
                upgradeWoodCost = 20*level + (int)Math.pow(level, 2.38) + (level-9)*30;
            }
        }
    }

    void produceWood() {
        TownHall.amountOfWood = TownHall.amountOfWood + woodProduction;
    }
}
