package model.vo;

import java.text.DecimalFormat;
import java.time.LocalDate;

/**
 * Classe que entidade para a tabela Despesa.
 * 
 * @author Adriano de Melo
 *
 */
public class DespesaVO extends LancamentoVO {

	DecimalFormat df = new DecimalFormat("0.00");

	private LocalDate dataVencimento;
	private LocalDate dataPagamento;
	private String categoria;

	public DespesaVO(int id, int idUsuario, String descricao, double valor, LocalDate dataVencimento,
			LocalDate dataPagamento, String categoria) {
		super(id, idUsuario, descricao, valor);
		this.dataVencimento = dataVencimento;
		this.dataPagamento = dataPagamento;
		this.categoria = categoria;
	}

	public DespesaVO() {
		super();
	}

	public LocalDate getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(LocalDate dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public LocalDate getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(LocalDate dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public void imprimir() {
		System.out.printf("%3d  %10d  %-30s  %-10s  %-15s  %-15s  %-15s\n", this.getId(), this.getIdUsuario(),
				this.getDescricao(), df.format(this.getValor()), this.getDataVencimento(),
				validaData(this.getDataPagamento()), this.getCategoria());

	}

	private String validaData(LocalDate data) {
		String resultado = "";
		if (data != null) {
			resultado = data.toString();
		}
		return resultado;
	}

}
