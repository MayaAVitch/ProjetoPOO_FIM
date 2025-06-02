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

    public void vender(){
        Scanner prodvend = new Scanner(System.in);
        System.out.print("Digite Produto a ser Vendido: ");
        String prodVender = prodvend.nextLine();

        switch (prodVender){
            case "Carne":
                Scanner quantidadevend = new Scanner(System.in);
                System.out.print("Digite Quantidade a ser Vendida: ");
                int quantVender = quantidadevend.nextInt();

                try {


                }catch (Exception e){
                    System.out.println("Erro: Estoque Insuficiente para Venda");
                    e.printStackTrace();
                }

        }



    }

    public void comprar(){

    }
}