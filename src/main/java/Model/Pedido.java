package Model;


import javax.persistence.*;
import java.math.*;
import java.time.*;
import java.util.*;

@Entity(name = "tb_pedido")
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

    public Pedido() {
        this.itens = new ArrayList<>();
        this.total = BigDecimal.ZERO;
    }

    public void adicionarItem(ItemPedido item) {
        if (itens == null) {
            itens = new ArrayList<>();
        }
        itens.add(item);
        item.setPedido(this); // Configura a referência bidirecional
        calcularTotal(); // Atualiza o total do pedido
    }

    public void calcularTotal() {
        BigDecimal soma = BigDecimal.ZERO;
        for (ItemPedido item : itens) {
            soma = soma.add(item.getPrecoUnitario().multiply(BigDecimal.valueOf(item.getQuantidade())));
        }
        this.total = soma; // Atribui a soma ao total do pedido
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedido> itens) {
        this.itens = itens;
    }
}
