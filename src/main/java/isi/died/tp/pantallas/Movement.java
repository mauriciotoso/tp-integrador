package isi.died.tp.pantallas;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class Movement extends JPanel implements MouseListener,MouseMotionListener {

	int x,y;
	
	public Movement() {
		
		setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		setBounds(0, 0, 900, 500);
		setBackground(Color.LIGHT_GRAY);
		
		for(int a=0;a<10;a++) {
			JPanel panel= new JPanel();
			panel.setBackground(new Color(a*10,a*5,a*10));
			panel.setSize(50,50);
			panel.setName("Panel : "+(a+1));
			this.add(panel);
		}
		
		for(Component panel:this.getComponents()) {
			panel.addMouseListener(this);
			panel.addMouseMotionListener(this);
		}
		
	}
	
	public void paint(Graphics g) {
		g.drawLine(0,0,200,200);	
	}
	
	/*public void repaint(Graphics g,int xi, int yi, int xf, int yf) {	
		g.drawLine(xi,yi,xf,yf);
	}
	*/
	@Override
	public void mouseDragged(MouseEvent e) {
		e.getComponent().setLocation(e.getX()+e.getComponent().getX()-x,e.getY()+e.getComponent().getY()-y);
		repaint();
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
