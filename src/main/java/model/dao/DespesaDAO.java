package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
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
 *         Vilmar César Pereira Júnior
 *
 */
public class DespesaDAO implements BaseDAO<DespesaVO> {

	DateTimeFormatter dataFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	public DespesaVO salvar(DespesaVO despesaVO) {
		Connection conn = Banco.getConnection();
		String sql = "INSERT INTO despesa (idUsuario, descricao, valor, dataVencimento, dataPagamento, categoria) "
				+ " VALUES (?,?,?,?,?,?) ";
		PreparedStatement stmt = Banco.getPreparedStatement(conn, sql, Statement.RETURN_GENERATED_KEYS);

		try {
			stmt.setInt(1, despesaVO.getIdUsuario());
			stmt.setString(2, despesaVO.getDescricao());
			stmt.setDouble(3, despesaVO.getValor());
			stmt.setDate(4, Date.valueOf(despesaVO.getDataVencimento()));
			stmt.setDate(5, Date.valueOf(despesaVO.getDataPagamento()));
			stmt.setString(6, despesaVO.getCategoria());
			stmt.execute();
			ResultSet generatedKeys = stmt.getGeneratedKeys();
			if (generatedKeys.next()) {
				despesaVO.setIdUsuario(generatedKeys.getInt(1));
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query de Cadastro da Despesa.");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return despesaVO;
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

	public boolean excluir(int id) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		String query = "DELETE FROM despesa WHERE iddespesa = " + id;
		try {
			resultado = stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query de Exclusão do Usuário.");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return resultado > 0;
	}

	public boolean alterar(DespesaVO despesaVO) {
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
		return resultado > 0;
	}

	public DespesaVO consultarPorId(int id) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		DespesaVO despesa = new DespesaVO();

		String query = "SELECT iddespesa, idUsuario, descricao, valor, dataVencimento, dataPagamento, categoria "
				+ " FROM despesa WHERE iddespesa = " + id;

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

	public ArrayList<DespesaVO> consultarTodos() {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		ArrayList<DespesaVO> despesasVO = new ArrayList<DespesaVO>();

		String query = "SELECT iddespesa, idUsuario, descricao, valor, dataVencimento, dataPagamento, categoria "
				+ " FROM despesa ";

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
			System.out.println("Erro ao executar ao consultar TODAS as Despesas");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return despesasVO;
	}

	/**
	 * Consulta todas as despesas de um determinado usuário
	 * 
	 * @param idUsuario a chave primária do usuário que possui as despesas
	 * @return uma lista de despesas.
	 */
	public ArrayList<DespesaVO> consultarDespesasDoUsuario(int idUsuario) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		ArrayList<DespesaVO> despesasVO = new ArrayList<DespesaVO>();

		String query = "SELECT iddespesa, idUsuario, descricao, valor, dataVencimento, dataPagamento, categoria "
				+ " FROM despesa WHERE idusuario = " + idUsuario;

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
