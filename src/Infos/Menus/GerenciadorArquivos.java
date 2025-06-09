package Infos.Menus;

import Infos.Menus.Estoques.MenuControledeEstoque;

import java.io.*;

public class GerenciadorArquivos {
    private final String caminho;

    public GerenciadorArquivos(String caminho) {
        this.caminho = caminho;
    }

    public void carregarEstoque(MenuControledeEstoque menu) { //Metodo
        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            String linha = br.readLine(); // cabeçalho
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(",");
                if (partes.length < 3) continue;
                String nome = partes[0].trim();
                int quantidade = Integer.parseInt(partes[1].trim());
                double preco = Double.parseDouble(partes[2].trim());

                switch (nome.toLowerCase()) {
                    case "carne" -> {
                        menu.carneEstoque.setQuantidade(quantidade);
                        menu.carneEstoque.setPreco(preco);
                    }
                    case "leite" -> {
                        menu.leiteEstoque.setQuantidade(quantidade);
                        menu.leiteEstoque.setPreco(preco);
                    }
                    case "tomate" -> {
                        menu.tomateEstoque.setQuantidade(quantidade);
                        menu.tomateEstoque.setPreco(preco);
                    }
                    case "sabonete" -> {
                        menu.saboneteEstoque.setQuantidade(quantidade);
                        menu.saboneteEstoque.setPreco(preco);
                    }
                    case "detergente" -> {
                        menu.detergenteEstoque.setQuantidade(quantidade);
                        menu.detergenteEstoque.setPreco(preco);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler arquivo: " + e.getMessage());
        }
    }

    public void salvarEstoque(MenuControledeEstoque menu) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(caminho))) {
            bw.write("nome, quantidade, preco\n");
            bw.write("Carne, " + menu.carneEstoque.getQuantidade() + ", " + menu.carneEstoque.getPreco() + "\n");
            bw.write("Leite, " + menu.leiteEstoque.getQuantidade() + ", " + menu.leiteEstoque.getPreco() + "\n");
            bw.write("Tomate, " + menu.tomateEstoque.getQuantidade() + ", " + menu.tomateEstoque.getPreco() + "\n");
            bw.write("Sabonete, " + menu.saboneteEstoque.getQuantidade() + ", " + menu.saboneteEstoque.getPreco() + "\n");
            bw.write("Detergente, " + menu.detergenteEstoque.getQuantidade() + ", " + menu.detergenteEstoque.getPreco() + "\n");
        } catch (IOException e) {
            System.out.println("Erro ao salvar arquivo: ");
                     e.getMessage();
        }
    }
}