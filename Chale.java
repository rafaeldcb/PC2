package br.com.prog2.trabfinal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.prog2.bancodedados.ChaleDTO;
import br.com.prog2.dao.ChaleDAO;
import javax.swing.JTabbedPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Chale extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtLocalizacao;
	private JTextField txtCapacidade;
	private JTextField txtVAT;
	private JTextField txtVBT;
	private JTextField txtIDChale;
	private JTextField txtLocalizacaoa;
	private JTextField txtCapacidadea;
	private JTextField txtVATa;
	private JTextField txtVBTa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Chale frame = new Chale();
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
	public Chale() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 315);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Cadastro", null, panel_2, null);
		
		JLabel lblLocalizao = new JLabel("Localiza\u00E7\u00E3o:");
		
		JLabel lblCapacidade = new JLabel("Capacidade:");
		
		JLabel lblValorEmAlta = new JLabel("Valor em alta temporada:");
		
		JLabel lblValorEmBaixa = new JLabel("Valor em baixa temporada:");
		
		txtLocalizacao = new JTextField();
		txtLocalizacao.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String localizacao = txtLocalizacao.getText();
				String capacidade = txtCapacidade.getText();
				int capacidadei = Integer.parseInt(capacidade);
				String valorAT = txtVAT.getText();
				Double valorATD = Double.parseDouble(valorAT);
				String valorBT = txtVBT.getText();
				Double valorBTD = Double.parseDouble(valorBT);
				ChaleDTO chaleDTO = new ChaleDTO();
				chaleDTO.setLocalizacao(localizacao);
				chaleDTO.setCapacidade(capacidadei);
				chaleDTO.setValorAltaTemporada(valorATD);
				chaleDTO.setValorBaixaTemporada(valorBTD);
				
				ChaleDAO chaleDAO = new ChaleDAO();

				chaleDAO.inserir(chaleDTO);

				JOptionPane.showMessageDialog(null, "Cadastro Realizado com Sucesso");
			}
		});
		
		txtCapacidade = new JTextField();
		txtCapacidade.setColumns(10);
		
		txtVAT = new JTextField();
		txtVAT.setColumns(10);
		
		txtVBT = new JTextField();
		txtVBT.setColumns(10);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(lblLocalizao)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtLocalizacao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(lblCapacidade)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtCapacidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(lblValorEmAlta)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtVAT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(lblValorEmBaixa)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtVBT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(286, Short.MAX_VALUE))
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap(405, Short.MAX_VALUE)
					.addComponent(btnCadastrar)
					.addGap(43))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(23)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLocalizao)
						.addComponent(txtLocalizacao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCapacidade)
						.addComponent(txtCapacidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblValorEmAlta)
						.addComponent(txtVAT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblValorEmBaixa)
						.addComponent(txtVBT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
					.addComponent(btnCadastrar)
					.addContainerGap())
		);
		panel_2.setLayout(gl_panel_2);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Atualizar", null, panel, null);
		
		JLabel lblCodigoDoChale = new JLabel("Codigo do Chale:");
		
		JLabel lblLocalizacao = new JLabel("Localizacao:");
		
		JLabel lblCapacidade_1 = new JLabel("Capacidade:");
		
		JLabel lblValorEmAlta_1 = new JLabel("Valor em alta temporada:");
		
		JLabel lblValorEmBaixa_1 = new JLabel("Valor em baixa temporada:");
		
		txtIDChale = new JTextField();
		txtIDChale.setColumns(10);
		
		txtLocalizacaoa = new JTextField();
		txtLocalizacaoa.setText("");
		txtLocalizacaoa.setColumns(10);
		
		txtCapacidadea = new JTextField();
		txtCapacidadea.setText("");
		txtCapacidadea.setColumns(10);
		
		txtVATa = new JTextField();
		txtVATa.setColumns(10);
		
		txtVBTa = new JTextField();
		txtVBTa.setColumns(10);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String idChalea = txtIDChale.getText();
				String localizacaoa = txtLocalizacaoa.getText();
				String capacidadea = txtCapacidadea.getText();
				int capacidadei = Integer.parseInt(capacidadea);
				String valorATa = txtVATa.getText();
				Double valorATDa = Double.parseDouble(valorATa);
				String valorBTa = txtVBT.getText();
				Double valorBTDa = Double.parseDouble(valorBTa);
				int aidChale = Integer.parseInt(idChalea);
				ChaleDTO chaleDTO = new ChaleDTO();
				chaleDTO.setId_chale(aidChale);
				chaleDTO.setLocalizacao(localizacaoa);
				chaleDTO.setCapacidade(capacidadei);
				chaleDTO.setValorAltaTemporada(valorATDa);
				chaleDTO.setValorBaixaTemporada(valorBTDa);
				ChaleDAO chaleDAO = new ChaleDAO();
				chaleDAO.atualizar(chaleDTO);
				JOptionPane.showMessageDialog(null,"Cadastro atualizado com sucesso");
			}
		});
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String remover = txtIDChale.getText();
				int id = Integer.parseInt(remover);

				ChaleDAO chaleDAO = new ChaleDAO();
				try {
					chaleDAO.remover(id);
				} catch (ClassNotFoundException | SQLException e1) {

					e1.printStackTrace();
				}
				
				JOptionPane.showMessageDialog(null, "Cliente Removido com Sucesso");
			}
		});
		
		JLabel lblParaRemoverDigite = new JLabel("Para remover digite o codigo do chale");
		
		JLabel lblEPrecioneO = new JLabel("e precione o bot\u00E3o remover");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblLocalizacao)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtLocalizacaoa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 149, Short.MAX_VALUE)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
									.addComponent(lblParaRemoverDigite)
									.addGap(20))
								.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
									.addComponent(lblEPrecioneO)
									.addGap(51))))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblCapacidade_1)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(txtCapacidadea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblValorEmAlta_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtVATa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblValorEmBaixa_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtVBTa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addContainerGap(286, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addComponent(lblCodigoDoChale)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtIDChale, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 179, Short.MAX_VALUE)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(btnAtualizar)
								.addComponent(btnRemover))
							.addGap(79))))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCodigoDoChale)
								.addComponent(txtIDChale, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblLocalizacao)
								.addComponent(txtLocalizacaoa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCapacidade_1)
								.addComponent(txtCapacidadea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblValorEmAlta_1)
								.addComponent(txtVATa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblValorEmBaixa_1)
								.addComponent(txtVBTa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(btnRemover)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblParaRemoverDigite)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblEPrecioneO)))
					.addPreferredGap(ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
					.addComponent(btnAtualizar)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
	}

}
