package Infos.Menus.Estoques;

public class VisualizadorEstoque {
    private MenuControledeEstoque estoque;

    public VisualizadorEstoque(MenuControledeEstoque estoque) {
        this.estoque = estoque;
    }

    public void mostrarEstoque() {
        System.out.println("\n=== ESTOQUE ATUAL ===");
        System.out.println("Carne: " + estoque.carneEstoque.getQuantidade() + " unidades");
        System.out.println("Detergente: " + estoque.detergenteEstoque.getQuantidade() + " unidades");
        System.out.println("Tomate: " + estoque.tomateEstoque.getQuantidade() + " unidades");
        System.out.println("Leite: " + estoque.leiteEstoque.getQuantidade() + " unidades");
        System.out.println("Sabonete: " + estoque.saboneteEstoque.getQuantidade() + " unidades");
    }

    public void mostrarPereciveis() {
        System.out.println("\n=== PRODUTOS PERECÍVEIS ===");
        System.out.println("-- Carne --");
        estoque.carneEstoque.exibirDataValidade();
        estoque.carneEstoque.diasParaVencer();

        System.out.println("\n-- Leite --");
        estoque.leiteEstoque.exibirDataValidade();
        estoque.leiteEstoque.diasParaVencer();

        System.out.println("\n-- Tomate --");
        estoque.tomateEstoque.exibirDataValidade();
        estoque.tomateEstoque.diasParaVencer();
    }
}