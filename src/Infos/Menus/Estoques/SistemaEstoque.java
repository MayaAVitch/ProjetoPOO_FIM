package Infos.Menus.Estoques;

import Infos.Menus.InterfaceUsuario;
import Infos.Usuarios.Gerente;
import Infos.Usuarios.Vendedor;

public class SistemaEstoque {
    private MenuControledeEstoque estoque;
    private InterfaceUsuario interfaceUsuario;

    public SistemaEstoque() {
        this.estoque = new MenuControledeEstoque();
        this.interfaceUsuario = new InterfaceUsuario();
    }

    public void iniciar() {
        // Cadastro de usuários de exemplo
        Gerente gerente = new Gerente("João Silva", "Gerente", 123456789, 5000.00);
        Vendedor vendedor = new Vendedor("Maria Souza", "Vendedor", 987654321, 2500.00);

        interfaceUsuario.mostrarMensagemInicial();
        int tipoUsuario = interfaceUsuario.solicitarTipoUsuario();

        if (tipoUsuario == 1) {
            interfaceUsuario.menuGerente(gerente, estoque);
        } else if (tipoUsuario == 2) {
            interfaceUsuario.menuVendedor(vendedor, estoque);
        } else {
            interfaceUsuario.mostrarMensagemErro("Opção inválida!");
        }
    }
}