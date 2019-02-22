package Model;

public class Itens {
	private String nome;
	private int valCristais;
	private int valDiamantes;

	public Itens() {

	}

	public Itens(String nome, int valCristais, int valDiamantes, int quantidade, boolean disponivel) {
		this.nome = nome;
		this.valCristais = valCristais;
		this.valDiamantes = valDiamantes;
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

	@Override
	public String toString() {
		return "\nNome: " + this.nome + "\nPreço\nCristais: " + this.valCristais + "\nDiamantes: " + this.valDiamantes
				+ "\n";
	}

}
