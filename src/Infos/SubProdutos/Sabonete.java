package Infos.SubProdutos;

import Infos.Produto;

public class Sabonete extends Produto {
    public Sabonete(String nome, int quantidade, double preco){super(nome, quantidade, preco);}

    @Override
    public void exibirInformacoes(){
        System.out.println("O produto " + super.nome + " tem um preço de R$" + super.preco + " e uma quantidade de " + super.quantidade + " no estoque.");
    }
}
