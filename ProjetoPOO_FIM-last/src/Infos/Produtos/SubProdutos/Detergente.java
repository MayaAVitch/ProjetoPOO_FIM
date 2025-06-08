package Infos.Produtos.SubProdutos;

import Infos.Produtos.Produto;
import Infos.Produtos.Interfaces.ProdutosComGarantia;

public class Detergente extends Produto implements ProdutosComGarantia {

    // Construtor
    public Detergente(String nome, int quantidade, double preco){super(nome, quantidade, preco);}

    // Metodos
    @Override
    public void exibirInformacoes(){
        System.out.println("O produto " + super.nome + " tem um preço de R$" + super.preco + " e uma quantidade de " + super.quantidade + " no estoque.");
    }

    // Exibe os termos de garantia específicos para detergente.
    @Override
    public void exibirTermosGarantia() {
        System.out.println("Garantia: 6 meses contra defeitos de fabricação");
    }

    // Simula a aplicação da garantia do produto.
    @Override
    public void aplicarGarantia() {
        System.out.println("Garantia aplicada! Detergente será substituído.");
    }
}
