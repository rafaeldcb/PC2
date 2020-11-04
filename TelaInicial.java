package br.com.prog2.trabfinal;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.prog2.dao.ChaleDAO;
import br.com.prog2.dao.HospedagemDAO;
import br.com.prog2.dao.PessoaDAO;
import br.com.prog2.dao.TelofoneDAO;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;

public class TelaInicial extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnCadastrarHospedagem;
	private JButton btnCadastrarChal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		TelofoneDAO telofoneDAO = new TelofoneDAO();
		try {
			telofoneDAO.verificar();
		} catch (Exception e1) {
			
			e1.printStackTrace();
		}
		PessoaDAO pessoaDAO = new PessoaDAO();
		try {
			pessoaDAO.verificar();
		} catch (Exception e1) {
			
			e1.printStackTrace();
		}

		ChaleDAO chaleDAO = new ChaleDAO();
		try {
			chaleDAO.verificar();
		} catch (Exception e1) {
			
			e1.printStackTrace();
		}

		
		HospedagemDAO hospedagemDAO = new HospedagemDAO();
		try {
			hospedagemDAO.verificar();
		} catch (Exception e1) {
			
			e1.printStackTrace();
		}

	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicial frame = new TelaInicial();
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
	public TelaInicial() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 315);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnAo = new JButton("Cliente");
		btnAo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Cliente tela2 = null;
				try {
					tela2 = new Cliente();
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				tela2.setVisible(true);
				tela2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnAo.setBounds(40, 70, 150, 20);
		contentPane.add(btnAo);

		JLabel lblNewLabel = new JLabel("Cadastros");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setBounds(150, 11, 100, 23);
		contentPane.add(lblNewLabel);

		btnCadastrarHospedagem = new JButton("Hospedagem");
		btnCadastrarHospedagem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Hospedagem tela2 = null;
				tela2 = new Hospedagem();
				tela2.setVisible(true);
				tela2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnCadastrarHospedagem.setBounds(200, 70, 150, 20);
		contentPane.add(btnCadastrarHospedagem);

		btnCadastrarChal = new JButton("Chale");
		btnCadastrarChal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Chale tela2 = null;
				tela2 = new Chale();
				tela2.setVisible(true);
				tela2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnCadastrarChal.setBounds(120, 110, 150, 20);
		contentPane.add(btnCadastrarChal);
	}
}
