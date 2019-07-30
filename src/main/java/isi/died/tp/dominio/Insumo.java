package isi.died.tp.dominio;

public class Insumo implements Comparable <Insumo> {
	
	protected String id;
	protected String descripcion;
	protected String planta;
	protected int stock;
	protected double peso;
	protected double costo;
	protected boolean esRefrigerado;
	protected UnidadMedida unidad;	
	
	public Insumo(String i,String des,String planta, int s,double peso,double costo,boolean ref,UnidadMedida u){
		this.id=i;
		this.descripcion=des;
		this.planta=planta;
		this.stock=s;
		this.peso=peso;
		this.costo=costo;
		this.esRefrigerado=ref;
		this.unidad=u;
	}
	
	public Insumo(int stock){this.stock=stock;}
	
	public String getId() {return id;}
	public void setId(String id) {this.id = id;}
	public String getDescripcion() {return descripcion;}
	public void setDescripcion(String descripcion) {this.descripcion = descripcion;}
	public String getPlanta() {return planta;}
	public void setPlanta(String planta) {this.planta = planta;}
	public int getStock() {return stock;}
	public void setStock(int stock) {this.stock = stock;}
	public double getPeso() {return peso;}
	public void setPeso(double peso) {this.peso = peso;}
	public double getCosto() {return costo;}
	public void setCosto(double costo) {this.costo = costo;}
	public boolean isEsRefrigerado() {return esRefrigerado;}
	public void setEsRefrigerado(boolean esRefrigerado) {this.esRefrigerado = esRefrigerado;}
	public UnidadMedida getUnidad() {return unidad;}
	public void setUnidad(UnidadMedida unidad) {this.unidad = unidad;}
	
	@Override
	public String toString() {
		return "Insumo [id=" + id + "]";
	}

	public int compareTo(Insumo in) {
		if (this.stock>in.getStock()) return 1;
		else if (this.stock<in.getStock()) return -1;
		else if (this.costo>in.getCosto()) return 1;
		else if (this.costo<in.getCosto()) return -1;
		else return this.descripcion.compareTo(in.getDescripcion());	
	}
	
	public double pesoPorStock() {
		return stock*peso;
	}
	
	public boolean nombreParecido(String nombre) {
		if(nombre=="") return true;
		else if(this.getDescripcion().length()<nombre.length()) return false;
		else if(this.getDescripcion().substring(0, nombre.length()).compareTo(nombre)==0) return true;
		else return false;
	}
}