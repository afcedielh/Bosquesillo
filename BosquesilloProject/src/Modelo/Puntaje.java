package Modelo;

public class Puntaje {
	private Jugador jugador;
	private Laberinto laberinto;
	private int puntaje;
	public Puntaje(Jugador jugador, Laberinto laberinto, int puntaje) {
		super();
		this.jugador = jugador;
		this.laberinto = laberinto;
		this.puntaje = puntaje;
	}
	public Jugador getJugador() {
		return jugador;
	}
	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}
	public Laberinto getLaberinto() {
		return laberinto;
	}
	public void setLaberinto(Laberinto laberinto) {
		this.laberinto = laberinto;
	}
	public int getPuntaje() {
		return puntaje;
	}
	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}

}
