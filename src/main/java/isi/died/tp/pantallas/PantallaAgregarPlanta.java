package isi.died.tp.pantallas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JSpinner;

public class PantallaAgregarPlanta {

	private JFrame frame;
	private JTextField textIDPlanta;
	private JTextField txtNombrePlanta;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaAgregarPlanta window = new PantallaAgregarPlanta();
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
	public PantallaAgregarPlanta() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Ingresar nueva planta");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblId = new JLabel("ID :");
		lblId.setBounds(124, 40, 18, 14);
		frame.getContentPane().add(lblId);
		
		JLabel lblNombre = new JLabel("Nombre :");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setBounds(85, 65, 57, 14);
		frame.getContentPane().add(lblNombre);
		
		textIDPlanta = new JTextField();
		textIDPlanta.setBounds(165, 37, 86, 20);
		frame.getContentPane().add(textIDPlanta);
		textIDPlanta.setColumns(10);
		
		txtNombrePlanta = new JTextField();
		txtNombrePlanta.setBounds(165, 62, 86, 20);
		frame.getContentPane().add(txtNombrePlanta);
		txtNombrePlanta.setColumns(10);
		
		JButton btnAtrs = new JButton("AtrÃ¡s");
		btnAtrs.setBounds(10, 227, 89, 23);
		frame.getContentPane().add(btnAtrs);
		
		JButton btnIngresarPlanta = new JButton("Ingresar planta");
		btnIngresarPlanta.setBounds(303, 227, 121, 23);
		frame.getContentPane().add(btnIngresarPlanta);
	}
}
