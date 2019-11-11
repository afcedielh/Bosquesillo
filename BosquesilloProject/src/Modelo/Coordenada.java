package Modelo;

public class Coordenada {
	private int x;
	private int y;
	private int movimiento;
	public Coordenada(int x, int y, int movimiento) {
		super();
		this.x = x;
		this.y = y;
		this.movimiento = movimiento;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getMovimiento() {
		return movimiento;
	}
	public void setMovimiento(int movimiento) {
		this.movimiento = movimiento;
	}

}
