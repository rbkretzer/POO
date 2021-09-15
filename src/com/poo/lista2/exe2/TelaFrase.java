package com.poo.lista2.exe2;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TelaFrase {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaFrase window = new TelaFrase();
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
	public TelaFrase() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 491, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 73, 455, 177);
		frame.getContentPane().add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setEditable(false);
		
		JLabel lblNewLabel = new JLabel("Digite uma frase:");
		lblNewLabel.setBounds(10, 11, 121, 14);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(126, 8, 339, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnSeparar = new JButton("Separar");
		btnSeparar.setBounds(376, 39, 89, 23);
		btnSeparar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frase f = new Frase(textField.getText());
				String[] vetorStr = f.separarFrase();
				String palavra;
				textArea.setText("Frase a ser separada: " + f.getFrase());
				for (int i = 0; i < vetorStr.length; i++) {
					palavra = vetorStr[i];
					textArea.append("\n"+palavra+" - "+palavra.length());
				}
			}
		});
		frame.getContentPane().add(btnSeparar);
	}
}
