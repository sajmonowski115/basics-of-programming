/*
 part of the RealTimeStrategyGame project
 project's authors~ Szymon Bobrowski && Marek Kwak
 date: 01.02.2021
*/

package game.RTS.com;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;

public class Map{

    protected JPanel mapPanel;
    private JLabel First;
    private JLabel Fifth;
    private JLabel Sixth;
    private JLabel Seventh;
    private JLabel Ninth;
    private JFrame frame;

    public Map(Village village1, Village village2, Village village3, Village village4, Town town) {
        First.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                frame = new JFrame("HoverOver");
                frame.setContentPane(new HoverOver(village1.getVillageName(), village1.isIndependent(), "Level:  " + village1.getLevel()).HoverOverPanel);
                frame.pack();
                frame.setVisible(true);
            }
            public void mouseExited(MouseEvent e){
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
        });

        Sixth.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                frame = new JFrame("HoverOver");
                frame.setContentPane(new HoverOver(village2.getVillageName(), village2.isIndependent(), "Level:  " + village2.getLevel()).HoverOverPanel);
                frame.pack();
                frame.setVisible(true);
            }
            public void mouseExited(MouseEvent e){
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
        });

        Seventh.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                frame = new JFrame("HoverOver");
                frame.setContentPane(new HoverOver(village3.getVillageName(), village3.isIndependent(), "Level:  " + village3.getLevel()).HoverOverPanel);
                frame.pack();
                frame.setVisible(true);
            }
            public void mouseExited(MouseEvent e){
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
        });

        Ninth.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                frame = new JFrame("HoverOver");
                frame.setContentPane(new HoverOver(village4.getVillageName(), village4.isIndependent(), "Level:  " + village4.getLevel()).HoverOverPanel);
                frame.pack();
                frame.setVisible(true);
            }
            public void mouseExited(MouseEvent e){
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));

            }
        });

        Fifth.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                frame = new JFrame("HoverOver");
                frame.setContentPane(new HoverOver(town.getNameOfTown(), false, "Conquered villages:  " + Integer.toString(town.getNumberOfConqueredVillages())).HoverOverPanel);
                frame.pack();
                frame.setVisible(true);
            }
            public void mouseExited(MouseEvent e){
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
        });
    }
}
