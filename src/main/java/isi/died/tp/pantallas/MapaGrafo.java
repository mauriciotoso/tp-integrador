package isi.died.tp.pantallas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

import isi.died.tp.datos.Listas;
import isi.died.tp.dominio.UnidadMedida;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import java.awt.BorderLayout;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class MapaGrafo extends JFrame {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MapaGrafo() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1200, 650);
		setLocationRelativeTo(this);
		
		JPanel back= new JPanel();
		back.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		back.setBounds(0, 0, 900, 500);
		back.setBackground(Color.LIGHT_GRAY);
		
		for(int a=0;a<10;a++) {
			JPanel panel= new JPanel();
			panel.setBackground(new Color(a*10,a*5,a*10));
			panel.setSize(50,50);
			panel.setName("Panel : "+(a+1));
			back.add(panel);
		}
		
		Movement mv= new Movement(back.getComponents());
		getContentPane().setLayout(null);
		
		getContentPane().add(back);
		back.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(910, 106, 264, 30);
		comboBox.setModel(new DefaultComboBoxModel((new Listas()).listaInsumosString()));
		getContentPane().add(comboBox);
		
		JLabel lblSeleccioneElInsumo = new JLabel("Seleccione el insumo para:");
		lblSeleccioneElInsumo.setBounds(910, 11, 186, 14);
		getContentPane().add(lblSeleccioneElInsumo);
		
		JLabel lblPlantasQue = new JLabel("- Plantas que necesiten ese insumo.");
		lblPlantasQue.setBounds(910, 36, 186, 14);
		getContentPane().add(lblPlantasQue);
		
		JLabel lblElMejor = new JLabel("- El mejor camino para ir desde el acopio puerto");
		lblElMejor.setHorizontalAlignment(SwingConstants.LEFT);
		lblElMejor.setToolTipText("");
		lblElMejor.setBounds(910, 61, 264, 14);
		getContentPane().add(lblElMejor);
		
		JLabel lblHastaElAcopio = new JLabel("hasta el acopio final pasando por todas esas plantas.");
		lblHastaElAcopio.setToolTipText("");
		lblHastaElAcopio.setHorizontalAlignment(SwingConstants.LEFT);
		lblHastaElAcopio.setBounds(910, 81, 264, 14);
		getContentPane().add(lblHastaElAcopio);
		
		setVisible(true);
	}
	
	/*public void paint(Graphics g) {
		Graphics g2D =(Graphics2D) g;
		
		repaint(g2D, 10,10,200,200);
	}
	
	public void repaint(Graphics g,int xi, int yi, int xf, int yf) {	
		g.drawLine(xi,yi,xf,yf);
	}
	*/
	public static void main (String[] args){
		new MapaGrafo();
	}
}
