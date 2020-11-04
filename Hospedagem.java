package br.com.prog2.trabfinal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.prog2.bancodedados.HospedagemDTO;
import br.com.prog2.dao.HospedagemDAO;
import javax.swing.JTabbedPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Hospedagem extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtIdChale;
	private JTextField txtQtdPessoas;
	private JTextField txtDesconto;
	private JTextField txtEstado;
	private JTextField txtDiarias;
	private JTextField textField;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Hospedagem frame = new Hospedagem();
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
	public Hospedagem() {
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
		
		JLabel lblCodigoDoChele = new JLabel("Codigo do Chele:");
		
		txtIdChale = new JTextField();
		txtIdChale.setColumns(10);
		
		JLabel lblChaleOcupado = new JLabel("Chale Ocupado");
		
		JLabel lblDataDeInicio = new JLabel("Data de Inicio:");
		
		JFormattedTextField txtDataDeInicio = new JFormattedTextField();
		
		JLabel lblDataDeSaida = new JLabel("Data de Saida:");
		
		JFormattedTextField txtDataDeSaida = new JFormattedTextField();
		
		JLabel lblQuantidaeDePessoas = new JLabel("Quantidae de Pessoas:");
		
		txtQtdPessoas = new JTextField();
		txtQtdPessoas.setColumns(10);
		
		JLabel lblDesconto = new JLabel("Desconto:");
		
		txtDesconto = new JTextField();
		txtDesconto.setColumns(10);
		
		JLabel lblValorFinal = new JLabel("Valor final:");
		
		JFormattedTextField txtValorFinal = new JFormattedTextField();
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HospedagemDAO hospedagemDAO = new HospedagemDAO();
			
				String id_chale = txtIdChale.getText();
				int id_chalei = Integer.parseInt(id_chale);
				String estado = txtEstado.getText();
				String dataInicio = txtDataDeInicio.getText();
				String dataFinal = txtDataDeSaida.getText();
				String qtdPessoas = txtQtdPessoas.getText();
				int qtdPessoasi = Integer.parseInt(qtdPessoas);
				String desconto = txtDesconto.getText();
				int descontoi = Integer.parseInt(desconto);
				String diarias = txtDiarias.getText();
				int diariasi = Integer.parseInt(diarias);
				HospedagemDTO hospedagemDTO = new HospedagemDTO();
				hospedagemDTO.setId_chale(id_chalei);
				hospedagemDTO.setEstado(estado);
				hospedagemDTO.setDataInicio(dataInicio);
				hospedagemDTO.setDataFinal(dataFinal);
				hospedagemDTO.setQtdPessoas(qtdPessoasi);
				hospedagemDTO.setDesconto(descontoi);
				hospedagemDTO.setDiarias(diariasi);
				Double valorFinal = 0.0;
				valorFinal = (double) ((150 + (qtdPessoasi * 50)) * diariasi * ((double)1 - ((double)descontoi/100)));
				txtValorFinal.setText(Double.toString(valorFinal));
				hospedagemDTO.setValorFinal(valorFinal);
				
				
				
				hospedagemDAO.inserir(hospedagemDTO);

				JOptionPane.showMessageDialog(null, "Cadastro Realizado com Sucesso");
				
			}
			
		});
		
		txtEstado = new JTextField();
		txtEstado.setColumns(10);
		
		JLabel lblQuantidadeDeDirias = new JLabel("Quantidade de Di\u00E1rias:");
		
		txtDiarias = new JTextField();
		txtDiarias.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblCodigoDoChele)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtIdChale, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblChaleOcupado)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtEstado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblDataDeInicio)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtDataDeInicio, 102, 102, 102))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblDataDeSaida)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtDataDeSaida, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblDesconto)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtDesconto, 0, 0, Short.MAX_VALUE))
								.addComponent(lblQuantidaeDePessoas))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtQtdPessoas, GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)))
					.addGap(74)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblValorFinal)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtValorFinal, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
							.addComponent(btnCadastrar)
							.addGroup(gl_panel.createSequentialGroup()
								.addComponent(lblQuantidadeDeDirias)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(txtDiarias, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(42))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCodigoDoChele)
						.addComponent(txtIdChale, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblQuantidadeDeDirias)
						.addComponent(txtDiarias, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblChaleOcupado)
						.addComponent(txtEstado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblValorFinal)
						.addComponent(txtValorFinal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDataDeInicio)
						.addComponent(txtDataDeInicio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDataDeSaida)
						.addComponent(txtDataDeSaida, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtQtdPessoas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblQuantidaeDePessoas))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDesconto)
						.addComponent(txtDesconto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
					.addComponent(btnCadastrar)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Servi\u00E7o", null, panel_1, null);
		
		JLabel lblServioRealizado = new JLabel("Servi\u00E7o  realizado:");
		
		JLabel lblDataDoServio = new JLabel("Data do Servi\u00E7o:");
		
		JLabel lblValorDoServio = new JLabel("Valor do Servi\u00E7o:");
		
		JButton btnLiberarServio = new JButton("Liberar Servi\u00E7o");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblServioRealizado)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblDataDoServio)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(formattedTextField)))
					.addGap(50)
					.addComponent(lblValorDoServio)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(96, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
					.addContainerGap(403, Short.MAX_VALUE)
					.addComponent(btnLiberarServio)
					.addGap(37))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(38)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblServioRealizado)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(60)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDataDoServio)
						.addComponent(lblValorDoServio)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(formattedTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
					.addComponent(btnLiberarServio)
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);
	}

}
