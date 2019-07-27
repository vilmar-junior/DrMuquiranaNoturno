package controller;

import java.util.ArrayList;

import model.bo.RelatorioBO;
import model.dto.LancamentoUsuarioDTO;

public class ControladoraRelatorio {

	public ArrayList<LancamentoUsuarioDTO> gerarRelatorioTotalReceitasUsuarioController() {
		RelatorioBO relatorioBO = new RelatorioBO();
		return relatorioBO.gerarRelatorioTotalReceitasUsuarioBO();
	}

	public ArrayList<LancamentoUsuarioDTO> gerarRelatorioTotalDespesasUsuarioController() {
		RelatorioBO relatorioBO = new RelatorioBO();
		return relatorioBO.gerarRelatorioTotalDespesasUsuarioBO();
	}

	public ArrayList<LancamentoUsuarioDTO> gerarRelatorioTotalReceitasUsuariosPorPeriodoController(LancamentoUsuarioDTO lancamentoUsuarioDTO) {
		RelatorioBO relatorioBO = new RelatorioBO();
		return relatorioBO.gerarRelatorioTotalReceitasUsuariosPorPeriodoBO(lancamentoUsuarioDTO);
	}

	public ArrayList<LancamentoUsuarioDTO> gerarRelatorioTotalDespesasUsuariosPorPeriodoController(LancamentoUsuarioDTO lancamentoUsuarioDTO) {
		RelatorioBO relatorioBO = new RelatorioBO();
		return relatorioBO. gerarRelatorioTotalDespesasUsuariosPorPeriodoBO(lancamentoUsuarioDTO);
	}

	public ArrayList<LancamentoUsuarioDTO> gerarRelatorioTotalDespesasUsuariosAbertasPorPeriodoController(LancamentoUsuarioDTO lancamentoUsuarioDTO) {
		RelatorioBO relatorioBO = new RelatorioBO();
		return relatorioBO.gerarRelatorioTotalDespesasUsuariosAbertasPorPeriodoBO(lancamentoUsuarioDTO);
	}

}
