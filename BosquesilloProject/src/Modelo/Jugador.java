package Modelo;

import java.util.List;

/**
 *
 * @author acediel
 */
public class Jugador {
	private String alias;
	private String idUsuario;
	private List<Coordenada> coordenadas;

    /**
     *
     * @param alias
     * @param idUsuario
     * @param coordenadas
     */
    public Jugador(String alias, String idUsuario, List<Coordenada> coordenadas) {
		super();
		this.alias = alias;
		this.idUsuario = idUsuario;
		this.coordenadas = coordenadas;
	}

    /**
     *
     * @return
     */
    public String getAlias() {
		return alias;
	}

    /**
     *
     * @param alias
     */
    public void setAlias(String alias) {
		this.alias = alias;
	}

    /**
     *
     * @return
     */
    public String getIdUsuario() {
		return idUsuario;
	}

    /**
     *
     * @param idUsuario
     */
    public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

    /**
     *
     * @return
     */
    public List<Coordenada> getCoordenadas() {
		return coordenadas;
	}

    /**
     *
     * @param coordenadas
     */
    public void setCoordenadas(List<Coordenada> coordenadas) {
		this.coordenadas = coordenadas;
	}

}
