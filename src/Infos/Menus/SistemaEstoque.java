package Infos.Menus;

import Infos.MenuControledeEstoque;
import Infos.Usuarios.Gerente;
import Infos.Usuarios.Vendedor;

public class SistemaEstoque {
    // "Chamando" outras classses
    private MenuControledeEstoque estoque;
    private InterfaceUsuario interfaceUsuario;

    // Construtor
    public SistemaEstoque() {
        this.estoque = new MenuControledeEstoque();
        this.interfaceUsuario = new InterfaceUsuario();
    }

    // Metodo paraInicializando todo o sistema da main
    public void iniciar() {
        // Cadastro de usuários
        Gerente gerente = new Gerente("João Silva", "Gerente", 123456789, 5000.00);
        Vendedor vendedor = new Vendedor("Maria Souza", "Vendedor", 987654321, 2500.00);

        // Solicita o tipo de Usuario apartir de outra classe
        interfaceUsuario.mostrarMensagemInicial();
        // Variavel que armazena o tipo de usuario
        int tipoUsuario = interfaceUsuario.solicitarTipoUsuario();

        // Logica para chamar o meno de cada usuario especifico
        if (tipoUsuario == 1) {
            // Gerente
            interfaceUsuario.menuGerente(gerente, estoque);
        } else if (tipoUsuario == 2) {
            // Vendedor
            interfaceUsuario.menuVendedor(vendedor, estoque);
        } else {
            // Mensagem Padrão
            interfaceUsuario.mostrarMensagemErro("Opção inválida!");
        }
    }
}