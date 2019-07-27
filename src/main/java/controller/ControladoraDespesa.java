package controller;

import java.util.ArrayList;

import model.bo.DespesaBO;
import model.vo.DespesaVO;

public class ControladoraDespesa {

	public void cadastrarDespesaController(DespesaVO despesaVO) {
		DespesaBO despesaBO = new DespesaBO();
		despesaBO.cadastrarDespesaBO(despesaVO);
	}

	public void excluirDespesaController(DespesaVO despesaVO) {
		DespesaBO despesaBO = new DespesaBO();
		despesaBO.excluirDespesaBO(despesaVO);
	}

	public void atualizarDespesaController(DespesaVO despesaVO) {
		DespesaBO despesaBO = new DespesaBO();
		despesaBO.atualizarDespesaBO(despesaVO);
	}

	public ArrayList<DespesaVO> consultarTodasDespesasController(DespesaVO despesaVO) {
		DespesaBO despesaBO = new DespesaBO();
		return despesaBO.consultarTodasDespesasBO(despesaVO);
	}

	public DespesaVO consultarDespesaoController(DespesaVO despesaVO) {
		DespesaBO despesaBO = new DespesaBO();
		return despesaBO.consultarDespesaBO(despesaVO);
	}

}
