package Infos.Usuarios;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import Infos.MenuControledeEstoque;


public class Gerente extends Usuario{
    public Gerente(String nome, String cargo, int cpf, double salario){super(nome, cargo, cpf, salario);}

    @Override
    public void exibirInfo(){
        System.out.println("Informações do Usuário: ");
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + cpf);
        System.out.println("Salário: " + salario);
        System.out.println("Cargo: " + cargo);
    }

    int quantComprar;

    public void vender(MenuControledeEstoque menu) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome do produto a vender: ");
        String produto = scanner.nextLine();

        System.out.print("Digite a quantidade a vender: ");
        int quantidade = scanner.nextInt();

        try {
            menu.menuestoque(produto, quantidade);
        } catch (EstoqueInsuficienteException e) {
            System.out.println("Erro na venda: " + e.getMessage());
        }
    }

    public void comprar(){

    }
}
