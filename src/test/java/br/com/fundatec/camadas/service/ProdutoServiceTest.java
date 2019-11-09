package br.com.fundatec.camadas.service;

import br.com.fundatec.camadas.model.Produto;
import br.com.fundatec.camadas.repository.ProdutoRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProdutoServiceTest {

    private ProdutoService produtoService;
    private ProdutoRepository produtoRepository;

    @Before
    public void setUp() throws Exception {
        produtoService = new ProdutoService();
        produtoRepository = Mockito.mock(ProdutoRepository.class);
        produtoService.setProdutoRepository(produtoRepository);
    }

    @Test
    public void deveConsultarUmProduto() {
        Produto p1 = new Produto(1L, "P1", 1D);
        Produto p2 = new Produto(2L, "P2", 2D);
        Produto p3 = new Produto(3L, "P3", 3D);

        List<Produto> listaProduto = Arrays.asList(p1, p2, p3);

        Mockito.when(produtoRepository.listar()).thenReturn(listaProduto);

        Produto resultado = produtoService.consultar(2L);

        Assert.assertEquals(p2, resultado);
    }
}
