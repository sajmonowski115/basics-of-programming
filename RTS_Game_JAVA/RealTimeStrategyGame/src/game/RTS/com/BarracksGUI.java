/*
 part of the RealTimeStrategyGame project
 project's authors~ Szymon Bobrowski && Marek Kwak
 date: 01.02.2021
*/

package game.RTS.com;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BarracksGUI extends Thread {
    private JPanel currentArmy;
    private JTextField numOfArchers;
    private JTextField numOfSwordsmen;
    private JTextField numOfCavaliers;
    protected JPanel barracksPanel;
    private JPanel icons;
    private JLabel cavalierIcon;
    private JLabel swordsmanIcon;
    private JLabel archerIcon;
    private JPanel recruitPanel;
    private JButton recruitArcherButton;
    private JButton recruitSwordsmanButton;
    private JButton recruitCavalierButton;
    private JTextField amountOfGold;
    private JLabel Barracks;
    private JLabel archerCostLabel;
    private JLabel swordsmanCostLabel;
    private JLabel cavalierCostLabel;
    private JLabel archerAttackValue;
    private JLabel swordsmanAttackValue;
    private JLabel cavalierAttackValue;
    private JLabel archerDefenceValue;
    private JLabel swordsmanDefenceValue;
    private JLabel cavalierDefenceValue;

    Archer archer = new Archer();
    Swordsman swordsman = new Swordsman();
    Cavalier cavalier = new Cavalier();

    Barracks barracks;

    public BarracksGUI(Barracks barracks) {
        this.barracks = barracks;
        start();
        recruitArcherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                barracks.recruitArcher();
            }
        });
        recruitSwordsmanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                barracks.recruitSwordsman();
            }
        });
        recruitCavalierButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                barracks.recruitCavalier();
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
        numOfArchers.setText(Integer.toString(barracks.getNumberOfArchers()));
        numOfSwordsmen.setText(Integer.toString(barracks.getNumberOfSwordsmen()));
        numOfCavaliers.setText(Integer.toString(barracks.getNumberOfCavaliers()));

        amountOfGold.setText(Integer.toString(TownHall.getAmountOfGold()));

        archerCostLabel.setText("cost: " + barracks.archer.recruitmentCost);
        swordsmanCostLabel.setText("cost: " + barracks.swordsman.recruitmentCost);
        cavalierCostLabel.setText("cost: " + barracks.cavalier.recruitmentCost);

        archerAttackValue.setText("attack: " + barracks.archer.attackValue);
        swordsmanAttackValue.setText("attack: " + barracks.swordsman.attackValue);
        cavalierAttackValue.setText("attack: " + barracks.cavalier.attackValue);

        archerDefenceValue.setText("defence: " + barracks.archer.defenceValue);
        swordsmanDefenceValue.setText("defence: " + barracks.swordsman.defenceValue);
        cavalierDefenceValue.setText("defence: " + barracks.cavalier.defenceValue);
    }
}
