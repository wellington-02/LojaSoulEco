package br.ufpb.souleco.service;

import br.ufpb.souleco.bd.ProdutoDAO;
import br.ufpb.souleco.classes.Produto;

public class ProdutoService {

    public static boolean cadastrar(Produto produto){
        Produto produtoRepetido = ProdutoDAO.procurarProdutoNome(produto.getNome());

        if(produtoRepetido == null){
            ProdutoDAO.inserir(produto);

            return true;
        }else{
            return false;
        }
    }

    public static Produto procurarProduto(String nome){
        Produto produto = ProdutoDAO.procurarProdutoNome(nome);

        if(produto != null){
            return produto;
        }else{
            return null;
        }
    }

    public static boolean removerProduto(String nome){
        Produto produto = ProdutoDAO.procurarProdutoNome(nome);

        if(produto != null){
            ProdutoDAO.delete(produto);

            return true;
        }else{
            return false;
        }
    }
}
