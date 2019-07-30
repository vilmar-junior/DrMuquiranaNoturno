package model.bo;

import java.util.ArrayList;

import model.dao.RelatorioDAO;
import model.dto.LancamentoUsuarioDTO;

/**
 * Classe responsável pelas Regras de Negócio de relatórios.
 * 
 * @author Adriano de Melo
 *
 */
public class RelatorioBO {

	public ArrayList<LancamentoUsuarioDTO> gerarRelatorioTotalReceitasUsuarioBO() {
		RelatorioDAO relatorioDAO = new RelatorioDAO();
		ArrayList<LancamentoUsuarioDTO> listaLancamentoUsuarioDTO = relatorioDAO
				.gerarRelatorioTotalReceitasUsuarioDAO();
		if (listaLancamentoUsuarioDTO.isEmpty()) {
			System.out.println("\nLista de lançamento de receitas do usuário está vazia.");
		}
		return listaLancamentoUsuarioDTO;
	}

	public ArrayList<LancamentoUsuarioDTO> gerarRelatorioTotalDespesasUsuarioBO() {
		RelatorioDAO relatorioDAO = new RelatorioDAO();
		ArrayList<LancamentoUsuarioDTO> listaLancamentoUsuarioDTO = relatorioDAO
				.gerarRelatorioTotalDespesasUsuarioDAO();
		if (listaLancamentoUsuarioDTO.isEmpty()) {
			System.out.println("\nLista de lançamento de despesas do usuário está vazia.");
		}
		return listaLancamentoUsuarioDTO;
	}

	public ArrayList<LancamentoUsuarioDTO> gerarRelatorioTotalReceitasUsuariosPorPeriodoBO(
			LancamentoUsuarioDTO lancamentoUsuarioDTO) {
		RelatorioDAO relatorioDAO = new RelatorioDAO();
		ArrayList<LancamentoUsuarioDTO> listaLancamentoUsuarioDTO = relatorioDAO
				.gerarRelatorioTotalReceitasUsuariosPorPeriodoDAO(lancamentoUsuarioDTO);
		if (listaLancamentoUsuarioDTO.isEmpty()) {
			System.out.println("\nLista de lançamento de receitas do usuário por período está vazia.");
		}
		return listaLancamentoUsuarioDTO;
	}

	public ArrayList<LancamentoUsuarioDTO> gerarRelatorioTotalDespesasUsuariosPorPeriodoBO(
			LancamentoUsuarioDTO lancamentoUsuarioDTO) {
		RelatorioDAO relatorioDAO = new RelatorioDAO();
		ArrayList<LancamentoUsuarioDTO> listaLancamentoUsuarioDTO = relatorioDAO
				.gerarRelatorioTotalDespesasUsuariosPorPeriodoDAO(lancamentoUsuarioDTO);
		if (listaLancamentoUsuarioDTO.isEmpty()) {
			System.out.println("\nLista de lançamento de despesas do usuário por período está vazia.");
		}
		return listaLancamentoUsuarioDTO;
	}

	public ArrayList<LancamentoUsuarioDTO> gerarRelatorioTotalDespesasUsuariosAbertasPorPeriodoBO(
			LancamentoUsuarioDTO lancamentoUsuarioDTO) {
		RelatorioDAO relatorioDAO = new RelatorioDAO();
		ArrayList<LancamentoUsuarioDTO> listaLancamentoUsuarioDTO = relatorioDAO
				.gerarRelatorioTotalDespesasUsuariosAbertasPorPeriodoDAO(lancamentoUsuarioDTO);
		if (listaLancamentoUsuarioDTO.isEmpty()) {
			System.out.println("\nLista de lançamento de despesas do usuário abertas por período está vazia.");
		}
		return listaLancamentoUsuarioDTO;
	}

}
