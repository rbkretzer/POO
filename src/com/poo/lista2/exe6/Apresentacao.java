package com.poo.lista2.exe6;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Apresentacao {

	private JFrame frame;
	private JTextField tfTamanho;
	private JTextField tfValor;
	private JTextField tfPosicao;
	private VetorDeReais vetor;
	private VetorDeReais outroVetor;

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
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 117, 414, 99);
		frame.getContentPane().add(textArea);
		
		JLabel lblTamanhoVetor = new JLabel("Tamanho do vetor: ");
		lblTamanhoVetor.setBounds(10, 11, 128, 14);
		frame.getContentPane().add(lblTamanhoVetor);
		
		tfTamanho = new JTextField();
		tfTamanho.setBounds(136, 8, 145, 20);
		frame.getContentPane().add(tfTamanho);
		tfTamanho.setColumns(10);
		
		JButton btnCriarVetor = new JButton("Criar o vetor");
		btnCriarVetor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vetor = new VetorDeReais(Integer.parseInt(tfTamanho.getText()));
			}
		});
		btnCriarVetor.setBounds(307, 7, 117, 23);
		frame.getContentPane().add(btnCriarVetor);
		
		JLabel lblValor = new JLabel("Valor:");
		lblValor.setBounds(10, 58, 58, 14);
		frame.getContentPane().add(lblValor);
		
		tfValor = new JTextField();
		tfValor.setBounds(51, 55, 117, 20);
		frame.getContentPane().add(tfValor);
		tfValor.setColumns(10);
		
		JLabel lblPosicao = new JLabel("Posi\u00E7\u00E3o:");
		lblPosicao.setBounds(180, 58, 58, 14);
		frame.getContentPane().add(lblPosicao);
		
		JButton btnAdiconarValor = new JButton("Adicionar");
		btnAdiconarValor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tfPosicao.getText().isBlank()) {
					JOptionPane.showMessageDialog(frame, "Posição é obrigatório.");
					return;
				}
				if (tfValor.getText().isBlank()) {
					JOptionPane.showMessageDialog(frame, "Valor é obrigatório.");
					return;
				}
				int posicao = Integer.parseInt(tfPosicao.getText());
				if (podeAdicionar(posicao)) {
					vetor.addValor(Double.parseDouble(tfValor.getText()), posicao);
				}
			}
		});
		btnAdiconarValor.setBounds(331, 54, 93, 23);
		frame.getContentPane().add(btnAdiconarValor);
		
		tfPosicao = new JTextField();
		tfPosicao.setBounds(243, 55, 78, 20);
		frame.getContentPane().add(tfPosicao);
		tfPosicao.setColumns(10);
		
		JButton btnCountPares = new JButton("Contar pares");
		btnCountPares.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("A quantidade de pares é " + vetor.countPairs());
			}
		});
		btnCountPares.setBounds(10, 83, 145, 23);
		frame.getContentPane().add(btnCountPares);
		
		JButton btnInverter = new JButton("Inverter");
		btnInverter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("Inversão do vetor:\n");
				textArea.append((String.format("\nO vetor antes: %s", vetor.getValues())));
				vetor.inverte();
				textArea.append((String.format("\nO vetor depois: %s", vetor.getValues())));
			}
		});
		btnInverter.setBounds(165, 83, 108, 23);
		frame.getContentPane().add(btnInverter);
		
		JButton btnDiferenca = new JButton("Maior diferenca");
		btnDiferenca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("A moir diferença é de " + vetor.getMaiorDiferencaConsecutivo());
			}
		});
		btnDiferenca.setBounds(283, 83, 141, 23);
		frame.getContentPane().add(btnDiferenca);
		
		JButton btnMultiplicacao = new JButton("Multiplicar vetores");
		btnMultiplicacao.setBounds(136, 227, 141, 23);
		frame.getContentPane().add(btnMultiplicacao);
		
		JButton btnNewButton = new JButton("Dividir vetores");
		btnNewButton.setBounds(10, 227, 122, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnMultiplicacao_1 = new JButton("Guardar vetor");
		btnMultiplicacao_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				outroVetor = vetor;
			}
		});
		btnMultiplicacao_1.setBounds(283, 227, 141, 23);
		frame.getContentPane().add(btnMultiplicacao_1);
	}
	
	public boolean podeAdicionar(int posicao) {
		if (!temVetor()) {
			return false;
		}
		if (posicao >= vetor.getTamanho()) {			
			JOptionPane.showMessageDialog(frame, "Não é possível adicionar valor pois posição é maior que o vetor");
			return false;
		}
		return true;
	}
	
	public boolean temVetor() {
		if (vetor == null) {			
			JOptionPane.showMessageDialog(frame, "Não é possível adicionar valor com um vetor vazio");
			return false;
		}
		return true;
	}
}
