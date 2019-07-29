package isi.died.tp.pantallas;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Movement implements MouseListener,MouseMotionListener{

	int x,y;
	int xaux,yaux;
	
	public Movement(Component[] components, int x,int y) {
		
		xaux=x;
		yaux=y;
		for(Component panel:components) {
			panel.addMouseListener(this);
			panel.addMouseMotionListener(this);
		}
	}
	
	public void paint(Graphics g) {
		Graphics g2D =(Graphics2D) g;
		
		repaint(g2D, 10,10,200,200);	
	}
	
	public void repaint(Graphics g,int xi, int yi, int xf, int yf) {	
		g.drawLine(xi,yi,xf,yf);
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		e.getComponent().setLocation(e.getX()+e.getComponent().getX()-x,e.getY()+e.getComponent().getY()-y);	
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
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
		x=e.getX();
		y=e.getY();
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
