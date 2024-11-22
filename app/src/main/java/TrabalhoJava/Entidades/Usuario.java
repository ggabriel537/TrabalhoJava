package TrabalhoJava.Entidades;

import javax.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @Column(name = "username", nullable = false, unique = true, length = 50)
    private String user;

    @Column(name = "senha", nullable = false, length = 100)
    private String senha;

    @Column(name = "permissao", nullable = false)
    private int permissao;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getPermissao() {
        return permissao;
    }

    public void setPermissao(int permissao) {
        this.permissao = permissao;
    }
}
