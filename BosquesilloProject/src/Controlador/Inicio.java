package Controlador;

import Vista.Registro;

/**
 *
 * @author acediel
 */
public class Inicio {

    /**
     *Metodo inicial del proyecto
     * @param args Argumentos que recibe el metodo main para su ejecución
     */
    public static void main(String[] args) {
        try {
            Registro window = new Registro();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
