package Model;

import java.util.Map;

public class Turma {
	private String nome;
	private String senha;

	public Turma() {

	}

	public Turma(String nome, String senha) {
		super();
		this.nome = nome;
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "\nNome  : " + this.nome + "\n";
	}

}
