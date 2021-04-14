/*
 part of the RealTimeStrategyGame project
 project's authors~ Szymon Bobrowski && Marek Kwak
 date: 01.02.2021
*/

package game.RTS.com;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TownHallGUI extends Thread {
    private JPanel resources;
    private JTextField stoneField;
    private JTextField woodField;
    private JTextField goldField;
    protected JPanel TownHallPanel;
    private JPanel greetingPanel;
    private JLabel greetingLabel;
    private JPanel buildingsPanel;
    private JButton upgradeQuarryButton;
    private JButton upgradeSawmillButton;
    private JButton upgradeMintButton;
    private JLabel quarryLabel;
    private JLabel mintLabel;
    private JLabel sawmillLabel;
    private JButton sendAttackButton;
    private JLabel swords;
    private JPanel attackPanel;
    private JTextField quarryTextField;
    private JTextField sawmillTextField;
    private JTextField mintTextField;
    private JLabel quarryLevelLabel;
    private JLabel sawmillLevelLabel;
    private JLabel mintLevelLabel;
    private JLabel stoneProductionLabel;
    private JLabel woodProductionLabel;
    private JLabel goldProductionLabel;
    private JLabel taxesLabel;

    Town town;

    public TownHallGUI(Town town) {

        this.town = town;

        start();

        upgradeQuarryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TownHall.quarry.upgrade();
            }
        });

        upgradeSawmillButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TownHall.sawmill.upgrade();
            }
        });


        upgradeMintButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TownHall.mint.upgrade();
            }
        });

        sendAttackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("AttackFormGUI");
                frame.setContentPane(new AttackFormGUI(town).attackPanel);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }

    public void run() {
        int time = 100;
        while(!GameGUI.gamerWin && !CombatField.gameOver) {
            refresh();

            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }

    public void refresh() {
        stoneField.setText(Integer.toString(TownHall.getAmountOfStone()));
        woodField.setText(Integer.toString(TownHall.getAmountOfWood()));
        goldField.setText(Integer.toString(TownHall.getAmountOfGold()));

        quarryLevelLabel.setText("level " + TownHall.quarry.getLevel());
        quarryTextField.setText("upgrade cost: " + TownHall.quarry.upgradeStoneCost + " stone, "
                + TownHall.quarry.upgradeWoodCost + " wood");

        sawmillLevelLabel.setText("level " + TownHall.sawmill.getLevel());
        sawmillTextField.setText("upgrade cost: " + TownHall.sawmill.upgradeStoneCost + " stone, "
                + TownHall.sawmill.upgradeWoodCost + " wood");

        mintLevelLabel.setText("level " + TownHall.mint.getLevel());
        mintTextField.setText("upgrade cost: " + TownHall.mint.upgradeStoneCost + " stone, "
                + TownHall.mint.upgradeWoodCost + " wood");

        stoneProductionLabel.setText("Currently: " + TownHall.quarry.stoneProduction + " stone per second");
        woodProductionLabel.setText("Currently: " + TownHall.sawmill.woodProduction + " wood per second");
        goldProductionLabel.setText("Currently: " + TownHall.mint.goldProduction + " gold per second");

        taxesLabel.setText("Current taxes: " + town.stoneTax + " stone, " + town.woodTax + " wood, " + town.goldTax + " gold");
    }
}