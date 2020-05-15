package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ExecController;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JFileChooser;

public class Tela extends JFrame {

	private JPanel contentPane;
	private JTextField textField1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela frame = new Tela();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Tela() {
		setTitle("Executar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 452, 229);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Ok");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ExecController ec = new ExecController();
				String s = textField1.getText();
				dispose();
				ec.executaComando(s);
			}
		});
		btnNewButton.setBounds(88, 139, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(203, 139, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				int i= fileChooser.showSaveDialog(null);
				if (i==1){
					textField1.setText("");
				} else {
					File arquivo = fileChooser.getSelectedFile();
					textField1.setText(arquivo.getPath());
				}
			}
		});
		btnProcurar.setBounds(318, 139, 89, 23);
		contentPane.add(btnProcurar);
		
		textField1 = new JTextField();
		textField1.setBounds(88, 79, 319, 20);
		contentPane.add(textField1);
		textField1.setColumns(10);
		
		JLabel lblDigiteOCaminho = new JLabel("Digite o caminho do execut\u00E1vel ou clique em procurar.");
		lblDigiteOCaminho.setBounds(88, 31, 319, 14);
		contentPane.add(lblDigiteOCaminho);
	}
}
