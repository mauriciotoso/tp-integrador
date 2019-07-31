package isi.died.tp.grafo;

import java.awt.Graphics;

public class VerticeView {
	private int x,y;
	private int id;
	private String nombre;
	public static final int d=20;
	
	public VerticeView(int x,int y,String nombre,int id) {
		this.id=id;
		this.x=x;
		this.y=y;
		this.nombre=nombre;
	}

	public void pintar(Graphics g) {
		g.drawOval(this.x -d/2,this.y-d/2,d,d);
		g.drawString(nombre,x,y);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public static int getD() {
		return d;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
