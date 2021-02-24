/*
 part of the RealTimeStrategyGame project
 project's authors~ Szymon Bobrowski && Marek Kwak
 date: 01.02.2021
*/

package game.RTS.com;

public class Town extends Colony {

    public Town(String name){
        start();
        this.name = name;
    }

    TownHall townHall = new TownHall();
    Barracks barracks = new Barracks();
    final private String name;
    private int numberOfConqueredVillages;
    protected int stoneTax =  numberOfConqueredVillages * 3;
    protected int woodTax = numberOfConqueredVillages * 3;
    protected int goldTax = numberOfConqueredVillages * 2;

    public String getNameOfTown() {
        return name;
    }

    public void VillageIsConquered(){
        numberOfConqueredVillages++;
    }

    public int getNumberOfConqueredVillages() { return numberOfConqueredVillages; }


    public void collectTaxes() {
        TownHall.amountOfWood = TownHall.amountOfWood + woodTax;
        TownHall.amountOfStone = TownHall.amountOfStone + stoneTax;
        TownHall.amountOfGold = TownHall.amountOfGold + goldTax;
    }

    public void run(){
        while(true) {
            stoneTax = numberOfConqueredVillages * 3;
            woodTax = numberOfConqueredVillages * 3;
            goldTax = numberOfConqueredVillages * 2;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            collectTaxes();
        }
    }
}
