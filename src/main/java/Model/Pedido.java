package Model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

@Entity(name = "tb_pedido")
@Getter
@Setter
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dataHora;
    private BigDecimal total;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemPedido> itens;

    // Construtor vazio
    public Pedido() {
        this.itens = new ArrayList<>();
        this.total = BigDecimal.ZERO;
    }

    // Método para adicionar itens ao pedido e calcular o total
    public void adicionarItem(ItemPedido item) {
        if (itens == null) {
            itens = new ArrayList<>();
        }
        itens.add(item);
        item.setPedido(this); // Configura a referência bidirecional
        calcularTotal(); // Atualiza o total do pedido
    }

    // Método para calcular o total do pedido com base nos itens
    public void calcularTotal() {
        BigDecimal soma = BigDecimal.ZERO;
        for (ItemPedido item : itens) {
            soma = soma.add(item.getPrecoUnitario().multiply(BigDecimal.valueOf(item.getQuantidade())));
        }
        this.total = soma; // Atribui a soma ao total do pedido
    }
}
