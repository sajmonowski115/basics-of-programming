/*
 part of the RealTimeStrategyGame project
 project's authors~ Szymon Bobrowski && Marek Kwak
 date: 01.02.2021
*/

package game.RTS.com;

public class Barracks {
    protected static int numberOfSwordsmen = 0;
    protected static int numberOfCavaliers = 0;
    protected static int numberOfArchers = 0;

    protected Swordsman swordsman = new Swordsman();
    protected Cavalier cavalier = new Cavalier();
    protected Archer archer = new Archer();

    public void recruitSwordsman() {
        swordsman = new Swordsman();
        if(TownHall.amountOfGold < swordsman.recruitmentCost) {
            return;
        } else {
            numberOfSwordsmen++;
            TownHall.amountOfGold -= swordsman.recruitmentCost;
        }
    }

    public void recruitCavalier() {
        cavalier = new Cavalier();
        cavalier.recruitmentCost = cavalier.getRecruitmentCost();
        if(TownHall.amountOfGold < cavalier.recruitmentCost) {
            return;
        } else {
            numberOfCavaliers++;
            TownHall.amountOfGold -= cavalier.recruitmentCost;
        }
    }

    public void recruitArcher() {
        archer = new Archer();
        if(TownHall.amountOfGold < archer.recruitmentCost) {
            return;
        } else {
            numberOfArchers++;
            TownHall.amountOfGold -= archer.recruitmentCost;
        }
    }

    public void changeNumberOfSwordsmen(int numberOfSwordsmen) {
        Barracks.numberOfSwordsmen = Barracks.numberOfSwordsmen + numberOfSwordsmen;
    }

    public void changeNumberOfCavaliers(int numberOfCavaliers) {
        Barracks.numberOfCavaliers = Barracks.numberOfCavaliers + numberOfCavaliers;
    }

    public void changeNumberOfArchers(int numberOfArchers) {
        Barracks.numberOfArchers = Barracks.numberOfArchers + numberOfArchers;
    }

    public int getNumberOfSwordsmen() {
        return numberOfSwordsmen;
    }

    public int getNumberOfCavaliers() {
        return numberOfCavaliers;
    }

    public int getNumberOfArchers() {
        return numberOfArchers;
    }


}
