import javax.swing.*;
import java.awt.*;

public class SearchStudentPanel extends JPanel {
    public SearchStudentPanel() {
        setLayout(new GridLayout(3, 2, 10, 10));

        JTextField idField = new JTextField();
        JTextArea resultArea = new JTextArea(5, 30);
        resultArea.setEditable(false);
        JButton searchButton = new JButton("Search");

        add(new JLabel("Enter Student ID:"));
        add(idField);
        add(new JLabel(""));
        add(searchButton);
        add(new JLabel("Result:"));
        add(new JScrollPane(resultArea));

        searchButton.addActionListener(e -> {
            int id = Integer.parseInt(idField.getText());
            Student student = new StudentDAO().getStudentById(id);
            if (student != null) {
                resultArea.setText("Name: " + student.getName() +
                        "\nAge: " + student.getAge() +
                        "\nGrade: " + student.getGrade() +
                        "\nEmail: " + student.getEmail());
            } else {
                resultArea.setText("Student not found.");
            }
        });
    }
}
