/*
 part of the RealTimeStrategyGame project
 project's authors~ Szymon Bobrowski && Marek Kwak
 date: 01.02.2021
*/

package game.RTS.com;

public class CombatField {

    public static boolean gameOver = false;

    public void PlayerAttack(Village defender, Town invader, int swordsmen, int cavaliers, int archers){
        Barracks barracks = invader.townHall.barracks;
        int defence = defender.getNumberOfBarbarians()*defender.barbarian.getDefenceValue();
        int off = swordsmen*barracks.swordsman.getAttackValue() + cavaliers*barracks.cavalier.getAttackValue() + archers*barracks.archer.getAttackValue();
        if (defence >= off){
            barracks.changeNumberOfSwordsmen((-1)*swordsmen);
            barracks.changeNumberOfCavaliers((-1)*cavaliers);
            barracks.changeNumberOfArchers((-1)*archers);
            Report.main(new String[]{"Defeat", Integer.toString(swordsmen), Integer.toString(cavaliers), Integer.toString(archers)});
        }
        else {
            int cavaliersLose = 0;
            int swordsmenLose = 0;
            int archersLose = 0;
            while (defence > 0){
                while(cavaliers > 0 && defence > 0){
                    defence = defence - barracks.cavalier.getAttackValue();
                    cavaliersLose++;
                    cavaliers--;
                }
                while (swordsmen > 0 && defence > 0){
                    defence = defence - barracks.swordsman.getAttackValue();
                    swordsmenLose++;
                    swordsmen--;
                }
                while (archers > 0 && defence > 0){
                    defence = defence - barracks.archer.getAttackValue();
                    archersLose++;
                    archers--;
                }
            }
            barracks.changeNumberOfSwordsmen((-1)*swordsmenLose);
            barracks.changeNumberOfCavaliers((-1)*cavaliersLose);
            barracks.changeNumberOfArchers((-1)*archersLose);
            invader.VillageIsConquered();
            defender.takeOver();

            Report.main(new String[]{"Victory", Integer.toString(swordsmenLose), Integer.toString(cavaliersLose), Integer.toString(archersLose)});
        }
    }
    public void BarbarianAttack(Village invader, Town defender){
        Barracks barracks = defender.townHall.barracks;
        int off = invader.getNumberOfBarbarians()*invader.barbarian.getAttackValue()*2/3;
        int defence = barracks.getNumberOfSwordsmen()*barracks.swordsman.getDefenceValue() + barracks.getNumberOfCavaliers()*barracks.cavalier.getDefenceValue() + barracks.getNumberOfArchers()*barracks.archer.getDefenceValue();
        if (off > defence){
            // GAME OVER
            gameOver = true;
            Report.main(new String[]{"GAME OVER", Integer.toString(barracks.getNumberOfSwordsmen()), Integer.toString(barracks.getNumberOfCavaliers()), Integer.toString(barracks.getNumberOfArchers())});
        }
        else {
            int cavaliersLose = 0;
            int swordsmenLose = 0;
            int archersLose = 0;
            int cavaliers = barracks.getNumberOfCavaliers();
            int swordsmen = barracks.getNumberOfSwordsmen();
            int archers = barracks.getNumberOfArchers();
            while (off > 0){
                while(archers > 0 && off > 0){
                    off = off - barracks.archer.getDefenceValue();
                    archersLose++;
                    archers--;
                }
                while (swordsmen > 0 && off > 0){
                    off = off - barracks.swordsman.getDefenceValue();
                    swordsmenLose++;
                    swordsmen--;
                }
                while (cavaliers > 0 && off > 0){
                    off = off - barracks.cavalier.getDefenceValue();
                    cavaliersLose++;
                    cavaliers--;
                }
            }
            barracks.changeNumberOfSwordsmen((-1)*swordsmenLose);
            barracks.changeNumberOfCavaliers((-1)*cavaliersLose);
            barracks.changeNumberOfArchers((-1)*archersLose);
            invader.lostInAttack();
            Report.main(new String[]{"Victory", Integer.toString(swordsmenLose), Integer.toString(cavaliersLose), Integer.toString(archersLose)});
        }
    }
}
