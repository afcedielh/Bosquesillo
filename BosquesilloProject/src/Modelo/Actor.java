package Modelo;

import javax.swing.ImageIcon;

public class Actor {

    private Obstaculo obstaculo;
    private Carro carro;
    private Jugador jugador;
    private Boolean Objetivo;

    public Actor(Obstaculo obstaculo, Carro carro, Jugador jugador, Boolean Objetivo) {
        this.obstaculo = obstaculo;
        this.carro = carro;
        this.jugador = jugador;
        this.Objetivo = Objetivo;
    }

    public Obstaculo getObstaculo() {
        return obstaculo;
    }

    public void setObstaculo(Obstaculo obstaculo) {
        this.obstaculo = obstaculo;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public Boolean getObjetivo() {
        return Objetivo;
    }

    public void setObjetivo(Boolean Objetivo) {
        this.Objetivo = Objetivo;
    }
}
