package Infos.Usuarios;

public class Vendedor extends Usuario {

    public Vendedor(String nome, String cargo, int cpf, double salario){super(nome, cargo, cpf, salario);}

    @Override
    public void exibirInfo(){
        System.out.println("Informações do Usuário: ");
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + cpf);
        System.out.println("Salário: " + salario);
        System.out.println("Cargo: " + cargo);
    }
    
    //Métodos
    public void vender(){

    }
}
