package br.ufpb.souleco.classes;


public class Venda {
    private int id;
    private String dataDaVenda;
    private String nomeProduto;
    private String cpfCliente;

    public Venda(String dataDaVenda, String nomeProduto, String cpfCliente){

        this.dataDaVenda = dataDaVenda;
        this.nomeProduto = nomeProduto;
        this.cpfCliente = cpfCliente;
    }

    public Venda(int id, String dataDaVenda, String nomeProduto, String cpfCliente){

        this.dataDaVenda = dataDaVenda;
        this.nomeProduto = nomeProduto;
        this.cpfCliente = cpfCliente;
        this.id = id;
    }
    public Venda (){
        this("","","");
    }

    public String getDataDaVenda() {
        return dataDaVenda;
    }

    public void setDataDaVenda(String dataDaVenda) {
        this.dataDaVenda = dataDaVenda;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }
}