import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MonthPageSwing extends JFrame {

    public MonthPageSwing(int selectedYear) {
        setTitle("Month Page");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(4, 3));

        // Simulated cases data for each month (replace this with your actual data)
        int[] monthlyCases = {10, 15, 8, 12, 20, 18, 14, 16, 22, 25, 30, 28};

        String[] monthNames = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

        for (int i = 0; i < 12; i++) {
            JButton monthButton = new JButton(monthNames[i]);
            int cases = monthlyCases[i];

            // Add ActionListener to display cases when the button is clicked
            monthButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    showCasesDialog(monthNames[i], cases);
                }
            });

            panel.add(monthButton);
        }

        add(panel);
    }

    private void showCasesDialog(String month, int cases) {
        JOptionPane.showMessageDialog(this, "Cases in " + month + ": " + cases, "Monthly Cases", JOptionPane.INFORMATION_MESSAGE);
    }
}
