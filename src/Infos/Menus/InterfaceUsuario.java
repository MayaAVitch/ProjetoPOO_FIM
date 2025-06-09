package Infos.Menus;

import Infos.Menus.Estoques.MenuControledeEstoque;
import Infos.Menus.Estoques.VisualizadorEstoque;
import Infos.Usuarios.Gerente;
import Infos.Usuarios.Vendedor;
import java.util.Scanner;

public class InterfaceUsuario {
    // Criando entrada
    private Scanner scanner;

    // Construtor
    public InterfaceUsuario() {
        this.scanner = new Scanner(System.in);
    }

    // Metodo P/ mostrar mensagem inicial
    public void mostrarMensagemInicial() {
        System.out.println("=== SISTEMA DE GERENCIAMENTO DE ESTOQUE ===");
    }

    // Metodo P/ seleceção do usuario (cada um tem funções especificas)
    public int solicitarTipoUsuario() {
        // Mostra na tela as opcoes
        System.out.println("\nSelecione seu tipo de usuário:");
        System.out.println("1 - Gerente");
        System.out.println("2 - Vendedor");
        System.out.print("Opção: ");
        // retorna o valor da opcao (entrada de valor)
        return scanner.nextInt();
    }

    // Metodo do menu especifico para o gerente
    public void menuGerente(Gerente gerente, MenuControledeEstoque estoque) {
        int opcao;
        do {
            // Mostra na tela as opcoes
            System.out.println("\n=== MENU GERENTE ===");
            System.out.println("1 - Vender produto");
            System.out.println("2 - Reabastecer estoque");
            System.out.println("3 - Verificar estoque");
            System.out.println("4 - Exibir informações do usuário");
            System.out.println("5 - Ver produtos perecíveis");
            System.out.println("6 - Ver produtos com garantia");
            System.out.println("7 - Aplicar garantia em algum produto");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            // Variavel para armazenar a opção
            opcao = scanner.nextInt();
            // Entrada
            scanner.nextLine();

            // Switch case no intuito fazer a logica das opcoes especificas do gerente
            switch (opcao) {
                // Vendendo
                case 1 -> gerente.vender(estoque);
                // Comprando/Reabastecendo o Estoque
                case 2 -> {
                    System.out.print("Digite o nome do produto para reabastecer: ");
                    // Usa a classe gerente e ja coloca a entrada
                    gerente.comprar(estoque, scanner.nextLine());
                }
                // Visualiza todos is itens do arquivo
                case 3 -> new VisualizadorEstoque(estoque).mostrarEstoque();
                // Exibe as info da clsse gerente
                case 4 -> gerente.exibirInfo();
                // Mostra Produtos Pereciveis
                case 5 -> new VisualizadorEstoque(estoque).mostrarPereciveis();
                // Mostra Produtos Com Garantia
                case 6 -> new VisualizadorEstoque(estoque).mostrarGarantia();
                // Aplicando Garantia
                case 7 -> new VisualizadorEstoque(estoque).aplicandoGarantia();
                // Saindo do Sistema
                case 0 -> System.out.println("Saindo do sistema...");
                // Mensagem padrao
                default -> mostrarMensagemErro("Opção inválida!");
            }
        } while (opcao != 0); // termina se opcao for 0
    }

    // Metodo do menu especifico para o vendedor
    public void menuVendedor(Vendedor vendedor, MenuControledeEstoque estoque) {
        int opcao;
        do {
            // Mostrando as Opcoes para o usuario
            System.out.println("\n=== MENU VENDEDOR ===");
            System.out.println("1 - Vender produto");
            System.out.println("2 - Verificar estoque");
            System.out.println("3 - Exibir informações do usuário");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            // variavel opcao com entrada
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                // Vendendo Produtos
                case 1 -> vendedor.vender(estoque);
                // Visualiza o que tem no estoque.txt
                case 2 -> new VisualizadorEstoque(estoque).mostrarEstoque();
                // Informacoes do vendedor
                case 3 -> vendedor.exibirInfo();
                // Terminando sessão
                case 0 -> System.out.println("Saindo do sistema...");
                // Mensagem padrao
                default -> mostrarMensagemErro("Opção inválida!");
            }
        } while (opcao != 0); // Termina se a opcao for igual a 0
    }

    // Metodo Mensagem erro
    public void mostrarMensagemErro(String mensagem) {
        System.out.println("ERRO: " + mensagem);
    }
}