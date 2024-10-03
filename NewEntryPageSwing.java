import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NewEntryPageSwing extends JFrame {

  private final MedicalRecordSystemSwing mainFrame;

  public NewEntryPageSwing(MedicalRecordSystemSwing mainFrame) {
    this.mainFrame = mainFrame;

    setTitle("New Entry");
    setSize(400, 300);
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    JPanel panel = new JPanel(new GridLayout(9, 2));

    // Name
    panel.add(createLabel("Enter Name:"));
    JTextField nameField = createTextField();
    panel.add(nameField);

    // Department
    panel.add(createLabel("Select Department:"));
    JComboBox<String> departmentComboBox = createComboBox(
        new String[] { "None", "CS", "EC", "EE", "ME", "CT", "EL", "CE" });
    panel.add(departmentComboBox);

    // Semester
    panel.add(createLabel("Select Semester:"));
    JComboBox<String> semesterComboBox = createComboBox(
        new String[] { "None", "S1", "S2", "S3", "S4", "S5", "S6", "S7", "S8" });
    panel.add(semesterComboBox);

    // Date and Time
    panel.add(createLabel("Date and Time:"));
    JLabel dateTimeLabel = new JLabel();
    panel.add(dateTimeLabel);

    updateDateTimeLabel(dateTimeLabel);

    // Disease
    panel.add(createLabel("Enter Disease:"));
    JTextField diseaseField = createTextField();
    panel.add(diseaseField);

    // Treatment
    panel.add(createLabel("Enter Treatment:"));
    JTextField treatmentField = createTextField();
    panel.add(treatmentField);

    JButton saveButton = new JButton("Save");
    saveButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        saveNewEntry(
            nameField.getText(),
            departmentComboBox.getSelectedItem().toString(),
            semesterComboBox.getSelectedItem().toString(),
            diseaseField.getText(),
            treatmentField.getText());
        closeFrame();
      }
    });

    JButton backButton = createBackButton();

    panel.add(saveButton);
    panel.add(backButton);

    add(panel);
  }

  private void saveNewEntry(String name, String department, String semester, String disease, String treatment) {
    // Code to save the new entry to the database
    // You can use the DatabaseConnector class and adapt the NewEntryPage class from
    // the previous example
  }

  private void updateDateTimeLabel(JLabel dateTimeLabel) {
    // Update the label with the current date and time
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String formattedDateTime = dateFormat.format(new Date());
    dateTimeLabel.setText(formattedDateTime);
  }

  private JLabel createLabel(String text) {
    JLabel label = new JLabel(text);
    label.setFont(new Font("Arial", Font.PLAIN, 14));
    return label;
  }

  private JTextField createTextField() {
    JTextField textField = new JTextField();
    textField.setFont(new Font("Arial", Font.PLAIN, 14));

    // Add a focus listener to set the font style to bold when the text field gains
    // focus
    textField.addFocusListener(new FocusListener() {
      @Override
      public void focusGained(FocusEvent e) {
        textField.setFont(new Font("Arial", Font.BOLD, 14));
      }

      @Override
      public void focusLost(FocusEvent e) {
        // Reset the font style to plain when the text field loses focus
        textField.setFont(new Font("Arial", Font.PLAIN, 14));
      }
    });

    return textField;
  }

  private JComboBox<String> createComboBox(String[] options) {
    JComboBox<String> comboBox = new JComboBox<>(options);
    comboBox.setFont(new Font("Arial", Font.PLAIN, 14));
    return comboBox;
  }

  private JButton createBackButton() {
    JButton backButton = new JButton("Back");
    backButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        closeFrame();
        mainFrame.setVisible(true);
      }
    });

    backButton.setFont(new Font("Arial", Font.PLAIN, 14));
    return backButton;
  }

  private void closeFrame() {
    // Close the current frame
    this.dispose();
  }
}
