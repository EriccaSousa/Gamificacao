package CRUDs;

import java.util.Scanner;

import Menus.MenusAdm;
import Menus.MenusGamer;
import Model.Administrador;
import Model.Gamer;
import Model.Itens;
import Model.Turma;

public class Validacoes {

	public static Scanner read = new Scanner(System.in);

	static CRUDGamer crudGamer = new CRUDGamer();
	static CRUDAdm crudAdm = new CRUDAdm();
	static CRUDTurma crudTurma = new CRUDTurma();
	static CRUDItens crudItens = new CRUDItens();

	static MenusAdm menuAdm = new MenusAdm();
	static MenusGamer menuGamer = new MenusGamer();

	public static void validaNome(Gamer gamer) {
		if (gamer.getNome() == "") {
			System.out.println("O campo referente ao nome n�o pode ficar vazio.");

			System.out.print("Nome : ");
			gamer.setNome(read.nextLine());
		}
	}

	public static void validaNome(Administrador adm) {
		if (adm.getNome() == "") {
			System.out.println("O campo referente ao nome n�o pode ficar vazio.");

			System.out.print("Nome : ");
			adm.setNome(read.nextLine());
		}
	}

	public static void validaNome(Turma turma) {
		if (turma.getNome() == "") {
			System.out.println("O campo referente ao nome n�o pode ficar vazio.");

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
			System.out.println("O campo referente ao email n�o pode ficar vazio.");

			System.out.print("Email : ");
			gamer.setEmail(read.nextLine());
		}
	}

	public static void validaEmail(Administrador adm) {
		if (adm.getEmail() == "") {
			System.out.println("O campo referente ao email n�o pode ficar vazio.");

			System.out.print("Email : ");
			adm.setEmail(read.nextLine());
		}
	}

	public static void validaSenha(Gamer gamer) {
		if (gamer.getSenha().length() < 6) {
			System.out.println("A senha n�o pode conter menos de 6 caracteres.");

			System.out.print("Senha : ");
			gamer.setSenha(read.nextLine());
		}
		if (gamer.getSenha().length() > 12) {
			System.out.println("A senha n�o pode conter mais de 12 caracteres.");

			System.out.print("Senha : ");
			gamer.setSenha(read.nextLine());
		}
		if (gamer.getSenha() == "") {
			System.out.println("O campo referente a senha n�o pode ficar vazio.");

			System.out.print("Senha : ");
			gamer.setSenha(read.nextLine());
		}
	}

	public static void validaSenha(Administrador adm) {
		if (adm.getSenha().length() < 6) {
			System.out.println("A senha n�o pode conter menos de 6 caracteres.");

			System.out.print("Senha : ");
			adm.setSenha(read.nextLine());
		}
		if (adm.getSenha().length() > 12) {
			System.out.println("A senha n�o pode conter mais de 12 caracteres.");

			System.out.print("Senha : ");
			adm.setSenha(read.nextLine());
		}
		if (adm.getSenha() == "") {
			System.out.println("O campo referente a senha n�o pode ficar vazio.");

			System.out.print("Senha : ");
			adm.setSenha(read.nextLine());
		}
	}

	public static void validaSenha(Turma turma) {
		if (turma.getSenha().length() < 6) {
			System.out.println("A senha n�o pode conter menos de 6 caracteres.");

			System.out.print("Senha : ");
			turma.setSenha(read.nextLine());
		}
		if (turma.getSenha().length() > 12) {
			System.out.println("A senha n�o pode conter mais de 12 caracteres.");

			System.out.print("Senha : ");
			turma.setSenha(read.nextLine());
		}
		if (turma.getSenha() == "") {
			System.out.println("O campo referente a senha n�o pode ficar vazio.");

			System.out.print("Senha : ");
			turma.setSenha(read.nextLine());
		}
	}

	public static void validaMatricula(Gamer gamer) {
		if (crudGamer.mapGamer.containsKey(gamer.getMatricula())) {
			System.out.println("A matr�cula informada ja existe.");

			System.out.print("Matr�cula : ");
			gamer.setMatricula(read.nextLine());
		}
		if (gamer.getMatricula() == "") {
			System.out.println("O campo referente a matr�cula n�o pode ficar vazio.");

			System.out.print("Matr�cula : ");
			gamer.setMatricula(read.nextLine());
		}

		if (gamer.getMatricula().length() != 6) {
			System.out.println("Matr�cula inv�lida!\n A matr�cula tem que ter 6 d�gitos.");

			System.out.print("Matr�cula : ");
			gamer.setMatricula(read.nextLine());
		}
	}

	public static void validaTurma(Gamer gamer) {
		if (gamer.getTurma() == "") {
			System.out.println("O campo referente a turma n�o pode ficar vazio.");

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
		System.out.print("Informe sua matr�cula : ");
		String matricula = read.nextLine();
		System.out.print("Informe sua senha : ");
		String senha = read.nextLine();

		if (crudGamer.mapGamer.containsKey(matricula)) {
			if (crudGamer.mapGamer.get(matricula).getSenha().equals(senha)) {
				menuGamer.menuConfiguracoes();
			} else {
				System.out.println("Login ou Senha inv�lido!");
			}
		}
		return false;
	}

	public static boolean validaAdm() {
		System.out.print("Informe seu Login : ");
		String login = read.nextLine();
		System.out.print("Informe sua senha : ");
		String senha = read.nextLine();

		if (crudAdm.mapAdm.containsKey(login)) {
			if (crudAdm.mapAdm.get(login).getSenha().equals(senha)) {
				menuAdm.menuConfiguracoesAdm();
			} else {
				System.out.println("Login ou Senha inv�lido.");
			}
		}
		return false;
	}

	public static void validaCadastroProdutos(Itens newItem) {
		if (crudItens.mapItens.containsKey(newItem.getNome())) {
			System.out.println("Produto j� cadastrado.");
			crudItens.cadastroProdutos();
		}
		if (newItem.getNome().equals("")) {
			System.out.print("O campo destinado ao NOME n�o pode ficar vazio.\nNome: ");
			newItem.setNome(read.nextLine());
		}
		if (newItem.getValCristais() < 0) {
			System.out.print("O campo destinado ao PRE�O EM CRISTAIS n�o pode ficar vazio.\nPre�o em Cristais: ");
			newItem.setValCristais(read.nextInt());
			read.nextLine();
		}
		if (newItem.getValDiamantes() < 0) {
			System.out.println("O campo destinado ao PRE�O EM DIAMANTES n�o pode ficar vazio.\nPre�o em Diamantes");
			newItem.setValDiamantes(read.nextInt());
			read.nextLine();
		}

	}

}
