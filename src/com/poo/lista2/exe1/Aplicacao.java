package com.poo.lista2.exe1;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Aplicacao {

	private JFrame frame;
	private JTextField nome;
	private JTextField cpf;
	private JTextField uf;
	private JTextField rendaAnual;
	private JTextField tfConsultaByImposto;
	private JTextField tfConsultaCPF;
	private HashMap<String, Contribuinte> contribs = new HashMap<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Aplicacao window = new Aplicacao();
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
	public Aplicacao() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 486, 351);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		nome = new JTextField();
		nome.setBounds(168, 8, 296, 20);
		frame.getContentPane().add(nome);
		nome.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nome do contribuinte:");
		lblNewLabel.setBounds(10, 14, 148, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("CPF:");
		lblNewLabel_1.setBounds(10, 39, 48, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		cpf = new JTextField();
		cpf.setBounds(168, 33, 108, 20);
		frame.getContentPane().add(cpf);
		cpf.setColumns(10);
		
		uf = new JTextField();
		uf.setBounds(168, 58, 32, 20);
		frame.getContentPane().add(uf);
		uf.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Estado (UF):");
		lblNewLabel_2.setBounds(10, 64, 115, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Renda anual: ");
		lblNewLabel_3.setBounds(10, 89, 115, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		rendaAnual = new JTextField();
		rendaAnual.setBounds(168, 83, 96, 20);
		frame.getContentPane().add(rendaAnual);
		rendaAnual.setColumns(10);
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.setBounds(368, 85, 96, 23);
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (contribs.containsKey(cpf.getText())) {
					JOptionPane.showMessageDialog(null, "CPF já existente.");
				} else {					
					Contribuinte c = new Contribuinte(nome.getText(), cpf.getText(), uf.getText(), Double.parseDouble(rendaAnual.getText()));
					contribs.put(cpf.getText(), c);
					JOptionPane.showMessageDialog(null, String.format("%s pagará R$: %s" , c.getNome(), c.getImpostoAPagar()));
				}
			}
		});
		frame.getContentPane().add(btnCalcular);
		
		JLabel lblNewLabel_4 = new JLabel("Valor do imposto a consultar (R$):");
		lblNewLabel_4.setBounds(10, 221, 226, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		tfConsultaByImposto = new JTextField();
		tfConsultaByImposto.setBounds(246, 218, 96, 20);
		frame.getContentPane().add(tfConsultaByImposto);
		tfConsultaByImposto.setColumns(10);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(352, 217, 112, 23);
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (Contribuinte c : contribs.values()) {
					double valor = Double.parseDouble(tfConsultaByImposto.getText());
					if (valor <= c.getImpostoAPagar()) {
						String msg  = "Contribuinte " + c.getNome()
								  + "\nCPF: " + c.getCpf()
								  + "\nUF: " +c.getUf()
								  + "\nRenda anual: " +c.getRendaAnual()
								  + "\nImposto a pagar: " +c.getImpostoAPagar();
						JOptionPane.showMessageDialog(null, msg);
					}
				}
			}
		});
		frame.getContentPane().add(btnConsultar);
		
		tfConsultaCPF = new JTextField();
		tfConsultaCPF.setBounds(207, 244, 108, 20);
		frame.getContentPane().add(tfConsultaCPF);
		tfConsultaCPF.setColumns(10);

		JButton btnConsultaContribuinteByCpf = new JButton("Consultar CPF");
		btnConsultaContribuinteByCpf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cpfConsultado = tfConsultaCPF.getText();
				Contribuinte c = contribs.get(cpfConsultado);
				String msg = "";
				if (c != null) {
					msg = "Contribuinte " + c.getNome()
					  + "\nCPF: " + c.getCpf()
					  + "\nUF: " +c.getUf()
					  + "\nRenda anual: " +c.getRendaAnual()
					  + "\nImposto a pagar: " +c.getImpostoAPagar();
				} else {
					msg = "CPF não localizado: " + cpfConsultado;
				}
				JOptionPane.showMessageDialog(null, msg);
			}
		});
		btnConsultaContribuinteByCpf.setBounds(326, 243, 138, 23);
		frame.getContentPane().add(btnConsultaContribuinteByCpf);
		
		
		JLabel lblConsultaCPF = new JLabel("CPF do contribuinte:");
		lblConsultaCPF.setBounds(10, 246, 160, 14);
		frame.getContentPane().add(lblConsultaCPF);
		
		JButton btnPercentualEstados = new JButton("% tribut\u00E1rio dos estados");
		btnPercentualEstados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HashMap<String,Double> estados = new HashMap<>();
				for(Contribuinte c : contribs.values()) {
					double imposto = c.getImpostoAPagar();
					Double valor = estados.get(c.getUf());
					double total = 0;
					if (valor == null) {
						valor = imposto;
					} else {
						total = valor.doubleValue() + imposto;
					}
					estados.put(c.getUf(), total);
				}
			}
		});
		btnPercentualEstados.setBounds(132, 147, 213, 23);
		frame.getContentPane().add(btnPercentualEstados);
	}
}
