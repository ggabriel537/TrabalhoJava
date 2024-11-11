package TrabalhoJava.BancoDeDados.Controllers;

import TrabalhoJava.BancoDeDados.Models.ItemRepositorio;
import TrabalhoJava.Entidades.Item;
import java.util.List;

public class ItemController {
    private static ItemRepositorio itemRepositorio;

    public ItemController() {
        this.itemRepositorio = new ItemRepositorio();
    }

    public static int salvarItem(String nomeItem, double preco, String descricao) {
        Item item = new Item();
        item.setNomeItem(nomeItem);
        item.setPreco(preco);
        item.setDescricao(descricao);
        itemRepositorio.salvar(item);

        return 1;
    }

    public static List<Item> listarItens() {
        return ItemRepositorio.listar();
    }

    public void deletarItem(int id) {
        itemRepositorio.deletar(id);
    }

    public void atualizarItem(int id, String nomeItem, double preco, String descricao) {
        Item item = new Item();
        item.setId(id);
        item.setNomeItem(nomeItem);
        item.setPreco(preco);
        item.setDescricao(descricao);
        itemRepositorio.atualizar(item);
    }
}
