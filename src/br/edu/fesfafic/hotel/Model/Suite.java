package br.edu.fesfafic.hotel.Model;

public class Suite {
    public int numero;
    public int capacidade;
    public double diaria;
    public boolean ocupado;
    public MobiliaEVaranda mobiliaEVaranda;

    public Suite(int numero, double diaria, MobiliaEVaranda mobiliaEVaranda){
        this.numero = numero;
        this.diaria = diaria;
        this.mobiliaEVaranda = mobiliaEVaranda;
        this.capacidade = 2*mobiliaEVaranda.camaDeCasal + mobiliaEVaranda.camaDeSolteiro;
        this.ocupado = false;
    }

    public int getNumero() {
        return numero;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public double getDiaria() {
        return diaria;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setDiaria (double status) {this.diaria = status;}

    public void setOcupado (boolean status) {this.ocupado = status;}

    @Override
    public String toString() {
        return "Suite{" +
                "numero=" + numero +
                ", capacidade=" + capacidade +
                ", diaria=" + diaria +
                ", ocupado=" + ocupado +
                ", mobiliaEVaranda=" + mobiliaEVaranda +
                '}';
    }
}
