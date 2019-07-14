package Model;

public class Loja {
	private String cod_Identificador;
	private String loginAdm;
	private String nomeLoja;
	private String senha;

	public Loja() {

	}

	public Loja(String cod_Identificador, String loginAdm, String nomeLoja, String senha) {
		this.cod_Identificador = cod_Identificador;
		this.loginAdm = loginAdm;
		this.nomeLoja = nomeLoja;
		this.senha = senha;
	}

	public String getCod_Identificador() {
		return cod_Identificador;
	}

	public void setCod_Identificador(String cod_Identificador) {
		this.cod_Identificador = cod_Identificador;
	}

	public String getLoginAdm() {
		return loginAdm;
	}

	public void setLoginAdm(String loginAdm) {
		this.loginAdm = loginAdm;
	}

	public String getNomeLoja() {
		return nomeLoja;
	}

	public void setNomeLoja(String nomeLoja) {
		this.nomeLoja = nomeLoja;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
