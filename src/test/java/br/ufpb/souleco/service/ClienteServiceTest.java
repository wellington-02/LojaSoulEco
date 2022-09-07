package br.ufpb.souleco.service;

import br.ufpb.souleco.classes.Produto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClienteServiceTest {

    @Test
    void cadastrarERemover() {
        Produto produto = new Produto("a", 1, 2,"");

        assertTrue(ProdutoService.cadastrar(produto));
        assertFalse(ProdutoService.cadastrar(produto));
        assertTrue(ProdutoService.removerProduto(produto.getNome()));
    }

    @Test
    @DisplayName("Produto nulo não pode ser cadastrado")
    void cadastrarProdutoNulo(){
        Produto produtoNulo = null;
        assertThrows(NullPointerException.class, () -> ProdutoService.cadastrar(produtoNulo));
    }

    @Test
    void clientesComOnome() {
        Produto produto = new Produto("a", 1, 2,"");
        assertTrue(ProdutoService.cadastrar(produto));


    }
}