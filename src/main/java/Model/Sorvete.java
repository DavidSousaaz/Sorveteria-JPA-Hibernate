package Model;

import lombok.*;

import javax.persistence.*;
import java.math.*;
import java.util.*;

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

