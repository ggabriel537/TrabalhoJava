package TrabalhoJava.BancoDeDados.Controllers;

import TrabalhoJava.BancoDeDados.Models.UsuarioRepositorio;
import TrabalhoJava.Entidades.Usuario;
import java.util.List;

public class UsuarioController {
    private static UsuarioRepositorio usuarioRepositorio;

    public UsuarioController() {
        this.usuarioRepositorio = new UsuarioRepositorio();
    }

    public int salvarUsuario(Usuario usr) {
        try{
            usuarioRepositorio.salvar(usr);
            return 1;
        }catch (Exception e)
        {
            System.err.println(e.getMessage());
        }
        return -1;
    }

    public List<Usuario> listarUsuarios() {
        return usuarioRepositorio.listar();
    }

    public void deletarUsuario(String username) {
        usuarioRepositorio.deletar(username);
    }

    public void atualizarUsuario(String username, String senha, int permissao) {
        Usuario usuario = new Usuario();
        usuario.setUser(username);
        usuario.setSenha(senha);
        usuario.setPermissao(permissao);
        usuarioRepositorio.atualizar(usuario);
    }
}
