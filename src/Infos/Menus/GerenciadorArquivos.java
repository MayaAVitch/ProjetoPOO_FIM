package Infos.Menus;

import Infos.Menus.Estoques.MenuControledeEstoque;

import java.io.*;

public class GerenciadorArquivos {
    private final String caminho;

    public GerenciadorArquivos(String caminho) { //Atributo "caminho" que é passado no momento da criação do objeto
        this.caminho = caminho;
    }

    public void carregarEstoque(MenuControledeEstoque menu) { //Metodo que faz a leitura do arquivo e preenche os objetos de estoque com os dados encontrados.
        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) { //Abre o arquivo com o bufferedReader e garante que ele seja fechado por meio do try-with-resources.
            String linha = br.readLine(); //Lê e descarta pq é o cabeçalho
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(","); //divide a linha usando vírgulas
                if (partes.length < 3) continue; //Verifica se há pelo menos três partes: nome, quantidade e preço.
                String nome = partes[0].trim();
                int quantidade = Integer.parseInt(partes[1].trim()); //Converte essas partes para os tipos corretos.
                double preco = Double.parseDouble(partes[2].trim());

                switch (nome.toLowerCase()) { //Identifica o produto pelo nome e atualiza os objetos correspondentes no MenuControledeEstoque.
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

    public void salvarEstoque(MenuControledeEstoque menu) { // Metodo chamado no momento em que há alteração no estoque (venda ou reabastecimento), reescrevendo o arquivo com os dados atualizados.
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(caminho))) { //Sobrescreve o conteúdo anterior
            bw.write("nome, quantidade, preco\n"); //cabeçalho do arquivo
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