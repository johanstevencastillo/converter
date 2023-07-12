package converter;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.SystemColor;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Component;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.ComponentOrientation;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

public class VentanaPrincipal extends JFrame implements ActionListener{

	private JPanel contentPane;
	
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
		
		contentPane = new JPanel();		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setResizable(false);
		setTitle("CONVERSOR");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 400);
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JLabel lblTitulo = new JLabel("MENU PRINCIPAL");
		lblTitulo.setForeground(UIManager.getColor("Button.foreground"));
		lblTitulo.setFont(new Font("Arial", Font.PLAIN, 20));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(100, 20, 300, 30);
		contentPane.add(lblTitulo);
		
		btnTemperatura = new JButton("Conversor De Temperatura");
		btnTemperatura.setHorizontalTextPosition(SwingConstants.CENTER);
		btnTemperatura.setFont(new Font("Arial", Font.ITALIC, 15));
		btnTemperatura.setBackground(Color.WHITE);
		btnTemperatura.setAlignmentX(0.5f);
		btnTemperatura.setBounds(100, 200, 300, 25);
		btnTemperatura.addActionListener(this);
		contentPane.add(btnTemperatura);
		
		btnMoneda = new JButton("Conversor De Monedas");
		btnMoneda.setFocusPainted(false);
		btnMoneda.setHorizontalTextPosition(SwingConstants.CENTER);
		btnMoneda.setFont(new Font("Arial", Font.ITALIC, 15));
		btnMoneda.setBackground(Color.WHITE);
		btnMoneda.setAlignmentX(0.5f);
		btnMoneda.setBounds(100, 100, 300, 25);
		btnMoneda.addActionListener(this);
		contentPane.add(btnMoneda);
		
		btnSalir = new JButton("SALIR");
		btnSalir.setBackground(Color.ORANGE);
		btnSalir.setBounds(150, 285, 200, 25);
		btnSalir.addActionListener(this);
		contentPane.add(btnSalir);
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnMoneda) {
			VentanaConversorMoneda ventanaMoneda  = new VentanaConversorMoneda();
			ventanaMoneda.setVisible(true);
			this.dispose();
			
		}
		
	}
}
 