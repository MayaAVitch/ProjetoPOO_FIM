package Infos.Produtos.Interfaces;

public interface ProdutoPerecivel {
    // Apenas exibe a data de validade
    void exibirDataValidade();

    // Imprime diretamente se está vencido
    void verificarSeEstaVencido();

    // Dias restantes ate o produto vencer
    void diasParaVencer();
}
