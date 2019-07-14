package CRUDs;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import DAO.AdministradorDAO;
import Menus.MenuInicial;
import Menus.MenusAdm;
import Model.Administrador;

public class CRUDAdm {
	public static Scanner read = new Scanner(System.in);

	static Administrador adm = new Administrador();
	static Validacoes validaAdm = new Validacoes();

	static MenusAdm menusAdm = new MenusAdm();
	static MenuInicial menuInicial = new MenuInicial();

	static Map<String, Administrador> mapAdm = new HashMap<String, Administrador>();

	static String key;
	static String pesquisaAdm;
	static int opcaoAdm = 0;

	public static void cadastroAdm() {
		Administrador adm = new Administrador();

		System.out.println("- Cadastro Administrador - ");
		System.out.print("Nome : ");
		adm.setNome(read.nextLine());
		System.out.print("Email : ");
		adm.setEmail(read.nextLine());
		System.out.print("Login : ");
		adm.setLogin(read.nextLine());
		System.out.print("Senha : ");
		String senha = read.nextLine();
		adm.setSenha(validaAdm.criptografarSenhas(senha));

		validaAdm.validaNome(adm);
		validaAdm.validaEmail(adm);
		validaAdm.validaLogin(adm);
		validaAdm.validaSenha(adm);

		try {
			if (AdministradorDAO.createADM(adm)) {
				System.out.println("Cadastro realizado com sucesso!\n");
			}
		} catch (Exception e) {
			System.out.println("Erro ao cadastrar!\nPor favor, tente novamente.\n");
		}

		menusAdm.menuPrincipalAdm();

	}

	public static void pesquisaAdm() {
		System.out.print("[ 1 ] Listar todos\n[ 2 ] Pesquisar Administrador específico\n-- ");
		opcaoAdm = read.nextInt();
		read.nextLine();

		if (opcaoAdm == 1) {
			listarAllAdm();
		} else if (opcaoAdm == 2) {
			pesquisarAdm();
		} else {
			System.out.println("Opção inválida.");
		}
	}

	public static void listarAllAdm() {
		mapAdm.forEach((key, adm) -> System.out.println("Login : " + key + adm));
	}

	public static void pesquisarAdm() {
		System.out.println("\n- Pesquisar Administrador -");
		System.out.print("Informe o login do adm que deseja encontrar : ");
		pesquisaAdm = read.nextLine();

		if (mapAdm.containsKey(pesquisaAdm)) {
			System.out.println(mapAdm.get(pesquisaAdm));
		} else {
			System.out.println("O Administrador pesquisado não existe.");
		}
	}

	public static void updateNome() {
		System.out.print("Informe seu Login  : ");
		pesquisaAdm = read.nextLine();

		if (mapAdm.containsKey(pesquisaAdm)) {
			System.out.println(mapAdm.get(pesquisaAdm));

			System.out.print("\nInforme o novo nome  : ");
			mapAdm.get(pesquisaAdm).setNome(read.nextLine());

			menusAdm.menuConfiguracoesAdm();
		} else {
			System.out.println("O Login informado não existe.");
		}

	}

	public static void updateEmail() {
		System.out.print("Informe seu Login  : ");
		pesquisaAdm = read.nextLine();

		if (mapAdm.containsKey(pesquisaAdm)) {
			System.out.println(mapAdm.get(pesquisaAdm));

			System.out.print("\nInforme o novo email  : ");
			mapAdm.get(pesquisaAdm).setEmail(read.nextLine());

			menusAdm.menuConfiguracoesAdm();
		} else {
			System.out.println("O Login informado não existe.");
		}
	}

	public static void updateSenha() {
		System.out.print("Informe seu Login  : ");
		pesquisaAdm = read.nextLine();

		if (mapAdm.containsKey(pesquisaAdm)) {
			System.out.println(mapAdm.get(pesquisaAdm));

			System.out.print("\nInforme sua nova senha  : ");
			mapAdm.get(pesquisaAdm).setSenha(read.nextLine());

			menusAdm.menuConfiguracoesAdm();
		} else {
			System.out.println("O Login informada não existe.");
		}
	}

	public static void deleteAdm() {
		System.out.println("Informe seu Login : ");

		if (mapAdm.containsKey(pesquisaAdm)) {
			System.out.println(mapAdm.get(pesquisaAdm));

			mapAdm.remove(pesquisaAdm);

			if (mapAdm.containsKey(pesquisaAdm)) {
				System.out.println("\nOcorreu um erro ao deletar Administrador.");
			} else {
				System.out.println("\nAdministrador deletado com sucesso!");

				menuInicial.menuInicial();
			}
		} else {
			System.out.println("\nO Login informado não existe.");
		}
	}

	public static void loginAdm() {
		System.out.println("- Login Administrador -");
		System.out.print("Login : ");
		String loginAdm = read.nextLine();
		System.out.println("Senha : ");
		String senhaAdm = read.nextLine();

		if (mapAdm.containsKey(loginAdm)) {
			if (mapAdm.get(loginAdm).getSenha().equals(senhaAdm)) {
				System.out.println("Bem vindo " + mapAdm.get(loginAdm).getNome());
				menusAdm.menuPrincipalAdm();
			} else {
				System.out.println("Senha incorreta.");
			}
		} else {
			System.out.println("Login incorreto.");
		}

	}

}
