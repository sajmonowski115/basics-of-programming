/*
 part of the RealTimeStrategyGame project
 project's authors~ Szymon Bobrowski && Marek Kwak
 date: 01.02.2021
*/

package game.RTS.com;

import javax.swing.*;

public class HoverOver {
    private JTextArea nameArea;
    private JTextArea isYoursArea;
    private JTextArea levelArea;
    protected JPanel HoverOverPanel;

    public HoverOver(String name, Boolean isIndependent, String level) {
        this.nameArea.setText(name);
        this.levelArea.setText(level);

        if (isIndependent){ isYoursArea.setText("It's not yours"); }
        else { isYoursArea.setText("You own it"); }
    }

    public static void main(String[] args) {
    }
}
