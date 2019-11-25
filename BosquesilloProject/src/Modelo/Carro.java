package Modelo;

import java.util.List;

/**
 * Clase con las propiedades y acciones del carro
 * @author Gelen Ruano
 */
public class Carro {
	private int maxMovimientos;
	private List<Coordenada> lista;
	
    /**
     * Constructor parametrico encargado de inicializar las propiedades de la clase
     * @param maxMovimientos Maximo de movimientos que tiene el carro
     * @param lista Lista de movimientos, representa el recorrido del carro en el 
     */
    public Carro(int maxMovimientos, List<Coordenada> lista) {
		super();
		this.maxMovimientos = maxMovimientos;
		this.lista = lista;
	}
	
    /**
     * Retorna el maximo de movimientos
     * @return Maximo de movimientos
     */
    public int getMaxMovimientos() {
		return maxMovimientos;
	}
	
    /**
     * Le asigna un maximo de movimientos
     * @param maxMovimientos Maximo de movimientos
     */
    public void setMaxMovimientos(int maxMovimientos) {
		this.maxMovimientos = maxMovimientos;
	}
	
    /**
     * Obtiene la lista de movimientos del carro
     * @return Lista de movimientos del carro
     */
    public List<Coordenada> getLista() {
		return lista;
	}
	
    /**
     * Asigna la lista de movimientos del carro
     * @param lista Lista de movimientos
     */
    public void setLista(List<Coordenada> lista) {
		this.lista = lista;
	}


}
