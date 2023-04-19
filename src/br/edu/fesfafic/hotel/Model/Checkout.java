package br.edu.fesfafic.hotel.Model;

import java.util.Calendar;

public class  Checkout {
    public Recepcionista recepcionista;
    public Conta conta;
    public int ano;
    public int mes;
    public int dia;
    public int hora;
    public int minuto;
    public boolean checkoutCompleto;

    public Checkout(Conta conta, Recepcionista recepcionista){
        this.conta = conta;
        this.recepcionista = recepcionista;
        this.checkoutCompleto = false;
    }
    public void fazerCheckout(int dia, int mes, int ano){
        if(checkoutCompleto)
            System.out.println("Check-out já feito anteriormente.");
        else {
            conta.calcConta(dia, mes, ano);
            if(conta.isPago()) {
                conta.getCheckin().getSuite().setOcupado(false);
                Calendar calendar = Calendar.getInstance();
                this.ano = ano;
                this.mes = mes;
                this.dia = dia;
                this.hora = calendar.get(Calendar.HOUR_OF_DAY);
                this.minuto = calendar.get(Calendar.MINUTE);
                System.out.println("Check-out concluído.");
                this.checkoutCompleto = true;
            } else
                System.out.println("Pague e tente novamente.");
        }
    }

    public void fazerCheckout(){
        if(checkoutCompleto)
            System.out.println("Check-out já feito anteriormente.");
        else {
            conta.calcConta();
            if(conta.isPago()) {
                conta.getCheckin().getSuite().setOcupado(false);
                Calendar calendar = Calendar.getInstance();
                this.ano = calendar.get(Calendar.YEAR);
                this.mes = calendar.get(Calendar.MONTH) + 1;
                this.dia = calendar.get(Calendar.DAY_OF_MONTH);
                this.hora = calendar.get(Calendar.HOUR_OF_DAY);
                this.minuto = calendar.get(Calendar.MINUTE);
                System.out.println("Check-out concluído.");
                this.checkoutCompleto = true;
            } else
                System.out.println("Pague e tente novamente.");
        }
    }

    public Recepcionista getRecepcionista() {
        return recepcionista;
    }

    public int getAno() {
        return ano;
    }

    public int getMes() {
        return mes;
    }

    public int getDia() {
        return dia;
    }

    public int getHora() {
        return hora;
    }

    public int getMinuto() {
        return minuto;
    }

    public Conta getConta() {
        return conta;
    }


    @Override
    public String toString() {
        return "Checkout{" +
                "conta=" + this.conta +
                ", recepcionista=" + this.recepcionista +
                ", data=" + this.dia + "/" + this.mes + "/" + this.ano +
                ", horário=" + this.hora + "h" + this.minuto +
                ", checkoutCompleto=" + this.checkoutCompleto +
                "}";
    }
}

