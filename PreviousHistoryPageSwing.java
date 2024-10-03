import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PreviousHistoryPageSwing extends JFrame {

  public PreviousHistoryPageSwing() {
    setTitle("Previous History");
    setSize(400, 300);
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    JPanel panel = new JPanel(new GridLayout(3, 4));

    for (int year = 2023; year <= 2024; year++) 
    {
      final int selectedYear = year;
      JButton yearButton = new JButton(Integer.toString(year));
      yearButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          openMonthPage(selectedYear);
        }
      });
      panel.add(yearButton);
    }

    add(panel);
  }

  private void openMonthPage(int selectedYear) {
    MonthPageSwing monthPage = new MonthPageSwing(selectedYear);
    monthPage.setVisible(true);
  }
}
