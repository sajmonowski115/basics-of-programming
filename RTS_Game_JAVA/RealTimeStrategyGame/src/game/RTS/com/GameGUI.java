/*
 main class of the RealTimeStrategyGame project
 project's authors~ Szymon Bobrowski && Marek Kwak
 date: 01.02.2021
*/

package game.RTS.com;

import javax.swing.*;
import java.awt.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class GameGUI extends Thread {

    private JPanel greetingPanel;
    private JPanel timePanel;
    private JPanel TownHallPanel;
    private JPanel BarracksPanel;
    private JPanel MapPanel;
    private JPanel gameGUI;
    private JButton townHallButton;
    private JButton barracksButton;
    private JButton worldMapButton;
    private JLabel timeLabel;
    private JLabel endGameLabel;
    private JPanel endGamePanel;
    private JPanel timeOfAttacksPanel;
    private JLabel attacksTime1;
    private JLabel attacksTime2;
    private JLabel attacksTime3;
    private JLabel attacksTime4;
    private JTextArea infoArea;

    public static Village village1 = new Village(1, "Village1");
    public static Village village2 = new Village(2, "Village2");
    public static Village village3 = new Village(3, "Village3");
    public static Village village4 = new Village(4, "Village4");

    static Town town = new Town("Stronghold");
    int time = 3600;

    protected static boolean gamerWin = false;

    public GameGUI() {

        BarbariansAttack barbariansAttack1 = new BarbariansAttack(town, village1);
        BarbariansAttack barbariansAttack2 = new BarbariansAttack(town, village2);
        BarbariansAttack barbariansAttack3 = new BarbariansAttack(town, village3);
        BarbariansAttack barbariansAttack4 = new BarbariansAttack(town, village4);

        ArrayList<Village> villages = new ArrayList<Village>(4);
        villages.add(village1);
        villages.add(village2);
        villages.add(village3);
        villages.add(village4);

        Random rand = new Random();
        Map<Village, Integer> token = new HashMap();
        for (int i = 0; i < 4; i++){
            int randValue = 0;
            while(token.containsValue(randValue)) {
                randValue = rand.nextInt(4);
            }
            token.put(villages.get(i), randValue);
            villages.get(i).setTimeOfAttack((randValue+1)*600 + rand.nextInt(600));
        }

        barbariansAttack1.start();
        barbariansAttack2.start();
        barbariansAttack3.start();
        barbariansAttack4.start();

        start();

        infoArea.setText("Some valuable information to bear in mind:\n" +
                "1. Your town is surrounded by four villages of barbarians which will attack you\n" +
                "2. If any of those attacks is successful it means GAME OVER\n" +
                "3. In order to win you need to conquer all the villages around you in one hour.\n" +
                "4. When a village attacks it uses 2/3 of its forces. If you beat them you only need to\n" +
                "fight the 1/3 remaining while conquering the village\n" +
                "5. If your attack fails than you lose all the warriors you sent, but the barbarians reproduce and\n" +
                "lose no man if they resist your attack. However when your win the village remains under your control\n" +
                "till the end of the game\n" +
                "6. If you conquer a village before it attacks you, the attack from that village will never occur\n" +
                "7. village 1 always attacks first, you do not know the order of other attackers, but every\n" +
                "village only attacks once");

        barracksButton.addActionListener(e -> {
            JFrame frame = new JFrame("BarracksGUI");
            frame.setContentPane(new BarracksGUI(town.barracks).barracksPanel);
            frame.pack();
            frame.setVisible(true);
        });


        townHallButton.addActionListener(e -> {
            JFrame frame = new JFrame("TownHallGUI");
            frame.setContentPane(new TownHallGUI(town).TownHallPanel);
            frame.pack();
            frame.setVisible(true);
        });
        worldMapButton.addActionListener(e -> {
            JFrame frame = new JFrame("Map");
            frame.setContentPane(new game.RTS.com.Map(village1, village2, village3, village4, town).mapPanel);
            frame.pack();
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            frame.setLocation((dim.width-frame.getSize().width)/2, 0);
            frame.setVisible(true);
        });
    }

    public void run() {
        int timeInterval = 1000;
        while(time >= 0 && !CombatField.gameOver && !gamerWin) {

            refresh();

            time -= 1;

            try {
                Thread.sleep(timeInterval);
            } catch (InterruptedException e) {
                System.out.println(e);
            }

            if(!village1.isIndependent() && !village2.isIndependent() && !village3.isIndependent() && !village4.isIndependent())
                gamerWin = true;

        }

        if(time == -1 || CombatField.gameOver) {
            endGameLabel.setText("GAME OVER!");
            CombatField.gameOver = true;
        } else if(gamerWin) {
            endGameLabel.setText("YOU WIN!");
        }
    }

    public void refresh() {
        if(time == 3600) {
            attacksTime1.setText("First village (village 1) attacks at:: " + village1.getTimeOfAttackStr());

            int randomInt = (int)(3.0 * Math.random());

            if(randomInt == 1) {
                attacksTime2.setText("Some village attacks at:: " + village2.getTimeOfAttackStr());
                attacksTime3.setText("Some village attacks at:: " + village4.getTimeOfAttackStr());
                attacksTime4.setText("Some village attacks at:: " + village3.getTimeOfAttackStr());
            } else if (randomInt == 2) {
                attacksTime2.setText("Some village attacks at:: " + village3.getTimeOfAttackStr());
                attacksTime3.setText("Some village attacks at:: " + village2.getTimeOfAttackStr());
                attacksTime4.setText("Some village attacks at:: " + village4.getTimeOfAttackStr());
            } else {
                attacksTime2.setText("Some village attacks at:: " + village4.getTimeOfAttackStr());
                attacksTime3.setText("Some village attacks at:: " + village3.getTimeOfAttackStr());
                attacksTime4.setText("Some village attacks at:: " + village2.getTimeOfAttackStr());
            }
        }

        endGameLabel.setText("Game is ON");
        int minutes = (time/60);
        int seconds = time - minutes*60;
        if(seconds < 10) {
            timeLabel.setText("Game time: " + minutes + ":0" + seconds);
        } else {
            timeLabel.setText("Game time: " + minutes + ":" + seconds);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("GameGUI");
        frame.setContentPane(new GameGUI().gameGUI);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
