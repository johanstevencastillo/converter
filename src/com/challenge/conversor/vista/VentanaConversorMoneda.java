package com.challenge.conversor.vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import com.challenge.conversor.controlador.Convertidor;
import com.challenge.conversor.controlador.MiException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.UIManager;

public class VentanaConversorMoneda extends JFrame implements ActionListener{
	private VentanaPrincipal ventanaPrincipal;
	private JPanel panel;
	private JTextField txtInput;
	private JComboBox <String> comboBoxFrom , comboBoxTo;
	private JButton btnConvertir , btnAtras;

	
	 
	public VentanaConversorMoneda(VentanaPrincipal ventanaPrincipal) {
		this.ventanaPrincipal = ventanaPrincipal;
		setResizable(false);
		setSize(500, 300);
		setTitle("CONVERSOR DE DIVISAS");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		iniciarComponentes();
		
		
	}
	private void iniciarComponentes() {
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Ingrese la cantidad a convertir");
		lblTitulo.setBounds(50, 20, 400, 20);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setForeground(Color.BLACK);
		lblTitulo.setFont(new Font("Arial", Font.PLAIN, 20));
		panel.add(lblTitulo);
		
		comboBoxFrom = new JComboBox<String>();
		comboBoxFrom.setToolTipText("");
		comboBoxFrom.setModel(new DefaultComboBoxModel<String>(new String[] {"USD", "COP" , "EUR" , "GBP" , "JPY" , "KRW"}));
		comboBoxFrom.setBounds(100, 100, 100, 22);
		comboBoxFrom.addActionListener(this);
		panel.add(comboBoxFrom);
		
		JLabel lblNewLabel = new JLabel(" De :");
		lblNewLabel.setBounds(50, 100, 50, 20);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(" A  :");
		lblNewLabel_1.setBounds(250, 100, 50, 20);
		panel.add(lblNewLabel_1);
		
		comboBoxTo = new JComboBox<String>();
		comboBoxTo.setToolTipText("");
		comboBoxTo.setModel(new DefaultComboBoxModel<String>(new String[] {"USD", "COP" , "EUR" , "GBP" , "JPY" , "KRW"}));
		comboBoxTo.setBounds(300, 100, 103, 22);
		panel.add(comboBoxTo);
		
		txtInput = new JTextField();
		txtInput.setBounds(150, 60, 200, 20);
		panel.add(txtInput);		
		txtInput.setColumns(10);
		txtInput.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				validarInput();				
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				validarInput();				
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				validarInput();
			}
		});
		
		btnConvertir = new JButton("Convertir");
		btnConvertir.setBackground(UIManager.getColor("Button.focus"));
		btnConvertir.setBounds(150, 160, 200, 20);
		btnConvertir.addActionListener(this);
		btnConvertir.setEnabled(false);
		panel.add(btnConvertir);
		
		btnAtras = new JButton("Menu Principal");
		btnAtras.setBackground(UIManager.getColor("CheckBox.interiorBackground"));
		btnAtras.setBounds(150, 220, 200, 20);
		btnAtras.addActionListener(this);
		panel.add(btnAtras);
	}
	public void validarInput() {
		String text = txtInput.getText();

		
		try {
			validarEntero(text);
			txtInput.setForeground(Color.BLACK);
			btnConvertir.setEnabled(true);

		} catch (NumberFormatException ex) {
			try {
				validarDouble(text);
				txtInput.setForeground(Color.BLACK);
				btnConvertir.setEnabled(true);
			} catch (NumberFormatException e) {
				btnConvertir.setEnabled(false);
				txtInput.setForeground(Color.RED);
			}

		}finally {
			try {
				verificarNumero(text);
				txtInput.setForeground(Color.BLACK);
				btnConvertir.setEnabled(true);
			} catch (Exception e) {
				btnConvertir.setEnabled(false);
				txtInput.setForeground(Color.RED);
			}
		}

		
				
	}
	private static void validarEntero(String texto) throws NumberFormatException  {
        int entero = Integer.parseInt(texto);
    }

    private static void validarDouble(String texto) throws NumberFormatException {
        double numero = Double.parseDouble(texto);
    }
    public static void verificarNumero(String texto) throws MiException {
    	double numero = Double.parseDouble(texto);
        if (numero <= 0) {
            throw new MiException("El número es menor a cero");
        }
    }
    
    
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnConvertir ) {			
			double cantidad = Double.parseDouble(txtInput.getText());
			String monedaInicial = (String) comboBoxFrom.getSelectedItem();
			String monedaFinal = (String) comboBoxTo.getSelectedItem();
			Convertidor convertidor = new Convertidor();			
			String resultado = convertidor.convertirMoneda(monedaInicial, monedaFinal, cantidad);
			JOptionPane.showMessageDialog(null, cantidad + " "+monedaInicial +" equivalen a " + resultado+" "+ monedaFinal , monedaInicial+ " to " + monedaFinal, JOptionPane.INFORMATION_MESSAGE);
			txtInput.setText(" ");
		}
		if(e.getSource() == btnAtras) {
			
			ventanaPrincipal.principal();
			dispose();
		}
	}
}
