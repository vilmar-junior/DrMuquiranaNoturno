package model.bo;

import java.util.ArrayList;
import model.dao.ReceitaDAO;
import model.vo.ReceitaVO;

public class ReceitaBO {

	public void cadastrarReceitaBO(ReceitaVO receitaVO) {
		ReceitaDAO receitaDAO = new ReceitaDAO();
		if(receitaDAO.existeRegistroReceita(receitaVO)){
			System.out.println("\nReceita já Cadastrada.");
		} else {
			int resultado = receitaDAO.cadastrarReceitaDAO(receitaVO);
			if(resultado == 1){
				System.out.println("\nReceita cadastrada com Sucesso.");
			} else {
				System.out.println("\nNão foi possível cadastrar a Receita.");
			}
		}
	}

	public void excluirReceitaBO(ReceitaVO receitaVO) {
		ReceitaDAO receitaDAO = new ReceitaDAO();
		if(receitaDAO.existeRegistroPorIdReceita(receitaVO.getId())){
			int resultado = receitaDAO.excluirReceitaDAO(receitaVO);
			if(resultado == 1){
				System.out.println("\nReceita excluída com Sucesso.");
			} else {
				System.out.println("\nNão foi possível excluir a Receita.");
			}
		} else {
			System.out.println("\nReceita não existe na base da dados.");
		}
	}

	public void atualizarReceitaBO(ReceitaVO receitaVO) {
		ReceitaDAO receitaDAO = new ReceitaDAO();
		if(receitaDAO.existeRegistroPorIdReceita(receitaVO.getId())){
			int resultado = receitaDAO.atualizarReceitaDAO(receitaVO);
			if(resultado == 1){
				System.out.println("\nReceita atualizada com Sucesso.");
			} else {
				System.out.println("\nNão foi possível atualizar a Receita.");
			}
		} else {
			System.out.println("\nReceita ainda não foi cadastrada.");
		}
	}

	public ArrayList<ReceitaVO> consultarReceitasBO() {
		ReceitaDAO receitaDAO = new ReceitaDAO();
		ArrayList<ReceitaVO> receitasVO = receitaDAO.consultarTodasReceitasDAO();
		if(receitasVO.isEmpty()){
			System.out.println("\nLista de Receitas está vazia.");
		}
		return receitasVO;
	}

	public ReceitaVO consultarReceitaBO(ReceitaVO receitaVO) {
		ReceitaDAO receitaDAO = new ReceitaDAO();
		ReceitaVO receita = receitaDAO.consultarReceitaDAO(receitaVO);
		if(receita == null){
			System.out.println("\nReceita não Localizada.");
		}
		return receita;
	}

}
