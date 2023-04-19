package br.edu.fesfafic.hotel.Model;

public class Cozinheiro extends Colaborador {
    public Cozinheiro(String nome, String cpf, String rg){
        super(nome, cpf, rg);
    }

    @Override
    public String toString() {
        return "Cozinheiro{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", rg='" + rg + '\'' +
                '}';
    }
}
