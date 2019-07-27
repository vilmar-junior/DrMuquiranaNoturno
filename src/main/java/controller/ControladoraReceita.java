package controller;

import java.util.ArrayList;

import model.bo.ReceitaBO;
import model.vo.DespesaVO;
import model.vo.ReceitaVO;

public class ControladoraReceita {

	public void cadastrarReceitaController(ReceitaVO receitaVO) {
		ReceitaBO receitaBO = new ReceitaBO();
		receitaBO.cadastrarReceitaBO(receitaVO);
	}

	public void excluirReceitaController(ReceitaVO receitaVO) {
		ReceitaBO receitaBO = new ReceitaBO();
		receitaBO.excluirReceitaBO(receitaVO);
	}

	public void atualizarReceitaController(ReceitaVO receitaVO) {
		ReceitaBO receitaBO = new ReceitaBO();
		receitaBO.atualizarReceitaBO(receitaVO);
	}
	
	public ArrayList<ReceitaVO> consultarTodasReceitasController() {
		ReceitaBO receitaBO = new ReceitaBO();
		return receitaBO.consultarReceitasBO();
	}

	public ReceitaVO consultarReceitaController(ReceitaVO receitaVO) {
		ReceitaBO receitaBO = new ReceitaBO();
		return receitaBO.consultarReceitaBO(receitaVO);
	}

}
