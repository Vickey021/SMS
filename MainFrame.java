import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    CardLayout cardLayout = new CardLayout();
    JPanel mainPanel = new JPanel(cardLayout);

    @SuppressWarnings("unused")
    public MainFrame() {
        setTitle("Student Management System");
        setSize(700, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel sidebar = new JPanel(new GridLayout(4, 1)); // Now 4 items
        JButton addBtn = new JButton("Add Student");
        JButton viewBtn = new JButton("View Students");
        JButton searchBtn = new JButton("Search Student");
        JButton updateBtn = new JButton("Update Student");

        sidebar.add(addBtn);
        sidebar.add(viewBtn);
        sidebar.add(searchBtn);
        sidebar.add(updateBtn); // Added Update button

        AddStudentPanel addPanel = new AddStudentPanel();
        ViewStudentsPanel viewPanel = new ViewStudentsPanel();
        SearchStudentPanel searchPanel = new SearchStudentPanel();
        UpdateStudentPanel updatePanel = new UpdateStudentPanel(); // Added update panel

        mainPanel.add(addPanel, "Add");
        mainPanel.add(viewPanel, "View");
        mainPanel.add(searchPanel, "Search");
        mainPanel.add(updatePanel, "Update"); // Added update panel

        addBtn.addActionListener(e -> cardLayout.show(mainPanel, "Add"));
        viewBtn.addActionListener(e -> {
            viewPanel.refreshTable();
            cardLayout.show(mainPanel, "View");
        });
        searchBtn.addActionListener(e -> cardLayout.show(mainPanel, "Search"));
        updateBtn.addActionListener(e -> cardLayout.show(mainPanel, "Update")); // Update panel action

        add(sidebar, BorderLayout.WEST);
        add(mainPanel, BorderLayout.CENTER);
    }
}
