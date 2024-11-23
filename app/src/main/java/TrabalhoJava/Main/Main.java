package TrabalhoJava.Main;

import TrabalhoJava.BancoDeDados.Controllers.UsuarioController;
import TrabalhoJava.BancoDeDados.Models.UsuarioRepositorio;
import TrabalhoJava.Entidades.Usuario;
import TrabalhoJava.Telas.Garcom.TelaAdicionarPedidos;
import TrabalhoJava.Telas.Garcom.TelaPedidos;
import TrabalhoJava.Telas.Gestor.TelaAdicionarAoCardapio;
import TrabalhoJava.Telas.Gestor.TelaListarCardapio;
import TrabalhoJava.Telas.Sistema.TelaLogin;
import TrabalhoJava.Telas.Sistema.TelaZero;
import TrabalhoJava.BancoDeDados.Outros.CriarDB;
import TrabalhoJava.Telas.Adm.TelaNovaConta;

import javax.swing.*;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        if (!CriarDB.bancoExiste()) //Checa se banco ja existe, caso nao existir cria o arquivo do banco
        {
            CriarDB.criarArquivo();
            JOptionPane.showMessageDialog(null, "Banco Criado!\nArquivo: "+CriarDB.localbanco);
        }
        UsuarioController uc = new UsuarioController();
        List<Usuario> ls = uc.listarUsuarios();
        if (ls.size()>0) new TelaLogin().setVisible(true);
        else new TelaZero().setVisible(true);
    }
}