package Vista;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.border.LineBorder;

import org.eclipse.swt.widgets.MessageBox;

import Controlador.Controlador;
import Modelo.Actor;
import Modelo.Laberinto;

import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;

/**
 * Formulario de inicio del juego, se define tamaño, monstruos, objetivos, etc
 */
public class Registro {
	private JFrame frame = new JFrame();
	private JTextField txtTamanoX;
	private JTextField txtTamanoY;
	private JTextField txtmonstruos;

	Controlador controller;

	/**
	 * Constructor básico, encargado de inicializar loc componentes de la vista
	 * */
	public Registro(Controlador laberinto) {
		inicialize();
		this.controller = laberinto;
	}

	/**
	 * Metodo encargado de hacer visible la vista de registro
	 * */
	public void open() {
		try {		
			frame.setVisible(true);
		}catch (Exception e) {
			System.out.println("Error Registro Open: " + e.getMessage()); 
		}
	}

	/**
	 * Metodo encargado de inicializar el laberinto
	 * @throws Exception 
	 * */
	private void btnGuardar_Click() throws Exception {
		int tamanox = Integer.parseInt(this.txtTamanoX.getText());		
		int tamanoy = Integer.parseInt(this.txtTamanoY.getText());
		int monstruos = Integer.parseInt(this.txtmonstruos.getText());

		//La cantidad de monstruos no puede superar el 70% de las casillas en el tablero
		if (monstruos>((tamanox*tamanoy)*0.3)) {
			JOptionPane.showMessageDialog(null, "Está excediendo la cantidad máxima de monstruos","Error", JOptionPane.WARNING_MESSAGE);
		}else {
			Actor[][] actor = new Actor[tamanox][tamanoy];
			this.controller.setLaberinto(new Laberinto(0,actor,null));
			this.controller.getLaberinto().ConfigurarTablero(monstruos);
		}
	}

	/**
	 * Metodo encargado de generar los componentes básicos del formulario
	 * */
	private void inicialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 400, 400);
		//frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);        

		//Controles encargados de definir el tamaño del tablero
		JLabel lbltamano = new JLabel("Tamaño: ");
		lbltamano.setBounds(10, 31, 60, 14);
		frame.getContentPane().add(lbltamano);

		txtTamanoX = new JTextField();
		txtTamanoX.setBounds(80, 28, 30, 20);
		frame.getContentPane().add(txtTamanoX);
		txtTamanoX.setColumns(10);

		txtTamanoY = new JTextField();
		txtTamanoY.setBounds(110, 28, 30, 20);
		frame.getContentPane().add(txtTamanoY);
		txtTamanoY.setColumns(10);         

		//Controles encargados de la configuración de los monstruos
		JLabel lblmonstruos = new JLabel("Monstruos: ");
		lblmonstruos.setBounds(10, 60, 100, 14);
		frame.getContentPane().add(lblmonstruos);

		txtmonstruos = new JTextField();
		txtmonstruos.setBounds(80, 60, 60, 20);
		frame.getContentPane().add(txtmonstruos);
		txtmonstruos.setColumns(10);

		JButton btnGuardar = new JButton("Guardar");        
		btnGuardar.setBounds(10, 85, 110, 23);
		frame.getContentPane().add(btnGuardar);
		btnGuardar.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {			
				try {
					btnGuardar_Click();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}			
		});
	}
}
