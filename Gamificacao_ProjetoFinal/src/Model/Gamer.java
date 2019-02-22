package Model;

public class Gamer extends Usuario {
	private String matricula;
	private String turma;
	private int diamantes;
	private int cristais;

	public Gamer() {

	}

	public Gamer(String nome, String senha, String email, String matricula, String turma, int diamantes, int cristais) {
		super(nome, senha, email);
		this.matricula = matricula;
		this.turma = turma;
		this.diamantes = diamantes;
		this.cristais = cristais;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getTurma() {
		return turma;
	}

	public void setTurma(String turma) {
		this.turma = turma;
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

	@Override
	public String toString() {
		return "\nNome : " + this.getNome() + "\nEmail : " + this.getEmail() + "\nTurma : " + this.turma
				+ "\nCristais : " + this.cristais + "\nDiamantes : " + this.diamantes;
	}

}
