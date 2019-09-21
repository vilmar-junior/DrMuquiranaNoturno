package model.bo;

import java.util.ArrayList;

import model.dao.DespesaDAO;
import model.vo.DespesaVO;
import model.vo.UsuarioVO;

/**
 * Classe responsável pelas Regras de Negócio da despesa.
 * 
 * @author Adriano de Melo
 *
 */
public class DespesaBO {

	public void cadastrarDespesaBO(DespesaVO despesaVO) {
		DespesaDAO despesaDAO = new DespesaDAO();
		int resultado = despesaDAO.cadastrarDespesaDAO(despesaVO);
		if (resultado == 1) {
			System.out.println("\nDespesa cadastrada com Sucesso.");
		} else {
			System.out.println("\nNão foi possível cadastrar a Despesa.");
		}
	}

	public void excluirDespesaBO(DespesaVO despesaVO) {
		DespesaDAO despesaDAO = new DespesaDAO();
		if (despesaDAO.existeRegistroPorIdDespesa(despesaVO.getId())) {
			int resultado = despesaDAO.excluirDespesaDAO(despesaVO);
			if (resultado == 1) {
				System.out.println("\nDespesa excluída com Sucesso.");
			} else {
				System.out.println("\nNão foi possível excluir a Despesa.");
			}
		} else {
			System.out.println("\nDespesa não existe na base da dados.");
		}
	}

	public void atualizarDespesaBO(DespesaVO despesaVO) {
		DespesaDAO despesaDAO = new DespesaDAO();
		if (despesaDAO.existeRegistroPorIdDespesa(despesaVO.getId())) {
			int resultado = despesaDAO.atualizarDespesaDAO(despesaVO);
			if (resultado == 1) {
				System.out.println("\nDespesa atualizada com Sucesso.");
			} else {
				System.out.println("\nNão foi possível atualizar a Despesa.");
			}
		} else {
			System.out.println("\nDespesa ainda não foi cadastrada.");
		}
	}

	public ArrayList<DespesaVO> consultarTodasDespesasBO(DespesaVO despesaVO) {
		DespesaDAO despesaDAO = new DespesaDAO();
		//TODO alterar para passar o idUsuario
		ArrayList<DespesaVO> despesasVO = despesaDAO.consultarTodasDespesas();
		if (despesasVO.isEmpty()) {
			System.out.println("\nLista de Despesas está vazia.");
		}
		return despesasVO;
	}

	public DespesaVO consultarDespesaBO(DespesaVO despesaVO) {
		DespesaDAO despesaDAO = new DespesaDAO();
		DespesaVO despesa = despesaDAO.consultarDespesaDAO(despesaVO);
		if (despesa == null) {
			System.out.println("\nDespesa não Localizada.");
		}
		return despesa;
	}

	public ArrayList<DespesaVO> consultarDespesas(UsuarioVO usuarioSelecionado, String categoriaSelecionada) {
		DespesaDAO despesaDAO = new DespesaDAO();
		ArrayList<DespesaVO> despesas = new ArrayList<DespesaVO>();
		
		boolean temUsuario = (usuarioSelecionado != null);
		boolean temCategoria = (categoriaSelecionada != null && categoriaSelecionada.isEmpty());
		
		if(!temUsuario && !temCategoria) {
			despesas = despesaDAO.consultarTodasDespesas();
		}
		
		if(temUsuario && !temCategoria) {
			despesas = despesaDAO.consultarDespesasDoUsuario(usuarioSelecionado.getIdUsuario());
		}
		
		if(!temUsuario && temCategoria) {
			despesas = despesaDAO.consultarDespesasPorCategoria(categoriaSelecionada);
		}
		
		if(temUsuario && temCategoria) {
			despesas = despesaDAO.consultarDespesasPorUsuarioECategoria(usuarioSelecionado.getIdUsuario(), categoriaSelecionada);
		}
		
		return despesas;
	}
}