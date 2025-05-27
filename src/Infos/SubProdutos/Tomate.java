package Infos.SubProdutos;

import Infos.Produto;
import Infos.Interfaces.ProdutoPerecivel;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Tomate extends Produto implements ProdutoPerecivel {
    // Variável
    private LocalDate dataValidade;

    // Construtor corrigido - faltava o parâmetro dataValidadeStr
    public Tomate(String nome, int quantidade, double preco, String dataValidadeStr) {
        super(nome, quantidade, preco);
        this.dataValidade = LocalDate.parse(dataValidadeStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("O produto " + super.nome +
                " tem um preço de R$" + super.preco +
                " e uma quantidade de " + super.quantidade +
                " no estoque.");
        exibirDataValidade(); // Chama o método da interface
        verificarSeEstaVencido(); // Chama o método da interface
    }

    @Override
    public void exibirDataValidade() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("Data de validade: " + dataValidade.format(formatter));
    }

    @Override
    public void verificarSeEstaVencido() {
        if (dataValidade.isBefore(LocalDate.now())) {
            System.out.println("ATENÇÃO: Este tomate está vencido!");
        } else {
            System.out.println("Produto dentro do prazo de validade.");
        }
    }

    @Override
    public void diasParaVencer() {
        long dias = java.time.temporal.ChronoUnit.DAYS.between(
                LocalDate.now(), dataValidade);
        System.out.println("Dias restantes para vencer: " + dias);
    }
}