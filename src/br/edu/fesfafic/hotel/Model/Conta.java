package br.edu.fesfafic.hotel.Model;

import java.util.Calendar;

public class Conta {
    public Checkin checkin;
    public int diasHospedado;
    public String metodoPagamento;
    public double acrescimos;
    public double valor;
    public boolean pago;

    public Conta(Checkin checkin, String metodoPagamento, double acrescimos) {
        this.checkin = checkin;
        this.metodoPagamento = metodoPagamento;
        this.acrescimos = acrescimos;
    }

    public void calcConta(int dia, int mes, int ano){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, ano);
        calendar.set(Calendar.MONTH, mes-1);
        calendar.set(Calendar.DAY_OF_MONTH, dia);
        this.diasHospedado = (int) ((calendar.getTimeInMillis() - checkin.getDataMilisegundos())/86400000);
        this.valor = diasHospedado * checkin.getSuite().getDiaria() + acrescimos;
    }

    public void calcConta(){
        Calendar calendar = Calendar.getInstance();
        this.diasHospedado = (int) ((calendar.getTimeInMillis() - checkin.getDataMilisegundos())/86400000);
        this.valor = diasHospedado * checkin.getSuite().getDiaria() + acrescimos;
    }
    public void exibirContaFormatada(int dia, int mes, int ano){
        calcConta(dia, mes, ano);
        System.out.println("-- Conta do hotel - hóspede: " + checkin.getHospede().getNome() + " --");
        System.out.printf("%d diárias no valor de R$ %.2f \n", diasHospedado, checkin.getSuite().getDiaria());
        System.out.printf("+ R$ %.2f de acréscimos \n", acrescimos);
        System.out.printf("Total: R$ %.2f \n", valor);
    }
    public void exibirContaFormatada(){
        calcConta();
        System.out.println("-- Conta do hotel - hóspede: " + checkin.getHospede().getNome() + " --");
        System.out.printf("%d diárias no valor de R$ %.2f \n", diasHospedado, checkin.getSuite().getDiaria());
        System.out.printf("+ R$ %.2f de acréscimos \n", acrescimos);
        System.out.printf("Total: R$ %.2f \n", valor);
    }

    public int getDiasHospedado() {
        return diasHospedado;
    }

    public double getValor() {
        return valor;
    }

    public Checkin getCheckin() {
        return checkin;
    }

    public void setCheckin(Checkin checkin) {
        this.checkin = checkin;
    }

    public String getMetodoPagamento() {
        return metodoPagamento;
    }

    public void setMetodoPagamento(String metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    public double getAcrescimos() {
        return acrescimos;
    }

    public void setAcrescimos(double acrescimos) {
        this.acrescimos = acrescimos;
    }

    public boolean isPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }

    @Override
    public String toString() {
        return "Conta{" +
                "checkin=" + checkin +
                ", diasHospedado=" + diasHospedado +
                ", metodoPagamento='" + metodoPagamento + '\'' +
                ", acrescimos=" + acrescimos +
                ", valor=" + valor +
                ", pago=" + pago +
                '}';
    }
}
