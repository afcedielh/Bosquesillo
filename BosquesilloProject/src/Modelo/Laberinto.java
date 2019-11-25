package Modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Laberinto {

    private int id;
    private Actor[][] actor;
    private List<Coordenada> destino;
    private int puntaje;
    private int vidas;
    private int escudo;
    private int PuntosObjetivo;

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

    public int getPuntosObjetivo() {
        return PuntosObjetivo;
    }

    public void setPuntosObjetivo(int PuntosObjetivo) {
        this.PuntosObjetivo = PuntosObjetivo;
    }

    public int getescudo() {
        return escudo;
    }

    public void setescudo(int escudo) {
        this.escudo = escudo;
    }

    public int getpuntaje() {
        return puntaje;
    }

    public void setpuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public int getvidas() {
        return vidas;
    }

    public void setvidas(int vidas) {
        this.vidas = vidas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Actor[][] getActor() {
        return actor;
    }

    public void setActor(Actor[][] actor) {
        this.actor = actor;
    }

    public List<Coordenada> getDestino() {
        return destino;
    }

    public void setDestino(List<Coordenada> destino) {
        this.destino = destino;
    }

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

    private void ValidarMonstruos(int x, int y) {
        validarCorazon(x, y);
        validarAngel(x, y);
        validarLetal(x, y);
        validarTormenta(x, y);
        validarEscudo(x, y);
        validarVidas();
    }

    private void validarCorazon(int x, int y) {
        if (this.actor[x][y] != null
                && this.actor[x][y].getObstaculo() != null
                && this.actor[x][y].getObstaculo().ordinal() == 4) {
            this.actor[x][y] = null;
            this.vidas++;
        }
    }

    private void validarAngel(int x, int y) {
        if (this.actor[x][y] != null
                && this.actor[x][y].getObstaculo() != null
                && this.actor[x][y].getObstaculo().ordinal() == 3) {
            this.actor[x][y] = null;
            this.puntaje = (int) (puntaje * 1.03);
        }
    }

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

    private void validarEscudo(int x, int y) {
        if (this.actor[x][y] != null
                && this.actor[x][y].getObstaculo() != null
                && this.actor[x][y].getObstaculo().ordinal() == 5) {
            this.actor[x][y] = null;
            this.escudo = escudo + 1;
        }
    }

    private void validarVidas() {
        if (this.puntaje == 0 && this.vidas > 0) {
            this.vidas--;
            this.puntaje = this.actor.length * this.actor.length;
        }
    }

    private void validarObjetivo(int x, int y) {
        if (this.actor[x][y] != null
                && this.actor[x][y].getObjetivo() != null) {
            this.actor[x][y] = null;
        }
    }

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
