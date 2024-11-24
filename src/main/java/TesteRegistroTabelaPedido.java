import Model.*;
import controller.*;

import java.math.BigDecimal;
import java.util.List;

public class TesteRegistroTabelaPedido {
    public static void main(String[] args) {
        // Criando instâncias dos controladores
        ClienteController clienteController = new ClienteController();
        ItemPedidoController itemPedidoController = new ItemPedidoController();
        PedidoController pedidoController = new PedidoController();
        SorveteController sorveteController = new SorveteController();

        // 1. Salvar Sorvetes
        Sorvete sorvete1 = sorveteController.buscarSorvetePorId(4l);

        Sorvete sorvete2 = sorveteController.buscarSorvetePorId(3l);


        // 3. Criar e salvar Pedido
        Pedido pedido = new Pedido();
        pedido.setDataHora(java.time.LocalDateTime.now());
        pedido.setCliente(clienteController.buscarClientePorId(4l)); // Associando cliente ao pedido

        // 4. Criar e adicionar Itens ao Pedido
        ItemPedido itemPedido1 = new ItemPedido();
        itemPedido1.setQuantidade(2);
        itemPedido1.setPrecoUnitario(sorvete1.getPreco());
        itemPedido1.setSorvete(sorvete1); // Associando o ItemPedido ao Sorvete
        pedido.adicionarItem(itemPedido1); // Adicionando o ItemPedido ao Pedido

        ItemPedido itemPedido2 = new ItemPedido();
        itemPedido2.setQuantidade(3);
        itemPedido2.setPrecoUnitario(sorvete2.getPreco());
        itemPedido2.setSorvete(sorvete2); // Associando o ItemPedido ao Sorvete
        pedido.adicionarItem(itemPedido2); // Adicionando o ItemPedido ao Pedido

        System.out.println("Pedido criado e itens adicionados:");
        System.out.println("Total do pedido: " + pedido.getTotal());
        System.out.println("Itens do pedido: ");
        for (ItemPedido item : pedido.getItens()) {
            System.out.println(item.getSorvete() + " " + item.getQuantidade());
        }

        // 5. Salvar os itens de pedido
        itemPedidoController.salvarItemPedido(itemPedido1);
        itemPedidoController.salvarItemPedido(itemPedido2);


        pedidoController.salvarPedido(pedido);


        // 6. Listar todos os pedidos
        List<Pedido> pedidos = pedidoController.listarTodosPedidos();
        System.out.println("Lista de Pedidos:");
        for (Pedido p : pedidos) {
            System.out.println(p.getCliente() + " " + p.getTotal());
        }

        // 7. Buscar pedido por ID
        Pedido pedidoEncontrado = pedidoController.buscarPedidoPorId(1l);
        if (pedidoEncontrado != null) {
            System.out.println("Pedido encontrado: " + pedidoEncontrado);
        } else {
            System.out.println("Pedido não encontrado com ID: " + pedido.getId());
        }

    }
}
