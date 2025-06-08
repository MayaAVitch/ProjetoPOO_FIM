package Infos.Menus;

import Infos.Menus.Estoques.MenuControledeEstoque;
import Infos.Menus.Estoques.VisualizadorEstoque;
import Infos.Usuarios.Gerente;
import Infos.Usuarios.Vendedor;
import java.util.Scanner;

public class InterfaceUsuario {
    private Scanner scanner;

    public InterfaceUsuario() {
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMensagemInicial() {
        System.out.println("=== SISTEMA DE GERENCIAMENTO DE ESTOQUE ===");
    }

    public int solicitarTipoUsuario() {
        System.out.println("\nSelecione seu tipo de usuário:");
        System.out.println("1 - Gerente");
        System.out.println("2 - Vendedor");
        System.out.print("Opção: ");
        return scanner.nextInt();
    }

    public void menuGerente(Gerente gerente, MenuControledeEstoque estoque) {
        int opcao;
        do {
            System.out.println("\n=== MENU GERENTE ===");
            System.out.println("1 - Vender produto");
            System.out.println("2 - Reabastecer estoque");
            System.out.println("3 - Verificar estoque");
            System.out.println("4 - Exibir informações do usuário");
            System.out.println("5 - Ver produtos perecíveis");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> gerente.vender(estoque);
                case 2 -> {
                    System.out.print("Digite o nome do produto para reabastecer: ");
                    gerente.comprar(estoque, scanner.nextLine());
                }
                case 3 -> new VisualizadorEstoque(estoque).mostrarEstoque();
                case 4 -> gerente.exibirInfo();
                case 5 -> new VisualizadorEstoque(estoque).mostrarPereciveis();
                case 0 -> System.out.println("Saindo do sistema...");
                default -> mostrarMensagemErro("Opção inválida!");
            }
        } while (opcao != 0);
    }

    public void menuVendedor(Vendedor vendedor, MenuControledeEstoque estoque) {
        int opcao;
        do {
            System.out.println("\n=== MENU VENDEDOR ===");
            System.out.println("1 - Vender produto");
            System.out.println("2 - Verificar estoque");
            System.out.println("3 - Exibir informações do usuário");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> vendedor.vender(estoque);
                case 2 -> new VisualizadorEstoque(estoque).mostrarEstoque();
                case 3 -> vendedor.exibirInfo();
                case 0 -> System.out.println("Saindo do sistema...");
                default -> mostrarMensagemErro("Opção inválida!");
            }
        } while (opcao != 0);
    }

    public void mostrarMensagemErro(String mensagem) {
        System.out.println("ERRO: " + mensagem);
    }
}