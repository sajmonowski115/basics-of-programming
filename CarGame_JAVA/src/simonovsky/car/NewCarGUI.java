package simonovsky.car;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewCarGUI extends JFrame {
    private JPanel parameters;
    private JTextField carModel;
    private JTextField numOfGears;
    private JTextField maxEngSpeed;
    private JButton addButton;
    private JButton cancelButton;
    private JRadioButton manualButton;
    private JRadioButton halfAutomaticButton;
    private JRadioButton petrolButton;
    private JRadioButton dieselButton;
    private JPanel addField;
    private JTextField rgNum;

    public void clearFields() {
        rgNum.setText("");
        carModel.setText("");
        numOfGears.setText("");
        manualButton.setSelected(false);
        halfAutomaticButton.setSelected(false);
        petrolButton.setSelected(false);
        dieselButton.setSelected(false);
        maxEngSpeed.setText("");
    }

    public static boolean isNumeric(String strNum) {
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
        if(rgNum.getText().equals("") || carModel.getText().equals("") || numOfGears.getText().equals(""))
            return false;
        if(!manualButton.isSelected() && !halfAutomaticButton.isSelected())
            return false;
        if(!petrolButton.isSelected() && !dieselButton.isSelected())
            return false;
        if(manualButton.isSelected() && halfAutomaticButton.isSelected())
            return false;
        if(petrolButton.isSelected() && dieselButton.isSelected())
            return false;
        if(!isNumeric(numOfGears.getText()) || !isNumeric(maxEngSpeed.getText()))
            return false;

        return true;
    }

    public NewCarGUI(JComboBox ComboBoxChoice) {
        setContentPane(addField);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(allSet()) {
                    String gearBoxType;
                    String engineFuelType;
                    int speed = 0;
                    int gears = 0;

                    if(manualButton.isSelected()) {
                        gearBoxType = "manual";
                    } else {
                        gearBoxType = "half-automatic";
                    }

                    if(petrolButton.isSelected()) {
                        engineFuelType = "petrol";
                    } else {
                        engineFuelType = "diesel";
                    }

                    if(Integer.parseInt(maxEngSpeed.getText()) > 11000) {
                        speed = 11000;
                    } else if(Integer.parseInt(maxEngSpeed.getText()) < 6000) {
                        speed = 6000;
                    } else {
                        speed = Integer.parseInt(maxEngSpeed.getText());
                    }

                    if(Integer.parseInt(numOfGears.getText()) > 7) {
                        gears = 7;
                    } else if (Integer.parseInt(numOfGears.getText()) < 4) {
                        gears = 4;
                    } else {
                        gears = Integer.parseInt(numOfGears.getText());
                    }

                    Engine engine = new Engine(speed);
                    Clutch clutch = new Clutch();
                    Gearbox gearbox = new Gearbox(gears, clutch);
                    Car theCar = new Car(rgNum.getText(), carModel.getText(), engine, gearbox, clutch);

                    ComboBoxChoice.addItem(theCar);

                    clearFields();
                } else {
                    System.out.println("WARNING!\nSome parameters have not been set correctly.");
                }
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearFields();
                dispose();
            }
        });
    }
}
