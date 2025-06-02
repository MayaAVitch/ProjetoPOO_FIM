package Infos.SubProdutos;

import Infos.Produto;
import Infos.Interfaces.ProdutosComGarantia;

public class Detergente extends Produto implements ProdutosComGarantia {

    // Construtor
    public Detergente(String nome, int quantidade, double preco){super(nome, quantidade, preco);}

    // Metodos
    @Override
    public void exibirInformacoes(){
        System.out.println("O produto " + super.nome + " tem um preço de R$" + super.preco + " e uma quantidade de " + super.quantidade + " no estoque.");
    }

    @Override
    public void exibirTermosGarantia() {
        System.out.println("Garantia: 6 meses contra defeitos de fabricação");
    }

    @Override
    public void aplicarGarantia() {
        System.out.println("Garantia aplicada! Detergente será substituído.");
    }
}
