package TrabalhoJava.BancoDeDados.Controllers;

import TrabalhoJava.BancoDeDados.Models.PedidoRepositorio;
import TrabalhoJava.Entidades.*;
import java.util.List;

public class PedidoController {
    private PedidoRepositorio pedidoRepositorio;

    public PedidoController() {
        this.pedidoRepositorio = new PedidoRepositorio();
    }

    public void salvarPedido(int mesa, String item) {
        Entidades.Pedido pedido = new Entidades.Pedido();
        pedido.setMesa(mesa);
        pedido.setItem(item);
        pedidoRepositorio.salvar(pedido);
    }

    public List<Entidades.Pedido> listarPedidos() {
        return pedidoRepositorio.listar();
    }

    public void deletarPedido(int id) {
        pedidoRepositorio.deletar(id);
    }

    public void atualizarPedido(int id, int mesa, String item) {
        Entidades.Pedido pedido = new Entidades.Pedido();
        pedido.setId(id);
        pedido.setMesa(mesa);
        pedido.setItem(item);
        pedidoRepositorio.atualizar(pedido);
    }
}
