package isi.died.tp.pantallas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.border.CompoundBorder;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import java.awt.SystemColor;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
//import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.border.LineBorder;

public class PantallaAgregarStockPlantaX {

	private JFrame frame;
	private JLabel lblIdInsumo;
	private JLabel lblCantidad;
	private JLabel lblPuntoDePedido;
	private JTextField textIdInsumo;
	private JTextField textCantidadInsumo;
	private JTextField textPuntoDePedido;
	private JButton btnAtrs;
	private JButton btnNewButton;
	private JLabel lblDatosDelStock;
	private JTable table;
	private JLabel lblSeleccionePlantas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaAgregarStockPlantaX window = new PantallaAgregarStockPlantaX();
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
	public PantallaAgregarStockPlantaX() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setEnabled(false);
	//	frame.getContentPane().setLayout(new MigLayout("", "[][grow]", "[][][][][][][grow][][grow][][][]"));
		
		lblDatosDelStock = new JLabel("Datos del stock :");
		frame.getContentPane().add(lblDatosDelStock, "cell 0 0,alignx right");
		
		lblIdInsumo = new JLabel("ID Insumo :");
		frame.getContentPane().add(lblIdInsumo, "cell 0 1,alignx trailing");
		
		textIdInsumo = new JTextField();
		frame.getContentPane().add(textIdInsumo, "cell 1 1,alignx left");
		textIdInsumo.setColumns(10);
		
		lblCantidad = new JLabel("Cantidad :");
		lblCantidad.setHorizontalAlignment(SwingConstants.RIGHT);
		frame.getContentPane().add(lblCantidad, "cell 0 2,alignx trailing");
		
		textCantidadInsumo = new JTextField();
		frame.getContentPane().add(textCantidadInsumo, "cell 1 2,alignx left");
		textCantidadInsumo.setColumns(10);
		
		lblPuntoDePedido = new JLabel("Punto de pedido :");
		frame.getContentPane().add(lblPuntoDePedido, "cell 0 3,alignx trailing");
		
		textPuntoDePedido = new JTextField();
		frame.getContentPane().add(textPuntoDePedido, "cell 1 3,alignx left");
		textPuntoDePedido.setColumns(10);
		
		lblSeleccionePlantas = new JLabel("Seleccione planta/s :");
		frame.getContentPane().add(lblSeleccionePlantas, "cell 0 4");
		
		table = new JTable();
		table.setForeground(SystemColor.desktop);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setBackground(SystemColor.scrollbar);
		table.setToolTipText("");
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"1","Juancito",190000,"Harina",true},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"ID Planta", "Nombre planta", "Capital en planta", "Insumos requeridos", "Seleccionar"
			}
		) {
			Class[] columnTypes = new Class[] {
				Object.class, Object.class, Object.class, Object.class, Boolean.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(1).setPreferredWidth(82);
		table.getColumnModel().getColumn(2).setPreferredWidth(92);
		table.getColumnModel().getColumn(3).setPreferredWidth(104);
		frame.getContentPane().add(table, "cell 1 5,grow");
		
		btnAtrs = new JButton("AtrÃ¡s");
		frame.getContentPane().add(btnAtrs, "cell 0 11");
		
		btnNewButton = new JButton("Siguiente");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		frame.getContentPane().add(btnNewButton, "cell 1 11,alignx right");
		frame.setTitle("Agregar stock a planta");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
