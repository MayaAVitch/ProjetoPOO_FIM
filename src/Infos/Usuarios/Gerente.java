package Infos.Usuarios;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import Infos.MenuControledeEstoque;
import Infos.EstoqueInsuficienteException;


public class Gerente extends Usuario{
    public Gerente(String nome, String cargo, int cpf, double salario){super(nome, cargo, cpf, salario);}

    @Override
    public void exibirInfo(){
        System.out.println("Informações do Usuário: ");
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + cpf);
        System.out.println("Salário: " + salario);
        System.out.println("Cargo: " + cargo);
    }

    public void vender(MenuControledeEstoque menu) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome do produto a vender: ");
        String produto = scanner.nextLine();

        System.out.print("Digite a quantidade a vender: ");
        int quantidade = scanner.nextInt();

        try {
            menu.menuestoque(produto, quantidade);

            if (verificarEstoqueZerado(menu, produto)) {
                System.out.println("Estoque zerado após a venda!");
                comprar(menu, produto);
            }

        } catch (EstoqueInsuficienteException e) {
            System.out.println("Erro na venda: " + e.getMessage());
        }
    }

    public void comprar(MenuControledeEstoque menu, String produto) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a quantidade para reabastecer " + produto + ": ");
        int quantidadeCompra = scanner.nextInt();

        switch (produto.toLowerCase()) {
            case "carne":
                menu.carneEstoque.setQuantidade(menu.carneEstoque.getQuantidade() + quantidadeCompra);
                break;
            case "detergente":
                menu.detergenteEstoque.setQuantidade(menu.detergenteEstoque.getQuantidade() + quantidadeCompra);
                break;
            case "tomate":
                menu.tomateEstoque.setQuantidade(menu.tomateEstoque.getQuantidade() + quantidadeCompra);
                break;
            case "leite":
                menu.leiteEstoque.setQuantidade(menu.leiteEstoque.getQuantidade() + quantidadeCompra);
                break;
            case "sabonete":
                menu.saboneteEstoque.setQuantidade(menu.saboneteEstoque.getQuantidade() + quantidadeCompra);
                break;
            default:
                System.out.println("Produto não encontrado para reabastecimento.");
                return;
        }

        System.out.println("Reabastecimento realizado. Novo estoque de " + produto + ": " + obterQuantidade(menu, produto));
    }

    private boolean verificarEstoqueZerado(MenuControledeEstoque menu, String produto) {
        switch (produto.toLowerCase()) {
            case "carne":
                return menu.carneEstoque.getQuantidade() == 0;
            case "detergente":
                return menu.detergenteEstoque.getQuantidade() == 0;
            case "tomate":
                return menu.tomateEstoque.getQuantidade() == 0;
            case "leite":
                return menu.leiteEstoque.getQuantidade() == 0;
            case "sabonete":
                return menu.saboneteEstoque.getQuantidade() == 0;
            default:
                return false;
        }
    }

    private int obterQuantidade(MenuControledeEstoque menu, String produto) {
        switch (produto.toLowerCase()) {
            case "carne":
                return menu.carneEstoque.getQuantidade();
            case "detergente":
                return menu.detergenteEstoque.getQuantidade();
            case "tomate":
                return menu.tomateEstoque.getQuantidade();
            case "leite":
                return menu.leiteEstoque.getQuantidade();
            case "sabonete":
                return menu.saboneteEstoque.getQuantidade();
            default:
                return -1;
        }
    }
}
