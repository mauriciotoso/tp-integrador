package isi.died.tp.ejemplo3;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Vector;

import javax.swing.*;

public class PanelDibujo extends JPanel {
 
 int x=150;
 int y=150;
 int ancho=30;
 int alto=30;
 public Vector<Integer> xvs;
 public Vector<Integer> yvs;
 public Vector<Grafo> vgrafos;
 int indice=0;
 
 public PanelDibujo(){
  vgrafos=new Vector();
  xvs=new Vector<Integer>();
  yvs=new Vector<Integer>();
  setDoubleBuffered(true);
 }
 
 public void paintComponent(Graphics grafico){
  super.paintComponents(grafico);
  Graphics2D g=(Graphics2D)grafico;
  if(vgrafos.size()!=0){
   g.setColor(Color.WHITE);
   g.fillRect(0, 0, getWidth(), getHeight());
   g.setColor(Color.BLACK);
   int radio = 100;
   float angulo = 360/10;
   angulo = (float) Math.toRadians(angulo);
   for(int i=indice;i<vgrafos.size();i++){
    int xv=(int)(x+radio*Math.cos(i * angulo));
    int yv=(int) (y- radio * Math.sin(i * angulo));
    xvs.add(xv);
    yvs.add(yv);
    indice++;
   }
  }
  for(int i=0;i<vgrafos.size();i++){
   for(int j=0;j<vgrafos.size();j++){
    g.setStroke(new BasicStroke(2));
    g.setColor(Color.BLACK);
    g.drawLine(xvs.get(i)+15,yvs.get(i)+15,xvs.get(j)+15,yvs.get(j)+15);
    g.setColor(Color.WHITE);
    g.fillOval(xvs.get(i), yvs.get(i), ancho, alto);
    g.setColor(Color.BLACK);
    g.drawOval(xvs.get(i),yvs.get(i), ancho, alto);
    g.drawString(""+vgrafos.get(i).obtenerDato(), xvs.get(i)+((ancho/2)-3), yvs.get(i)+((alto/2)+3));
    g.setColor(Color.WHITE);
    g.fillOval(xvs.get(j), yvs.get(j), ancho, alto);
    g.setColor(Color.BLACK);
    g.drawOval(xvs.get(j),yvs.get(j), ancho, alto);
    g.drawString(""+vgrafos.get(j).obtenerDato(), xvs.get(j)+((ancho/2)-3), yvs.get(j)+((alto/2)+3));
   }
  }
 }
 public Vector<Grafo> getVgrafos() {
  return vgrafos;
 }
 public void setVgrafos(Vector<Grafo> vgrafos) {
  this.vgrafos = vgrafos;
 }
}