package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import model.vo.DespesaVO;

/**
 * Classe que contém as chamadas SQL para a entidade/tabela Despesa.
 * 
 * @author Adriano de Melo
 *
 */
public class DespesaDAO {

	DateTimeFormatter dataFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	public int cadastrarDespesaDAO(DespesaVO despesaVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		String query = "INSERT INTO despesa (idUsuario, descricao, valor, dataVencimento, dataPagamento, categoria) VALUES ("
				+ despesaVO.getIdUsuario() + ", '" + despesaVO.getDescricao() + "', " + despesaVO.getValor() + ", '"
				+ despesaVO.getDataVencimento() + "', '" + despesaVO.getDataPagamento() + "', '"
				+ despesaVO.getCategoria() + "')";
		try {
			resultado = stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query de Cadastro da Despesa.");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return resultado;
	}

	public boolean existeRegistroPorIdDespesa(int id) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		String query = "SELECT iddespesa FROM despesa WHERE iddespesa = " + id;
		try {
			resultado = stmt.executeQuery(query);
			if (resultado.next()) {
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

	public int excluirDespesaDAO(DespesaVO despesaVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		String query = "DELETE FROM despesa WHERE iddespesa = " + despesaVO.getId();
		try {
			resultado = stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query de Exclusão do Usuário.");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return resultado;
	}

	public int atualizarDespesaDAO(DespesaVO despesaVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		String query = "UPDATE despesa SET " + " idUsuario = " + despesaVO.getIdUsuario() + ", " + " descricao = '"
				+ despesaVO.getDescricao() + "', " + " valor = " + despesaVO.getValor() + ", " + " dataVencimento = '"
				+ despesaVO.getDataVencimento() + "', " + " dataPagamento = '" + despesaVO.getDataPagamento() + "', "
				+ " categoria = '" + despesaVO.getCategoria() + "' " + " WHERE iddespesa = " + despesaVO.getId();

		try {
			resultado = stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query de Cadastro da Despesa.");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return resultado;
	}

	public DespesaVO consultarDespesaDAO(DespesaVO despesaVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		DespesaVO despesa = new DespesaVO();

		String query = "SELECT iddespesa, idUsuario, descricao, valor, dataVencimento, dataPagamento, categoria "
				+ " FROM despesa WHERE iddespesa = " + despesaVO.getId();

		try {
			resultado = stmt.executeQuery(query);
			while (resultado.next()) {
				despesa.setId(Integer.parseInt(resultado.getString(1)));
				despesa.setIdUsuario(Integer.parseInt(resultado.getString(2)));
				despesa.setDescricao(resultado.getString(3));
				despesa.setValor(Double.parseDouble(resultado.getString(4)));
				despesa.setDataVencimento(LocalDate.parse(resultado.getString(5), dataFormatter));
				if (resultado.getString(6) != null) {
					despesa.setDataPagamento(LocalDate.parse(resultado.getString(6), dataFormatter));
				}
				despesa.setCategoria(resultado.getString(7));
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query de Consulta de Despesa.");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return despesa;
	}

	public ArrayList<DespesaVO> consultarTodasDespesasDAO(DespesaVO despesaVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		ArrayList<DespesaVO> despesasVO = new ArrayList<DespesaVO>();

		String query = "SELECT iddespesa, idUsuario, descricao, valor, dataVencimento, dataPagamento, categoria "
				+ " FROM despesa WHERE idusuario = " + despesaVO.getIdUsuario();

		try {
			resultado = stmt.executeQuery(query);
			while (resultado.next()) {
				DespesaVO despesa = new DespesaVO();
				despesa.setId(Integer.parseInt(resultado.getString(1)));
				despesa.setIdUsuario(Integer.parseInt(resultado.getString(2)));
				despesa.setDescricao(resultado.getString(3));
				despesa.setValor(Double.parseDouble(resultado.getString(4)));
				despesa.setDataVencimento(LocalDate.parse(resultado.getString(5), dataFormatter));
				if (resultado.getString(6) != null) {
					despesa.setDataPagamento(LocalDate.parse(resultado.getString(6), dataFormatter));
				}
				despesa.setCategoria(resultado.getString(7));
				despesasVO.add(despesa);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query de Consulta de Despesas de um Usuário.");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return despesasVO;
	}

}
