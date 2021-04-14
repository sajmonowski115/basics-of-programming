/*
 part of the RealTimeStrategyGame project
 project's authors~ Szymon Bobrowski && Marek Kwak
 date: 01.02.2021
*/

package game.RTS.com;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AttackFormGUI extends JFrame {

    private JPanel combatUnitsPanel;
    protected JPanel attackPanel;
    private JTextField swordsmenField;
    private JTextField cavaliersField;
    private JTextField archersField;
    private JRadioButton village1Button;
    private JRadioButton village2Button;
    private JRadioButton village3Button;
    private JRadioButton village4Button;
    private JLabel villageLabel;
    private JPanel villagePanel;
    private JPanel buttonPanel;
    private JPanel iconPanel;
    private JButton sendAttackButton;
    private JButton cancelAttackButton;
    private JPanel barbarianPanel;
    private JLabel attackValueLabel;
    private JLabel attackWayLabel;
    private JLabel messageLabel;
    private JLabel defenceValueLabel;

    public void clearFields(){
        swordsmenField.setText("");
        cavaliersField.setText("");
        archersField.setText("");

        village1Button.setSelected(false);
        village2Button.setSelected(false);
        village3Button.setSelected(false);
        village4Button.setSelected(false);
    }

    Barbarian barbarian = new Barbarian();

    public static boolean isInteger(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public boolean allSet() {
        if(swordsmenField.getText().equals("") || cavaliersField.getText().equals("") || archersField.getText().equals(""))
            return false;
        if(!isInteger(swordsmenField.getText()) || !isInteger(cavaliersField.getText()) || !isInteger(archersField.getText()))
            return false;

        int count = 0;

        if(village1Button.isSelected()) count++;
        if(village2Button.isSelected()) count++;
        if(village3Button.isSelected()) count++;
        if(village4Button.isSelected()) count++;

        if(count != 1)
            return false;

        return true;
    }

    public AttackFormGUI(Town town) {

        village1Button.setText("Village 1 with " + GameGUI.village1.getNumberOfBarbarians() + " barbarians");
        village2Button.setText("Village 2 with " + GameGUI.village2.getNumberOfBarbarians() + " barbarians");
        village3Button.setText("Village 3 with " + GameGUI.village3.getNumberOfBarbarians() + " barbarians");
        village4Button.setText("Village 4 with " + GameGUI.village4.getNumberOfBarbarians() + " barbarians");

        messageLabel.setText("Our spies have discovered some valuable information");
        attackValueLabel.setText("barbarian attack value: " + barbarian.attackValue);
        defenceValueLabel.setText("barbarian defence value: " + barbarian.defenceValue);

        sendAttackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(allSet()) {
                    int numOfSwordsmen = Integer.parseInt(swordsmenField.getText());
                    int numOfCavaliers = Integer.parseInt(cavaliersField.getText());
                    int numOfArchers = Integer.parseInt(archersField.getText());
                    if(village1Button.isSelected())
                        town.townHall.sendAttack(GameGUI.village1, town, numOfSwordsmen, numOfCavaliers, numOfArchers);
                    else if(village2Button.isSelected())
                        town.townHall.sendAttack(GameGUI.village2, town, numOfSwordsmen, numOfCavaliers, numOfArchers);
                    else if(village3Button.isSelected())
                        town.townHall.sendAttack(GameGUI.village3, town, numOfSwordsmen, numOfCavaliers, numOfArchers);
                    else if(village4Button.isSelected())
                        town.townHall.sendAttack(GameGUI.village4, town, numOfSwordsmen, numOfCavaliers, numOfArchers);

                    System.out.println("Number of archers: " + town.townHall.barracks.getNumberOfArchers());
                    System.out.println("Number of swordsmen: " + town.townHall.barracks.getNumberOfSwordsmen());
                    System.out.println("Number of cavaliers: " + town.townHall.barracks.getNumberOfCavaliers());
                } else {
                    System.out.println("WARNING!\nSome parameters have not been set correctly.");
                }
            }
        });

        cancelAttackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearFields();
            }
        });
    }
}
