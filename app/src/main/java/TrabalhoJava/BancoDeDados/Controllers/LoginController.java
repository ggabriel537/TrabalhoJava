package TrabalhoJava.BancoDeDados.Controllers;


import java.util.List;

import TrabalhoJava.BancoDeDados.Models.UsuarioRepositorio;
import TrabalhoJava.Entidades.Usuario;
import TrabalhoJava.Telas.Adm.TelaAdministrador;
import TrabalhoJava.Telas.Garcom.TelaPedidos;
import TrabalhoJava.Telas.Gestor.TelaCardapio;

public class LoginController {
    public static boolean validaLogin(String user, String senha) {
        boolean sucesso;
        sucesso = false;


        if (senha != null && !senha.isEmpty() && user != null && !user.isEmpty()) {
            UsuarioRepositorio usuarioRepositorio = new UsuarioRepositorio();
            List<Usuario> loginList = usuarioRepositorio.listar();
            for (Usuario loginL : loginList) {
                System.out.println("User:" + user + "\nSenha:" + senha);
                if (user.equals(loginL.getUser())) {
                    if (senha.equals(loginL.getSenha())) {
                        sucesso = true;
                        System.out.println(loginL.getPermissao());
                        System.err.print("Logado Com sucesso");
                        //Qual o tipo de permissão/usuário?
                        //Para descobir... Que tal:
                        int permissao = loginL.getPermissao();


                        //Para fazer isso aqui em cima, vai precisar primeiro adicionar esse campo na entidade e no banc -> tá FEITO :D

                        //Dependendo do tipo, haverá um CASE para cada, chamando as telas de acordo.
                        //Isso serve para separar as funções disponiveis para cada usuario

                        switch (permissao) {
                            case 0:
                                new TelaPedidos().setVisible(true);
                                break;

                            case 1:
                                new TelaCardapio().setVisible(true);
                                break;

                            case 2:
                                new TelaAdministrador().setVisible(true);
                                break;

                            default:
                                //N/A
                                break;
                        }
                    }
                }
            }
        } else {
            //Dados Invalidos // Tratar TELA
            System.err.print("Dados invalidos");
            return false;
        }

        if (sucesso == false) {
            System.err.print("Usuario ou senha inválidos");
            return false;
        } else {
            System.err.print("Logado Com sucesso");
            return true;
        }
    }
}