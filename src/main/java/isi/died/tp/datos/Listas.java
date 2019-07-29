package isi.died.tp.datos;

import java.util.ArrayList;

import isi.died.tp.dominio.*;

public class Listas {
	private ArrayList<Insumo> listaInsumos;
	private ArrayList<Planta> listaPlantas;
	private ArrayList<Camion> listaCamiones;
	private ArrayList<Stock> listaStocks;
	
	public Listas() {
		listaInsumos = new ArrayList<Insumo>();
		listaPlantas = new ArrayList<Planta>();
		listaCamiones = new ArrayList<Camion>();
		listaStocks = new ArrayList<Stock>();
		
		Insumo i1=new Insumo(0,"I1","Planta A",500,5.6,5000,false,UnidadMedida.UNIDAD);
		Insumo i2=new Insumo(1,"I2","Planta A",600,2.4,6000,false,UnidadMedida.UNIDAD);
		Insumo i3=new Insumo(2,"I3","Planta B",1100,2,5000,false,UnidadMedida.UNIDAD);
		Insumo i4=new Insumo(3,"I4","Planta B",200,1,100,false,UnidadMedida.UNIDAD);
		Insumo i5=new Insumo(4,"I5","Planta C",100,5.6,200,false,UnidadMedida.UNIDAD);
		Insumo i6=new Insumo(5,"I6","Planta D",600,2.4,40,false,UnidadMedida.UNIDAD);
		Insumo i7=new Insumo(6,"I1","Planta E",6100,2,5400,false,UnidadMedida.UNIDAD);
		Insumo i8=new Insumo(7,"I7","Planta E",700,1,700,false,UnidadMedida.UNIDAD);
		Insumo i9=new Insumo(8,"I8","Planta A",500,5.6,1000,false,UnidadMedida.UNIDAD);
		Insumo i10=new Insumo(9,"I2","Planta C",600,2.4,2000,false,UnidadMedida.UNIDAD);
		Insumo i11=new Insumo(10,"I9","Planta C",700,2,700,false,UnidadMedida.UNIDAD);
		Insumo i12=new Insumo(11,"I10","Planta F",300,1,300,false,UnidadMedida.UNIDAD);
		
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
	
	
}
