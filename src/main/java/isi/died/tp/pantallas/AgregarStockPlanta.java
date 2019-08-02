package isi.died.tp.pantallas;

import isi.died.tp.datos.Datos;
import isi.died.tp.dominio.Planta;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AgregarStockPlanta {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private static Planta planta;
	private Datos datos;

	public AgregarStockPlanta(Planta pl, Datos datos) {
		this.datos=datos;
		planta=pl;
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Agregar stock a planta");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("Datos del stock:");
		lblNewLabel.setBounds(43, 47, 150, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID Insumo:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(73, 82, 100, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Cantidad:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(73, 117, 100, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Punto de pedido:");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setBounds(43, 152, 130, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(183, 79, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(183, 114, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(183, 149, 86, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("Atrás");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new EditarInsumosDePlanta(planta,datos);
				frame.dispose();
			}
		});
		btnNewButton.setBounds(10, 226, 100, 25);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new EditarInsumosDePlanta(planta,datos);
				frame.dispose();
			}
		});
		btnGuardar.setBounds(324, 226, 100, 25);
		frame.getContentPane().add(btnGuardar);
		
		frame.setVisible(true);
	}
}
