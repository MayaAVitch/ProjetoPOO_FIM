package Infos.Produtos;

public class Produto {
    // Variaveis
    protected String nome;
    protected int quantidade;
    protected double preco;

    // Construtor
    public Produto(String nome, int quantidade, double preco) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    // Exibir informações
    public void exibirInformacoes(){
        System.out.println("O produto " + nome + " tem um preço de R$" + preco + " e uma quantidade de " + quantidade + " no estoque.");
    }

    // Métodos getters para acesso aos atributos
    public String getNome() {
        return nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getPreco() {
        return preco;
    }

}
