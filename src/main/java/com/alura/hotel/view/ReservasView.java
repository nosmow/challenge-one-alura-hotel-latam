package com.alura.hotel.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.alura.hotel.controller.ReservasController;
import com.alura.hotel.modelo.Reservas;
import com.toedter.calendar.JDateChooser;

/**
 * @version 1.0
 * @author Dainer Cortés
 */
@SuppressWarnings("serial")
public class ReservasView extends JFrame {

	private JPanel contentPane;
	public static JTextField txtValor;
	public static JDateChooser dateFechaEntrada;
	public static JDateChooser dateFechaSalida;
	public static JComboBox<String> txtFormaPago;
	int xMouse, yMouse;
	private JLabel labelExit;
	private JLabel labelAtras;
	
	private ReservasController reservasController;

	/**
	 * Lanza la aplicación.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReservasView frame = new ReservasView();
					frame.setVisible(true);		
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Crea la ventana.
	 */
	public ReservasView() {
		super("Reserva");
		
		this.reservasController = new ReservasController();
				
		setIconImage(Toolkit.getDefaultToolkit().getImage(ReservasView.class.getResource("/imagenes/aH-40px.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 560);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.control);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setUndecorated(true);
		

		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 910, 560);
		contentPane.add(panel);
		panel.setLayout(null);
		
		// Código que crea los elementos de la interfáz gráfica
		
		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setForeground(SystemColor.textHighlight);
		separator_1_2.setBounds(68, 195, 289, 2);
		separator_1_2.setBackground(SystemColor.textHighlight);
		panel.add(separator_1_2);
		
		JSeparator separator_1_3 = new JSeparator();
		separator_1_3.setForeground(SystemColor.textHighlight);
		separator_1_3.setBackground(SystemColor.textHighlight);
		separator_1_3.setBounds(68, 453, 289, 2);
		panel.add(separator_1_3);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setForeground(SystemColor.textHighlight);
		separator_1_1.setBounds(68, 281, 289, 11);
		separator_1_1.setBackground(SystemColor.textHighlight);
		panel.add(separator_1_1);
		
		JLabel lblCheckIn = new JLabel("FECHA DE CHECK IN");
		lblCheckIn.setForeground(SystemColor.textInactiveText);
		lblCheckIn.setBounds(68, 136, 169, 14);
		lblCheckIn.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		panel.add(lblCheckIn);
		
		JLabel lblCheckOut = new JLabel("FECHA DE CHECK OUT");
		lblCheckOut.setForeground(SystemColor.textInactiveText);
		lblCheckOut.setBounds(68, 221, 187, 14);
		lblCheckOut.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		panel.add(lblCheckOut);
		
		JLabel lblFormaPago = new JLabel("FORMA DE PAGO");
		lblFormaPago.setForeground(SystemColor.textInactiveText);
		lblFormaPago.setBounds(68, 382, 187, 24);
		lblFormaPago.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		panel.add(lblFormaPago);
		
		JLabel lblTitulo = new JLabel("SISTEMA DE RESERVAS");
		lblTitulo.setBounds(109, 60, 219, 42);
		lblTitulo.setForeground(new Color(12, 138, 199));
		lblTitulo.setFont(new Font("Roboto", Font.BOLD, 20));
		panel.add(lblTitulo);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(428, 0, 482, 560);
		panel_1.setBackground(new Color(12, 138, 199));
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel logo = new JLabel("");
		logo.setBounds(197, 68, 104, 107);
		panel_1.add(logo);
		logo.setIcon(new ImageIcon(ReservasView.class.getResource("/imagenes/Ha-100px.png")));
		
		JLabel imagenFondo = new JLabel("");
		imagenFondo.setBounds(0, 140, 500, 409);
		panel_1.add(imagenFondo);
		imagenFondo.setBackground(Color.WHITE);
		imagenFondo.setIcon(new ImageIcon(ReservasView.class.getResource("/imagenes/reservas-img-3.png")));
		
		JLabel lblValor = new JLabel("VALOR DE LA RESERVA");
		lblValor.setForeground(SystemColor.textInactiveText);
		lblValor.setBounds(72, 303, 196, 14);
		lblValor.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		panel.add(lblValor);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(SystemColor.textHighlight);
		separator_1.setBounds(68, 362, 289, 2);
		separator_1.setBackground(SystemColor.textHighlight);
		panel.add(separator_1);
												
		// Componentes para dejar la interfaz con estilo Material Design
		final JPanel btnexit = new JPanel();
		btnexit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuPrincipal principal = new MenuPrincipal();
				principal.setVisible(true);
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnexit.setBackground(Color.red);
				labelExit.setForeground(Color.white);
			}			
			@Override
			public void mouseExited(MouseEvent e) {
				 btnexit.setBackground(new Color(12, 138, 199));
			     labelExit.setForeground(Color.white);
			}
		});
		btnexit.setLayout(null);
		btnexit.setBackground(new Color(12, 138, 199));
		btnexit.setBounds(429, 0, 53, 36);
		panel_1.add(btnexit);
		
		labelExit = new JLabel("X");
		labelExit.setForeground(Color.WHITE);
		labelExit.setBounds(0, 0, 53, 36);
		btnexit.add(labelExit);
		labelExit.setHorizontalAlignment(SwingConstants.CENTER);
		labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));
		
		JPanel header = new JPanel();
		header.setBounds(0, 0, 910, 36);
		header.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				headerMouseDragged(e);
			     
			}
		});
		header.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				headerMousePressed(e);
			}
		});
		header.setLayout(null);
		header.setBackground(Color.WHITE);
		panel.add(header);
		
		final JPanel btnAtras = new JPanel();
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuUsuario usuario = new MenuUsuario();
				usuario.setVisible(true);
				dispose();				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAtras.setBackground(new Color(12, 138, 199));
				labelAtras.setForeground(Color.white);
			}			
			@Override
			public void mouseExited(MouseEvent e) {
				 btnAtras.setBackground(Color.white);
			     labelAtras.setForeground(Color.black);
			}
		});
		btnAtras.setLayout(null);
		btnAtras.setBackground(Color.WHITE);
		btnAtras.setBounds(0, 0, 53, 36);
		header.add(btnAtras);
		
		labelAtras = new JLabel("<");
		labelAtras.setBounds(0, 0, 53, 36);
		btnAtras.add(labelAtras);
		labelAtras.setHorizontalAlignment(SwingConstants.CENTER);
		labelAtras.setFont(new Font("Roboto", Font.PLAIN, 23));
		
		JLabel lblSiguiente = new JLabel("SIGUIENTE");
		lblSiguiente.setHorizontalAlignment(SwingConstants.CENTER);
		lblSiguiente.setForeground(Color.WHITE);
		lblSiguiente.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblSiguiente.setBounds(0, 0, 122, 35);		
		
		txtValor = new JTextField();
		txtValor.setBackground(SystemColor.text);
		txtValor.setHorizontalAlignment(SwingConstants.LEFT);
		txtValor.setForeground(Color.BLACK);
		txtValor.setBounds(70, 328, 280, 33);
		txtValor.setEditable(false);
		txtValor.setFont(new Font("Roboto Black", Font.BOLD, 17));
		txtValor.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		panel.add(txtValor);
		txtValor.setColumns(10);
		
		//Campos que guardaremos en la base de datos
		dateFechaEntrada = new JDateChooser();
		dateFechaEntrada.setMinSelectableDate(new Date());
		dateFechaEntrada.getCalendarButton().setBackground(SystemColor.textHighlight);
		dateFechaEntrada.getCalendarButton().setIcon(new ImageIcon(ReservasView.class.getResource("/imagenes/icon-reservas.png")));
		dateFechaEntrada.getCalendarButton().setFont(new Font("Roboto", Font.PLAIN, 12));
		dateFechaEntrada.setBounds(68, 161, 289, 35);
		dateFechaEntrada.getCalendarButton().setBounds(268, 0, 21, 33);
		dateFechaEntrada.setBackground(Color.WHITE);
		dateFechaEntrada.setBorder(new LineBorder(SystemColor.window));
		dateFechaEntrada.setDateFormatString("yyyy-MM-dd");
		dateFechaEntrada.setFont(new Font("Roboto", Font.PLAIN, 18));
		panel.add(dateFechaEntrada);
		dateFechaEntrada.getDateEditor().addPropertyChangeListener(new PropertyChangeListener() {
			
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				txtValor.setText(calcularPrecio().toString());				
			}
		});	

		dateFechaSalida = new JDateChooser();
		dateFechaSalida.setMinSelectableDate(new Date());
		dateFechaSalida.getCalendarButton().setIcon(new ImageIcon(ReservasView.class.getResource("/imagenes/icon-reservas.png")));
		dateFechaSalida.getCalendarButton().setFont(new Font("Roboto", Font.PLAIN, 11));
		dateFechaSalida.setBounds(68, 246, 289, 35);
		dateFechaSalida.getCalendarButton().setBounds(267, 1, 21, 31);
		dateFechaSalida.setBackground(Color.WHITE);
		dateFechaSalida.setFont(new Font("Roboto", Font.PLAIN, 18));
		dateFechaSalida.setDateFormatString("yyyy-MM-dd");
		dateFechaSalida.getCalendarButton().setBackground(SystemColor.textHighlight);
		dateFechaSalida.setBorder(new LineBorder(new Color(255, 255, 255), 0));
		panel.add(dateFechaSalida);
		dateFechaSalida.getDateEditor().addPropertyChangeListener(new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {

				txtValor.setText(calcularPrecio().toString());				
			}
		});
		

		txtFormaPago = new JComboBox();
		txtFormaPago.setBounds(68, 417, 289, 38);
		txtFormaPago.setBackground(SystemColor.text);
		txtFormaPago.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		txtFormaPago.setFont(new Font("Roboto", Font.PLAIN, 16));
		txtFormaPago.setModel(new DefaultComboBoxModel(new String[] {"Tarjeta de Crédito", "Tarjeta de Débito", "Dinero en efectivo"}));
		panel.add(txtFormaPago);

		JButton btnsiguiente = new JButton("Continuar");
		btnsiguiente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Guarda la reserva en la base de datos
				guardar();		
			}						
		});
		btnsiguiente.setLayout(null);
		btnsiguiente.setBackground(SystemColor.textHighlight);
		btnsiguiente.setBounds(238, 493, 122, 35);
		btnsiguiente.setForeground(SystemColor.white);
		btnsiguiente.setBorder(null);
		btnsiguiente.setFont(new Font("Roboto", Font.PLAIN, 16));
		panel.add(btnsiguiente);
		btnsiguiente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
	}
		
	//Código que permite mover la ventana por la pantalla según la posición de "x" y "y"	
	 private void headerMousePressed(java.awt.event.MouseEvent evt) {
	        xMouse = evt.getX();
	        yMouse = evt.getY();
	    }

	 private void headerMouseDragged(java.awt.event.MouseEvent evt) {
	        int x = evt.getXOnScreen();
	        int y = evt.getYOnScreen();
	        this.setLocation(x - xMouse, y - yMouse);
	 }


	/**
	 * Revisa que haya seleccionado alguna fecha
	 * @return
	 */
	private boolean fechasNulas() {
		 return dateFechaEntrada.getDate() != null && dateFechaSalida.getDate() != null;
	 }
	 //Revisa que la fecha de entrada coincida con la de salida

	/**
	 * Revisa que la fecha de salia sea posterior a la fecha de entrada
	 * Si fecha entrada es mayor que fecha salida retorna 1
	 * Si fecha entrada es menor que fecha salida retorna -1
	 * Si fecha entrada es igual que fecha salida retorna 0
	 * @return
	 */
	private boolean fechasCoinciden() {
		 return dateFechaEntrada.getDate().compareTo(dateFechaSalida.getDate()) <= 0 ;
	 }

	/**
	 * Calcular el precio de hospedaje dependiendo de los dias
	 * precio por día $20.000 COP
	 * @return
	 */
	private Float calcularPrecio() {
		 float pagar = 0;
		 try {
			 if (fechasNulas()) {
				 if(fechasCoinciden()) {
					 int dias = (int)((dateFechaSalida.getDate().getTime() - dateFechaEntrada.getDate().getTime()) / 86400000) + 1;				 
					 pagar = dias * 20000;			 
				 }
			 }
		} catch (ArithmeticException e) {
			throw new RuntimeException(e);
		}
		 return pagar;
	 }

	/**
	 * Convierte la fecha a formato compatible con MySQL
	 * @param fecha
	 * @return
	 */
	private java.sql.Date fecha(JDateChooser fecha) {
		 java.sql.Date fechaSQL = new java.sql.Date(fecha.getDate().getTime());
		 
		 return fechaSQL;		 
	 }

	/**
	 * Guarda los datos de la reserva y abre el formulario para registrar el huesped
	 */
	private void guardar() {
		 
		 if (fechasNulas()) {			  
			 if(fechasCoinciden()) {
				 
				 //Da formato a la fecha
				  
				 System.out.println(fecha(dateFechaEntrada));
				 			 
				 //Guarda los datos en el objeto reserva
				 var reserva = new Reservas(
						 fecha(this.dateFechaEntrada), 
						 fecha(this.dateFechaSalida), 
						 String.valueOf(this.txtFormaPago.getSelectedItem()), 
						 Float.valueOf(this.txtValor.getText()));
				 
				 //Envia la reserva a la DB
				 this.reservasController.guardar(reserva);
				 
				 JOptionPane.showMessageDialog(null, "Datos guardados correctamente No reserva: " + reserva.getId());
				 
				 RegistroHuesped registro = new RegistroHuesped(reserva.getId());
				 registro.setVisible(true);
				 dispose();
			 }				
			} else {
				JOptionPane.showMessageDialog(null, "Debes llenar todos los campos.");
			}
	 }
}
