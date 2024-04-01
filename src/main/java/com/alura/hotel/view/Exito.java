package com.alura.hotel.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Toolkit;

/**
 * @version 1.0
 * @author Dainer Cortés
 */
@SuppressWarnings("serial")
public class Exito extends JDialog {

	private JFrame frameAbierto;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Lanza la aplicación.
	 */
	public static void main(String[] args) {
		try {
			Exito dialog = new Exito(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Crea la ventana.
	 */
	public Exito(JFrame frame) {

		frameAbierto = frame;

		setIconImage(Toolkit.getDefaultToolkit().getImage(Exito.class.getResource("/imagenes/aH-40px.png")));
		setBounds(100, 100, 394, 226);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.control);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setLocationRelativeTo(null);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(Exito.class.getResource("/imagenes/Ha-100px.png")));
			lblNewLabel.setBounds(123, 11, 100, 100);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Datos guardados satisfactoriamente");
			lblNewLabel_1.setForeground(new Color (12, 138, 199));
			lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 18));
			lblNewLabel_1.setBounds(27, 122, 322, 21);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						abrirVentanaUsuario();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						abrirVentanaUsuario();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
				getRootPane().setDefaultButton(cancelButton);
			}
		}
	}

	/**
	 * Devuelve al usuario al menu de usuario
	 */
	private void abrirVentanaUsuario() {
		MenuUsuario usuario = new MenuUsuario();
		frameAbierto.dispose();
		usuario.setVisible(true);
		dispose();
	}

}
