package view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import controller.ControladoraRelatorio;
import model.dto.LancamentoUsuarioDTO;


public class MenuRelatorio {

	Scanner teclado = new Scanner(System.in);
	DateTimeFormatter dataFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	private static final int OPCAO_MENU_RELATORIO_TOTAL_RECEITAS_USUARIO = 1;
	private static final int OPCAO_MENU_RELATORIO_TOTAL_RECEITAS_USUARIO_POR_PERIODO = 2;
	private static final int OPCAO_MENU_RELATORIO_TOTAL_DESPESAS_USUARIO = 3;
	private static final int OPCAO_MENU_RELATORIO_TOTAL_DESPESAS_USUARIO_POR_PERIODO = 4;
	private static final int OPCAO_MENU_RELATORIO_TOTAL_DESPESAS_USUARIO_ABERTAS_POR_PERIODO = 5;
	private static final int OPCAO_MENU_RELATORIO_SAIR = 6;

	public void apresentarMenuRelatorio() {
		int opcao = this.apresentarOpcoesMenu();
		while (opcao != OPCAO_MENU_RELATORIO_SAIR) {
			switch (opcao) {
				case OPCAO_MENU_RELATORIO_TOTAL_RECEITAS_USUARIO: {
					this.gerarRelatorioTotalReceitasUsuario();
					break;
				}
				case OPCAO_MENU_RELATORIO_TOTAL_RECEITAS_USUARIO_POR_PERIODO: {
					this.gerarRelatorioTotalReceitasUsuariosPorPeriodo();
					break;
				}
				case OPCAO_MENU_RELATORIO_TOTAL_DESPESAS_USUARIO: {
					this.gerarRelatorioTotalDespesasUsuario();
					break;
				}
				case OPCAO_MENU_RELATORIO_TOTAL_DESPESAS_USUARIO_POR_PERIODO: {
					this.gerarRelatorioTotalDespesasUsuariosPorPeriodo();
					break;
				}
				case OPCAO_MENU_RELATORIO_TOTAL_DESPESAS_USUARIO_ABERTAS_POR_PERIODO: {
					this.gerarRelatorioTotalDespesasUsuarioAbertasPorPeriodo();
					break;
				}
				default: {
					System.out.println("\nOpção Inválida");
				}
			}
			opcao = this.apresentarOpcoesMenu();
		}
	}
	

	private int apresentarOpcoesMenu() {
		System.out.println("\nDr. Muquirana - Controle de Gastos \n-------- Menu Relatório --------");
		System.out.println("\nOpções:");
		System.out.println(OPCAO_MENU_RELATORIO_TOTAL_RECEITAS_USUARIO + " - Relatório - Total de Receitas dos Usuários");
		System.out.println(OPCAO_MENU_RELATORIO_TOTAL_RECEITAS_USUARIO_POR_PERIODO + " - Relatório - Total de Receitas dos Usuários por Período");
		System.out.println(OPCAO_MENU_RELATORIO_TOTAL_DESPESAS_USUARIO + " - Relatório - Total de Despesas dos Usuários");
		System.out.println(OPCAO_MENU_RELATORIO_TOTAL_DESPESAS_USUARIO_POR_PERIODO + " - Relatório - Total de Despesas dos Usuários por Período");
		System.out.println(OPCAO_MENU_RELATORIO_TOTAL_DESPESAS_USUARIO_ABERTAS_POR_PERIODO + " - Relatório - Total de Despesas dos Usuários Abertas por Período");
		System.out.println(OPCAO_MENU_RELATORIO_SAIR + " - Voltar");
		System.out.print("\nDigite a Opção: ");
		return Integer.parseInt(teclado.nextLine());
	}

	
	private void gerarRelatorioTotalReceitasUsuario() {
		ControladoraRelatorio controladoraRelatorio = new ControladoraRelatorio();
		ArrayList<LancamentoUsuarioDTO> listaLancamentosUsuarioDTO = controladoraRelatorio.gerarRelatorioTotalReceitasUsuarioController();
		
		System.out.print("\n-------- RELATÓRIO - TOTAL DE RECEITAS DOS USUÁRIOS -------");
		System.out.printf("\n%3s   %-40s   %10s  \n", "ID", "NOME", "TOTAL");
		for(int i = 0; i < listaLancamentosUsuarioDTO.size(); i++) {
			listaLancamentosUsuarioDTO.get(i).imprimir();
		}
	}
	
	private void gerarRelatorioTotalDespesasUsuario() {
		ControladoraRelatorio controladoraRelatorio = new ControladoraRelatorio();
		ArrayList<LancamentoUsuarioDTO> listaLancamentosUsuarioDTO = controladoraRelatorio.gerarRelatorioTotalDespesasUsuarioController();
		
		System.out.print("\n-------- RELATÓRIO - TOTAL DE DESPESAS DOS USUÁRIOS -------");
		System.out.printf("\n%3s   %-40s   %10s  \n", "ID", "NOME", "TOTAL");
		for(int i = 0; i < listaLancamentosUsuarioDTO.size(); i++) {
			listaLancamentosUsuarioDTO.get(i).imprimir();
		}
	}
	
	
	private void gerarRelatorioTotalReceitasUsuariosPorPeriodo() {
		LancamentoUsuarioDTO lancamentoUsuarioDTO = new LancamentoUsuarioDTO();
		System.out.print("\nDigite a data de início do período da busca: ");
		lancamentoUsuarioDTO.setDataInicioPesquisa(LocalDate.parse(teclado.nextLine(), dataFormatter));
		System.out.print("\nDigite a data de fim do período da busca: ");
		lancamentoUsuarioDTO.setDataFimPesquisa(LocalDate.parse(teclado.nextLine(), dataFormatter));
		
		ControladoraRelatorio controladoraRelatorio = new ControladoraRelatorio();
		ArrayList<LancamentoUsuarioDTO> listaLancamentosUsuarioDTO = controladoraRelatorio.gerarRelatorioTotalReceitasUsuariosPorPeriodoController(lancamentoUsuarioDTO);
		
		System.out.print("\n-------- RELATÓRIO - TOTAL DE RECEITAS DOS USUÁRIOS POR PERÍODO -------");
		System.out.printf("\n%3s   %-40s   %10s  \n", "ID", "NOME", "TOTAL");
		for(int i = 0; i < listaLancamentosUsuarioDTO.size(); i++) {
			listaLancamentosUsuarioDTO.get(i).imprimir();
		}
		
	}
	
	private void gerarRelatorioTotalDespesasUsuariosPorPeriodo() {
		LancamentoUsuarioDTO lancamentoUsuarioDTO = new LancamentoUsuarioDTO();
		System.out.print("\nDigite a data de início do período da busca: ");
		lancamentoUsuarioDTO.setDataInicioPesquisa(LocalDate.parse(teclado.nextLine(), dataFormatter));
		System.out.print("\nDigite a data de fim do período da busca: ");
		lancamentoUsuarioDTO.setDataFimPesquisa(LocalDate.parse(teclado.nextLine(), dataFormatter));
		
		ControladoraRelatorio controladoraRelatorio = new ControladoraRelatorio();
		ArrayList<LancamentoUsuarioDTO> listaLancamentosUsuarioDTO = controladoraRelatorio.gerarRelatorioTotalDespesasUsuariosPorPeriodoController(lancamentoUsuarioDTO);
		
		System.out.print("\n-------- RELATÓRIO - TOTAL DE DESPESAS DOS USUÁRIOS POR PERÍODO -------");
		System.out.printf("\n%3s   %-40s   %10s  \n", "ID", "NOME", "TOTAL");
		for(int i = 0; i < listaLancamentosUsuarioDTO.size(); i++) {
			listaLancamentosUsuarioDTO.get(i).imprimir();
		}
		
	}
	
	private void gerarRelatorioTotalDespesasUsuarioAbertasPorPeriodo() {
		LancamentoUsuarioDTO lancamentoUsuarioDTO = new LancamentoUsuarioDTO();
		System.out.print("\nDigite a data de início do período da busca: ");
		lancamentoUsuarioDTO.setDataInicioPesquisa(LocalDate.parse(teclado.nextLine(), dataFormatter));
		System.out.print("\nDigite a data de fim do período da busca: ");
		lancamentoUsuarioDTO.setDataFimPesquisa(LocalDate.parse(teclado.nextLine(), dataFormatter));
		
		ControladoraRelatorio controladoraRelatorio = new ControladoraRelatorio();
		ArrayList<LancamentoUsuarioDTO> listaLancamentosUsuarioDTO = controladoraRelatorio.gerarRelatorioTotalDespesasUsuariosAbertasPorPeriodoController(lancamentoUsuarioDTO);
		
		System.out.print("\n-------- RELATÓRIO - TOTAL DE DESPESAS DOS USUÁRIOS ABERTAS POR PERÍODO -------");
		System.out.printf("\n%3s   %-40s   %10s  \n", "ID", "NOME", "TOTAL");
		for(int i = 0; i < listaLancamentosUsuarioDTO.size(); i++) {
			listaLancamentosUsuarioDTO.get(i).imprimir();
		}
	}

}
