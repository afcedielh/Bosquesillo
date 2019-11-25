package Vista;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

import Modelo.Actor;
import Modelo.Laberinto;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author oneiber
 */
public class Registro {

    private static Laberinto lab;

    //atributos
    static JFrame ventana;

    //presentacion
    JPanel panelPresentacion;
    JButton iniciar;
    JLabel fondoPresentacion;
    ImageIcon imagenFondoPres;

    //menu
    JPanel panelMenu;
    JButton botones[];
    JLabel fondoMenu;
    ImageIcon imagenFondoMenu;
    //formulario
    private JFrame frame = new JFrame();
    private JTextField txtTamanoX;
    private JTextField txtTamanoY;
    private JTextField txtmonstruos;
    private JTextField txtpuntosObjetivo;

    //juego
    static JPanel panelJuego;
    JLabel fondoJuego;
    ImageIcon imagenFondoJuego;
    static int mat[][];
    static JLabel matriz[][];
    int px;
    int py;
    String jugador;
    JLabel nombre;
    int puntos;
    JLabel records;
    int abajo;
    int arriba;
    int izq;
    int der;
    Timer timer;

    //fantasmas
    Monstruos letal1;
    Monstruos letal2;
    Monstruos letal3;
    static int matAux[][];

    public Registro() {

        ventana = new JFrame("Bosquecillo");
        ventana.setFocusable(true);
        ventana.setSize(1000, 1000);
        ventana.setLayout(null);
        ventana.setLocationRelativeTo(null);
        ventana.setResizable(false);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.addKeyListener(new KeyListener() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    lab.Mover(1);
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    lab.Mover(2);
                }
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    lab.Mover(3);
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    lab.Mover(4);
                }
                records.setText("Puntos: " + lab.getpuntaje() + " Vidas: " + lab.getvidas() + " Escudos: " + lab.getescudo());
                lab.ReconfigurarTablero();
                pintarMatriz();
                if (lab.getpuntaje() == 0) {
                    JOptionPane.showMessageDialog(null, "Perdiste!", "Bosquesillo", JOptionPane.WARNING_MESSAGE);
                    System.exit(1);
                }else if(lab.ValidarGano()){                
                    JOptionPane.showMessageDialog(null, "Ganaste!", "Bosquesillo", JOptionPane.WARNING_MESSAGE);
                    System.exit(1);
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyTyped(KeyEvent e) {
            }

        });
        panelPresentacion = new JPanel();
        panelPresentacion.setLayout(null);
        panelPresentacion.setBounds(0, 0, ventana.getWidth(), ventana.getHeight());
        panelPresentacion.setVisible(true);
        panelPresentacion.setBackground(Color.red);

        iniciar = new JButton("Iniciar");
        iniciar.setBounds(ventana.getWidth() - 550, 400, 100, 30);
        iniciar.setVisible(true);
        iniciar.setBackground(Color.white);
        panelPresentacion.add(iniciar, 0);

        fondoPresentacion = new JLabel();
        fondoPresentacion.setBounds(0, 0, ventana.getWidth(), ventana.getHeight());
        imagenFondoPres = new ImageIcon("imagenes/fondoPresentacion.png");
        imagenFondoPres = new ImageIcon(imagenFondoPres.getImage().getScaledInstance(ventana.getWidth(), ventana.getHeight(), Image.SCALE_DEFAULT));
        fondoPresentacion.setIcon(imagenFondoPres);
        fondoPresentacion.setVisible(true);
        panelPresentacion.add(fondoPresentacion, 0);

        //menu
        botones = new JButton[4];
        for (int i = 0; i < botones.length; i++) {
            botones[i] = new JButton();
        }

        iniciar.addMouseListener(new MouseAdapter() {

            public void mousePressed(MouseEvent e) {
                System.out.println("iniciar");
                menu();
                eventoMenu();
                inicialize();
            }

        });

        //juego
        mat = new int[100][100];
        mat = tablero(1);
        //matAux = tablero(1);
        matriz = new JLabel[100][100];
        matAux = new int[100][100];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                matriz[i][j] = new JLabel();
                matAux[i][j] = mat[i][j];
            }
        }

        px = 1;
        py = 1;
        mat[px][py] = 3;
        abajo = 0;
        arriba = 0;
        izq = 0;
        der = 0;

        ventana.add(panelPresentacion);

        ventana.setVisible(true);

    }

    public void jugar() {
        int X = Integer.parseInt(txtTamanoX.getText()) + 1;
        int Y = Integer.parseInt(txtTamanoY.getText()) + 1;
        int Cantidad = Integer.parseInt(txtpuntosObjetivo.getText());
        int monstruos = Integer.parseInt(txtmonstruos.getText());
        lab = new Laberinto(1, new Actor[X][Y], null, (X * Y), 0, 0, Cantidad);
        try {
            lab.ConfigurarTablero(monstruos);
        } catch (Exception ex) {
            Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
        }
        panelMenu.setVisible(false);
        panelJuego = new JPanel();
        panelJuego.setLayout(null);
        panelJuego.setBounds(0, 0, ventana.getWidth(), ventana.getHeight());
        panelJuego.setVisible(true);

        fondoJuego = new JLabel();
        fondoJuego.setBounds(0, 0, ventana.getWidth(), ventana.getHeight());
        imagenFondoJuego = new ImageIcon("imagenes/fondoJugar.png");
        imagenFondoJuego = new ImageIcon(imagenFondoJuego.getImage().getScaledInstance(ventana.getWidth(), ventana.getHeight(), Image.SCALE_DEFAULT));
        fondoJuego.setIcon(imagenFondoJuego);
        fondoJuego.setVisible(true);
        panelJuego.add(fondoJuego, 0);
        System.out.print("Finalizo creacion matriz");
        boolean hayJugador = false;
        for (int i = 0; i < lab.getActor().length; i++) {
            System.out.println("");
            for (int j = 0; j < lab.getActor()[i].length; j++) {
                if (lab.getActor()[i][j] != null) {
                    System.out.print("O ");
                } else {
                    System.out.print("x ");
                }
                if (lab.getActor()[i][j] != null) {
                    if (lab.getActor()[i][j].getObstaculo() != null) {
                        switch (lab.getActor()[i][j].getObstaculo().ordinal()) {
                            case 0:
                                matriz[i][j].setIcon(new ImageIcon("imagenes/5.png"));
                                break;
                            case 1:
                                matriz[i][j].setIcon(new ImageIcon("imagenes/4.png"));
                                break;
                            case 2:
                                matriz[i][j].setIcon(new ImageIcon("imagenes/7.png"));
                                break;
                            case 3:
                                matriz[i][j].setIcon(new ImageIcon("imagenes/9.png"));
                                break;
                            case 4:
                                matriz[i][j].setIcon(new ImageIcon("imagenes/6.png"));
                                break;
                            case 5:
                                matriz[i][j].setIcon(new ImageIcon("imagenes/8.png"));
                                break;
                            default:
                                matriz[i][j].setIcon(new ImageIcon("imagenes/0.png"));
                                break;
                        }
                    } else if (lab.getActor()[i][j].getCarro() != null) {
                        matriz[i][j].setIcon(new ImageIcon("imagenes/3.png"));
                    } else if (lab.getActor()[i][j].getJugador() != null) {
                        matriz[i][j].setIcon(new ImageIcon("imagenes/1.png"));
                        hayJugador = true;
                    } else if (lab.getActor()[i][j].getObjetivo() != null) {
                        matriz[i][j].setIcon(new ImageIcon("imagenes/10.png"));
                        hayJugador = true;
                    } else {
                        matriz[i][j].setIcon(new ImageIcon("imagenes/0.png"));
                    }
                } else {
                    matriz[i][j].setIcon(new ImageIcon("imagenes/0.png"));
                }

                matriz[i][j].setBounds(120 + (i * 30), 120 + (j * 30), 30, 30);
                matriz[i][j].setVisible(true);
                panelJuego.add(matriz[i][j], 0);
            }
        }

        nombre = new JLabel("JUGADOR: " + jugador);
        nombre.setBounds(20, 20, 150, 30);
        nombre.setForeground(Color.white);
        nombre.setVisible(true);
        panelJuego.add(nombre, 0);

        puntos = 0;
        records = new JLabel("Puntos: ");
        records.setBounds(600, 20, 300, 30);
        records.setVisible(true);
        records.setForeground(Color.white);
        panelJuego.add(records, 0);
        ventana.add(panelJuego);
        if (!hayJugador) {
            jugar();
        }
    }

    public void pintarMatriz() {
        for (int i = 0; i < lab.getActor().length; i++) {
            for (int j = 0; j < lab.getActor()[i].length; j++) {
                if (lab.getActor()[i][j] != null) {
                    if (lab.getActor()[i][j].getObstaculo() != null) {
                        switch (lab.getActor()[i][j].getObstaculo().ordinal()) {
                            case 0:
                                matriz[i][j].setIcon(new ImageIcon("imagenes/5.png"));
                                break;
                            case 1:
                                matriz[i][j].setIcon(new ImageIcon("imagenes/4.png"));
                                break;
                            case 2:
                                matriz[i][j].setIcon(new ImageIcon("imagenes/7.png"));
                                break;
                            case 3:
                                matriz[i][j].setIcon(new ImageIcon("imagenes/9.png"));
                                break;
                            case 4:
                                matriz[i][j].setIcon(new ImageIcon("imagenes/6.png"));
                                break;
                            case 5:
                                matriz[i][j].setIcon(new ImageIcon("imagenes/8.png"));
                                break;
                            default:
                                matriz[i][j].setIcon(new ImageIcon("imagenes/0.png"));
                                break;
                        }
                    } else if (lab.getActor()[i][j].getCarro() != null) {
                        matriz[i][j].setIcon(new ImageIcon("imagenes/3.png"));
                    } else if (lab.getActor()[i][j].getJugador() != null) {
                        matriz[i][j].setIcon(new ImageIcon("imagenes/1.png"));
                    } else if (lab.getActor()[i][j].getObjetivo() != null) {
                        matriz[i][j].setIcon(new ImageIcon("imagenes/10.png"));
                    } else {
                        matriz[i][j].setIcon(new ImageIcon("imagenes/0.png"));
                    }
                } else {
                    matriz[i][j].setIcon(new ImageIcon("imagenes/0.png"));
                }

                matriz[i][j].setBounds(120 + (i * 30), 120 + (j * 30), 30, 30);
                matriz[i][j].setVisible(true);
                panelJuego.add(matriz[i][j], 0);

            }
        }
        panelJuego.add(records, 0);
    }

    public int[][] tablero(int opcion) {

        int[][] aux1 = new int[100][100];
        return aux1;
    }

    public void menu() {

        panelPresentacion.setVisible(false);
        panelMenu = new JPanel();
        panelMenu.setLayout(null);
        panelMenu.setBounds(0, 0, ventana.getWidth(), ventana.getHeight());
        panelMenu.setVisible(true);

        fondoMenu = new JLabel();
        fondoMenu.setBounds(0, 0, ventana.getWidth(), ventana.getHeight());
        imagenFondoMenu = new ImageIcon("imagenes/fondoMenu.png");
        imagenFondoMenu = new ImageIcon(imagenFondoMenu.getImage().getScaledInstance(ventana.getWidth(), ventana.getHeight(), Image.SCALE_DEFAULT));
        fondoMenu.setIcon(imagenFondoMenu);
        fondoMenu.setVisible(true);
        panelMenu.add(fondoMenu, 0);

        botones[0].setText("Jugar");
        botones[1].setText("Instrucciones");
        botones[2].setText("Creditos");
        botones[3].setText("Salir");

        for (int i = 0; i < botones.length; i++) {
            botones[i].setBounds(ventana.getWidth() - (200 + 50), (i + 1) * 50, 200, 40);
            botones[i].setVisible(true);
            botones[i].setBackground(Color.WHITE);
            panelMenu.add(botones[i], 0);
        }

        ventana.add(panelMenu);

    }//fin del menu

    public void eventoMenu() {

        //boton jugar
        botones[0].addMouseListener(new MouseAdapter() {

            public void mousePressed(MouseEvent e) {
                System.out.println("jugar");
                //pedir nombre
                jugador = JOptionPane.showInputDialog(ventana, "Nombre del jugador", "Escribe aqui");
                while (jugador == null || jugador.compareTo("Escribe aqui") == 0 || jugador.compareTo("") == 0) {
                    jugador = JOptionPane.showInputDialog(ventana, "Debes ingresar usuario", "Escribe aqui");
                }
                jugar();

            }

        });

        //boton crear tablero
        botones[1].addMouseListener(new MouseAdapter() {

            public void mousePressed(MouseEvent e) {
                System.out.println("Instrucciones");

            }

        });

        //boton records
        botones[2].addMouseListener(new MouseAdapter() {

            public void mousePressed(MouseEvent e) {
                System.out.println("Creditos");

            }

        });

        //salir
        botones[3].addMouseListener(new MouseAdapter() {

            public void mousePressed(MouseEvent e) {
                System.out.println("SALIR");
                System.exit(0);
            }

        });

    }

    private void inicialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 400, 400);
        //frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lbltamano = new JLabel("Tama�o: ");
        lbltamano.setBounds(10, 31, 60, 14);
        frame.getContentPane().add(lbltamano);
        lbltamano.setVisible(true);
        panelMenu.add(lbltamano, 0);

        txtTamanoX = new JTextField();
        txtTamanoX.setBounds(80, 28, 30, 20);
        frame.getContentPane().add(txtTamanoX);
        txtTamanoX.setColumns(10);
        txtTamanoX.setVisible(true);
        panelMenu.add(txtTamanoX, 0);

        txtTamanoY = new JTextField();
        txtTamanoY.setBounds(110, 28, 30, 20);
        frame.getContentPane().add(txtTamanoY);
        txtTamanoY.setColumns(10);
        txtTamanoY.setVisible(true);
        panelMenu.add(txtTamanoY, 0);

        JLabel lblmonstruos = new JLabel("Monstruos: ");
        lblmonstruos.setBounds(10, 60, 100, 14);
        frame.getContentPane().add(lblmonstruos);
        lblmonstruos.setVisible(true);
        panelMenu.add(lblmonstruos, 0);

        txtpuntosObjetivo = new JTextField();
        txtpuntosObjetivo.setBounds(110, 90, 30, 20);
        frame.getContentPane().add(txtpuntosObjetivo);
        txtpuntosObjetivo.setColumns(10);
        txtpuntosObjetivo.setVisible(true);
        panelMenu.add(txtpuntosObjetivo, 0);

        JLabel lblpuntos = new JLabel("Puntos objetivo: ");
        lblpuntos.setBounds(10, 90, 100, 14);
        frame.getContentPane().add(lblpuntos);
        lblpuntos.setVisible(true);
        panelMenu.add(lblpuntos, 0);

        txtmonstruos = new JTextField();
        txtmonstruos.setBounds(80, 60, 60, 20);
        frame.getContentPane().add(txtmonstruos);
        txtmonstruos.setColumns(10);
        txtmonstruos.setVisible(true);
        panelMenu.add(txtmonstruos, 0);

        JButton btnAgregar = new JButton("Jugar");
        btnAgregar.setBounds(160, 90, 100, 23);
        frame.getContentPane().add(btnAgregar);
        panelMenu.add(btnAgregar, 0);
        btnAgregar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    btnAgregar_Click();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }

            private void btnAgregar_Click() {
                // TODO Auto-generated method stub
                try {
                    jugar();
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(10, 120, 110, 23);
        frame.getContentPane().add(btnGuardar);
        panelMenu.add(btnGuardar, 0);
        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    btnGuardar_Click();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }

            private void btnGuardar_Click() {
                // TODO Auto-generated method stub

            }

        });
    }

}
