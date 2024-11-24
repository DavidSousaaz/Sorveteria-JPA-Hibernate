import Model.*;
import controller.*;

public class testePedido {
    public static void main(String[] args) {

        PedidoController pedidoController = new PedidoController();

        for(Pedido p: pedidoController.listarTodosPedidos()){
            System.out.println(p.getId());
        }

        Pedido pedido = pedidoController.buscarPedidoPorId(1l);

        System.out.println(pedido.getCliente().getNome());
        for(ItemPedido i : pedido.getItens()){
            System.out.println(i.getSorvete().getSabor() + " " + i.getQuantidade() + " " + i.getPrecoUnitario() + "\n");
        }

        System.out.println(pedido.getTotal());

    }
}
