package isi.died.tp.dominio;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Planta {
	
	private int id;
	private String nombre;
	ArrayList<Stock> stocks;
	
	public Planta() {
		stocks= new ArrayList<Stock>();
	}
	
	public Planta(int i, String n) {
		this.id=i;
		this.nombre=n;
		stocks= new ArrayList<Stock>();
	}
	
	public double costoTotal() {
		
		return stocks.stream().mapToDouble((s) -> s.getInsumo().getCosto()*s.getCantidad()).sum();
		}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Stock> getStocks() {
		return stocks;
	}

	public void setStocks(ArrayList<Stock> stocks) {
		this.stocks = stocks;
	}
	
	public void agregarStock(Stock stock) {
		this.stocks.add(stock);
	}


	public ArrayList<Insumo> stockEntre(int s1, int s2){
		
		ArrayList<Stock> aux = (ArrayList<Stock>) this.stocks.stream().filter((s)->(s.getCantidad()>s1)).filter((s)->(s.getCantidad()<s2)).collect(Collectors.toList());
		ArrayList<Insumo> aux2= new ArrayList<Insumo>();
		
		for(int i=0;i<aux.size();i++) {
			aux2.add(aux.get(i).getInsumo());
		}
		
		return aux2;
	}
	
	public boolean necesitaInsumo(Insumo insumo) {
		
		Stock stock=new Stock();
		
		for(int i=0; i<stocks.size(); i++) {
			if (stocks.get(i).getInsumo()==insumo)
				stock = stocks.get(i);
		}
			
		if (stock.getCantidad()<stock.getPuntoPedido())
			return true;
		return false; 
	}

}
