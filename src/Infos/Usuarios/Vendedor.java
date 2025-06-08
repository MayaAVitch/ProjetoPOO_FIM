package Infos.Usuarios;

import Infos.EstoqueInsuficienteException;
import Infos.MenuControledeEstoque;

import java.util.Scanner;

public class Vendedor extends Usuario {

    public Vendedor(String nome, String cargo, int cpf, double salario) {
        super(nome, cargo, cpf, salario);
    }

    @Override
    public void exibirInfo() {
        System.out.println("Informações do Usuário: ");
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + cpf);
        System.out.println("Salário: " + salario);
        System.out.println("Cargo: " + cargo);
    }

    int quantVender;

    //Métodos
    public void vender(MenuControledeEstoque menu) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome do produto a vender: ");
        String produto = scanner.nextLine();

    }
}