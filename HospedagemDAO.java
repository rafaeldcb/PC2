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
import br.com.prog2.bancodedados.HospedagemDTO;


public class HospedagemDAO {

	public void inserir(HospedagemDTO hospedagemDTO) {
		try {

			Connection connection = ConexaoUtil.getInstance().getConnection();

			String sql = "INSERT INTO HOSPEDAGEM(ID_CHALE,ESTADO,DATA_DE_INICIO,DATA_DE_SAIDA,QTD_PESSOAS,DESCONTO,VALOR_FINAL, DIARIAS) VALUES(?, ?, ?, ?, ?, ?, ?,?)";

			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setInt(1, hospedagemDTO.getId_chale());
			statement.setString(2, hospedagemDTO.getEstado());
			statement.setString(3, hospedagemDTO.getDataInicio());
			statement.setString(4, hospedagemDTO.getDataFinal());
			statement.setInt(5, hospedagemDTO.getQtdPessoas());
			statement.setInt(6, hospedagemDTO.getDesconto());
			statement.setDouble(7, hospedagemDTO.getValorFinal());
			statement.setInt(8, hospedagemDTO.getDiarias());
			statement.execute();
			connection.close();
			System.out.println("INSERIDO COM SUCESSO");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void remover(int idhospedagem) throws ClassNotFoundException, SQLException {
		Connection connection = ConexaoUtil.getInstance().getConnection();

		String sql = "DELETE FROM HOSPEDAGEM WHERE ID_HOSPEDAGEM = ?";

		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, idhospedagem);
		statement.execute();
		connection.close();
		System.out.println("REMOVIDO COM SUCESO");
	}

	public List<HospedagemDTO> listarTodos() {
		List<HospedagemDTO> listaHospedagem = new ArrayList<HospedagemDTO>();
		try {
			Connection connection = ConexaoUtil.getInstance().getConnection();
			String sql = "SELECT * FROM HOSPEDAGEM";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultset = statement.executeQuery();

			while (resultset.next()) {
				HospedagemDTO hospedagemDTO = new HospedagemDTO();
				hospedagemDTO.setId_hospedagem(resultset.getInt("ID_HOSPEDAGEM"));
				hospedagemDTO.setId_chale(resultset.getInt("ID_CHALE"));
				hospedagemDTO.setEstado(resultset.getString("ESTADO"));
				hospedagemDTO.setDataInicio(resultset.getString("DATA_DE_INICIO"));
				hospedagemDTO.setDataFinal(resultset.getString("DATA_DE_SAIDA"));
				hospedagemDTO.setQtdPessoas(resultset.getInt("QTD_PESSOAS"));
				hospedagemDTO.setDesconto(resultset.getInt("DESCONTO"));
				hospedagemDTO.setValorFinal(resultset.getDouble("VALOR_FINLA"));
				hospedagemDTO.setDiarias(resultset.getInt("DIARIAS"));
				listaHospedagem.add(hospedagemDTO);
			}

			connection.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return listaHospedagem;
	}

	public void atualizar(HospedagemDTO hospedagemDTO) {
		try {
			Connection connection = ConexaoUtil.getInstance().getConnection();
			String sql = "UPDATE HOSPEDAGEM SET ID_CHALE = ?, ESTADO = ?, DATA_DE_INICIO = ?, DATA_DE_SAIDA = ?, QTD_PESSOAS = ?, DESCONTO = ?, VALOR_FINAL = ?, DIARIAS = ? WHERE ID_HOSPEDAGEM = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, hospedagemDTO.getId_chale());
			statement.setString(2, hospedagemDTO.getEstado());
			statement.setString(3, hospedagemDTO.getDataInicio());
			statement.setString(4, hospedagemDTO.getDataFinal());
			statement.setInt(5, hospedagemDTO.getQtdPessoas());
			statement.setInt(6, hospedagemDTO.getDesconto());
			statement.setDouble(7, hospedagemDTO.getValorFinal());
			statement.setInt(8, hospedagemDTO.getDiarias());

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
		ResultSet tables = dbm.getTables(null, null, "hospedagem", null);
		if (tables.next()) {
			System.out.println("Tabela encontrada");
		} else {
			System.out.println("Tabele não encontrada");
			System.out.println(tables.next());

			String sql = "CREATE TABLE HOSPEDAGEM(ID_HOSPEDAGEM INT NOT NULL AUTO_INCREMENT,ID_CHALE INT NULL,ESTADO VARCHAR(10) NULL,"
					+ "DATA_DE_INICIO VARCHAR(15) NULL,DATA_DE_SAIDA VARCHAR(15) NULL,QTD_PESSOAS VARCHAR(10) NULL,DESCONTO VARCHAR(10) NULL,"
					+ "VALOR_FINAL VARCHAR(10) NULL,DIARIAS VARCHAR(10) NULL,PRIMARY KEY (`ID_HOSPEDAGEM`), FOREIGN KEY (ID_CHALE) REFERENCES CHALE(ID_CHALE)) ";
					
			Statement statement = (Statement) connection.createStatement();
			statement.execute(sql);
			statement.close();

		}
		
	}
	
	public static void main(String[] args) throws SQLException, Exception {
		HospedagemDAO hospedagemDAO = new HospedagemDAO();
		hospedagemDAO.verificar();
	}
	
}
