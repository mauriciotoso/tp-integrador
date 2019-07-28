package isi.died.tp.pantallas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class BuscarInsumos {

	private JFrame frame;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;
	private JScrollPane scrollPaneTabla;
	private JTable table;
	private JTableHeader th;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuscarInsumos window = new BuscarInsumos();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BuscarInsumos() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();		
		frame.setSize(600,300);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton agregarInsumo = new JButton("Agregar Insumo");
		agregarInsumo.setBounds(365, 306, 109, 23);
		frame.getContentPane().add(agregarInsumo);
		
		JButton Atrás = new JButton("Atrás");
		Atrás.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestionInsumos gInsumos = new GestionInsumos();
				gInsumos.main(null);
				frame.dispose();
			}
		});
		Atrás.setBounds(10, 225, 100, 25);
		frame.getContentPane().add(Atrás);
		
		JLabel lblIngreseLosDatos = new JLabel("Ingrese los datos del insumo:");
		lblIngreseLosDatos.setBounds(10, 11, 200, 14);
		frame.getContentPane().add(lblIngreseLosDatos);
		
		JLabel lblDescripcin = new JLabel("Descripción: ");
		lblDescripcin.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDescripcin.setBounds(-59, 39, 200, 14);
		frame.getContentPane().add(lblDescripcin);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(151, 36, 130, 20);
		frame.getContentPane().add(textField_1);
		
		JLabel lblCostoPorUnidad = new JLabel("Costo maximo: ");
		lblCostoPorUnidad.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCostoPorUnidad.setBounds(-59, 101, 200, 14);
		frame.getContentPane().add(lblCostoPorUnidad);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(151, 67, 130, 20);
		frame.getContentPane().add(textField_3);
		
		JLabel lblStockEnCentro = new JLabel("Stock mínimo: ");
		lblStockEnCentro.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStockEnCentro.setBounds(-13, 132, 154, 20);
		frame.getContentPane().add(lblStockEnCentro);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(151, 98, 130, 20);
		frame.getContentPane().add(textField_4);
	
		JLabel lblRef = new JLabel("Stock máximo: ");
		lblRef.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRef.setBounds(-59, 163, 200, 14);
		frame.getContentPane().add(lblRef);
		
		JTextField tfPeso = new JTextField();
		tfPeso.setColumns(10);
		tfPeso.setBounds(151, 129, 130, 20);
		frame.getContentPane().add(tfPeso);
		
		JLabel lblDensidad = new JLabel("Costo mínimo: ");
		lblDensidad.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDensidad.setBounds(-59, 70, 200, 14);
		frame.getContentPane().add(lblDensidad);
		
		JTextField tfDensidad = new JTextField();
		tfDensidad.setColumns(10);
		tfDensidad.setBounds(151, 160, 130, 20);
		
		Object[][] datos= {{"Nombre",2,3},{1,2,3},{1,2,3},{1,2,3},{1,2,3},{1,2,3}};
		String[] columnas= {"Nombre","Costo","Stock"};
		
		table = new JTable(datos, columnas);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setBounds(312, 39, 142, 138);
	    frame.getContentPane().add(table);
	}
}
