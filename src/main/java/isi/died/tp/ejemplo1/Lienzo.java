package isi.died.tp.ejemplo1;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Lienzo extends JPanel implements MouseListener, MouseMotionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ArrayList<Nodo> listaNodos;
	private ArrayList<Enlace> listaEnlaces;
	private Nodo nodo1, nodo2,nodoaux;
	private Nodo nodoMover;
	private int iNodo;
	private int contIdNodo=0;
	private int contIdEnlace=0;
	private ArrayList<Integer> enlacesMover;
	
	public Lienzo() {
		this.listaNodos = new ArrayList<>();
		this.listaEnlaces = new ArrayList<>();
		this.enlacesMover= new ArrayList<>();
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		for(Nodo nodos: listaNodos) {
			nodos.pintar(g);
		}
		for(Enlace enlace:listaEnlaces) {
			enlace.pintar(g);
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getButton()==MouseEvent.BUTTON1) {
			String nombre = JOptionPane.showInputDialog("Ingrese nombre nodo: ");
			this.listaNodos.add(new Nodo(e.getX(),e.getY(),nombre,contIdNodo));
			contIdNodo++;
			repaint();
		}
		if(e.getButton()==MouseEvent.BUTTON3) {
			for(Nodo nodo:listaNodos) {
				if(new Rectangle(nodo.getX() - Nodo.d/2, nodo.getY() - Nodo.d/2,Nodo.d,Nodo.d).contains(e.getPoint())) {
					if(nodo1==null) {
						nodo1=nodo;
					}
					else {
						String nombre = JOptionPane.showInputDialog("Ingrese nombre enlace: ");
						nodo2=nodo;
						this.listaEnlaces.add(new Enlace(nodo1,nodo2,nombre,contIdEnlace));
						contIdEnlace++;
						repaint();
						nodo1=null;
						nodo2=null;
					}
				}
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		int iN=0;
		for(Nodo nodo: listaNodos) {
			if(new Rectangle(nodo.getX()-Nodo.d/2, nodo.getY()-Nodo.d/2,Nodo.d,Nodo.d).contains(e.getPoint())) {
				nodoMover=nodo;
				iNodo=iN;
				
				int iE2=0;
				for(Enlace enlace: listaEnlaces) {
					if(new Rectangle(enlace.getX1()-Nodo.d/2,enlace.getY1()-Nodo.d/2,Nodo.d,Nodo.d).contains(e.getPoint())) {
						if(!enlacesMover.contains(this.listaEnlaces.get(iE2).getId())) enlacesMover.add(this.listaEnlaces.get(iE2).getId());
					}
					else if(new Rectangle(enlace.getX2()-Nodo.d/2,enlace.getY2()-Nodo.d/2,Nodo.d,Nodo.d).contains(e.getPoint())) {
						if(!enlacesMover.contains(this.listaEnlaces.get(iE2).getId())) enlacesMover.add(this.listaEnlaces.get(iE2).getId());
					}
					iE2++;
				}
				
				break;
			}
			iN++;
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		nodoMover=null;
		enlacesMover=new ArrayList<>();
		iNodo=-1;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if(nodoMover!=null) {
			nodoaux=new Nodo(e.getX(),e.getY(),nodoMover.getNombre(),nodoMover.getId());
			this.listaNodos.set(iNodo,nodoaux);
			int iE=0;
			for(Enlace enlace: listaEnlaces) {
				if(new Rectangle(enlace.getX1()-Nodo.d/2,enlace.getY1()-Nodo.d/2,Nodo.d,Nodo.d).contains(e.getPoint())&&enlacesMover.contains(enlace.getId())) {
					this.listaEnlaces.set(iE, new Enlace(nodoaux, enlace.getNodo2(), enlace.getNombre(),enlace.getId()));
				}
				else if(new Rectangle(enlace.getX2()-Nodo.d/2,enlace.getY2()-Nodo.d/2,Nodo.d,Nodo.d).contains(e.getPoint())&&enlacesMover.contains(enlace.getId())) {
					this.listaEnlaces.set(iE, new Enlace(enlace.getNodo1(),nodoaux, enlace.getNombre(),enlace.getId()));
				}
				iE++;
			}
		}
		repaint();
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	

}
