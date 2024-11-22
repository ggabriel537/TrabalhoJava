package TrabalhoJava.BancoDeDados.Controllers;

import TrabalhoJava.BancoDeDados.Models.PedidoRepositorio;
import TrabalhoJava.Entidades.*;
import java.util.List;

public class PedidoController {
    private static PedidoRepositorio pedidoRepositorio;

    public PedidoController() {
        pedidoRepositorio = new PedidoRepositorio();
    }

    public static int salvarPedido(int mesa, String item) {
        Pedido pedido = new Pedido();
        pedido.setMesa(mesa);
        pedido.setItem(item);
        pedidoRepositorio.salvar(pedido);
        return 1;
    }

    public static List<Pedido> listarPedidos() {
        return pedidoRepositorio.listar();
    }

    public static int deletarPedido(int id) {
        pedidoRepositorio.deletar(id);
        return 1;
    }

    public void atualizarPedido(int id, int mesa, String item) {
        Pedido pedido = new Pedido();
        pedido.setId(id);
        pedido.setMesa(mesa);
        pedido.setItem(item);
        pedidoRepositorio.atualizar(pedido);
    }
}
