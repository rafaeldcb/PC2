package br.com.prog2.trabfinal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import br.com.prog2.bancodedados.PessoaDTO;
import br.com.prog2.bancodedados.TelefoneDTO;
import br.com.prog2.dao.PessoaDAO;
import br.com.prog2.dao.TelofoneDAO;

import javax.swing.JTabbedPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JFormattedTextField;
import javax.swing.JRadioButton;

public class Cliente extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtEndereco;
	private JTextField txtRG;
	private JTextField txtCidade;
	private JTextField txtEstado;
	private JTextField txtBairro;
	private JLabel lblNome;
	private JLabel lblEndereo;
	private JLabel lblRg;
	private JLabel lblBairro;
	private JLabel lblCidade;
	private JLabel lblEstado;
	private JFormattedTextField txtDataDeNascimento;
	private JFormattedTextField txtCEP;
	private JLabel lblDataDeNascimento;
	private JLabel lblNewLabel;
	private JLabel lblTelefone;
	private JFormattedTextField txtTelefone;
	private JLabel txtRemover;
	private JTextField txtRemoverCliente;
	private JButton btnConsultar;
	private JLabel lblNome_1;
	private JTextField txtANome;
	private JLabel lblRg_1;
	private JTextField txtARG;
	private JLabel lblDataDeNascimento_1;
	private JFormattedTextField txtADataDeNascimento;
	private JLabel lblTelefone_1;
	private JFormattedTextField txtATelefone;
	private JRadioButton celular_1;
	private JLabel lblEndereo_1;
	private JTextField txtAEndereco;
	private JTextField txtABairro;
	private JLabel lblBairro_1;
	private JLabel lblCidade_1;
	private JTextField txtACidade;
	private JTextField txtAEstado;
	private JLabel lblEstado_1;
	private JLabel lblNewLabel_1;
	private JFormattedTextField txtACEP;
	private JButton btnAtualizar;
	private JLabel lblCodigoDoCliente;
	private JTextField txtAId;
	private JLabel lblTipoDeTelefone;
	private JTextField txtTipo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cliente frame = new Cliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws ParseException
	 */
	public Cliente() throws ParseException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 315);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);

		JPanel panel = new JPanel();
		tabbedPane.addTab("Cadastro", null, panel, null);

		txtNome = new JTextField();
		txtNome.setColumns(10);

		txtEndereco = new JTextField();
		txtEndereco.setColumns(10);

		txtRG = new JTextField();
		txtRG.setColumns(10);

		txtCidade = new JTextField();
		txtCidade.setColumns(10);

		txtEstado = new JTextField();
		txtEstado.setColumns(10);

		txtBairro = new JTextField();
		txtBairro.setColumns(10);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			PessoaDAO pessoaDAO = new PessoaDAO();
			TelofoneDAO telofoneDAO = new TelofoneDAO();
			TelefoneDTO telefoneDTO = new TelefoneDTO();
				
				String telefone = txtTelefone.getText();
				String tipoTelefone = txtTipo.getText();
				String nome = txtNome.getText();
				String rg = txtRG.getText();
				String endereco = txtEndereco.getText();
				String bairro = txtBairro.getText();
				String cidade = txtCidade.getText();
				String estado = txtEstado.getText();
				String cep = txtCEP.getText();
				String dataDeNascimento = txtDataDeNascimento.getText();
				PessoaDTO pessoaDTO = new PessoaDTO();
				pessoaDTO.setNome(nome);
				pessoaDTO.setRg(rg);
				pessoaDTO.setEndereco(endereco);
				pessoaDTO.setBairro(bairro);
				pessoaDTO.setCidade(cidade);
				pessoaDTO.setEstado(estado);
				pessoaDTO.setCep(cep);
				pessoaDTO.setDataDeNascimento(dataDeNascimento);
				telefoneDTO.setTelefone(telefone);
				telefoneDTO.setTipoTelefone(tipoTelefone);
			
				telofoneDAO.inserir(telefoneDTO);
				pessoaDAO.inserir(pessoaDTO);

				JOptionPane.showMessageDialog(null, "Cadastro Realizado com Sucesso");

			}
		});

		lblNome = new JLabel("Nome:");

		lblEndereo = new JLabel("Endere\u00E7o:");

		lblRg = new JLabel("RG:");

		lblBairro = new JLabel("Bairro:");

		lblCidade = new JLabel("Cidade:");

		lblEstado = new JLabel("Estado:");

		txtDataDeNascimento = new JFormattedTextField(new MaskFormatter("##/##/####"));

		txtCEP = new JFormattedTextField(new MaskFormatter("#####-###"));

		lblDataDeNascimento = new JLabel("Data de Nascimento:");

		lblNewLabel = new JLabel("CEP:");

		lblTelefone = new JLabel("Telefone:");

		txtTelefone = new JFormattedTextField(new MaskFormatter("(##)#########"));
		
		lblTipoDeTelefone = new JLabel("Tipo de telefone:");
		
		txtTipo = new JTextField();
		txtTipo.setColumns(10);

		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
							.addComponent(lblNome)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(lblRg)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtRG, GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
							.addGap(31))
						.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblEndereo)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(txtEndereco, GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE))
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
										.addGroup(gl_panel.createSequentialGroup()
											.addComponent(lblBairro)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(txtBairro, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(lblCidade))
										.addGroup(gl_panel.createSequentialGroup()
											.addComponent(lblEstado)
											.addGap(4)
											.addComponent(txtEstado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addComponent(lblNewLabel)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(txtCEP)))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(txtCidade, GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)))
							.addGap(31))
						.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
							.addComponent(lblDataDeNascimento)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtDataDeNascimento, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblTelefone)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtTelefone, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblTipoDeTelefone)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtTipo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(3))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(btnCadastrar)
							.addContainerGap())))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNome)
						.addComponent(lblRg)
						.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtRG, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDataDeNascimento)
						.addComponent(txtDataDeNascimento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTelefone)
						.addComponent(txtTelefone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTipoDeTelefone)
						.addComponent(txtTipo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(14)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEndereo)
						.addComponent(txtEndereco, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBairro)
						.addComponent(txtBairro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCidade)
						.addComponent(txtCidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtEstado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEstado)
						.addComponent(lblNewLabel)
						.addComponent(txtCEP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
					.addComponent(btnCadastrar)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Atualizar Dados", null, panel_1, null);
		
		lblNome_1 = new JLabel("Nome:");
		
		txtANome = new JTextField();
		txtANome.setColumns(10);
		
		lblRg_1 = new JLabel("RG:");
		
		txtARG = new JTextField();
		txtARG.setColumns(10);
		
		lblDataDeNascimento_1 = new JLabel("Data de Nascimento:");
		
		txtADataDeNascimento = new JFormattedTextField(new MaskFormatter("##/##/####"));
		
		lblTelefone_1 = new JLabel("Telefone:");
		
		txtATelefone = new JFormattedTextField(new MaskFormatter("(##)#########"));
		
		celular_1 = new JRadioButton("Celular");
		
		lblEndereo_1 = new JLabel("Endere\u00E7o:");
		
		txtAEndereco = new JTextField();
		txtAEndereco.setColumns(10);
		
		txtABairro = new JTextField();
		txtABairro.setColumns(10);
		
		lblBairro_1 = new JLabel("Bairro:");
		
		lblCidade_1 = new JLabel("Cidade:");
		
		txtACidade = new JTextField();
		txtACidade.setColumns(10);
		
		txtAEstado = new JTextField();
		txtAEstado.setColumns(10);
		
		lblEstado_1 = new JLabel("Estado:");
		
		lblNewLabel_1 = new JLabel("CEP:");
		
		txtACEP = new JFormattedTextField(new MaskFormatter("#####-###"));
		
		btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String anome = txtANome.getText();
				String arg = txtARG.getText();
				String aendereco = txtAEndereco.getText();
				String abairro = txtABairro.getText();
				String acidade = txtACidade.getText();
				String aestado = txtAEstado.getText();
				String acep = txtACEP.getText();
				String adataDeNascimento = txtDataDeNascimento.getText();
				String a_id = txtAId.getText();
				int aid = Integer.parseInt(a_id);
				PessoaDTO pessoaDTO = new PessoaDTO();
				pessoaDTO.setNome(anome);
				pessoaDTO.setRg(arg);
				pessoaDTO.setEndereco(aendereco);
				pessoaDTO.setBairro(abairro);
				pessoaDTO.setCidade(acidade);
				pessoaDTO.setEstado(aestado);
				pessoaDTO.setCep(acep);
				pessoaDTO.setDataDeNascimento(adataDeNascimento);
				pessoaDTO.setId(aid);
				PessoaDAO pessoaDAO = new PessoaDAO();
				pessoaDAO.atualizar(pessoaDTO);
				JOptionPane.showMessageDialog(null,"Cadastro atualizado com sucesso");
				
				
			}
		});
		
		lblCodigoDoCliente = new JLabel("Codigo do Cliente");
		
		txtAId = new JTextField();
		txtAId.setColumns(10);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblNome_1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(txtANome, GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(lblRg_1, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addComponent(txtARG, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblDataDeNascimento_1, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addComponent(txtADataDeNascimento, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(lblTelefone_1, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(txtATelefone, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(celular_1, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblEndereo_1, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(txtAEndereco, GroupLayout.PREFERRED_SIZE, 430, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblBairro_1, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(txtABairro, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(lblCidade_1, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(txtACidade, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblEstado_1, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addComponent(txtAEstado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(txtACEP, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(31, Short.MAX_VALUE))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap(443, Short.MAX_VALUE)
					.addComponent(btnAtualizar)
					.addContainerGap())
				.addGroup(Alignment.LEADING, gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblCodigoDoCliente)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(txtAId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(327, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNome_1))
						.addComponent(txtANome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(3)
							.addComponent(lblRg_1))
						.addComponent(txtARG, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(5)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(4)
							.addComponent(lblDataDeNascimento_1))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(1)
							.addComponent(txtADataDeNascimento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(4)
							.addComponent(lblTelefone_1))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(1)
							.addComponent(txtATelefone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(celular_1))
					.addGap(14)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(3)
							.addComponent(lblEndereo_1))
						.addComponent(txtAEndereco, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(3)
							.addComponent(lblBairro_1))
						.addComponent(txtABairro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(3)
							.addComponent(lblCidade_1))
						.addComponent(txtACidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(3)
							.addComponent(lblEstado_1))
						.addComponent(txtAEstado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel_1))
						.addComponent(txtACEP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCodigoDoCliente)
						.addComponent(txtAId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
					.addComponent(btnAtualizar)
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);

		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Consultar", null, panel_2, null);

		btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PessoaDAO pessoaDAO = new PessoaDAO();

				List<PessoaDTO> listaPessoas = new ArrayList<>();
				listaPessoas = pessoaDAO.listarTodos();

				for (int i = 0; i < listaPessoas.size(); i++) {
					JOptionPane.showMessageDialog(null, listaPessoas.get(i));
					System.out.println(listaPessoas.get(i));
				}
			}
		});

		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(gl_panel_2.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_2
				.createSequentialGroup().addGap(223).addComponent(btnConsultar).addContainerGap(228, Short.MAX_VALUE)));
		gl_panel_2.setVerticalGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING).addGroup(Alignment.LEADING,
				gl_panel_2.createSequentialGroup().addGap(100).addComponent(btnConsultar).addContainerGap(115,
						Short.MAX_VALUE)));
		panel_2.setLayout(gl_panel_2);

		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Remover Cliente", null, panel_3, null);

		JButton btnSalvar = new JButton("Remover");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String remover = txtRemoverCliente.getText();
				int id = Integer.parseInt(remover);

				PessoaDAO pessoaDAO = new PessoaDAO();
				try {
					pessoaDAO.remover(id);
				} catch (ClassNotFoundException | SQLException e1) {

					e1.printStackTrace();
				}
				
				JOptionPane.showMessageDialog(null, "Cliente Removido com Sucesso");

			}
		});

		txtRemover = new JLabel("Digitar codigo do Cliente:");

		txtRemoverCliente = new JTextField();
		txtRemoverCliente.setColumns(10);
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(gl_panel_3.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_3.createSequentialGroup().addContainerGap(318, Short.MAX_VALUE)
						.addComponent(btnSalvar).addGap(20))
				.addGroup(Alignment.LEADING, gl_panel_3
						.createSequentialGroup().addContainerGap().addComponent(txtRemover)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(txtRemoverCliente,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(184, Short.MAX_VALUE)));
		gl_panel_3.setVerticalGroup(gl_panel_3.createParallelGroup(Alignment.TRAILING).addGroup(gl_panel_3
				.createSequentialGroup().addGap(61)
				.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE).addComponent(txtRemover).addComponent(
						txtRemoverCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED, 114, Short.MAX_VALUE).addComponent(btnSalvar)
				.addContainerGap()));
		panel_3.setLayout(gl_panel_3);
	}
}
