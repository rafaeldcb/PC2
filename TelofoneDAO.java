package br.com.prog2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.DatabaseMetaData;

import br.com.prog2.bancodedados.ChaleDTO;
import br.com.prog2.bancodedados.ConexaoUtil;
import br.com.prog2.bancodedados.TelefoneDTO;

public class TelofoneDAO {
	
	
	public void inserir(TelefoneDTO telefoneDTO) {
		try {
			Connection connection = ConexaoUtil.getInstance().getConnection();
			
			String sql = "INSERT INTO TELEFONE(TIPO_TELEFONE, TELEFONE) VALUES(?, ?)";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, telefoneDTO.getTelefone());
			statement.setString(2, telefoneDTO.getTipoTelefone());
			statement.execute();
			statement.close();
			
		}catch(Exception e){
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

			String sql = "CREATE TABLE TELEFONE(ID_TELEFONE INT NOT NULL AUTO_INCREMENT,ID_PESSOA INT NULL,TELEFONE INT NULL, PRIMARY KEY (`ID_PESSOA`),PRIMARY KEY (`TELEFONE`))"
					+ "FOREIGN KEY (ID_PESSOA) REFERENCES CLIENTE(ID_PESSOA))";
			Statement statement = (Statement) connection.createStatement();
			statement.execute(sql);
			statement.close();

		}

	}
	
}
