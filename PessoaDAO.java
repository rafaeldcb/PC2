package br.com.prog2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.DatabaseMetaData;

import br.com.prog2.bancodedados.ConexaoUtil;
import br.com.prog2.bancodedados.PessoaDTO;

public class PessoaDAO {

	public void inserir(PessoaDTO pessoaDTO) {
		try {

			Connection connection = ConexaoUtil.getInstance().getConnection();

			String sql = "INSERT INTO CLIENTE(NOME,RG,ENDERECO,BAIRRO,CIDADE,ESTADO,CEP,DATADENASCIMENTO) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setString(1, pessoaDTO.getNome());
			statement.setString(2, pessoaDTO.getRg());
			statement.setString(3, pessoaDTO.getEndereco());
			statement.setString(4, pessoaDTO.getBairro());
			statement.setString(5, pessoaDTO.getCidade());
			statement.setString(6, pessoaDTO.getEstado());
			statement.setString(7, pessoaDTO.getCep());
			statement.setString(8, pessoaDTO.getDataDeNascimento());
			statement.execute();
			connection.close();
			} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void remover(int idpessoa) throws ClassNotFoundException, SQLException {
		Connection connection = ConexaoUtil.getInstance().getConnection();

		String sql = "DELETE FROM CLIENTE WHERE ID_PESSOA = ?";

		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, idpessoa);
		statement.execute();
		connection.close();
		System.out.println("REMOVIDO COM SUCESO");
	}

	public List<PessoaDTO> listarTodos() {
		List<PessoaDTO> listaPessoas = new ArrayList<PessoaDTO>();
		try {
			Connection connection = ConexaoUtil.getInstance().getConnection();
			String sql = "SELECT * FROM CLIENTE";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultset = statement.executeQuery();

			while (resultset.next()) {
				PessoaDTO pessoaDTO = new PessoaDTO();
				pessoaDTO.setId(resultset.getInt("ID_PESSOA"));
				pessoaDTO.setNome(resultset.getString("NOME"));
				pessoaDTO.setRg(resultset.getString("RG"));
				pessoaDTO.setEndereco(resultset.getString("ENDERECO"));
				pessoaDTO.setBairro(resultset.getString("BAIRRO"));
				pessoaDTO.setCidade(resultset.getString("CIDADE"));
				pessoaDTO.setEstado(resultset.getString("ESTADO"));
				pessoaDTO.setCep(resultset.getString("CEP"));
				pessoaDTO.setDataDeNascimento(resultset.getString("DATADENASCIMENTO"));
				listaPessoas.add(pessoaDTO);
			}

			connection.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return listaPessoas;
	}

	public void atualizar(PessoaDTO pessoaDTO) {
		try {
			Connection connection = ConexaoUtil.getInstance().getConnection();
			String sql = "UPDATE CLIENTE SET NOME = ?, RG = ?, ENDERECO = ?, BAIRRO = ?, CIDADE = ?, ESTADO = ?, CEP = ?, DATADENASCIMENTO = ? WHERE ID_PESSOA = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, pessoaDTO.getNome());
			statement.setString(2, pessoaDTO.getRg());
			statement.setString(3, pessoaDTO.getEndereco());
			statement.setString(4, pessoaDTO.getBairro());
			statement.setString(5, pessoaDTO.getCidade());
			statement.setString(6, pessoaDTO.getEstado());
			statement.setString(7, pessoaDTO.getCep());
			statement.setString(8, pessoaDTO.getDataDeNascimento());
			statement.setInt(2, pessoaDTO.getId());

			statement.execute();
			statement.close();
			System.out.println("ATUALIZADO COM SUCESO");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verificar() throws SQLException, Exception {
		Connection connection = ConexaoUtil.getInstance().getConnection();
		DatabaseMetaData dbm = (DatabaseMetaData) connection.getMetaData();
		ResultSet tables = dbm.getTables(null, null, "cliente", null);
		if (tables.next()) {
			System.out.println("Tabela encontrada");
		} else {
			System.out.println("Tabele não encontrada");
			System.out.println(tables.next());

			String sql = "CREATE TABLE CLIENTE(ID_PESSOA INT NOT NULL AUTO_INCREMENT,NOME VARCHAR(50) NULL,RG VARCHAR(10) NULL,"
					+ "ENDERECO VARCHAR(100) NULL,BAIRRO VARCHAR(100) NULL,CIDADE VARCHAR(100) NULL,ESTADO VARCHAR(50) NULL,"
					+ "CEP VARCHAR(20) NULL,DATADENASCIMENTO VARCHAR(15) NULL,PRIMARY KEY (`ID_PESSOA`))";
			Statement statement = (Statement) connection.createStatement();
			statement.execute(sql);
			statement.close();

		}

	}

	public static void main(String[] args) throws Exception {

		PessoaDAO pessoaDAO = new PessoaDAO();
		pessoaDAO.verificar();

		/*
		 * PessoaDTO pessoaDTO = new PessoaDTO();
		 * pessoaDTO.setNome("Eliete");
		 * 
		 * PessoaDAO pessoaDAO = new PessoaDAO();
		 * pessoaDAO.inserir(pessoaDTO);
		 * pessoaDTO.setId_pessoa(2);
		 * pessoaDTO.setNome("Tiago");
		 * pessoaDAO.atualizar(pessoaDTO);
		 * pessoaDAO.remover(2);
		 * List<PessoaDTO>
		 * listaPessoas = new ArrayList<>();
		 * 
		 * listaPessoas = pessoaDAO.listarTodos();
		 * 
		 * for(int i = 0; i < listaPessoas.size(); i++) {
		 * System.out.println(listaPessoas.get(i)); }
		 */

	}
}
