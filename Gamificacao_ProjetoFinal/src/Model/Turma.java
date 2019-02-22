package Model;

import java.util.Map;

public class Turma {
	private String nome;
	private String senha;
	private Map<String, Gamer> newMap;

	public Turma() {

	}

	public Turma(String nome, String senha, Map<String, Gamer> newMap) {
		super();
		this.nome = nome;
		this.senha = senha;
		this.newMap = newMap;
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

	public Map<String, Gamer> getNewMapGamer() {
		return newMap;
	}

	public void setNewMapGamer(Map<String, Gamer> newMap) {
		this.newMap = newMap;
	}

	@Override
	public String toString() {
		return "\nNome  : " + this.nome + "\nSenha : " + this.senha + "\nTurma : " + newMap;
	}

}
