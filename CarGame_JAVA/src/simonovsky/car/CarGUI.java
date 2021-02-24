// main class of the CarProject
// author~ Szymon Bobrowski
// date: 27.12.2020

package simonovsky.car;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CarGUI extends Thread {
    private JTextField carModel;
    private JTextField carRgNum;
    private JTextField carWeight;
    private JTextField carVelocity;
    private JTextField numOfGears;
    private JTextField gearboxPrice;
    private JTextField gearboxWeight;
    private JTextField currentGear;
    private JTextField pressed;
    private JButton turnOnButton;
    private JButton turnOffButton;
    private JButton increaseGearButton;
    private JButton decreaseGearButton;
    private JButton increaseSpeedButton;
    private JButton decreaseSpeedButton;
    private JButton pressButton;
    private JButton releaseButton;
    private JButton addNewButton;
    private JButton removeButton;
    private JPanel CarGUI;
    private JTextField clutchPrice;
    private JTextField clutchWeight;
    private JTextField engineMaxSpeed;
    private JTextField enginePrice;
    private JTextField engineWeight;
    private JTextField engineCurrSpeed;
    private JPanel mapPanel;
    private JLabel carIcon;
    protected JComboBox carChoice;

    private Car car;

    public void setCar(Car car) {
        this.car = car;
    }

    public CarGUI() {

        turnOnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                car.turnOn();
                refresh();
            }
        });

        turnOffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                car.turnOff();
                refresh();
            }
        });

        increaseGearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                car.getGearbox().increaseGear();
                refresh();
            }
        });

        decreaseGearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                car.getGearbox().decreaseGear();
                refresh();
            }
        });

        increaseSpeedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                car.getEngine().increaseEngineSpeed();
                refresh();
            }
        });

        decreaseSpeedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                car.getEngine().decreaseEngineSpeed();
                refresh();
            }
        });

        pressButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                car.getClutch().pressTheClutch();
                refresh();
            }
        });

        releaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                car.getClutch().releaseTheClutch();
                refresh();
            }
        });

        mapPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                car.goTo(new Position(e.getX(), e.getY()));
            }
        });

        addNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame f = new NewCarGUI(carChoice);
                f.pack();
                f.setVisible(true);
            }
        });

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                car.currentPosition = car.destiny;
                car.arrived = true;
                car.active = true;
                car.turnOff();
                car.interrupt();
                carChoice.removeItem(car);
            }
        });

        carChoice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                car = (Car)carChoice.getSelectedItem();
            }
        });

        start();
    }

    public void run() {
        int time = 100; // time in milliseconds to refresh the thread
        while(true) {
            if(car != null) {
                refresh();
            } else {
                clearFields();
            }
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }

    public void clearFields() {
        carModel.setText("-");
        carRgNum.setText("-");
        carWeight.setText("-");
        carVelocity.setText("-");

        numOfGears.setText("-");
        gearboxPrice.setText("-");
        gearboxWeight.setText("-");
        currentGear.setText("-");

        engineMaxSpeed.setText("-");
        enginePrice.setText("-");
        engineWeight.setText("-");
        engineCurrSpeed.setText("-");

        pressed.setText("-");
        clutchPrice.setText("-");
        clutchWeight.setText("-");

        carIcon.setVisible(false);
    }

    public void refresh() {
        carModel.setText(car.getModel());
        carRgNum.setText(car.getRegistrationNumber());
        carWeight.setText(Integer.toString(car.getWeight()));
        carVelocity.setText(Double.toString(car.currentVelocity));

        numOfGears.setText(Integer.toString(car.getGearbox().getNumberOfGears()));
        gearboxPrice.setText(Integer.toString(car.getGearbox().getPrice()));
        gearboxWeight.setText(Integer.toString(car.getGearbox().getWeight()));
        currentGear.setText(Integer.toString(car.getGearbox().getCurrentGear()));

        engineMaxSpeed.setText(Integer.toString(car.getEngine().getMaxEngineSpeed()));
        enginePrice.setText(Integer.toString(car.getEngine().getPrice()));
        engineWeight.setText(Integer.toString(car.getEngine().getWeight()));
        engineCurrSpeed.setText(Integer.toString(car.getEngine().currentEngineSpeed));

        pressed.setText(Boolean.toString(car.getClutch().pressed));
        clutchPrice.setText(Integer.toString(car.getClutch().getPrice()));
        clutchWeight.setText(Integer.toString(car.getClutch().getWeight()));

        carIcon.setVisible(true);
        carIcon.setLocation((int)car.getCurrentPosition().x, (int)car.getCurrentPosition().y);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("CarGUI");
        frame.setContentPane(new CarGUI().CarGUI);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
