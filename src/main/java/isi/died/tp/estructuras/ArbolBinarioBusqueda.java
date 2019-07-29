package isi.died.tp.estructuras;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import isi.died.tp.dominio.Insumo;

public class ArbolBinarioBusqueda<E extends Comparable<E>> extends Arbol<E> {

	protected Arbol<E> izquierdo;
	protected Arbol<E> derecho;
	
	public ArbolBinarioBusqueda(){
		this.valor=null;
		this.izquierdo=new ArbolVacio<E>();
		this.derecho=new ArbolVacio<E>();
	}
	
	public ArbolBinarioBusqueda(E e){
		this.valor=e;
		this.izquierdo=new ArbolVacio<E>();
		this.derecho=new ArbolVacio<E>();
	}
	
	public ArbolBinarioBusqueda(E e,Arbol<E> i,Arbol<E> d){
		this.valor=e;
		this.izquierdo=i;
		this.derecho=d;
	}
	
	@Override
	public String toString() {
		return this.valor +" ( "+ this.izquierdo.toString() +", "+this.derecho.toString()+ ") ";
	}
	
	@Override
	public List<E> preOrden() {
		List<E> lista = new ArrayList<E>();
		lista.add(this.valor);
		lista.addAll(this.izquierdo.preOrden());
		lista.addAll(this.derecho.preOrden());
		return lista;
	}
	@Override
	public List<E> inOrden() {
		List<E> lista = new ArrayList<E>();
		lista.addAll(this.izquierdo.preOrden());
		lista.add(this.valor);
		lista.addAll(this.derecho.preOrden());
		return lista;
	}
	@Override
	public List<E> posOrden() {
		List<E> lista = new ArrayList<E>();
		lista.addAll(this.izquierdo.preOrden());
		lista.addAll(this.derecho.preOrden());
		lista.add(this.valor);
		return lista;

	}
	@Override
	public boolean esVacio() {
		return false;
	}
        
	@Override
	public E valor() {
		return this.valor;
	}
	
	@Override
	public Arbol<E> izquierdo() {
		return this.izquierdo;
	}
	
	@Override
	public Arbol<E> derecho() {
		return this.derecho;
	}


	@Override
	public void agregar(E a) {
		if(this.valor.compareTo(a)<1) {
			if (this.derecho.esVacio()) this.derecho = new ArbolBinarioBusqueda<E>(a);
			else this.derecho.agregar(a);
		}else {
			if (this.izquierdo.esVacio()) this.izquierdo= new ArbolBinarioBusqueda<E>(a);
			else this.izquierdo.agregar(a);
		}
	}
	
	@Override
	public boolean equals(Arbol<E> unArbol) {
		return this.valor.equals(unArbol.valor()) && this.izquierdo.equals(unArbol.izquierdo()) && this.derecho.equals(unArbol.derecho());
	}
	
	
	@Override
	public boolean contiene(E unValor) {
		// TODO 1.a
		if (this.valor.equals(unValor)|| this.izquierdo.contiene(unValor)||this.derecho.contiene(unValor)) return true;
		else return false;
	}

	@Override
	public int profundidad() {
		// TODO 1.b
		if(this.izquierdo.esVacio()&&this.derecho.esVacio()) return 0;
		
		return 1+Math.max(izquierdo.profundidad(),derecho.profundidad());
	}

	@Override
	public int cuentaNodosDeNivel(int nivel) {
		// TODO 1.c
		
		if (nivel==0) return 1;
		
		return this.izquierdo.cuentaNodosDeNivel(nivel-1)+this.derecho.cuentaNodosDeNivel(nivel-1);
	}
	

	@Override
	public boolean esCompleto() {
		// TODO 1.d
		
		if(this.esLleno()) return true;
		
		if(this.izquierdo.esVacio() && !this.derecho.esVacio()) return false;
		
		if(!this.izquierdo.esVacio() && this.derecho.esVacio()) return true;
		
		if(izquierdo.profundidad()-derecho.profundidad()==1 && derecho.esLleno() && izquierdo.esCompleto()) return true;
		
		if(izquierdo.profundidad()-derecho.profundidad()==0 && izquierdo.esLleno() && derecho.esCompleto()) return true; 
		
		return false;
	}

	@Override
	public boolean esLleno() {
		// TODO 1.e
		
		int n=this.profundidad();
		int aux =this.cuentaNodosDeNivel(n);
		if(aux==Math.pow(2,n)) return true;
		else return false;
	}
	
	public ArrayList<E> rango(String nombre, int stockMin,int stockMax, double costoMin, double costoMax){
		
		ArrayList<E> lista = new ArrayList<E>();
		System.out.println("2. Stock Minimo: "+stockMin+" Stock Maximo: "+stockMax+" Costo Minimo: "+costoMin+" Costo Maximo: "+ costoMax);
		
		lista=rangoAux(nombre,stockMin,stockMax,costoMin,costoMax,lista);
		Collections.sort(lista);
		
		return lista;
	}
	
	public ArrayList<E> rangoAux(String nombre, int stockMin,int stockMax, double costoMin, double costoMax,ArrayList<E> lista) {
		
		if(this.izquierdo.esVacio()&&this.derecho.esVacio()) {
			if (((Insumo) this.valor).getStock() >= stockMin  && ((Insumo) this.valor).getStock() <= stockMax && 
				((Insumo) this.valor).getCosto() >= costoMin  && ((Insumo) this.valor).getCosto() <= costoMax) {if(((Insumo) this.valor).nombreParecido(nombre)) lista.add(valor);}
		}
		
		else if (((Insumo) this.valor).getStock() < stockMin || 
				(((Insumo) this.valor).getStock() < stockMin && ((Insumo) this.valor).getCosto() < costoMin)) {
				lista = this.derecho.rangoAux(nombre,stockMin,stockMax,costoMin,costoMax,lista);
		}
		
		else if (((Insumo) this.valor).getStock() > stockMax || 
				(((Insumo) this.valor).getStock() > stockMax && ((Insumo) this.valor).getCosto() > costoMax)){
			lista = this.izquierdo.rangoAux(nombre,stockMin,stockMax,costoMin,costoMax,lista);
		}
		
		else if (((Insumo) this.valor).getStock() >= stockMin  && ((Insumo) this.valor).getStock() <= stockMax && 
				((Insumo) this.valor).getCosto() >= costoMin  && ((Insumo) this.valor).getCosto() <= costoMax) {
			if(((Insumo) this.valor).nombreParecido(nombre)) lista.add(valor);
			lista = this.derecho.rangoAux(nombre,stockMin,stockMax,costoMin,costoMax,lista);
			lista = this.izquierdo.rangoAux(nombre,stockMin,stockMax,costoMin,costoMax,lista);
		}
		
		return lista;
	}
}
