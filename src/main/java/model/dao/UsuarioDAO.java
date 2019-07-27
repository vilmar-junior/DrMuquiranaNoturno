package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.vo.UsuarioVO;

public class UsuarioDAO {

	public boolean existeRegistroPorCpf(String cpf) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		String query = "SELECT cpf FROM usuario WHERE cpf = '" + cpf + "'";
		try {
			resultado = stmt.executeQuery(query);
			if (resultado.next()){
				return true;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query que verifica existência de Usuário por CPF.");
			System.out.println("Erro: " + e.getMessage());
			return false;
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return false;
	}

	public int cadastrarUsuarioDAO(UsuarioVO usuarioVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		String query = "INSERT INTO usuario (nome, cpf, telefone, login, senha) VALUES ('" 
		+ usuarioVO.getNome() + "', '" 
		+ usuarioVO.getCpf() + "', '"
		+ usuarioVO.getTelefone() + "', '"
		+ usuarioVO.getLogin() + "', '"
		+ usuarioVO.getSenha() + "')";
		try {
			resultado = stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query de Cadastro do Usuário.");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return resultado;
	}

	public boolean existeRegistroPorIdUsuario(int idUsuario) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		String query = "SELECT idusuario FROM usuario WHERE idusuario = " + idUsuario;
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

	public int excluirUsuarioDAO(UsuarioVO usuarioVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		String query = "DELETE FROM usuario WHERE idusuario = " + usuarioVO.getIdUsuario();
		try{
			resultado = stmt.executeUpdate(query);
		} catch (SQLException e){
			System.out.println("Erro ao executar a Query de Exclusão do Usuário.");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return resultado;
	}

	public int atualizarUsuarioDAO(UsuarioVO usuarioVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		String query = "UPDATE usuario SET nome = '" + usuarioVO.getNome() 
					+ "', cpf = '" + usuarioVO.getCpf() 
					+ "', telefone = '" + usuarioVO.getTelefone() 
					+ "', login = '" + usuarioVO.getLogin() 
					+ "', senha = '" + usuarioVO.getSenha() 
					+ "' WHERE idusuario = " + usuarioVO.getIdUsuario();
		try {
			resultado = stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query de Atualização do Usuário.");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return resultado;
	}

	public ArrayList<UsuarioVO> consultarTodosUsuariosDAO() {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		ArrayList<UsuarioVO> usuariosVO = new ArrayList<UsuarioVO>();
		String query = "SELECT idusuario, nome, cpf, telefone, login, senha FROM usuario";
		try{
			resultado = stmt.executeQuery(query);
			while(resultado.next()){
				UsuarioVO usuarioVO = new UsuarioVO();
				usuarioVO.setIdUsuario(Integer.parseInt(resultado.getString(1)));
				usuarioVO.setNome(resultado.getString(2));
				usuarioVO.setCpf(resultado.getString(3));
				usuarioVO.setTelefone(resultado.getString(4));
				usuarioVO.setLogin(resultado.getString(5));
				usuarioVO.setSenha(resultado.getString(6));
				usuariosVO.add(usuarioVO);
			}
		} catch (SQLException e){
			System.out.println("Erro ao executar a Query de Consulta de Usuários.");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return usuariosVO;
	}

	public UsuarioVO consultarUsuarioDAO(UsuarioVO usuarioVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		UsuarioVO usuario = new UsuarioVO();
		
		String query = "SELECT idusuario, nome, cpf, telefone, login, senha FROM usuario WHERE idusuario = " 
				+ usuarioVO.getIdUsuario();
		
		try{
			resultado = stmt.executeQuery(query);
			while(resultado.next()){
				usuario.setIdUsuario(Integer.parseInt(resultado.getString(1)));
				usuario.setNome(resultado.getString(2));
				usuario.setCpf(resultado.getString(3));
				usuario.setTelefone(resultado.getString(4));
				usuario.setLogin(resultado.getString(5));
				usuario.setSenha(resultado.getString(6));
			}
		} catch (SQLException e){
			System.out.println("Erro ao executar a Query de Consulta de Usuário.");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return usuario;
	}

}
