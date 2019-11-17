package Controlador;

import Modelo.Laberinto;
import Vista.Registro;

public class Inicio {

	public static void main(String[] args) {
		Controlador c = new Controlador(new Laberinto(0, null, null));
		try {
			Registro window = new Registro();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
