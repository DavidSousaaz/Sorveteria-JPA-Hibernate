DROP DATABASE sorveteria;

CREATE DATABASE sorveteria;


use sorveteria;


--Visualizar Tabelas individualmente
select * from tb_sorvete;
select * from tb_pedido;
select * from tb_itempedido;
select * from tb_cliente;



--Visualizar pedido completo
SELECT 
    p.id AS pedido_id, 
    p.dataHora, 
    p.total, 
    c.nome AS cliente_nome, 
    i.id AS item_id, 
    i.quantidade, 
    i.precoUnitario, 
    s.sabor AS sabor_sorvete
FROM 
    tb_pedido p
LEFT JOIN 
    tb_itemPedido i ON p.id = i.pedido_id
LEFT JOIN 
    tb_sorvete s ON i.sorvete_id = s.id
LEFT JOIN 
    tb_cliente c ON p.cliente_id = c.id;



SHOW TABLES;