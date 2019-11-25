package Controlador;

import Modelo.Laberinto;

/**
 *
 * @author acediel
 */
public class Controlador {
	private Laberinto laberinto;	
	
    /**
     *
     * @param laberinto
     */
    public Controlador(Laberinto laberinto) {
		super();
		this.laberinto = laberinto;
	}

    /**
     *
     * @return
     */
    public Laberinto getLaberinto() {
		System.out.println("Laberinto"+laberinto == null ? "Nulo":"No nulo");
		return laberinto;
	}

    /**
     *
     * @param laberinto
     */
    public void setLaberinto(Laberinto laberinto) {
		this.laberinto = laberinto;
	}	
	
}
