package model.seletor;

import model.vo.UsuarioVO;

public class DespesaSeletor extends BaseSeletor {

	//Atributos que servirão de filtros
	private UsuarioVO usuario;
	private String categoria;
	
	public DespesaSeletor() {
	}
	
	/**
	 * Verifica se este seletor tem algum campo preenchido
	 *
	 * @return verdadeiro se existe algum campo de filtro preenchido
	 */
	@Override
	public boolean temFiltro() {
		boolean temFiltro = false;
		
		if ((this.usuario != null) && (this.usuario.getIdUsuario() > 0)) {
			temFiltro = true;
		}
		if ((this.categoria != null) && (this.categoria.trim().length() > 0)) {
			temFiltro = true;
		}
		
		return temFiltro;
	}
	
	//Getters e setters
	public UsuarioVO getUsuario() {
		return usuario;
	}
	public void setUsuario(UsuarioVO usuario) {
		this.usuario = usuario;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
}