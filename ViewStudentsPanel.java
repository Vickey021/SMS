import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class ViewStudentsPanel extends JPanel {
    private JTable table;
    private DefaultTableModel model;

    public ViewStudentsPanel() {
        setLayout(new BorderLayout());

        model = new DefaultTableModel(new String[]{"ID", "Name", "Age", "Grade", "Email"}, 0);
        table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);
    }

    public void refreshTable() {
        model.setRowCount(0);
        List<Student> list = new StudentDAO().getAllStudents();
        for (Student s : list) {
            model.addRow(new Object[]{
                s.getStudentId(), s.getName(), s.getAge(), s.getGrade(), s.getEmail()
            });
        }
    }
}
