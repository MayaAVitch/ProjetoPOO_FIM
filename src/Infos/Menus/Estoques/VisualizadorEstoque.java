package Infos.Menus.Estoques;

import java.util.Scanner;

public class VisualizadorEstoque {
    private MenuControledeEstoque estoque;

    // Visualiaza todo o estoque
    public VisualizadorEstoque(MenuControledeEstoque estoque) {
        this.estoque = estoque;
    }

    // Mostra todo o estoque
    public void mostrarEstoque() {
        System.out.println("\n=== ESTOQUE ATUAL ===");
        System.out.println("Carne: " + estoque.carneEstoque.getQuantidade() + " unidades");
        System.out.println("Detergente: " + estoque.detergenteEstoque.getQuantidade() + " unidades");
        System.out.println("Tomate: " + estoque.tomateEstoque.getQuantidade() + " unidades");
        System.out.println("Leite: " + estoque.leiteEstoque.getQuantidade() + " unidades");
        System.out.println("Sabonete: " + estoque.saboneteEstoque.getQuantidade() + " unidades");
    }

    // Metodo que mostra todos os produtos pereciveis
    public void mostrarPereciveis() {
        System.out.println("\n=== PRODUTOS PERECÍVEIS ===");
        System.out.println("-- Carne --");
        estoque.carneEstoque.exibirDataValidade();
        estoque.carneEstoque.diasParaVencer();
        estoque.carneEstoque.verificarSeEstaVencido();

        System.out.println("\n-- Leite --");
        estoque.leiteEstoque.exibirDataValidade();
        estoque.leiteEstoque.diasParaVencer();
        estoque.leiteEstoque.verificarSeEstaVencido();

        System.out.println("\n-- Tomate --");
        estoque.tomateEstoque.exibirDataValidade();
        estoque.tomateEstoque.diasParaVencer();
        estoque.tomateEstoque.verificarSeEstaVencido();
    }
    // Metodo que mostra todos os produtos com garantia
    public void mostrarGarantia() {
        System.out.println("\n=== PRODUTOS COM GARANTIA ===");
        System.out.println("-- Detergente --");
        estoque.detergenteEstoque.exibirTermosGarantia();

        System.out.println("\n-- Sabonete --");
        estoque.saboneteEstoque.exibirTermosGarantia();
    }
    // Metodo que mostra todos os produtos com garantia
    public void aplicandoGarantia() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Selecione uma opção abaixo:");
        System.out.println("1 - Detergente");
        System.out.println("2 - Sabonete");
        System.out.print("Opção: ");

        int opcao = scanner.nextInt();

        System.out.println("\n=== APLICANDO GARANTIA ===");

        switch (opcao) {
            case 1:
                System.out.println("-- Detergente --");
                estoque.detergenteEstoque.aplicarGarantia();
                break;
            case 2:
                System.out.println("-- Sabonete --");
                estoque.saboneteEstoque.aplicarGarantia();
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }
    }
}

