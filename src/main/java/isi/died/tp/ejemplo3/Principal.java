package isi.died.tp.ejemplo3;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.*;

public class Principal extends JApplet{
 
 PanelDibujo pd;
 int max=0;
 JTextField valor;
 
 public void init(){
  
  pd=new PanelDibujo();
  add(pd);
  
  JPanel pdatos=new JPanel();
  
  JButton agregar=new JButton("Agregar Nodo");
  agregar.addActionListener(new ActionListener(){

   @Override
   public void actionPerformed(ActionEvent e) {
    if(max<10){
     try{
      Grafo gf=new Grafo(""+Integer.parseInt(valor.getText()));
      pd.getVgrafos().add(gf);
      pd.repaint();
      repaint();
      max++;
     }catch(NumberFormatException ne){
      JOptionPane.showMessageDialog(null, "Digite un numero valido");
     }
    } 
   }
  });
  
  valor=new JTextField(5);
  pdatos.add(new JLabel("Valor Vertice" +
    ""));
  pdatos.add(valor);
  pdatos.add(agregar);
  add(pdatos,BorderLayout.SOUTH);
  
 }
 
}