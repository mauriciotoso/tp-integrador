package isi.died.tp.pantallas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GestionInsumos {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionInsumos window = new GestionInsumos();
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
	public GestionInsumos() {
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setSize(450, 300);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnCrearInsumo = new JButton("Crear Insumo");
		btnCrearInsumo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearInsumo cInsumo = new CrearInsumo();
				cInsumo.main(null);
				frame.dispose();
			}
		});
		btnCrearInsumo.setBounds(143, 68, 140, 40);
		frame.getContentPane().add(btnCrearInsumo);
		
		JButton btnBucarInsumo = new JButton("Buscar Insumo");
		btnBucarInsumo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BuscarInsumos bInsumo=new BuscarInsumos();
				bInsumo.main(null);
				frame.dispose();
			}
		});
		
		btnBucarInsumo.setBounds(143, 132, 140, 40);
		frame.getContentPane().add(btnBucarInsumo);
		
		JButton btnNewButton = new JButton("Atrás");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Principal principal =new Principal();
				principal.main(null);
				frame.dispose();
			
			}
		});
		btnNewButton.setBounds(10, 227, 100, 25);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Salir");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_1.setBounds(324, 227, 100, 25);
		frame.getContentPane().add(btnNewButton_1);
	}

}
