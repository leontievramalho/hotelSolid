package br.edu.fesfafic.hotel.Model;

public class Recepcionista extends Colaborador {
    public Recepcionista(String nome, String cpf, String rg){
        super(nome, cpf, rg);
    }

    @Override
    public String toString() {
        return "Recepcionista{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", rg='" + rg + '\'' +
                '}';
    }
}
