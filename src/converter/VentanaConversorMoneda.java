package converter;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;

public class VentanaConversorMoneda extends JFrame {

	private JPanel contentPane;

	
	 
	public VentanaConversorMoneda() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblConversorDeMonedas = new JLabel("Conversor De Monedas");
		lblConversorDeMonedas.setBounds(134, 10, 165, 24);
		lblConversorDeMonedas.setHorizontalAlignment(SwingConstants.CENTER);
		lblConversorDeMonedas.setForeground(Color.BLACK);
		lblConversorDeMonedas.setFont(new Font("Arial", Font.PLAIN, 20));
		contentPane.add(lblConversorDeMonedas);
	}

}
