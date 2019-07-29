package isi.died.tp.ejemplo;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
 
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.TableModel;
 
/**
 * This program demonstrates how to sort rows in a table.
 * @author www.codejava.net
 *
 */
public class JTableSortingExample extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
 
    public JTableSortingExample() {
        super("JTable Sorting Example");
 
 
        List<Employee> listEmployees = createListEmployees();
        TableModel tableModel = new EmployeeTableModel(listEmployees);
        table = new JTable(tableModel);
 
        table.setAutoCreateRowSorter(true);

        add(new JScrollPane(table), BorderLayout.CENTER);
 
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
 
    public List<Employee> createListEmployees() {
        List<Employee> listEmployees = new ArrayList<>();
        
        listEmployees.add(new Employee("Tom","Manager",40));
        listEmployees.add(new Employee("Peter","Programmer",25));
        listEmployees.add(new Employee("Peter","Programmer",25));
        listEmployees.add(new Employee("Patrick","Leader",30));
        listEmployees.add(new Employee("Tim","Designer",28));
        listEmployees.add(new Employee("Sam","Analyst",50));
        listEmployees.add(new Employee("Jeremy","Programmer",32));
        
        return listEmployees;
    }
    
 
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new JTableSortingExample().setVisible(true);
            }
        });
    }
}

