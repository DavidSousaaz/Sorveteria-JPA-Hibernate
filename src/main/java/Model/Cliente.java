package Model;

import lombok.*;

import javax.persistence.*;
import java.util.*;

@Entity(name = "tb_cliente")
@Getter
@Setter
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String telefone;
    private String email;

    @OneToMany(mappedBy = "cliente")
    private List<Pedido> pedidos;

}