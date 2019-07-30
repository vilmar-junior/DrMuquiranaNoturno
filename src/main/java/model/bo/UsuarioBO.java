package model.bo;

import java.util.ArrayList;

import model.dao.UsuarioDAO;
import model.vo.UsuarioVO;

/**
 * Classe responsável pelas Regras de Negócio de usuário.
 * 
 * @author Adriano de Melo
 *
 */
public class UsuarioBO {

	public void cadastrarUsuarioBO(UsuarioVO usuarioVO) {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		if (usuarioDAO.existeRegistroPorCpf(usuarioVO.getCpf())) {
			System.out.println("\nUsuário já Cadastrado");
		} else {
			usuarioVO = usuarioDAO.salvar(usuarioVO);
			if (usuarioVO.getIdUsuario() > 0) {
				System.out.println("\nUsuário cadastrado com Sucesso.");
			} else {
				System.out.println("\nNão foi possível cadastrar o Usuário.");
			}
		}
	}

	public void excluirUsuarioBO(UsuarioVO usuarioVO) {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		if (usuarioDAO.existeRegistroPorIdUsuario(usuarioVO.getIdUsuario())) {
			boolean conseguiuExcluir = usuarioDAO.excluir(usuarioVO.getIdUsuario());
			if (conseguiuExcluir) {
				System.out.println("\nUsuário excluído com Sucesso.");
			} else {
				System.out.println("\nNão foi possível excluir o Usuário.");
			}
		} else {
			System.out.println("\nUsuário não existe na base da dados.");
		}
	}

	public void atualizarUsuarioBO(UsuarioVO usuarioVO) {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		if (usuarioDAO.existeRegistroPorIdUsuario(usuarioVO.getIdUsuario())) {
			boolean alterou = usuarioDAO.alterar(usuarioVO);
			if (alterou) {
				System.out.println("\nUsuário atualizado com Sucesso.");
			} else {
				System.out.println("\nNão foi possível atualizar o Usuário.");
			}
		} else {
			System.out.println("\nUsuário ainda não foi cadastrado.");
		}
	}

	public ArrayList<UsuarioVO> consultarUsuariosBO() {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		ArrayList<UsuarioVO> usuariosVO = usuarioDAO.consultarTodos();
		if (usuariosVO.isEmpty()) {
			System.out.println("\nLista de Usuários está vazia.");
		}
		return usuariosVO;
	}

	public UsuarioVO consultarUsuarioBO(UsuarioVO usuarioVO) {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		UsuarioVO usuario = usuarioDAO.consultarPorId(usuarioVO.getIdUsuario());
		if (usuario == null) {
			System.out.println("\nUsuário não Localizado.");
		}
		return usuario;
	}
}