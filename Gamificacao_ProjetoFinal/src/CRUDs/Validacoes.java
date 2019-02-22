package CRUDs;

import java.util.Scanner;

import Model.Administrador;
import Model.Gamer;
import Model.Turma;

public class Validacoes {

	public static Scanner read = new Scanner(System.in);

	static CRUDGamer crudGamer = new CRUDGamer();
	static CRUDAdm crudAdm = new CRUDAdm();
	static CRUDTurma crudTurma = new CRUDTurma();

	public static void validaNome(Gamer gamer) {
		if (gamer.getNome() == "") {
			System.out.println("O campo referente ao nome não pode ficar vazio.");

			System.out.print("Nome : ");
			gamer.setNome(read.nextLine());
		}
	}

	public static void validaNome(Administrador adm) {
		if (adm.getNome() == "") {
			System.out.println("O campo referente ao nome não pode ficar vazio.");

			System.out.print("Nome : ");
			adm.setNome(read.nextLine());
		}
	}

	public static void validaNome(Turma turma) {
		if (turma.getNome() == "") {
			System.out.println("O campo referente ao nome não pode ficar vazio.");

			System.out.print("Nome : ");
			turma.setNome(read.nextLine());
		}
		if (crudTurma.mapTurma.containsKey(turma.getNome())) {
			System.out.println("O nome informado ja foi cadastrado em outra turma.");

			System.out.print("Nome : ");
			turma.setNome(read.nextLine());
		}
	}

	public static void validaEmail(Gamer gamer) {
		if (gamer.getEmail() == "") {
			System.out.println("O campo referente ao email não pode ficar vazio.");

			System.out.print("Email : ");
			gamer.setEmail(read.nextLine());
		}
	}

	public static void validaEmail(Administrador adm) {
		if (adm.getEmail() == "") {
			System.out.println("O campo referente ao email não pode ficar vazio.");

			System.out.print("Email : ");
			adm.setEmail(read.nextLine());
		}
	}

	public static void validaSenha(Gamer gamer) {
		if (gamer.getSenha().length() < 6) {
			System.out.println("A senha não pode conter menos de 6 caracteres.");

			System.out.print("Senha : ");
			gamer.setSenha(read.nextLine());
		}
		if (gamer.getSenha().length() > 12) {
			System.out.println("A senha não pode conter mais de 12 caracteres.");

			System.out.print("Senha : ");
			gamer.setSenha(read.nextLine());
		}
		if (gamer.getSenha() == "") {
			System.out.println("O campo referente a senha não pode ficar vazio.");

			System.out.print("Senha : ");
			gamer.setSenha(read.nextLine());
		}
	}

	public static void validaSenha(Administrador adm) {
		if (adm.getSenha().length() < 6) {
			System.out.println("A senha não pode conter menos de 6 caracteres.");

			System.out.print("Senha : ");
			adm.setSenha(read.nextLine());
		}
		if (adm.getSenha().length() > 12) {
			System.out.println("A senha não pode conter mais de 12 caracteres.");

			System.out.print("Senha : ");
			adm.setSenha(read.nextLine());
		}
		if (adm.getSenha() == "") {
			System.out.println("O campo referente a senha não pode ficar vazio.");

			System.out.print("Senha : ");
			adm.setSenha(read.nextLine());
		}
	}

	public static void validaSenha(Turma turma) {
		if (turma.getSenha().length() < 6) {
			System.out.println("A senha não pode conter menos de 6 caracteres.");

			System.out.print("Senha : ");
			turma.setSenha(read.nextLine());
		}
		if (turma.getSenha().length() > 12) {
			System.out.println("A senha não pode conter mais de 12 caracteres.");

			System.out.print("Senha : ");
			turma.setSenha(read.nextLine());
		}
		if (turma.getSenha() == "") {
			System.out.println("O campo referente a senha não pode ficar vazio.");

			System.out.print("Senha : ");
			turma.setSenha(read.nextLine());
		}
	}

	public static void validaMatricula(Gamer gamer) {
		if (crudGamer.mapGamer.containsKey(gamer.getMatricula())) {
			System.out.println("A matrícula informada ja existe.");

			System.out.print("Matrícula : ");
			gamer.setMatricula(read.nextLine());
		}
		if (gamer.getMatricula() == "") {
			System.out.println("O campo referente a matrícula não pode ficar vazio.");

			System.out.print("Matrícula : ");
			gamer.setMatricula(read.nextLine());
		}

		if (gamer.getMatricula().length() != 6) {
			System.out.println("Matrícula inválida!\n A matrícula tem que ter 6 dígitos.");

			System.out.print("Matrícula : ");
			gamer.setMatricula(read.nextLine());
		}
	}

	public static void validaTurma(Gamer gamer) {
		if (gamer.getTurma() == "") {
			System.out.println("O campo referente a turma não pode ficar vazio.");

			System.out.print("Turma : ");
			gamer.setTurma(read.nextLine());
		}
	}

	public static void validaLogin(Administrador adm) {
		if (crudAdm.mapAdm.containsKey(adm.getLogin())) {
			System.out.println("O login informado ja existe.");

			System.out.print("Login : ");
			adm.setLogin(read.nextLine());
		}
	}

	public static boolean validaGamer() {
		System.out.print("Informe sua matrícula : ");
		String matricula = read.nextLine();
		System.out.print("Informe sua senha : ");
		String senha = read.nextLine();

		if (crudGamer.mapGamer.containsKey(matricula)) {
			if (crudGamer.mapGamer.get(matricula).getSenha().equals(senha)) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

	public static boolean validaAdm() {
		System.out.println("Informe seu Login : ");
		String login = read.nextLine();
		System.out.println("Informe sua senha : ");
		String senha = read.nextLine();

		if (crudAdm.mapAdm.containsKey(login)) {
			if (crudAdm.mapAdm.get(login).getSenha().equals(senha)) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}
}
