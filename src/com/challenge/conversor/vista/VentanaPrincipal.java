package com.challenge.conversor.vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.UIManager;

public class VentanaPrincipal extends JFrame implements ActionListener{

	private JPanel panel;
	
	private JButton btnTemperatura;
	private JButton btnMoneda;
	private JButton btnSalir;

	

	
	public VentanaPrincipal() {
		setBackground(new Color(255, 0, 0));
		setBackground(SystemColor.activeCaption);
		getContentPane().setLayout(null);
		
		iniciarComponentes();
		

		
	}
	private void iniciarComponentes() {
		
		panel = new JPanel();		
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setResizable(false);
		setTitle("CONVERSOR");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 400);
		setLocationRelativeTo(null);
		setContentPane(panel);
		panel.setLayout(null);
		
		
		
		JLabel lblTitulo = new JLabel("MENU PRINCIPAL");
		lblTitulo.setForeground(UIManager.getColor("Button.foreground"));
		lblTitulo.setFont(new Font("Arial", Font.PLAIN, 20));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(100, 20, 300, 30);
		panel.add(lblTitulo);
		
		btnTemperatura = new JButton("Conversor De Temperatura");
		btnTemperatura.setHorizontalTextPosition(SwingConstants.CENTER);
		btnTemperatura.setFont(new Font("Arial", Font.ITALIC, 15));
		btnTemperatura.setBackground(Color.WHITE);
		btnTemperatura.setAlignmentX(0.5f);
		btnTemperatura.setBounds(100, 200, 300, 25);
		btnTemperatura.addActionListener(this);
		panel.add(btnTemperatura);
		
		btnMoneda = new JButton("Conversor De Monedas");
		btnMoneda.setFocusPainted(false);
		btnMoneda.setHorizontalTextPosition(SwingConstants.CENTER);
		btnMoneda.setFont(new Font("Arial", Font.ITALIC, 15));
		btnMoneda.setBackground(Color.WHITE);
		btnMoneda.setAlignmentX(0.5f);
		btnMoneda.setBounds(100, 100, 300, 25);
		btnMoneda.addActionListener(this);
		panel.add(btnMoneda);
		
		btnSalir = new JButton("SALIR");
		btnSalir.setBackground(Color.ORANGE);
		btnSalir.setBounds(150, 285, 200, 25);
		btnSalir.addActionListener(this);
		panel.add(btnSalir);
		
		
	}
	public void principal() {
		this.setVisible(true);

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == btnMoneda) {
			VentanaConversorMoneda ventanaMoneda  = new VentanaConversorMoneda(this);
			ventanaMoneda.setVisible(true);
			this.setVisible(false);
			
		}
		if(e.getSource() == btnTemperatura) {
			VentanaConversorTemperatura ventanaTemperatura = new VentanaConversorTemperatura(this);
			ventanaTemperatura.setVisible(true);
			this.setVisible(false);
		}
		if(e.getSource() == btnSalir) {
			this.dispose();
		
		}
		
	}
}
 