package es.EmmaParís.com;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Simulador extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JButton btnMultiproceso;
	private JButton btnMultihilo;
	private TextArea textArea;
	
	 
	public Simulador() {
		initialize();
	}
	

	private void initialize() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 814, 727);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel titulo = new JLabel("Simulador de Estructuras Proteicas");
		titulo.setBounds(198, 11, 391, 21);
		titulo.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		contentPane.add(titulo);
		
		JLabel tituloTipo = new JLabel("Tipo de Proteína");
		tituloTipo.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		tituloTipo.setBounds(198, 56, 139, 14);
		contentPane.add(tituloTipo);
		
		JLabel tituloCantidad = new JLabel("Cantidad");
		tituloCantidad.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		tituloCantidad.setBounds(417, 56, 105, 14);
		contentPane.add(tituloCantidad);
		
		textField_1 = new JTextField();
		textField_1.setBounds(417, 94, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(417, 125, 86, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(417, 156, 86, 20);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(417, 187, 86, 20);
		contentPane.add(textField_4);
		
		btnMultiproceso = new JButton("Simular Multiproceso");
		btnMultiproceso.setBounds(157, 263, 180, 23);
		contentPane.add(btnMultiproceso);
		
		btnMultihilo = new JButton("Simular Multihilo");
		btnMultihilo.setBounds(374, 263, 129, 23);
		contentPane.add(btnMultihilo);
		
		JLabel tituloPrimaria = new JLabel("Primaria (1)");
		tituloPrimaria.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		tituloPrimaria.setBounds(198, 96, 105, 14);
		contentPane.add(tituloPrimaria);
		
		JLabel tituloSecundaria = new JLabel("Secundaria (2)");
		tituloSecundaria.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		tituloSecundaria.setBounds(198, 127, 105, 14);
		contentPane.add(tituloSecundaria);
		
		JLabel tituloTerciaria = new JLabel("Terciaria (3)");
		tituloTerciaria.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		tituloTerciaria.setBounds(198, 158, 105, 14);
		contentPane.add(tituloTerciaria);
		
		JLabel tituloCuarternaria = new JLabel("Cuaternaria (4)");
		tituloCuarternaria.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		tituloCuarternaria.setBounds(198, 189, 105, 14);
		contentPane.add(tituloCuarternaria);
		
		JLabel tituloResult = new JLabel("Resultados");
		tituloResult.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		tituloResult.setBounds(299, 314, 139, 14);
		contentPane.add(tituloResult);
		
		textArea = new TextArea();
		textArea.setBounds(103, 355, 486, 298);
		contentPane.add(textArea);
		
		setVisible(true);
	}
	
	public  JTextField getTextField_1() {
		return textField_1;
	}
	
	public  JTextField getTextField_2() {
		return textField_2;
	}
	
	public  JTextField getTextField_3() {
		return textField_3;
	}
	
	public  JTextField getTextField_4() {
		return textField_4;
	}

	public JButton getBtnMultiproceso() {
		return btnMultiproceso;
	}

	public JButton getBtnMultihilo() {
		return btnMultihilo;
	}

	public TextArea getTextArea() {
		return textArea;
	}
}
