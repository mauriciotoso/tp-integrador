package isi.died.tp.ejemplo1;

import java.awt.Graphics;

public class Enlace {
	
	private int x1,y1,x2,y2;
	private Nodo nodo1, nodo2;
	private String nombre;
	private int id;
	
	public Enlace(Nodo nodo1,Nodo nodo2,String nombre,int id) {
		this.x1=nodo1.getX();
		this.y1=nodo1.getY();
		this.x2=nodo2.getX();
		this.y2=nodo2.getY();
		this.nodo1=nodo1;
		this.nodo2=nodo2;
		this.nombre=nombre;
		this.id=id;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void pintar(Graphics g){
		g.drawLine(x1,y1,x2,y2);
		
		if(x1>x2 && y1>y2) g.drawString(nombre, x1-Math.abs((x1-x2)/2), y1- Math.abs((y1-y2)/2));

		if(x1<x2 && y1<y2) g.drawString(nombre, x2-Math.abs((x1-x2)/2), y2- Math.abs((y1-y2)/2));

		if(x1>x2 && y1<y2) g.drawString(nombre, x1-Math.abs((x1-x2)/2), y2- Math.abs((y1-y2)/2));

		if(x1<x2 && y1>y2) g.drawString(nombre, x2-Math.abs((x1-x2)/2), y1- Math.abs((y1-y2)/2));
	}

	public int getX1() {
		return x1;
	}

	public void setX1(int x1) {
		this.x1 = x1;
	}

	public int getY1() {
		return y1;
	}

	public void setY1(int y1) {
		this.y1 = y1;
	}

	public int getX2() {
		return x2;
	}

	public void setX2(int x2) {
		this.x2 = x2;
	}

	public int getY2() {
		return y2;
	}

	public void setY2(int y2) {
		this.y2 = y2;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Nodo getNodo1() {
		return nodo1;
	}

	public void setNodo1(Nodo nodo1) {
		this.nodo1 = nodo1;
	}

	public Nodo getNodo2() {
		return nodo2;
	}

	public void setNodo2(Nodo nodo2) {
		this.nodo2 = nodo2;
	}
	
	

}
