package br.ufpb.souleco.classes;

public class Produto {
    private String nome;
    private double preco;
    private int quantidadeEmEstoque;
    private String foto;

    public Produto(String nome, double preco, int quantidadeEmEstoque, String foto){
        this.nome = nome;
        this.preco = preco;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
        this.foto = foto;
    }

    public Produto(){
        this("", 0.0, 0, "");
    }


    @Override
    public String toString() {

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Nome: ");
        stringBuffer.append(this.nome);
        stringBuffer.append("\nPreço: ");
        stringBuffer.append(this.preco);
        stringBuffer.append(" \nQuantidade disponível: ");
        stringBuffer.append(this.quantidadeEmEstoque);

        return stringBuffer.toString();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }

    public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }



}