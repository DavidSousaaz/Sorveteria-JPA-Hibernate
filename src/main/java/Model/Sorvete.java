package Model;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity(name = "tb_sorvete")
@Getter
@Setter
public class Sorvete {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sabor;
    private String tipo;
    private BigDecimal preco;

    @OneToMany(mappedBy = "sorvete")
    private List<ItemPedido> itens;

}

