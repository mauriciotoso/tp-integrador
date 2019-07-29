package isi.died.tp.pantallas;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import isi.died.tp.datos.Listas;
import isi.died.tp.dominio.Insumo;
import isi.died.tp.estructuras.ArbolBinarioBusqueda;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class BuscarInsumos {

	private JFrame frame;
	private JTextField tfDescripcion;
	private JTextField tfCostoMin;
	private JTextField tfCostoMax;
    private JTextField tfStockMax;
    private JTable busqueda;
    private ListSelectionModel model;
	
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

	private void initialize() {
		frame = new JFrame();		
		frame.setSize(600,350);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton borrar = new JButton("Borrar");
		borrar.setBounds(447, 276, 109, 23);
		frame.getContentPane().add(borrar);
		borrar.setEnabled(false);
		
		JButton Atrás = new JButton("Atrás");
		Atrás.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestionInsumos gInsumos = new GestionInsumos();
				gInsumos.main(null);
				frame.dispose();
			}
		});
		Atrás.setBounds(10, 275, 100, 25);
		frame.getContentPane().add(Atrás);
		
		JLabel lblIngreseLosDatos = new JLabel("Ingrese los datos del insumo:");
		lblIngreseLosDatos.setBounds(10, 11, 200, 14);
		frame.getContentPane().add(lblIngreseLosDatos);
		
		JLabel descripcion = new JLabel("Descripción: ");
		descripcion.setHorizontalAlignment(SwingConstants.RIGHT);
		descripcion.setBounds(-59, 39, 200, 14);
		frame.getContentPane().add(descripcion);
		
		tfDescripcion = new JTextField();
		tfDescripcion.setColumns(10);
		tfDescripcion.setBounds(151, 36, 130, 20);
		frame.getContentPane().add(tfDescripcion);
		
		JLabel costoMax = new JLabel("Costo maximo: ");
		costoMax.setHorizontalAlignment(SwingConstants.RIGHT);
		costoMax.setBounds(-59, 101, 200, 14);
		frame.getContentPane().add(costoMax);
		
		tfCostoMin = new JTextField();
		tfCostoMin.setColumns(10);
		tfCostoMin.setBounds(151, 67, 130, 20);
		frame.getContentPane().add(tfCostoMin);
		
		JLabel stockMin = new JLabel("Stock mínimo: ");
		stockMin.setHorizontalAlignment(SwingConstants.RIGHT);
		stockMin.setBounds(-13, 132, 154, 20);
		frame.getContentPane().add(stockMin);
		
		tfCostoMax = new JTextField();
		tfCostoMax.setColumns(10);
		tfCostoMax.setBounds(151, 98, 130, 20);
		frame.getContentPane().add(tfCostoMax);
	
		JLabel stockMax = new JLabel("Stock máximo: ");
		stockMax.setHorizontalAlignment(SwingConstants.RIGHT);
		stockMax.setBounds(-59, 163, 200, 14);
		frame.getContentPane().add(stockMax);
		
		JTextField tfStockMin = new JTextField();
		tfStockMin.setColumns(10);
		tfStockMin.setBounds(151, 129, 130, 20);
		frame.getContentPane().add(tfStockMin);
		
		JLabel costoMin = new JLabel("Costo mínimo: ");
		costoMin.setHorizontalAlignment(SwingConstants.RIGHT);
		costoMin.setBounds(-59, 70, 200, 14);
		frame.getContentPane().add(costoMin);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(331, 38, 225, 200);
		frame.getContentPane().add(scrollPane);
		
		Listas datos = new Listas();
		
		Object[][] datosInsumos= datos.getBusquedaInsumos();
		String[] columnas= {"Nombre","Costo","Stock"};
		
		busqueda = new JTable(datosInsumos,columnas);
		model=busqueda.getSelectionModel();
		busqueda.setAutoCreateRowSorter(true);
		scrollPane.setViewportView(busqueda);
		
		tfStockMax = new JTextField();
		tfStockMax.setColumns(10);
		tfStockMax.setBounds(151, 160, 130, 20);
		frame.getContentPane().add(tfStockMax);
		
		JButton editar = new JButton("Editar");
		editar.setBounds(337, 276, 100, 25);
		frame.getContentPane().add(editar);
		editar.setEnabled(false);		
		
		tfDescripcion.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				editar.setEnabled(false);
				borrar.setEnabled(false);
				
				busqueda= new JTable(actualizarTabla(datosInsumos,tfDescripcion.getText(),tfCostoMin.getText(),tfCostoMax.getText(),tfStockMin.getText(),tfStockMax.getText()),columnas);
				scrollPane.setViewportView(busqueda);
				model=busqueda.getSelectionModel();
				busqueda.setAutoCreateRowSorter(true);
				
				model.addListSelectionListener(new ListSelectionListener() {
					
					public void valueChanged(ListSelectionEvent e) {
						if(!model.isSelectionEmpty()) {
							editar.setEnabled(true);
							borrar.setEnabled(true);
							//System.out.println(model.getMinSelectionIndex());
							//System.out.println("Nombre="+tfDescripcion.getText()+" Costo Min="+tfCostoMin.getText()+" Costo Max="+tfCostoMax.getText()+" Stock Min="+tfStockMin.getText()+" Stock Max="+tfStockMax.getText());
							
						}
					}
				});
			}
		});		
		
		tfCostoMin.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				editar.setEnabled(false);
				borrar.setEnabled(false);
				busqueda= new JTable(actualizarTabla(datosInsumos,tfDescripcion.getText(),tfCostoMin.getText(),tfCostoMax.getText(),tfStockMin.getText(),tfStockMax.getText()),columnas);
				scrollPane.setViewportView(busqueda);
				model=busqueda.getSelectionModel();
				busqueda.setAutoCreateRowSorter(true);
				
				model.addListSelectionListener(new ListSelectionListener() {
					
					public void valueChanged(ListSelectionEvent e) {
						if(!model.isSelectionEmpty()) {
							editar.setEnabled(true);
							borrar.setEnabled(true);
							//System.out.println(model.getMinSelectionIndex());
							//System.out.println("Nombre="+tfDescripcion.getText()+" Costo Min="+tfCostoMin.getText()+" Costo Max="+tfCostoMax.getText()+" Stock Min="+tfStockMin.getText()+" Stock Max="+tfStockMax.getText());
							
						}
					}
				});
			}
		});	
		
		tfCostoMax.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				editar.setEnabled(false);
				borrar.setEnabled(false);
				busqueda= new JTable(actualizarTabla(datosInsumos,tfDescripcion.getText(),tfCostoMin.getText(),tfCostoMax.getText(),tfStockMin.getText(),tfStockMax.getText()),columnas);
				scrollPane.setViewportView(busqueda);
				model=busqueda.getSelectionModel();
				busqueda.setAutoCreateRowSorter(true);
				
				model.addListSelectionListener(new ListSelectionListener() {
					
					public void valueChanged(ListSelectionEvent e) {
						if(!model.isSelectionEmpty()) {
							editar.setEnabled(true);
							borrar.setEnabled(true);
							//System.out.println(model.getMinSelectionIndex());
							//System.out.println("Nombre="+tfDescripcion.getText()+" Costo Min="+tfCostoMin.getText()+" Costo Max="+tfCostoMax.getText()+" Stock Min="+tfStockMin.getText()+" Stock Max="+tfStockMax.getText());
							
						}
					}
				});
			}
		});	
		
		tfStockMin.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				editar.setEnabled(false);
				borrar.setEnabled(false);
				busqueda= new JTable(actualizarTabla(datosInsumos,tfDescripcion.getText(),tfCostoMin.getText(),tfCostoMax.getText(),tfStockMin.getText(),tfStockMax.getText()),columnas);
				scrollPane.setViewportView(busqueda);
				model=busqueda.getSelectionModel();
				busqueda.setAutoCreateRowSorter(true);
				
				model.addListSelectionListener(new ListSelectionListener() {
					
					public void valueChanged(ListSelectionEvent e) {
						if(!model.isSelectionEmpty()) {
							editar.setEnabled(true);
							borrar.setEnabled(true);
						//	System.out.println(model.getMinSelectionIndex());
						//	System.out.println("Nombre="+tfDescripcion.getText()+" Costo Min="+tfCostoMin.getText()+" Costo Max="+tfCostoMax.getText()+" Stock Min="+tfStockMin.getText()+" Stock Max="+tfStockMax.getText());
						}
					}
				});
			}
		});	
		
		tfStockMax.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				editar.setEnabled(false);
				borrar.setEnabled(false);
				
				busqueda= new JTable(actualizarTabla(datosInsumos,tfDescripcion.getText(),tfCostoMin.getText(),tfCostoMax.getText(),tfStockMin.getText(),tfStockMax.getText()),columnas);
				scrollPane.setViewportView(busqueda);
				model=busqueda.getSelectionModel();
				busqueda.setAutoCreateRowSorter(true);
				
				model.addListSelectionListener(new ListSelectionListener() {
					
					public void valueChanged(ListSelectionEvent e) {
						
						if(!model.isSelectionEmpty()) {						
							editar.setEnabled(true);
							borrar.setEnabled(true);
							System.out.println(model.getMinSelectionIndex());
							System.out.println("Nombre="+tfDescripcion.getText()+" Costo Min="+tfCostoMin.getText()+" Costo Max="+tfCostoMax.getText()+" Stock Min="+tfStockMin.getText()+" Stock Max="+tfStockMax.getText());
							
						}
					}
				});
			}
		});	
	
	model.addListSelectionListener(new ListSelectionListener() {
	
			public void valueChanged(ListSelectionEvent e) {
				if(!model.isSelectionEmpty()) {
					editar.setEnabled(true);
					borrar.setEnabled(true);
					
					System.out.println(model.getMinSelectionIndex());
					System.out.println("Nombre="+tfDescripcion.getText()+" Costo Min="+tfCostoMin.getText()+" Costo Max="+tfCostoMax.getText()+" Stock Min="+tfStockMin.getText()+" Stock Max="+tfStockMax.getText());
				}
			}
		});
	}
	
	public Object[][] actualizarTabla(Object[][] datos,String des,String cMin, String cMax, String sMin, String sMax){

		Listas datosAux = new Listas();
		ArbolBinarioBusqueda<Insumo> arbolDatos = new ArbolBinarioBusqueda<Insumo>(datosAux.getListaInsumos().get(0));
		int stockMin;
		int stockMax;
		double costoMin;
		double costoMax;
		
		for(int i=1;i<datos.length;i++){
			arbolDatos.agregar(datosAux.getListaInsumos().get(i));
		}
		
		if(sMin.compareTo("")==0) sMin="0";
		if(sMax.compareTo("")==0) sMax="99999999";
		if(cMin.compareTo("")==0) cMin="0";
		if(cMax.compareTo("")==0) cMax="99999999";

		stockMin=Integer.parseInt(sMin);
		stockMax=Integer.parseInt(sMax);
		costoMin=Double.parseDouble(cMin);
		costoMax=Double.parseDouble(cMax);
		
		System.out.println("1. Stock Minimo: "+stockMin+" Stock Maximo: "+stockMax+" Costo Minimo: "+costoMin+" Costo Maximo: "+ costoMax);
		
		
		ArrayList<Insumo> listaInsumos=arbolDatos.rango(des,stockMin,stockMax,costoMin,costoMax);
		
		datosAux.setListaInsumos(listaInsumos);
		
		/*for(int i=0;i<datosAux.getBusquedaInsumos().length;i++) {
			for()
			System.out.println(datosAux.getBusquedaInsumos()[i]);
		}*/
		
		return datosAux.getBusquedaInsumos();
	}	
}
