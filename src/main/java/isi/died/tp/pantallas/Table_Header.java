package isi.died.tp.pantallas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

public class Table_Header extends JFrame{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Table_Header()
    {
        JPanel panel;
        JScrollPane ScrollPane;
        JTable table;
        
        setTitle("JTable Header");
        setSize(500,350);
        
        panel = new JPanel(new BorderLayout());
                
        Object[][] data = {
        {1, "FN1","LN1",10},
        {2, "FN1","LN1",15},
        {3, "FN1","LN1",20},
        {4, "FN1","LN1",25},
        {5, "FN1","LN1",30},
        {6, "FN1","LN1",35},
        {7, "FN1","LN1",40},
        {8, "FN1","LN1",45},
        {9, "FN1","LN1",50},
        {10, "FN1","LN1",60}
        };
    

        table = new JTable(data, new Object[]{"ID","First Name","Last Name","Age"});
         
        ScrollPane = new JScrollPane(table);
        panel.add(ScrollPane, BorderLayout.CENTER);
        setContentPane(panel);
        
        JTableHeader Theader = table.getTableHeader();
        
        Theader.setBackground(Color.red); // change the Background color
        Theader.setForeground(Color.WHITE); // change the Foreground
        
        Theader.setFont(new Font("Tahome", Font.BOLD, 20)); // font name style size
        ((DefaultTableCellRenderer)Theader.getDefaultRenderer())
                .setHorizontalAlignment(JLabel.CENTER); // center header text
        
        table.setFont(new Font("Tahome", Font.BOLD, 15));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    
    public static void main(String arg[]) {
    Table_Header th  = new Table_Header();
    th.setVisible( true );
    
  }
    
}