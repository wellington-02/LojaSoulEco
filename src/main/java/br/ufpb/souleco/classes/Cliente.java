package br.ufpb.souleco.classes;

public class Cliente {
    private String nome;
    private String cpf;
    private int cep;
    private String nomeDeUsuario;
    private String senha;
    private boolean logado;

    public Cliente(String nome,String cpf, int cep,String nomeDeUsuario, String senha){
        this.nome = nome;
        this.cpf = cpf;
        this.cep = cep;
        this.nomeDeUsuario = nomeDeUsuario;
        this.senha = senha;
    }
    public Cliente(String nome,String cpf, int cep,String nomeDeUsuario, String senha, boolean logado){
        this.nome = nome;
        this.cpf = cpf;
        this.cep = cep;
        this.nomeDeUsuario = nomeDeUsuario;
        this.senha = senha;
        this.logado = logado;
    }
    public Cliente(String nome,String cpf, int cep){
        this.nome = nome;
        this.cpf = cpf;
        this.cep = cep;
    }
    public Cliente(){
        this("","",0,"","");
    }



    @Override
    public String toString() {
        return "Cliente: " +this.nome+ ", CPF: " +this.cpf+ ", Cep: "+this.cep;
    }

    public String getNomeDeUsuario() {
        return nomeDeUsuario;
    }

    public void setNomeDeUsuario(String nomeDeUsuario) {
        this.nomeDeUsuario = nomeDeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public boolean isLogado() {
        return logado;
    }

    public void setLogado(boolean logado) {
        this.logado = logado;
    }

}