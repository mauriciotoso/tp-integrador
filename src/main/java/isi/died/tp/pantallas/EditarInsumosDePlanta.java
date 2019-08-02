
//El botón editar stocks está comentado ya que no está la pantalla para editar dichos stocks por el momento

package isi.died.tp.pantallas;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import isi.died.tp.datos.Datos;
import isi.died.tp.dominio.Planta;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditarInsumosDePlanta {

	private JFrame frame;
	private JTable table;
	private JButton btnAgregarStockA;
	private JButton btnAtrs;
	private static Planta planta;
	private Datos datos;

	public EditarInsumosDePlanta(Planta pl, Datos datos) {
		this.datos=datos;
		planta=pl;
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setTitle("Editar Insumos");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 21, 394, 154);
		frame.getContentPane().add(scrollPane);
		
		Object[][] datosStocks= planta.getDatosStock();
		String[] columnas= {"Insumo","Cantidad","Cantidad Mínima"};
		
		table = new JTable(datosStocks, columnas);
		table.editingCanceled(null);
		scrollPane.setViewportView(table);
		
		btnAgregarStockA = new JButton("Agregar stock a planta");
		btnAgregarStockA.setBounds(20, 186, 180, 25);
		frame.getContentPane().add(btnAgregarStockA);
		btnAgregarStockA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AgregarStockPlanta(planta,datos);
				frame.dispose();
			}
		});

		btnAtrs = new JButton("Atrás");
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new EditarPlanta(planta,datos);
				frame.dispose();
			}
		});
		btnAtrs.setBounds(10, 225, 100, 25);
		frame.getContentPane().add(btnAtrs);
		
		frame.setVisible(true);
	}
}
