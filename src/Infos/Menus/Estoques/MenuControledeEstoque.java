package Infos.Menus.Estoques;

import Infos.EstoqueInsuficienteException;
import Infos.Menus.GerenciadorArquivos;
import Infos.Produtos.SubProdutos.Carne;
import Infos.Produtos.SubProdutos.Detergente;
import Infos.Produtos.SubProdutos.Leite;
import Infos.Produtos.SubProdutos.Sabonete;
import Infos.Produtos.SubProdutos.Tomate;

public class MenuControledeEstoque {

    /** Estoque dos produtos disponíveis. Tornado público para
     *  permitir o acesso pelos usuários localizados em subpacotes. */
    public Carne carneEstoque = new Carne("Alcatra Bovina", 20, 47.90, "01/01/2023");
    public Detergente detergenteEstoque = new Detergente("Detergente Ypê Neutro",100, 2.99);
    public Tomate tomateEstoque = new Tomate("Tomate Carmem",40, 1.89, "01/01/2025");
    public Leite leiteEstoque = new Leite("Leite CooperRita", 15, 4.99, "01/01/2026");
    public Sabonete saboneteEstoque = new Sabonete("Sabonete Francis", 45, 2.89);

    private final GerenciadorArquivos arquivo;

    public MenuControledeEstoque() { //Construtor da classe
        arquivo = new GerenciadorArquivos("src/Infos/estoque.txt");
        arquivo.carregarEstoque(this); // Preenche os atributos da intancia atual com os dados do arquivo
    }

    public void salvarArquivo() {
        arquivo.salvarEstoque(this);
    }

    public void menuestoque(String nomeProduto, int quantidadevend) throws EstoqueInsuficienteException {
        switch (nomeProduto.toLowerCase()) {
            case "carne":
                if (quantidadevend > carneEstoque.getQuantidade()) {
                    throw new EstoqueInsuficienteException("Estoque insuficiente de " + carneEstoque.getNome());
                }
                carneEstoque.setQuantidade(carneEstoque.getQuantidade() - quantidadevend);
                System.out.println("Venda realizada: " + quantidadevend + " unidades de " + carneEstoque.getNome());
                System.out.println("Estoque restante: " + carneEstoque.getQuantidade());
                salvarArquivo();
                break;
            case "detergente":
                if (quantidadevend > detergenteEstoque.getQuantidade()) {
                    throw new EstoqueInsuficienteException("Estoque insuficiente de " + detergenteEstoque.getNome());
                }
                detergenteEstoque.setQuantidade(detergenteEstoque.getQuantidade() - quantidadevend);
                System.out.println("Venda realizada: " + quantidadevend + " unidades de " + detergenteEstoque.getNome());
                System.out.println("Estoque restante: " + detergenteEstoque.getQuantidade());
                salvarArquivo();
                break;
            case "tomate":
                if (quantidadevend > tomateEstoque.getQuantidade()) {
                    throw new EstoqueInsuficienteException("Estoque insuficiente de " + tomateEstoque.getNome());
                }
                tomateEstoque.setQuantidade(tomateEstoque.getQuantidade() - quantidadevend);
                System.out.println("Venda realizada: " + quantidadevend + " unidades de " + tomateEstoque.getNome());
                System.out.println("Estoque restante: " + tomateEstoque.getQuantidade());
                salvarArquivo();
                break;
            case "leite":
                if (quantidadevend > leiteEstoque.getQuantidade()) {
                    throw new EstoqueInsuficienteException("Estoque insuficiente de " + leiteEstoque.getNome());
                }
                leiteEstoque.setQuantidade(leiteEstoque.getQuantidade() - quantidadevend);
                System.out.println("Venda realizada: " + quantidadevend + " unidades de " + leiteEstoque.getNome());
                System.out.println("Estoque restante: " + leiteEstoque.getQuantidade());
                salvarArquivo();
                break;
            case "sabonete":
                if (quantidadevend > saboneteEstoque.getQuantidade()) {
                    throw new EstoqueInsuficienteException("Estoque insuficiente de " + saboneteEstoque.getNome());
                }
                saboneteEstoque.setQuantidade(saboneteEstoque.getQuantidade() - quantidadevend);
                System.out.println("Venda realizada: " + quantidadevend + " unidades de " + saboneteEstoque.getNome());
                System.out.println("Estoque restante: " + saboneteEstoque.getQuantidade());
                salvarArquivo();
                break;
            default:
                System.out.println("Produto não encontrado.");
        }
    }

}