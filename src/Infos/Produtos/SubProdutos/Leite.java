package Infos.Produtos.SubProdutos;

import Infos.Produtos.Produto;
import Infos.Produtos.Interfaces.ProdutoPerecivel;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Leite extends Produto implements ProdutoPerecivel {
    private LocalDate dataValidade; // Armazena a data de validade do leite

    // Construtor
    public Leite(String nome, int quantidade, double preco, String dataValidadeStr) {
        super(nome, quantidade, preco);
        // Converte a String da data para LocalDate usando o formato especificado
        this.dataValidade = LocalDate.parse(dataValidadeStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
    // Metodos
    // Exibe todas as informações do produto, incluindo dados básicos e informações de validade.
    @Override
    public void exibirInformacoes() {
        System.out.println("O produto " + super.nome +
                " tem um preço de R$" + super.preco +
                " e uma quantidade de " + super.quantidade +
                " no estoque.");
        exibirDataValidade(); // Mostra a data de validade
        verificarSeEstaVencido(); // Verifica e informa se está vencido
    }

    // Exibe a data de validade formatada.
    @Override
    public void exibirDataValidade() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("Data de validade: " + dataValidade.format(formatter));
    }

    // Verifica se o produto está vencido comparando com a data atual.
    // Exibe mensagem de alerta se estiver vencido.
    @Override
    public void verificarSeEstaVencido() {
        if (dataValidade.isBefore(LocalDate.now())) {
            System.out.println("ATENÇÃO: Este tomate está vencido!");
        } else {
            System.out.println("Produto dentro do prazo de validade.");
        }
    }

    // Calcula e exibe quantos dias faltam para o produto vencer.
    // Se o valor for negativo, significa que já está vencido.
    @Override
    public void diasParaVencer() {
        long dias = java.time.temporal.ChronoUnit.DAYS.between(
                LocalDate.now(), dataValidade);
        System.out.println("Dias restantes para vencer: " + dias);
    }
}

