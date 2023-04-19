package br.edu.fesfafic.hotel.Model;

public class MobiliaEVaranda {
    public int camaDeCasal;
    public int camaDeSolteiro;
    public boolean arcondicionado;
    public boolean banheira;
    public boolean varanda;

    public MobiliaEVaranda(int camaDeCasal, int camaDeSolteiro, boolean arcondicionado, boolean banheira, boolean varanda) {
        this.camaDeCasal = camaDeCasal;
        this.camaDeSolteiro = camaDeSolteiro;
        this.arcondicionado = arcondicionado;
        this.banheira = banheira;
        this.varanda = varanda;
    }

    public int getCamaDeCasal() {
        return camaDeCasal;
    }

    public void setCamaDeCasal(int camaDeCasal) {
        this.camaDeCasal = camaDeCasal;
    }

    public int getCamaDeSolteiro() {
        return camaDeSolteiro;
    }

    public void setCamaDeSolteiro(int camaDeSolteiro) {
        this.camaDeSolteiro = camaDeSolteiro;
    }

    public boolean isArcondicionado() {
        return arcondicionado;
    }

    public void setArcondicionado(boolean arcondicionado) {
        this.arcondicionado = arcondicionado;
    }

    public boolean isBanheira() {
        return banheira;
    }

    public void setBanheira(boolean banheira) {
        this.banheira = banheira;
    }

    public boolean isVaranda() {
        return varanda;
    }

    public void setVaranda(boolean varanda) {
        this.varanda = varanda;
    }

    @Override
    public String toString() {
        return "MobiliaEVaranda{" +
                "camaDeCasal=" + camaDeCasal +
                ", camaDeSolteiro=" + camaDeSolteiro +
                ", arcondicionado=" + arcondicionado +
                ", banheira=" + banheira +
                ", varanda=" + varanda +
                '}';
    }
}
