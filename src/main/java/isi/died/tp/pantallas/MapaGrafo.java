package isi.died.tp.pantallas;

import java.awt.Color;

import isi.died.tp.grafo.*;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import isi.died.tp.datos.Listas;
import isi.died.tp.dominio.UnidadMedida;
import isi.died.tp.ejemplo1.Lienzo;

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


public class MapaGrafo {	
	
	private JPanel lienzo;
	
	public static void main (String[] args){
		new MapaGrafo();
	}
	
	public MapaGrafo() {
		
		lienzo=new Lienzo();
		lienzo.setBackground(Color.LIGHT_GRAY);
		lienzo.setForeground(Color.BLACK);
		lienzo.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		lienzo.setLocation(0, 0);
		lienzo.setSize(900,500);
		
		JFrame ventana = new JFrame("GRAFO");
		ventana.getContentPane().setLayout(null);
		ventana.getContentPane().add(lienzo);
		lienzo.setLayout(null);
		ventana.setSize(1200,600);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setVisible(true);
		ventana.setLocationRelativeTo(null);	
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(910, 106, 264, 30);
		comboBox.setModel(new DefaultComboBoxModel((new Listas()).listaInsumosString()));
		ventana.getContentPane().add(comboBox);
		
		JLabel lblSeleccioneElInsumo = new JLabel("Seleccione el insumo para:");
		lblSeleccioneElInsumo.setBounds(910, 11, 186, 14);
		ventana.getContentPane().add(lblSeleccioneElInsumo);
		
		JLabel lblPlantasQue = new JLabel("- Plantas que necesiten ese insumo.");
		lblPlantasQue.setBounds(910, 36, 186, 14);
		ventana.getContentPane().add(lblPlantasQue);
		
		JLabel lblElMejor = new JLabel("- El mejor camino para ir desde el acopio puerto");
		lblElMejor.setHorizontalAlignment(SwingConstants.LEFT);
		lblElMejor.setToolTipText("");
		lblElMejor.setBounds(910, 61, 264, 14);
		ventana.getContentPane().add(lblElMejor);
		
		JLabel lblHastaElAcopio = new JLabel("hasta el acopio final pasando por todas esas plantas.");
		lblHastaElAcopio.setToolTipText("");
		lblHastaElAcopio.setHorizontalAlignment(SwingConstants.LEFT);
		lblHastaElAcopio.setBounds(910, 81, 264, 14);
		ventana.getContentPane().add(lblHastaElAcopio);
	
		/*
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1200, 650);
		
		lienzo = new Lienzo();
		//getContentPane().setLayout(null);
		
		getContentPane().add(lienzo);
		
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
		*/
	}
}
