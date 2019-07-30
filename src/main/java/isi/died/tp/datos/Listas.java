package isi.died.tp.datos;

import java.util.ArrayList;

import isi.died.tp.dominio.*;
import isi.died.tp.estructuras.GrafoPlanta;

public class Listas {
	private ArrayList<Insumo> listaInsumos;
	private ArrayList<Planta> listaPlantas;
	private ArrayList<Camion> listaCamiones;
	private ArrayList<Stock> listaStocks;
	private ArrayList<Ruta> listaRutas;
	private GrafoPlanta grafo;
	
	public Listas() {
		listaInsumos = new ArrayList<Insumo>();
		listaPlantas = new ArrayList<Planta>();
		listaCamiones = new ArrayList<Camion>();
		listaStocks = new ArrayList<Stock>();
		listaRutas = new ArrayList<Ruta>();
		grafo = new GrafoPlanta();
		
		Insumo i1=new Insumo("0","I1a",500,5.6,5000,false,UnidadMedida.UNIDAD);
		Insumo i2=new Insumo("1","I2a",600,2.4,6000,false,UnidadMedida.UNIDAD);
		Insumo i3=new Insumo("2","I3",1100,2,5000,false,UnidadMedida.UNIDAD);
		Insumo i4=new Insumo("3","I4",200,1,100,false,UnidadMedida.UNIDAD);
		Insumo i5=new Insumo("4","I5",100,5.6,200,false,UnidadMedida.UNIDAD);
		Insumo i6=new Insumo("5","I6",600,2.4,40,false,UnidadMedida.UNIDAD);
		Insumo i7=new Insumo("6","I1b",6100,2,5400,false,UnidadMedida.UNIDAD);
		Insumo i8=new Insumo("7","I7",700,1,700,false,UnidadMedida.UNIDAD);
		Insumo i9=new Insumo("8","I8",500,5.6,1000,false,UnidadMedida.UNIDAD);
		Insumo i10=new Insumo("9","I2b",600,2.4,2000,false,UnidadMedida.UNIDAD);
		Insumo i11=new Insumo("10","I9",700,2,700,false,UnidadMedida.UNIDAD);
		Insumo i12=new Insumo("11","I10",300,1,300,false,UnidadMedida.UNIDAD);
		
		listaInsumos.add(i1);
		listaInsumos.add(i2);
		listaInsumos.add(i3);
		listaInsumos.add(i4);
		listaInsumos.add(i5);
		listaInsumos.add(i6);
		listaInsumos.add(i7);
		listaInsumos.add(i8);
		listaInsumos.add(i9);
		listaInsumos.add(i10);
		listaInsumos.add(i11);
		listaInsumos.add(i12);
		
		Planta acopioPuerto= new Planta(0,"Acopio Puerto");
		Planta acopioFinal= new Planta(1,"Acopio Final");
		Planta p1= new Planta(1,"Planta A");
		Planta p2= new Planta(2,"Planta B");
		Planta p3= new Planta(3,"Planta C");
		
		listaPlantas.add(acopioPuerto);
		listaPlantas.add(acopioFinal);
		
		Stock s1 = new Stock(0,200,100,i1);
		Stock s2 = new Stock(1,100,500,i2);
		Stock s3 = new Stock(2,600,500,i4);
		
		p1.agregarStock(s1);
		p2.agregarStock(s2);
		p2.agregarStock(s3);
		
		listaStocks.add(s1);
		listaStocks.add(s2);
		listaStocks.add(s3);
		
		Ruta r1= new Ruta(0,10,60,40,acopioPuerto,acopioFinal);
		Ruta r2= new Ruta(1,5,20,20,acopioPuerto,p1);
		Ruta r3= new Ruta(2,6,22,20,acopioPuerto,p2);
		Ruta r4= new Ruta(3,14,180,40,p3,acopioFinal);
		Ruta r5= new Ruta(4,20,170,60,p2,acopioFinal);
		Ruta r6= new Ruta(5,10,180,40,p1,p3);
		Ruta r7= new Ruta(6,22,170,60,p1,p2);
		
		listaRutas.add(r1);
		listaRutas.add(r2);
		listaRutas.add(r3);
		listaRutas.add(r4);
		listaRutas.add(r5);
		listaRutas.add(r6);
		listaRutas.add(r7);
		
		grafo.addNodo(acopioPuerto);
		grafo.addNodo(acopioFinal);
		grafo.addNodo(p1);
		grafo.addNodo(p2);
		grafo.addNodo(p3);
		
		grafo.conectar(acopioPuerto, acopioFinal, 0);
		grafo.conectar(acopioPuerto, p1, 1);
		grafo.conectar(acopioPuerto, p2, 2);
		grafo.conectar(p3, acopioFinal, 3);
		grafo.conectar(p2, acopioFinal, 4);
		grafo.conectar(p1, p3, 5);
		grafo.conectar(p1, p2, 6);
	}

	public ArrayList<Insumo> getListaInsumos() {
		return listaInsumos;
	}

	public void setListaInsumos(ArrayList<Insumo> listaInsumos) {
		this.listaInsumos = listaInsumos;
	}

	public ArrayList<Planta> getListaPlantas() {
		return listaPlantas;
	}

	public void setListaPlantas(ArrayList<Planta> listaPlantas) {
		this.listaPlantas = listaPlantas;
	}

	public ArrayList<Camion> getListaCamiones() {
		return listaCamiones;
	}

	public void setListaCamiones(ArrayList<Camion> listaCamiones) {
		this.listaCamiones = listaCamiones;
	}

	public ArrayList<Stock> getListaStocks() {
		return listaStocks;
	}

	public void setListaStocks(ArrayList<Stock> listaStocks) {
		this.listaStocks = listaStocks;
	}
	
	public Object[][] getBusquedaInsumos() {
		Object [][] aux = new Object[this.listaInsumos.size()][3]; 
		
		for(int i=0; i<this.listaInsumos.size(); i++) {
			aux[i][0]= listaInsumos.get(i).getDescripcion();
			aux[i][1]= listaInsumos.get(i).getCosto();
			aux[i][2]= listaInsumos.get(i).getStock();
		}
		
		return aux;
	}
	
	public Object[] listaInsumosString() {
		Object [] aux = new Object[this.listaInsumos.size()]; 
		
		for(int i=0; i<this.listaInsumos.size(); i++) {
			aux[i]=listaInsumos.get(i).getDescripcion();
		}
		
		return aux;
	}
	
	public Insumo buscarInsumo(String nombre, double costo, int stock) {
		for(Insumo in:listaInsumos) {
			if(in.getDescripcion().compareTo(nombre)==0 && in.getCosto()==costo && in.getStock()==stock) return in;
		}
		return null;
	}
	
	
}
