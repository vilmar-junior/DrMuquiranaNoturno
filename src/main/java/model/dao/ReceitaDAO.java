package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import model.vo.ReceitaVO;
import model.vo.UsuarioVO;

public class ReceitaDAO {
	
	DateTimeFormatter dataFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	
	public boolean existeRegistroReceita(ReceitaVO receitaVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		String query = "SELECT descricao, valor, dataReceita FROM receita "
				+ " WHERE descricao = '" + receitaVO.getDescricao() + "' " 
				+ " AND valor = " + receitaVO.getValor() + " " 
				+ " AND dataReceita = '" + receitaVO.getDataReceita() + "' ";
		try {
			resultado = stmt.executeQuery(query);
			if (resultado.next()){
				return true;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query que verifica existência de Receita já cadastrada.");
			System.out.println("Erro: " + e.getMessage());
			return false;
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return false;
	}

	public int cadastrarReceitaDAO(ReceitaVO receitaVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		String query = "INSERT INTO receita (idUsuario, descricao, valor, dataReceita) VALUES (" 
		+ receitaVO.getIdUsuario() + ", '" 
		+ receitaVO.getDescricao() + "', "
		+ receitaVO.getValor() + ", '"
		+ receitaVO.getDataReceita() + "' )";
		try {
			resultado = stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query de Cadastro de Receita.");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return resultado;
	}

	public boolean existeRegistroPorIdReceita(int id) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		String query = "SELECT idreceita FROM receita WHERE idreceita = " + id;
		try {
			resultado = stmt.executeQuery(query);
			if (resultado.next()){
				return true;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query que verifica existência de Registro por Id.");
			System.out.println("Erro: " + e.getMessage());
			return false;
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return false;
	}

	public int excluirReceitaDAO(ReceitaVO receitaVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		String query = "DELETE FROM receita WHERE idreceita = " + receitaVO.getId();
		try{
			resultado = stmt.executeUpdate(query);
		} catch (SQLException e){
			System.out.println("Erro ao executar a Query de Exclusão da Receita.");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return resultado;
	}

	public int atualizarReceitaDAO(ReceitaVO receitaVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		String query = "UPDATE receita SET idusuario = " + receitaVO.getIdUsuario()
					+ ", descricao = '" + receitaVO.getDescricao() 
					+ "', valor = " + receitaVO.getValor() 
					+ ", datareceita = '" + receitaVO.getDataReceita() 
					+ "' WHERE idreceita = " + receitaVO.getId();
		try {
			resultado = stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query de Atualização da Receita.");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return resultado;
	}

	public ArrayList<ReceitaVO> consultarTodasReceitasDAO() {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		ArrayList<ReceitaVO> receitasVO = new ArrayList<ReceitaVO>();
		String query = "SELECT idreceita, idusuario, descricao, valor, datareceita FROM receita";
		try{
			resultado = stmt.executeQuery(query);
			while(resultado.next()){
				ReceitaVO receitaVO = new ReceitaVO();
				receitaVO.setId(Integer.parseInt(resultado.getString(1)));
				receitaVO.setIdUsuario(Integer.parseInt(resultado.getString(2)));
				receitaVO.setDescricao(resultado.getString(3));
				receitaVO.setValor(Double.parseDouble(resultado.getString(4)));
				receitaVO.setDataReceita(LocalDate.parse(resultado.getString(5), dataFormatter));
				receitasVO.add(receitaVO);
			}
		} catch (SQLException e){
			System.out.println("Erro ao executar a Query de Consulta de Receitas.");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return receitasVO;
	}

	public ReceitaVO consultarReceitaDAO(ReceitaVO receitaVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		ReceitaVO receita = new ReceitaVO();
		
		String query = "SELECT idreceita, idusuario, descricao, valor, datareceita FROM receita WHERE idreceita = " 
				+ receitaVO.getId();
		
		try{
			resultado = stmt.executeQuery(query);
			while(resultado.next()){
				receita.setId(Integer.parseInt(resultado.getString(1)));
				receita.setIdUsuario(Integer.parseInt(resultado.getString(2)));
				receita.setDescricao(resultado.getString(3));
				receita.setValor(Double.parseDouble(resultado.getString(4)));
				receita.setDataReceita(LocalDate.parse(resultado.getString(5), dataFormatter));
			}
		} catch (SQLException e){
			System.out.println("Erro ao executar a Query de Consulta de Receita.");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return receita;
	}

}
