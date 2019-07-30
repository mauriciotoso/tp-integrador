package isi.died.tp.ejemplo2;

import javax.swing.JApplet;


public class Principal extends JApplet {
 
 public void init(){
  lienzo l=new lienzo(this);
  l.setBounds(0, 0, 400, 400);
  add(l);
 }
}