package Infos.Usuarios;

public abstract class Usuario {
    //Variáveis
    protected String nome;
    protected int cpf;
    protected double salario;
    protected String cargo;

    public Usuario(String nome, String cargo, int cpf, double salario) {
        this.nome = nome;
        this.cargo = cargo;
        this.cpf = cpf;
        this.salario = salario;
    }

    //Métodos
    public void exibirInfo(){
        System.out.println("Informações do Usuário: ");
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + cpf);
        System.out.println("Salário: " + salario);
        System.out.println("Cargo: " + cargo);
    }

    public void vender(){

    }

    public void verificarEstoque(){

    }

    public String getNome() {
        return nome;
    }

    public int getCpf() {
        return cpf;
    }

    public double getSalario() {
        return salario;
    }

    public String getCargo() {
        return cargo;
    }
}