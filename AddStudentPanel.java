import javax.swing.*;
import java.awt.*;

public class AddStudentPanel extends JPanel {
    @SuppressWarnings("unused")
    public AddStudentPanel() {
        setLayout(new GridLayout(6, 2, 10, 10));

        JTextField nameField = new JTextField();
        JTextField ageField = new JTextField();
        JTextField gradeField = new JTextField();
        JTextField emailField = new JTextField();
        JButton addButton = new JButton("Add Student");

        add(new JLabel("Name:"));
        add(nameField);
        add(new JLabel("Age:"));
        add(ageField);
        add(new JLabel("Grade:"));
        add(gradeField);
        add(new JLabel("Email:"));
        add(emailField);
        add(new JLabel(""));
        add(addButton);

        addButton.addActionListener(e -> {
            Student student = new Student();
            student.setName(nameField.getText());
            student.setAge(Integer.parseInt(ageField.getText()));
            student.setGrade(gradeField.getText());
            student.setEmail(emailField.getText());

            new StudentDAO().addStudent(student);
            JOptionPane.showMessageDialog(this, "Student Added!");
            nameField.setText("");
            ageField.setText("");
            gradeField.setText("");
            emailField.setText("");
        });
    }
}
