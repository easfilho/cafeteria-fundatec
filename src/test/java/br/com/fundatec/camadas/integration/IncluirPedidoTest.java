package br.com.fundatec.camadas.integration;

import br.com.fundatec.camadas.model.Pedido;
import br.com.fundatec.camadas.repository.BancoDados;
import br.com.fundatec.camadas.service.PedidoService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IncluirPedidoTest {

    private PedidoService pedidoService;

    @Before
    public void setUp() {
        pedidoService = new PedidoService();
    }

    @Test
    public void deveIncluirPedido() {
        Long idProduto = 1L;
        Integer quantidade = 3;
        pedidoService.incluir(idProduto, quantidade);
        Pedido pedidoIncluido = BancoDados.getPedidos().get(0);
        Assert.assertTrue(BancoDados.getPedidos().contains(pedidoIncluido));
        Assert.assertEquals("Pao de Queijo", pedidoIncluido.getNomeProduto());
        Assert.assertEquals(Double.valueOf(12), pedidoIncluido.getValorTotal());
        Assert.assertEquals(3, pedidoIncluido.getQuantidade().intValue());
    }
}
