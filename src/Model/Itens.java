package Model;

public class Itens {
	private String nome;
	private int valCristais;
	private int valDiamantes;
	private char descricao;

	public Itens() {

	}

	public Itens(String nome, int valCristais, int valDiamantes, int quantidade, boolean disponivel, char descricao) {
		this.nome = nome;
		this.valCristais = valCristais;
		this.valDiamantes = valDiamantes;
		this.setDescricao(descricao);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getValCristais() {
		return valCristais;
	}

	public void setValCristais(int valCristais) {
		this.valCristais = valCristais;
	}

	public int getValDiamantes() {
		return valDiamantes;
	}

	public void setValDiamantes(int valDiamantes) {
		this.valDiamantes = valDiamantes;
	}
	
	public char getDescricao() {
		return descricao;
	}

	public void setDescricao(char descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "\nNome: " + this.nome + "\nPreço\nCristais: " + this.valCristais + "\nDiamantes: " + this.valDiamantes
				+ "\n";
	}
}
