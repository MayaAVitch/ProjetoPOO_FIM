package Infos.Usuarios;

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

    public void vender(){

    }

    public void comprar(){

    }
}
