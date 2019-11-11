package Modelo;

public class Actor {
	private Obstaculo obstaculo;
	private Carro carro;
	private Jugador jugador;

	public Actor(Obstaculo obstaculo,  Carro carro,  Jugador jugador) {
		super();
		this.obstaculo = obstaculo;
		this.carro = carro;
		this.jugador = jugador;
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


}
