package Modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Clase encargada de definir y controlar toda la logica de negocio dentro del
 * juego
 *
 * @author Gelen Ruano
 */
public class Laberinto {

    private int id;
    private Actor[][] actor;
    private List<Coordenada> destino;
    private int puntaje;
    private int vidas;
    private int escudo;
    private int PuntosObjetivo;

    /**
     * Constructor parametrico de la clase laberinto
     *
     * @param id Id del tablero
     * @param actor Matriz que representa cada elemento dentro del tablero
     * @param destino Lista de coordenadas de puntos objetivo
     * @param puntaje Puntaje del jugador en el tablero
     * @param vidas Cantidad de vidas restantes
     * @param escudo Cantidad de escudos restantes
     * @param CantidadPuntos Puntos totales objetivo
     */
    public Laberinto(int id, Actor[][] actor, List<Coordenada> destino, int puntaje, int vidas, int escudo, int CantidadPuntos) {
        super();
        this.id = id;
        this.actor = actor;
        this.destino = destino;
        this.puntaje = puntaje;
        this.vidas = vidas;
        this.escudo = escudo;
        this.PuntosObjetivo = CantidadPuntos;
    }

    /**
     *
     * @return
     */
    public int getPuntosObjetivo() {
        return PuntosObjetivo;
    }

    /**
     *
     * @param PuntosObjetivo
     */
    public void setPuntosObjetivo(int PuntosObjetivo) {
        this.PuntosObjetivo = PuntosObjetivo;
    }

    /**
     *
     * @return
     */
    public int getescudo() {
        return escudo;
    }

    /**
     *
     * @param escudo
     */
    public void setescudo(int escudo) {
        this.escudo = escudo;
    }

    /**
     *
     * @return
     */
    public int getpuntaje() {
        return puntaje;
    }

    /**
     *
     * @param puntaje
     */
    public void setpuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    /**
     *
     * @return
     */
    public int getvidas() {
        return vidas;
    }

    /**
     *
     * @param vidas
     */
    public void setvidas(int vidas) {
        this.vidas = vidas;
    }

    /**
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public Actor[][] getActor() {
        return actor;
    }

    /**
     *
     * @param actor
     */
    public void setActor(Actor[][] actor) {
        this.actor = actor;
    }

    /**
     *
     * @return
     */
    public List<Coordenada> getDestino() {
        return destino;
    }

    /**
     *
     * @param destino
     */
    public void setDestino(List<Coordenada> destino) {
        this.destino = destino;
    }

    /**
     *
     * @param punto
     */
    public void AgregarDestino(Coordenada punto) {
        if (this.destino == null) {
            this.destino = new ArrayList<Coordenada>();
        }
        this.destino.add(punto);
    }

    private void CrearMarco() {
        for (int i = 0; i < actor.length; i++) {
            for (int j = 0; j < actor[i].length; j++) {
                if (i == 0 || j == 0 || i == actor.length - 1 || j == actor[i].length - 1) {
                    this.actor[i][j] = new Actor(Obstaculo.Muro, null, null, null);
                }
            }
        }
    }

    /**
     * Metodo encargado de generar de manera aleatoria la configuración inicial
     * del tablero, esta configuración la realiza Instanciando la mitad de los
     * monstruos como buenos y la otra mitad como malos.
     *
     * @param monstruos Cantidad de monstruos dentro del tablero
     * @throws Exception Excepcion que se lanza cuando no se ha generado ningun
     * tablero
     */
    public void ConfigurarTablero(int monstruos) throws Exception {
        if (this.actor == null) {
            throw new Exception("No se ha generado una matriz aún.");
        } else {
            CrearMarco();
            DefinirPuntos();
            Random r = new Random();
            int obstaculos[] = new int[6];
            for (int i = 0; i < obstaculos.length; i++) {
                if (i < 3) {
                    obstaculos[i] = r.nextInt((int) ((Math.ceil((double) monstruos / 2)) - obstaculos[0]));
                    if (i == 2) {
                        obstaculos[i] = ((int) (Math.ceil((double) monstruos / 2)) - obstaculos[0] - obstaculos[1]);
                    }
                } else {
                    obstaculos[i] = r.nextInt((monstruos / 2) - obstaculos[3]);
                    if (i == 5) {
                        obstaculos[i] = (monstruos / 2) - obstaculos[3] - obstaculos[4];
                    }
                }
                System.out.println(obstaculos[i]);
            }
            int x, y;
            Boolean bandera = false;
            while (!bandera) {
                x = r.nextInt(this.actor.length);
                y = r.nextInt(this.actor[0].length);
                if (this.actor[x][y] == null) {
                    bandera = true;
                    this.actor[x][y] = new Actor(null, new Carro(0, destino), null, null);
                }
            }
            bandera = false;
            while (!bandera) {
                bandera = true;
                x = r.nextInt(this.actor.length);
                y = r.nextInt(this.actor[0].length);
                if (this.actor[x][y] == null) {
                    bandera = true;
                    this.actor[x][y] = new Actor(null, null, new Jugador("", "", destino), null);
                }
            }
            for (int i = 0; i < obstaculos.length; i++) {
                for (int j = 0; j < obstaculos[i]; j++) {
                    Boolean bandera1 = false;
                    while (!bandera1) {
                        x = r.nextInt(this.actor.length);
                        y = r.nextInt(this.actor[0].length);
                        if (this.actor[x][y] == null) {
                            bandera1 = true;
                            switch (i) {
                                case 0:
                                    this.actor[x][y] = new Actor(Obstaculo.Muro, null, null, null);
                                    break;
                                case 1:
                                    this.actor[x][y] = new Actor(Obstaculo.Tormentoso, null, null, null);
                                    break;
                                case 2:
                                    this.actor[x][y] = new Actor(Obstaculo.Letal, null, null, null);
                                    break;
                                case 3:
                                    this.actor[x][y] = new Actor(Obstaculo.Angelito, null, null, null);
                                    break;
                                case 4:
                                    this.actor[x][y] = new Actor(Obstaculo.Corazon, null, null, null);
                                    break;
                                case 5:
                                    this.actor[x][y] = new Actor(Obstaculo.Escudo, null, null, null);
                                    break;
                                default:
                                    break;
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * Metodo encargado de mover al jugador
     *
     * @param direccion Direcion a la cual se va a mover el jugador 1: Arriba,
     * 2: abajo, 3: Izquierda, 4: Derecha
     */
    public void Mover(int direccion) {
        puntaje--;
        for (int i = 0; i < actor.length; i++) {
            for (int j = 0; j < actor[i].length; j++) {
                if (actor[i][j] != null && actor[i][j].getJugador() != null) {
                    Actor ac = this.actor[i][j];
                    if (direccion == 1) {
                        if (this.actor[i][j - 1] != null && this.actor[i][j - 1].getCarro() != null) {
                            moverCarro(direccion);
                        }
                        ValidarMonstruos(i, j - 1);
                        if (this.actor[i][j - 1] == null) {
                            this.actor[i][j] = null;
                            this.actor[i][j - 1] = ac;
                        }
                    }
                    if (direccion == 2) {
                        if (this.actor[i][j + 1] != null && this.actor[i][j + 1].getCarro() != null) {
                            moverCarro(direccion);
                        }
                        ValidarMonstruos(i, j + 1);
                        if (this.actor[i][j + 1] == null) {
                            this.actor[i][j] = null;
                            this.actor[i][j + 1] = ac;
                        }
                    }
                    if (direccion == 3) {
                        if (this.actor[i - 1][j] != null && this.actor[i - 1][j].getCarro() != null) {
                            moverCarro(direccion);
                        }
                        ValidarMonstruos(i - 1, j);
                        if (this.actor[i - 1][j] == null) {
                            this.actor[i][j] = null;
                            this.actor[i - 1][j] = ac;
                        }
                    }
                    if (direccion == 4) {
                        if (this.actor[i + 1][j] != null && this.actor[i + 1][j].getCarro() != null) {
                            moverCarro(direccion);
                        }
                        ValidarMonstruos(i + 1, j);
                        if (this.actor[i + 1][j] == null) {
                            this.actor[i][j] = null;
                            this.actor[i + 1][j] = ac;
                        }
                    }
                    return;
                }
            }
        }
    }

    /**
     * Metodo encargado de reconfigrar el tablero, mueve cada uno de los
     * mosntruos que se pueden mover en alguna dirección
     */
    public void ReconfigurarTablero() {
        Random r = new Random();
        int direccion = 0;
        for (int i = 0; i < actor.length; i++) {
            for (int j = 0; j < actor[i].length; j++) {
                if (actor[i][j] != null && actor[i][j].getObstaculo() != null
                        && actor[i][j].getObstaculo().ordinal() != 0
                        && actor[i][j].getObstaculo().ordinal() != 4
                        && actor[i][j].getObstaculo().ordinal() != 5) {
                    Actor ac = this.actor[i][j];
                    direccion = r.nextInt(4);
                    if (i != actor.length - 1 && j != actor.length - 1 && i != 0 && j != 0) {
                        if (direccion == 1) {
                            if (j - 1 == 0) {
                                if (this.actor[i][actor.length - 2] == null) {
                                    this.actor[i][j] = null;
                                    this.actor[i][actor.length - 2] = ac;
                                }
                            } else {
                                if (this.actor[i][j - 1] == null) {
                                    this.actor[i][j] = null;
                                    this.actor[i][j - 1] = ac;
                                }
                            }
                        }
                        if (direccion == 2) {

                            if (j + 1 == actor.length - 1) {
                                if (this.actor[i][1] == null) {
                                    this.actor[i][j] = null;
                                    this.actor[i][1] = ac;
                                }
                            } else {
                                if (this.actor[i][j + 1] == null) {
                                    this.actor[i][j] = null;
                                    this.actor[i][j + 1] = ac;
                                }
                            }
                        }
                        if (direccion == 3) {
                            if (i - 1 == 0) {
                                if (this.actor[actor.length - 2][j] == null) {
                                    this.actor[i][j] = null;
                                    this.actor[actor.length - 2][j] = ac;
                                }
                            } else {
                                if (this.actor[i - 1][j] == null) {
                                    this.actor[i][j] = null;
                                    this.actor[i - 1][j] = ac;
                                }
                            }
                        }
                        if (direccion == 4) {
                            if (i + 1 == actor.length - 1) {
                                if (this.actor[actor.length - 2][1] == null) {
                                    this.actor[i][j] = null;
                                    this.actor[actor.length - 2][1] = ac;
                                }
                            } else {
                                if (this.actor[i + 1][j] == null) {
                                    this.actor[i][j] = null;
                                    this.actor[i + 1][j] = ac;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * Metodo encargado de mover en alguna direccion el carro
     */
    private void moverCarro(int direccion) {
        for (int i = 0; i < actor.length; i++) {
            for (int j = 0; j < actor[i].length; j++) {
                if (actor[i][j] != null && actor[i][j].getCarro() != null) {
                    Actor ac = this.actor[i][j];
                    if (direccion == 1) {
                        validarObjetivo(i, j - 1);
                        if (this.actor[i][j - 1] == null) {
                            this.actor[i][j] = null;
                            this.actor[i][j - 1] = ac;
                        }
                    }
                    if (direccion == 2) {
                        validarObjetivo(i, j + 1);
                        if (this.actor[i][j + 1] == null) {
                            this.actor[i][j] = null;
                            this.actor[i][j + 1] = ac;
                        }
                    }
                    if (direccion == 3) {
                        validarObjetivo(i - 1, j);
                        if (this.actor[i - 1][j] == null) {
                            this.actor[i][j] = null;
                            this.actor[i - 1][j] = ac;
                        }
                    }
                    if (direccion == 4) {
                        validarObjetivo(i + 1, j);
                        if (this.actor[i + 1][j] == null) {
                            this.actor[i][j] = null;
                            this.actor[i + 1][j] = ac;
                        }
                    }
                    return;
                }
            }
        }

    }

    /**
     * Metodo encargado de validar cacada uno de los monstruos ejecutando su
     * respectiva función
     */
    private void ValidarMonstruos(int x, int y) {
        validarCorazon(x, y);
        validarAngel(x, y);
        validarLetal(x, y);
        validarTormenta(x, y);
        validarEscudo(x, y);
        validarVidas();
    }

    /**
     * Valida si a la posición en la que se va a mover hay un corazon
     */
    private void validarCorazon(int x, int y) {
        if (this.actor[x][y] != null
                && this.actor[x][y].getObstaculo() != null
                && this.actor[x][y].getObstaculo().ordinal() == 4) {
            this.actor[x][y] = null;
            this.vidas++;
        }
    }

    /**
     * Valida si a la posición en la que se va a mover hay un Angel
     */
    private void validarAngel(int x, int y) {
        if (this.actor[x][y] != null
                && this.actor[x][y].getObstaculo() != null
                && this.actor[x][y].getObstaculo().ordinal() == 3) {
            this.actor[x][y] = null;
            this.puntaje = (int) (puntaje * 1.03);
        }
    }

    /**
     * Valida si a la posición en la que se va a mover hay un Letal
     */
    private void validarLetal(int x, int y) {
        if (this.actor[x][y] != null
                && this.actor[x][y].getObstaculo() != null
                && this.actor[x][y].getObstaculo().ordinal() == 2) {
            this.actor[x][y] = null;
            if (this.escudo > 0) {
                escudo--;
            } else {
                this.puntaje = (0);
            }

        }
    }

    /**
     * Valida si a la posición en la que se va a mover hay un Tormenta
     */
    private void validarTormenta(int x, int y) {
        if (this.actor[x][y] != null
                && this.actor[x][y].getObstaculo() != null
                && this.actor[x][y].getObstaculo().ordinal() == 1) {
            this.actor[x][y] = null;
            if (this.escudo > 0) {
                escudo--;
            } else {
                this.puntaje = (int) ((int) this.puntaje * 0.95);
            }
        }
    }

    /**
     * Valida si a la posición en la que se va a mover hay un Escudo
     */
    private void validarEscudo(int x, int y) {
        if (this.actor[x][y] != null
                && this.actor[x][y].getObstaculo() != null
                && this.actor[x][y].getObstaculo().ordinal() == 5) {
            this.actor[x][y] = null;
            this.escudo = escudo + 1;
        }
    }

    /**
     * Valida si ya perdió el juego
     */
    private void validarVidas() {
        if (this.puntaje == 0 && this.vidas > 0) {
            this.vidas--;
            this.puntaje = this.actor.length * this.actor.length;
        }
    }

    /**
     * Valida si a la posición en la que se va a mover hay un corazon
     */
    private void validarObjetivo(int x, int y) {
        if (this.actor[x][y] != null
                && this.actor[x][y].getObjetivo() != null) {
            this.actor[x][y] = null;
        }
    }

    /**
     *
     * @return
     */
    public Boolean ValidarGano() {
        Boolean retornar = true;
        for (int i = 0; i < actor.length; i++) {
            for (int j = 0; j < actor[i].length; j++) {
                if (actor[i][j] != null && actor[i][j].getObjetivo() != null) {
                    retornar = false;
                }
            }
        }
        return retornar;
    }

    private void DefinirPuntos() {
        System.out.println("Puntos: " + this.PuntosObjetivo);
        for (int i = 0; i < this.PuntosObjetivo; i++) {
            boolean bandera = false;
            while (!bandera) {
                Random r = new Random();
                int x = r.nextInt(this.actor.length);
                int y = r.nextInt(this.actor.length);
                if (this.actor[x][y] == null) {
                    bandera = true;
                    System.out.println("Objetivo");
                    this.actor[x][y] = new Actor(null, null, null, true);
                }
            }
        }

    }
}
