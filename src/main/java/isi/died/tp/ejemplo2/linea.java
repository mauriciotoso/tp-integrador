package isi.died.tp.ejemplo2;


import java.awt.Color;
import java.awt.Graphics;

public class linea{

    circulo inicial;
    circulo ffinal;
    Color color= Color.BLACK;

    public linea(circulo inicial, circulo ffinal) {
        this.inicial=inicial;
        this.ffinal=ffinal;
    }

    public void painter(Graphics g) {
        g.setColor(Color.BLUE);
        g.setColor(color);
        g.drawLine(inicial.getX(), inicial.getY(), ffinal.getX(), ffinal.getY());
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public circulo getFfinal() {
        return ffinal;
    }

    public circulo getInicial() {
        return inicial;
    }
    
}
