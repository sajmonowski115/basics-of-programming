package game.RTS.com;

import javax.swing.*;

public class Report {
    private JPanel ReportForm;
    private JTextArea swordsmenTextArea;
    private JTextArea cavaliersTextArea;
    private JTextArea archersTextArea;
    private JTextArea resultsArea;

    public Report(String results, String swordsmenLose, String cavaliersLose, String archersLose){
        resultsArea.setText(results);
        swordsmenTextArea.setText(swordsmenLose);
        cavaliersTextArea.setText(cavaliersLose);
        archersTextArea.setText(archersLose);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Report");
        frame.setContentPane(new Report(args[0], args[1], args[2], args[3]).ReportForm);
        frame.pack();
        frame.setVisible(true);
    }
}

