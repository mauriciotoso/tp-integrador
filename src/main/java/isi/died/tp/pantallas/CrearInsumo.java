package isi.died.tp.pantallas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import isi.died.tp.dominio.UnidadMedida;
import javax.swing.JRadioButton;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class CrearInsumo {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;
	
	private final ButtonGroup buttonGroupRefrigerado = new ButtonGroup();
	private final ButtonGroup buttonGroupLiquidos = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrearInsumo window = new CrearInsumo();
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
	public CrearInsumo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Crear Insumo");
		frame.setSize(500,380);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(214, 36, 130, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
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
		Atrás.setBounds(10, 305, 100, 25);
		frame.getContentPane().add(Atrás);
		
		JLabel lblIngreseLosDatos = new JLabel("Ingrese los datos del insumo:");
		lblIngreseLosDatos.setBounds(10, 11, 200, 14);
		frame.getContentPane().add(lblIngreseLosDatos);
		
		JLabel lblId = new JLabel("ID: ");
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblId.setBounds(164, 39, 46, 14);
		frame.getContentPane().add(lblId);
		
		JLabel lblDescripcin = new JLabel("Descripción: ");
		lblDescripcin.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDescripcin.setBounds(10, 70, 200, 14);
		frame.getContentPane().add(lblDescripcin);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(214, 67, 130, 20);
		frame.getContentPane().add(textField_1);
		
		JLabel lblUnidadDeMedida = new JLabel("Unidad de medida: ");
		lblUnidadDeMedida.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUnidadDeMedida.setBounds(10, 98, 200, 14);
		frame.getContentPane().add(lblUnidadDeMedida);
		
		JLabel lblCostoPorUnidad = new JLabel("Costo por unidad: ");
		lblCostoPorUnidad.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCostoPorUnidad.setBounds(10, 126, 200, 14);
		frame.getContentPane().add(lblCostoPorUnidad);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(214, 123, 130, 20);
		frame.getContentPane().add(textField_3);
		
		JLabel lblStockEnCentro = new JLabel("Stock en centro de acopio: ");
		lblStockEnCentro.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStockEnCentro.setBounds(10, 154, 200, 14);
		frame.getContentPane().add(lblStockEnCentro);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(214, 151, 130, 20);
		frame.getContentPane().add(textField_4);
		
		JLabel lblRef = new JLabel("¿Es refrigerado? ");
		lblRef.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRef.setBounds(10, 182, 200, 14);
		frame.getContentPane().add(lblRef);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(UnidadMedida.values()));
		comboBox.setBounds(214, 95, 130, 20);
		frame.getContentPane().add(comboBox);
		
		JRadioButton siR = new JRadioButton("Si");
		siR.setBounds(214, 178, 46, 23);
		frame.getContentPane().add(siR);
		
		JRadioButton noR = new JRadioButton("No");
		noR.setBounds(298, 178, 46, 23);
		frame.getContentPane().add(noR);
		
		JLabel lblesLquido = new JLabel("¿Es líquido? ");
		lblesLquido.setHorizontalAlignment(SwingConstants.RIGHT);
		lblesLquido.setBounds(10, 207, 200, 14);
		frame.getContentPane().add(lblesLquido);
		
		JRadioButton noL = new JRadioButton("No");
		noL.setBounds(298, 204, 46, 23);
		frame.getContentPane().add(noL);
		
		JRadioButton siL = new JRadioButton("Si");
		siL.setBounds(214, 204, 46, 23);
		frame.getContentPane().add(siL);
		
		buttonGroupRefrigerado.add(noR);
		buttonGroupRefrigerado.add(siR);
		buttonGroupLiquidos.add(noL);
		buttonGroupLiquidos.add(siL);
		
		JLabel lblPeso = new JLabel("Peso: ");
		lblPeso.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPeso.setBounds(10, 232, 200, 14);
		frame.getContentPane().add(lblPeso);
		lblPeso.setVisible(false);
		
		JTextField tfPeso = new JTextField();
		tfPeso.setColumns(10);
		tfPeso.setBounds(214, 229, 130, 20);
		frame.getContentPane().add(tfPeso);
		tfPeso.setVisible(false);
		
		JLabel lblDensidad = new JLabel("Densidad: ");
		lblDensidad.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDensidad.setBounds(10, 232, 200, 14);
		frame.getContentPane().add(lblDensidad);
		lblDensidad.setVisible(false);
		
		JTextField tfDensidad = new JTextField();
		tfDensidad.setColumns(10);
		tfDensidad.setBounds(214, 229, 130, 20);
		frame.getContentPane().add(tfDensidad);
		tfDensidad.setVisible(false);
		
		JLabel lblVol = new JLabel("Volumen: ");
		lblVol.setHorizontalAlignment(SwingConstants.RIGHT);
		lblVol.setBounds(10, 263, 200, 14);
		frame.getContentPane().add(lblVol);
		lblVol.setVisible(false);
		
		JTextField tfVol = new JTextField();
		tfVol.setColumns(10);
		tfVol.setBounds(214, 260, 130, 20);
		frame.getContentPane().add(tfVol);
		tfVol.setVisible(false);
		
		siL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblPeso.setVisible(false);
				lblDensidad.setVisible(true);
				lblVol.setVisible(true);
				tfPeso.setVisible(false);
				tfDensidad.setVisible(true);
				tfVol.setVisible(true);
			}
		});
		
		noL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblPeso.setVisible(true);
				lblDensidad.setVisible(false);
				lblVol.setVisible(false);
				tfPeso.setVisible(true);
				tfDensidad.setVisible(false);
				tfVol.setVisible(false);
			}
		});
	}
}
