package isi.died.tp.dominio;

import isi.died.tp.dominio.Planta;
import isi.died.tp.estructuras.Arista;
import isi.died.tp.estructuras.Vertice;

public class Ruta extends Arista<Planta> {
		private float distancia;
		private int duracionEnMin;
		private float pesoMaxEnToneladas;
		
		public float getDistancia() {
			return distancia;
		}
		public void setDistancia(float distancia) {
			this.distancia = distancia;
		}
		public int getDuracionEnMin() {
			return duracionEnMin;
		}
		public void setDuracionEnMin(int duracionEnMin) {
			this.duracionEnMin = duracionEnMin;
		}
		public float getPesoMaxEnToneladas() {
			return pesoMaxEnToneladas;
		}
		public void setPesoMaxEnToneladas(float pesoMaxEnToneladas) {
			this.pesoMaxEnToneladas = pesoMaxEnToneladas;
		}
		public Ruta(int id,float distancia, int duracionEnMin, float pesoMaxEnToneladas,Planta plantaInicial, Planta plantaFinal) {
			super(new Vertice<Planta>(plantaInicial),new Vertice<Planta>(plantaFinal),id);
			
			this.distancia = distancia;
			this.duracionEnMin = duracionEnMin;
			this.pesoMaxEnToneladas = pesoMaxEnToneladas;
		}
		
		public Ruta() {
			super();
			this.distancia=0;
			this.duracionEnMin=0;
			this.pesoMaxEnToneladas=0;
		}
		
}
