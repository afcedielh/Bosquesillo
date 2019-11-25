package Modelo;

/**
 *
 * @author Gelen Ruano
 */
public class Actor {

    private Obstaculo obstaculo;
    private Carro carro;
    private Jugador jugador;
    private Boolean Objetivo;

    /**
     *Constructor parámetrico de la clase actor
     * @param obstaculo Define si la instancia está definida por un obstaculo
     * @param carro Define si la instancia está definida por un carro
     * @param jugador Define si la instancia está definida por un jugador
     * @param Objetivo Define si la instancia está definida por un Objetivo
     */
    public Actor(Obstaculo obstaculo, Carro carro, Jugador jugador, Boolean Objetivo) {
        this.obstaculo = obstaculo;
        this.carro = carro;
        this.jugador = jugador;
        this.Objetivo = Objetivo;
    }

    /**
     *Retorna el valor de Obstaculo
     * @return Obstaculo
     */
    public Obstaculo getObstaculo() {
        return obstaculo;
    }

    /**
     * Le asigna un valor a obstaculo
     * @param obstaculo Nuevo valor de obstaculo
     */
    public void setObstaculo(Obstaculo obstaculo) {
        this.obstaculo = obstaculo;
    }

    /**
     *Retorna el valor de carro
     * @return  valor de carro
     */
    public Carro getCarro() {
        return carro;
    }

    /**
     * Le asigna un valor a carro
     * @param carro valor de carro
     */
    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    /**
     *Retorna el valor de jugador
     * @return valor de jugador
     */
    public Jugador getJugador() {
        return jugador;
    }

    /**
     *Le asigna un valor a jugador
     * @param jugador valor de carro
     */
    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    /**
     *Retorna el valor de Objetivo
     * @return valor de Objetivo
     */
    public Boolean getObjetivo() {
        return Objetivo;
    }

    /**
     *Le asigna un valor a Objetivo
     * @param Objetivo valor de Objetivo
     */
    public void setObjetivo(Boolean Objetivo) {
        this.Objetivo = Objetivo;
    }
}
