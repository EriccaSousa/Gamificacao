package Model;

public class Gamer extends Usuario {
	private String matricula;
	private int diamantes;
	private int cristais;
	private double pontuacao;

	public Gamer() {

	}

	public Gamer(String nome, String senha, String email, String matricula, int diamantes, int cristais,
			double pontuacao) {
		super(nome, senha, email);
		this.matricula = matricula;
		this.diamantes = diamantes;
		this.cristais = cristais;
		this.pontuacao = pontuacao;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public int getDiamantes() {
		return diamantes;
	}

	public void setDiamantes(int diamantes) {
		this.diamantes = diamantes;
	}

	public int getCristais() {
		return cristais;
	}

	public void setCristais(int cristais) {
		this.cristais = cristais;
	}

	public double getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(double pontuacao) {
		this.pontuacao = pontuacao;
	}

}
