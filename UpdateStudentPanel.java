import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateStudentPanel extends JPanel {
    private JTextField idField, nameField, ageField, gradeField, emailField;
    private JButton searchButton, updateButton;

    public UpdateStudentPanel() {
        setLayout(new GridLayout(6, 2, 10, 10));

        idField = new JTextField();
        nameField = new JTextField();
        ageField = new JTextField();
        gradeField = new JTextField();
        emailField = new JTextField();
        
        searchButton = new JButton("Search");
        updateButton = new JButton("Update");

        // Add labels and input fields to panel
        add(new JLabel("Student ID:"));
        add(idField);
        add(new JLabel("Name:"));
        add(nameField);
        add(new JLabel("Age:"));
        add(ageField);
        add(new JLabel("Grade:"));
        add(gradeField);
        add(new JLabel("Email:"));
        add(emailField);
        add(searchButton);
        add(updateButton);

        // Disable update button until search is successful
        updateButton.setEnabled(false);

        // Action for Search button
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int studentId = Integer.parseInt(idField.getText());
                Student student = new StudentDAO().getStudentById(studentId);
                if (student != null) {
                    nameField.setText(student.getName());
                    ageField.setText(String.valueOf(student.getAge()));
                    gradeField.setText(student.getGrade());
                    emailField.setText(student.getEmail());
                    updateButton.setEnabled(true); // Enable the Update button
                } else {
                    JOptionPane.showMessageDialog(UpdateStudentPanel.this, "Student not found!");
                }
            }
        });

        // Action for Update button
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int studentId = Integer.parseInt(idField.getText());
                String name = nameField.getText();
                int age = Integer.parseInt(ageField.getText());
                String grade = gradeField.getText();
                String email = emailField.getText();

                boolean updated = new StudentDAO().updateStudent(studentId, name, age, grade, email);
                if (updated) {
                    JOptionPane.showMessageDialog(UpdateStudentPanel.this, "Student updated successfully!");
                } else {
                    JOptionPane.showMessageDialog(UpdateStudentPanel.this, "Update failed.");
                }
            }
        });
    }
}
