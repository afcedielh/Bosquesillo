package Modelo;

/**
 *
 * @author acediel
 */
public class Puntaje {
	private Jugador jugador;
	private Laberinto laberinto;
	private int puntaje;

    /**
     *
     * @param jugador
     * @param laberinto
     * @param puntaje
     */
    public Puntaje(Jugador jugador, Laberinto laberinto, int puntaje) {
		super();
		this.jugador = jugador;
		this.laberinto = laberinto;
		this.puntaje = puntaje;
	}

    /**
     *
     * @return
     */
    public Jugador getJugador() {
		return jugador;
	}

    /**
     *
     * @param jugador
     */
    public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}

    /**
     *
     * @return
     */
    public Laberinto getLaberinto() {
		return laberinto;
	}

    /**
     *
     * @param laberinto
     */
    public void setLaberinto(Laberinto laberinto) {
		this.laberinto = laberinto;
	}

    /**
     *
     * @return
     */
    public int getPuntaje() {
		return puntaje;
	}

    /**
     *
     * @param puntaje
     */
    public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}

}
