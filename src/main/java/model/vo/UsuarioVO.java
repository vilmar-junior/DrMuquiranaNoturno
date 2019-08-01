package model.vo;

/**
 * Classe que entidade para a tabela Usuario.
 * 
 * @author Adriano de Melo
 *
 */
public class UsuarioVO {

	@Override
	public String toString() {
		return "UsuarioVO [idUsuario=" + idUsuario + ", nome=" + nome + ", cpf=" + cpf + ", telefone=" + telefone
				+ ", login=" + login + ", senha=" + senha + "]";
	}

	private int idUsuario;
	private String nome;
	private String cpf;
	private String telefone;
	private String login;
	private String senha;

	public UsuarioVO(int idUsuario, String nome, String cpf, String telefone, String login, String senha) {
		super();
		this.idUsuario = idUsuario;
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.login = login;
		this.senha = senha;
	}

	public UsuarioVO(String nome, String cpf) {
		super();
		this.nome = nome;
		this.cpf = cpf;
	}

	public UsuarioVO() {
		super();
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void imprimir() {
		System.out.printf("%3d   %-40s   %-15s   %-15s \n", this.getIdUsuario(), this.getNome(), this.getCpf(),
				this.getTelefone());
	}

}
