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

public class MapaGrafo extends JFrame {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MapaGrafo() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1000, 1000);
		setLocationRelativeTo(this);
		
		JPanel back= new JPanel();
		back.setBounds(0, 0, 700, 500);
		back.setBackground(Color.WHITE);
		
		for(int a=0;a<10;a++) {
			JPanel panel= new JPanel();
			panel.setBackground(new Color(a*10,a*5,a*10));
			panel.setSize(50,50);
			panel.setName("Panel : "+(a+1));
			back.add(panel);
		}
		
		Movement mv= new Movement(back.getComponents(),10,10);
		getContentPane().setLayout(null);
		
		getContentPane().add(back);
		back.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(710, 11, 264, 30);
		comboBox.setModel(new DefaultComboBoxModel((new Listas()).listaInsumosString()));
		getContentPane().add(comboBox);
		
		
		setVisible(true);
	}
	
	public void paint(Graphics g) {
		Graphics g2D =(Graphics2D) g;
		
		repaint(g2D, 10,10,200,200);
	}
	
	public void repaint(Graphics g,int xi, int yi, int xf, int yf) {	
		g.drawLine(xi,yi,xf,yf);
	}
	
	public static void main (String[] args){
		new MapaGrafo();
	}
}
