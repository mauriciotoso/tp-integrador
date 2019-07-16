package isi.died.tp.dominio;

public class Camion {
		private String id;
		private String marca;
		private String modelo;
		private String dominio;
		private int anio;
		private float costoXKM;
		private boolean AptoLiq;
		private float capacidad;
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getMarca() {
			return marca;
		}
		public void setMarca(String marca) {
			this.marca = marca;
		}
		public String getModelo() {
			return modelo;
		}
		public void setModelo(String modelo) {
			this.modelo = modelo;
		}
		public String getDominio() {
			return dominio;
		}
		public void setDominio(String dominio) {
			this.dominio = dominio;
		}
		public int getAnio() {
			return anio;
		}
		public void setAnio(int anio) {
			this.anio = anio;
		}
		public float getCostoXKM() {
			return costoXKM;
		}
		public void setCostoXKM(float costoXKM) {
			this.costoXKM = costoXKM;
		}
		public boolean isAptoLiq() {
			return AptoLiq;
		}
		public void setAptoLiq(boolean aptoLiq) {
			AptoLiq = aptoLiq;
		}
		public float getCapacidad() {
			return capacidad;
		}
		public void setCapacidad(float capacidad) {
			this.capacidad = capacidad;
		}
		public Camion(String id, String marca, String modelo, String dominio, int anio, float costoXKM, boolean aptoLiq,
				float capacidad) {
			super();
			this.id = id;
			this.marca = marca;
			this.modelo = modelo;
			this.dominio = dominio;
			this.anio = anio;
			this.costoXKM = costoXKM;
			this.AptoLiq = aptoLiq;
			this.capacidad = capacidad;
		}
		
		public Camion() {
			super();
			this.id = null;
			this.marca = null;
			this.modelo = null;
			this.dominio = null;
			this.anio = 0;
			this.costoXKM = 0;
			this.AptoLiq = false;
			this.capacidad = 0;
		}
}
