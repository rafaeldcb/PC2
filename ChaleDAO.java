package br.com.prog2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.DatabaseMetaData;

import br.com.prog2.bancodedados.ChaleDTO;
import br.com.prog2.bancodedados.ConexaoUtil;


public class ChaleDAO {

	public void inserir(ChaleDTO chaleDTO) {
		try {
			Connection connection = ConexaoUtil.getInstance().getConnection();
			
			String sql = "INSERT INTO CLIENTE(ID_CHALE, LOCALIZACAO, CAPACIDADE, VALOR_ALTA_TEMPORADA, VALOR_BAIXA_TEMPORADA) VALUES(?, ?, ?, ?, ?)";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setInt(1, chaleDTO.getId_chale());
			statement.setString(2, chaleDTO.getLocalizacao());
			statement.setInt(3, chaleDTO.getCapacidade());
			statement.setDouble(4, chaleDTO.getValorAltaTemporada());
			statement.setDouble(5, chaleDTO.getValorBaixaTemporada());
			statement.execute();
			statement.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void remover(int idchale) throws ClassNotFoundException, SQLException {
		Connection connection = ConexaoUtil.getInstance().getConnection();

		String sql = "DELETE FROM CHALE WHERE ID_CHALE = ?";

		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, idchale);
		statement.execute();
		connection.close();
		
	}

	public List<ChaleDTO> listarTodos() {
		List<ChaleDTO> listaChale = new ArrayList<ChaleDTO>();
		try {
			Connection connection = ConexaoUtil.getInstance().getConnection();
			String sql = "SELECT * FROM CHALE";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultset = statement.executeQuery();

			while (resultset.next()) {
				ChaleDTO chaleDTO = new ChaleDTO();
				chaleDTO.setId_chale(resultset.getInt("ID_CHALE"));
				chaleDTO.setLocalizacao(resultset.getString("LOCALIZACAO"));
				chaleDTO.setCapacidade(resultset.getInt("CAPACIDADE"));
				chaleDTO.setValorAltaTemporada(resultset.getDouble("VALOR_ALTA_TEMPORADA"));
				chaleDTO.setValorBaixaTemporada(resultset.getDouble("VALOR_BAIXA_TEMPORADA"));
				listaChale.add(chaleDTO);
			}

			connection.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return listaChale;
	}

	public void atualizar(ChaleDTO chaleDTO) {
		try {
			Connection connection = ConexaoUtil.getInstance().getConnection();
			String sql = "UPDATE HOSPEDAGEM SET ID_CHALE = ?, LOCALIZACAO = ?, CAPACIDADE = ?, VALOR_ALTA_TEMPORADA = ?, VALOR_BAIXA_TEMPORADA = ? WHERE ID_CHALE = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, chaleDTO.getId_chale());
			statement.setString(2, chaleDTO.getLocalizacao());
			statement.setInt(3, chaleDTO.getCapacidade());
			statement.setDouble(4, chaleDTO.getValorAltaTemporada());
			statement.setDouble(5, chaleDTO.getValorBaixaTemporada());

			statement.execute();
			statement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verificar() throws SQLException, Exception {
		Connection connection = ConexaoUtil.getInstance().getConnection();
		DatabaseMetaData dbm = (DatabaseMetaData) connection.getMetaData();
		ResultSet tables = dbm.getTables(null, null, "chale", null);
		if (tables.next()) {
			System.out.println("Tabela encontrada");
		} else {
			System.out.println("Tabele não encontrada");
			System.out.println(tables.next());

			String sql = "CREATE TABLE CHALE(ID_CHALE INT NOT NULL AUTO_INCREMENT,LOCALIZACAO VARCHAR(10) NULL,"
					+ "CAPACIDADE VARCHAR(15) NULL,VALOR_ALTA_TEMPORADA VARCHAR(15) NULL,VALOR_BAIXA_TEMPORADA VARCHAR(10) NULL, PRIMARY KEY (`ID_CHALE`))";
			Statement statement = (Statement) connection.createStatement();
			statement.execute(sql);
			statement.close();

		}

	}
	
}
