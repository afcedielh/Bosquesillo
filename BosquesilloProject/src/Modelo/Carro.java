package Modelo;

import java.util.List;

public class Carro {
	private int maxMovimientos;
	private List<Coordenada> lista;
	
	public Carro(int maxMovimientos, List<Coordenada> lista) {
		super();
		this.maxMovimientos = maxMovimientos;
		this.lista = lista;
	}
	
	public int getMaxMovimientos() {
		return maxMovimientos;
	}
	
	public void setMaxMovimientos(int maxMovimientos) {
		this.maxMovimientos = maxMovimientos;
	}
	
	public List<Coordenada> getLista() {
		return lista;
	}
	
	public void setLista(List<Coordenada> lista) {
		this.lista = lista;
	}


}
