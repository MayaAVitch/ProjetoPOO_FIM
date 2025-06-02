package Infos.SubProdutos;

import Infos.Produto;
import Infos.Interfaces.ProdutosComGarantia;

public class Sabonete extends Produto implements ProdutosComGarantia {
    // Construtor
    public Sabonete(String nome, int quantidade, double preco) {super(nome, quantidade, preco);}

    // Metodos
    @Override
    public void exibirInformacoes(){
        System.out.println("O produto " + super.nome + " tem um preço de R$" + super.preco + " e uma quantidade de " + super.quantidade + " no estoque.");
    }

    // Exibe os termos de garantia específicos para sabonetes.
    @Override
    public void exibirTermosGarantia() {
        System.out.println("Garantia: 1 meses contra defeitos de fabricação");
    }

    // Simula a aplicação da garantia do produto.
    @Override
    public void aplicarGarantia() {
        System.out.println("Garantia aplicada! Sabonete será substituída.");
    }
}
