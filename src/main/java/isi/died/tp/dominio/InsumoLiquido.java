package isi.died.tp.dominio;

public class InsumoLiquido extends Insumo {
	
	private double densidad;
	
	public InsumoLiquido(int stock){
		super(stock);
	}
	
	public InsumoLiquido(int i,String des,String planta, int s,double den,double vol,double costo,boolean ref,UnidadMedida u){	//vol en m3
		super(i,des,planta,s,vol*den,costo,ref,u);
		this.densidad=den;
	}
	
	public double getDensidad() {return densidad;}
	public void setDensidad(double densidad) {this.densidad = densidad;}
}
