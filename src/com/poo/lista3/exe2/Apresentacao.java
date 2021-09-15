package com.poo.lista3.exe2;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Apresentacao {

	private JFrame frame;
	private JTextField tfTitulo;
	private JTextField tfAutor;
	private JTextField tfNome;
	private JTextField tfData;
	private DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
	private JTextField tfTituloConsulta;
	private JTextArea taConteudo;
	private HashMap<String, Obra> obras = new HashMap<>();
	private Obra obraAtual = new Obra();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Apresentacao window = new Apresentacao();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Apresentacao() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 366);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("T\u00EDtulo da obra:");
		lblNewLabel.setBounds(10, 11, 102, 14);
		frame.getContentPane().add(lblNewLabel);
		
		tfTitulo = new JTextField();
		tfTitulo.setBounds(115, 8, 218, 20);
		frame.getContentPane().add(tfTitulo);
		tfTitulo.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Autor:");
		lblNewLabel_1.setBounds(10, 36, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		tfAutor = new JTextField();
		tfAutor.setBounds(115, 36, 218, 20);
		frame.getContentPane().add(tfAutor);
		tfAutor.setColumns(10);
		
		JButton btnCadastrarObra = new JButton("OK");
		btnCadastrarObra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (podeAdicionarObra()) {
					obraAtual.setTitulo(tfTitulo.getText());
					obraAtual.setAutor(tfAutor.getText());
					obras.put(tfTitulo.getText(), obraAtual);
					tfNome.setEnabled(true);
					tfData.setEnabled(true);
					taConteudo.setEnabled(true);
					JOptionPane.showMessageDialog(null, "Obra adicionada.");
				};
			}

		});
		
		btnCadastrarObra.setBounds(343, 35, 81, 23);
		frame.getContentPane().add(btnCadastrarObra);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 72, 414, 2);
		frame.getContentPane().add(separator);
		
		JLabel lblNewLabel_2 = new JLabel("Nome do parecerista:");
		lblNewLabel_2.setBounds(10, 94, 121, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		tfNome = new JTextField();
		tfNome.setEnabled(false);
		tfNome.setBounds(129, 91, 204, 20);
		frame.getContentPane().add(tfNome);
		tfNome.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Data:");
		lblNewLabel_3.setBounds(10, 119, 46, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		tfData = new JTextField();
		tfData.setEnabled(false);
		tfData.setBounds(129, 119, 86, 20);
		frame.getContentPane().add(tfData);
		tfData.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Conte\u00FAdo do parecer:");
		lblNewLabel_4.setBounds(10, 153, 121, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 171, 323, 63);
		frame.getContentPane().add(scrollPane);
		
		taConteudo.setEnabled(false);
		scrollPane.setViewportView(taConteudo);
		
		JButton btnInserir = new JButton("Inserir");
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Parecer p = new Parecer(tfNome.getText(), LocalDate.parse(tfData.getText(), formatador), taConteudo.getText());
				obraAtual.addParecer(p);
			}
		});
		btnInserir.setBounds(343, 211, 89, 23);
		frame.getContentPane().add(btnInserir);
		
		JLabel lblNewLabel_5 = new JLabel("T\u00EDtulo a consultar:");
		lblNewLabel_5.setBounds(10, 276, 102, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		tfTituloConsulta = new JTextField();
		tfTituloConsulta.setBounds(115, 273, 149, 20);
		frame.getContentPane().add(tfTituloConsulta);
		tfTituloConsulta.setColumns(10);
		
		JButton btnNewButton = new JButton("Consultar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Obra obraPesq = obras.get(tfTituloConsulta.getText());
				String msg;
				if (obraPesq == null) {
					msg = "Título não encontrado.";
				} else {
					msg = "Obra: " + obraPesq.getTitulo() 
					   +"\nAutor: " + obraPesq.getAutor()
					   +"\nPareceres: " + obraPesq.exibirPareceres();
				}
				JOptionPane.showMessageDialog(null, msg);
			}
		});
		btnNewButton.setBounds(278, 272, 89, 23);
		frame.getContentPane().add(btnNewButton);
	}
	
	private boolean podeAdicionarObra() {
		if (tfAutor.getText().isBlank() || tfAutor.getText().isBlank()) {
			JOptionPane.showMessageDialog(null, "Campo autor não preenchido.");
			return false;
		}
		
		if (tfTitulo.getText().isEmpty() || tfTitulo.getText().isBlank()) {
			JOptionPane.showMessageDialog(null, "Campo título não preenchido.");
			return false;
		}
		return true;
		
	}
}
