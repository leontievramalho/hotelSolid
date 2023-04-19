package br.edu.fesfafic.hotel.Model;

public abstract class Colaborador {
    public String nome;
    protected String cpf;
    protected String rg;

    public Colaborador(String nome, String cpf, String rg){
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    protected String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    protected String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    @Override
    public String toString() {
        return "Colaborador{" +
                "nome='" + this.nome +
                ", cpf='" + this.cpf +
                ", rg='" + this.rg +
                '}';
    }
}


