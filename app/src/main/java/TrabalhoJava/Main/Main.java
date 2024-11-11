package TrabalhoJava.Main;

import TrabalhoJava.Telas.Garcom.TelaAdicionarPedidos;
import TrabalhoJava.Telas.Garcom.TelaPedidos;
import TrabalhoJava.Telas.Gestor.TelaAdicionarAoCardapio;
import TrabalhoJava.Telas.Gestor.TelaListarCardapio;
import TrabalhoJava.Telas.Sistema.TelaLogin;
import TrabalhoJava.Telas.Sistema.TelaZero;
import TrabalhoJava.BancoDeDados.Outros.CriarDB;

import javax.swing.*;

public class Main {

    public static void main(String[] args) throws Exception {
        if (!CriarDB.bancoExiste()) //Checa se banco ja existe, caso nao existir cria o arquivo do banco
        {
            CriarDB.criarArquivo();
            JOptionPane.showMessageDialog(null, "Banco Criado!\nArquivo: "+CriarDB.localbanco);
        }

        new TelaAdicionarAoCardapio().setVisible(false);
        new TelaLogin().setVisible(false);
        new TelaZero().setVisible(false);
        //new TelaAdicionarPedidos().setVisible(true);
        
        new TelaPedidos().setVisible(true);
        new TelaListarCardapio().setVisible(false);

    }
}