package Modelo;

import java.util.List;

public class Jugador {
	private String alias;
	private String idUsuario;
	private List<Coordenada> coordenadas;
	public Jugador(String alias, String idUsuario, List<Coordenada> coordenadas) {
		super();
		this.alias = alias;
		this.idUsuario = idUsuario;
		this.coordenadas = coordenadas;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public String getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}
	public List<Coordenada> getCoordenadas() {
		return coordenadas;
	}
	public void setCoordenadas(List<Coordenada> coordenadas) {
		this.coordenadas = coordenadas;
	}

}
