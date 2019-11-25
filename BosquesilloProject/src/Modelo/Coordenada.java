package Modelo;

/**
 * Representa una coordenada dentro del tablero
 * @author Gelen Ruano
 */
public class Coordenada {
	private int x;
	private int y;
	private int movimiento;

    /**
     * Constructor parametrico de la clase coordenada
     * @param x Representa el indice en X
     * @param y Representa el Indice en Y
     * @param movimiento Movimiento
     */
    public Coordenada(int x, int y, int movimiento) {
		super();
		this.x = x;
		this.y = y;
		this.movimiento = movimiento;
	}

    /**
     *
     * @return
     */
    public int getX() {
		return x;
	}

    /**
     *
     * @param x
     */
    public void setX(int x) {
		this.x = x;
	}

    /**
     *
     * @return
     */
    public int getY() {
		return y;
	}

    /**
     *
     * @param y
     */
    public void setY(int y) {
		this.y = y;
	}

    /**
     *
     * @return
     */
    public int getMovimiento() {
		return movimiento;
	}

    /**
     *
     * @param movimiento
     */
    public void setMovimiento(int movimiento) {
		this.movimiento = movimiento;
	}

}
