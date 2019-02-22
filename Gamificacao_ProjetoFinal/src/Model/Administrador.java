package Model;

public class Administrador extends Usuario {
	private String login;

	public Administrador() {

	}

	public Administrador(String nome, String senha, String email, String login) {
		super(nome, senha, email);
		this.login = login;

	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	@Override
	public String toString() {
		return "Administrador\nLogin : " + this.login;
	}

}
