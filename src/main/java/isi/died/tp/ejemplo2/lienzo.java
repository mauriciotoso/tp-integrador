package isi.died.tp.ejemplo2;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class lienzo extends JPanel implements MouseListener,MouseMotionListener{

    int x=0,y=0;
    linea linea;
    circulo circulo;
    circulo jalada=null;
    List<circulo> ListCirculo = new ArrayList<circulo>();
    List<linea> ListArista = new ArrayList<linea>();
    Principal p;

    public lienzo(Principal prin) {
     p=prin;
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.setVisible(true);
        this.setDoubleBuffered(true);
    }

    public void anadirCirculo(int x, int y){
        circulo = new circulo(ListCirculo.size(),x,y);
        ListCirculo.add(circulo);
        repaint();
        p.repaint();
    }

    public void anadirLinea( int x, int y){
        try{
            linea = new linea (ListCirculo.get(x),ListCirculo.get(y));
            this.ListArista.add(linea);
            repaint();
            p.repaint();
        }catch(IndexOutOfBoundsException e){
            JOptionPane.showMessageDialog(null, "No se encontro circulo");
        }
    }

    @Override
    public void paintComponent(Graphics g){
     super.paintComponents(g);
      for (linea f:ListArista)
      {
       f.painter(g);
      }

      for (circulo f:ListCirculo)
      {
       f.painter(g,this);
      }

    }

    public void mouseClicked(MouseEvent e) {
        try{
         if(e.getButton()==1){
             int ini = Integer.parseInt(JOptionPane.showInputDialog("Numero de circulo inicial"));
             int fin = Integer.parseInt(JOptionPane.showInputDialog("Numero de circulo final"));
             anadirLinea(ini, fin);
        	 
         }else
         {
             if(e.getButton()==3)
             {
            	 x = e.getX();
                 y = e.getY();
                 anadirCirculo(x,y);
             }
         }
        }catch(Exception ex){
            
        }
    }

    public void mousePressed(MouseEvent e) {}

    public void mouseReleased(MouseEvent e) {}

    public void mouseEntered(MouseEvent e) {}

    public void mouseExited(MouseEvent e) {}

    public void mouseDragged(MouseEvent e) {
       if(jalada==null)
        {
           for (circulo f:ListCirculo)
           {
             if(f.jaladopor(e.getPoint()))
               {
                 jalada=f;
               }
             x=e.getPoint().x;
             y=e.getPoint().y;
             repaint();
             p.repaint();
            }
       }
       else{
           jalada.transladar(e.getPoint().x-x,e.getPoint().y-y);
           x=e.getPoint().x;
           y=e.getPoint().y;
           repaint();
           p.repaint();
           }
    }

    public void mouseMoved(MouseEvent e){
        jalada=null;
    }

}
