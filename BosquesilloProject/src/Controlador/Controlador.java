package Controlador;

import Modelo.Laberinto;

public class Controlador {
	private Laberinto laberinto;	
	
	public Controlador(Laberinto laberinto) {
		super();
		this.laberinto = laberinto;
	}

	public Laberinto getLaberinto() {
		System.out.println("Laberinto"+laberinto == null ? "Nulo":"No nulo");
		return laberinto;
	}

	public void setLaberinto(Laberinto laberinto) {
		this.laberinto = laberinto;
	}	
	
}
