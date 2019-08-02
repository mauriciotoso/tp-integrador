package isi.died.tp.pantallas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

import isi.died.tp.app.App;
import isi.died.tp.datos.Datos;

public class GestionLogistica {

	private JFrame frame;
	private Datos datos;

	public GestionLogistica(Datos datos) {
		this.datos=datos;
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Gestión Logística");
		frame.setSize(450, 300);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton gestionPlantas = new JButton("Ver Mapa de Plantas");
		gestionPlantas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MapaPlantas(datos);
				frame.dispose();
			}
		});
		gestionPlantas.setBounds(60, 60, 130, 40);
		frame.getContentPane().add(gestionPlantas);
		
		JButton gestionLogistica = new JButton("Agregar Ruta");
		gestionLogistica.setBounds(60, 120, 130, 40);
		frame.getContentPane().add(gestionLogistica);
		
		JButton gestionInsumos = new JButton("Flujo Máximo de Red");
		gestionInsumos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		gestionInsumos.setBounds(230, 60, 130, 40);
		frame.getContentPane().add(gestionInsumos);
		
		JButton salir = new JButton("Salir");
		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		salir.setBounds(324, 225, 100, 25);
		frame.getContentPane().add(salir);
		
		JButton atras = new JButton("Atrás");
		atras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new App(datos);
				frame.dispose();
			}
		});
		atras.setBounds(10, 226, 100, 25);
		frame.getContentPane().add(atras);
		
		frame.setVisible(true);
	}

}
