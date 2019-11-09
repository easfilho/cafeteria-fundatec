package br.com.fundatec.camadas.service;

import br.com.fundatec.camadas.model.Pedido;
import br.com.fundatec.camadas.model.Produto;
import br.com.fundatec.camadas.repository.PedidoRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class PedidoServiceTest {

    private PedidoService pedidoService;
    private ProdutoService produtoService;
    private PedidoRepository pedidoRepository;

    @Before
    public void setUp() {
        produtoService = Mockito.mock(ProdutoService.class);
        pedidoRepository = Mockito.mock(PedidoRepository.class);
        pedidoService = new PedidoService();
        pedidoService.setProdutoService(produtoService);
        pedidoService.setPedidoRepository(pedidoRepository);
    }

    @Test
    public void deveIncluirUmPedido() {
        Long idProduto = 1L;
        Integer quantidade = 2;
        Produto produto = new Produto(1L, "Café", 3D);
        Mockito.when(produtoService.consultar(idProduto)).thenReturn(produto);
        Pedido esperado = new Pedido("Café", quantidade, 6D);
        Mockito.when(pedidoRepository.incluir(esperado)).thenReturn(esperado);
        Pedido resultado = pedidoService.incluir(idProduto, quantidade);
        Assert.assertEquals(resultado.getQuantidade(), quantidade);
        Assert.assertEquals(resultado.getNomeProduto(), "Café");
        Assert.assertEquals(resultado.getValorTotal(), new Double("6"));
    }
}