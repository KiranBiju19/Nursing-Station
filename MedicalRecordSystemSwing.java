import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MedicalRecordSystemSwing extends JFrame {

    public MedicalRecordSystemSwing() {
        setTitle("Medical Record System");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton newEntryButton = new JButton("New Entry");
        JButton previousHistoryButton = new JButton("Previous History");

        newEntryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openNewEntryPage();
            }
        });

        previousHistoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openPreviousHistoryPage();
            }
        });

        JPanel panel = new JPanel();
        panel.add(newEntryButton);
        panel.add(previousHistoryButton);

        add(panel);
        setVisible(true);
    }

    private void openNewEntryPage() {
        NewEntryPageSwing newEntryPage = new NewEntryPageSwing(this);
        newEntryPage.setVisible(true);
    }

    private void openPreviousHistoryPage() {
        PreviousHistoryPageSwing previousHistoryPage = new PreviousHistoryPageSwing();
        previousHistoryPage.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MedicalRecordSystemSwing();
            }
        });
    }
}
