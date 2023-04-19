package br.edu.fesfafic.hotel.Model;

import java.util.*;

public class Checkin {
    public Suite suite;
    public Hospede hospede;
    public Recepcionista recepcionista;
    public int ano;
    public int mes;
    public int dia;
    public int hora;
    public int minuto;
    public long dataMilisegundos;
    public boolean checkinCompleto;

    public Checkin(Hospede hospede, Recepcionista recepcionista){
        this.hospede = hospede;
        this.recepcionista = recepcionista;
        this.checkinCompleto = false;
    }

    public void fazerCheckin(Suite suite){
        if(this.checkinCompleto)
            System.out.println("Check-in já foi feito anteriormente.");
        else if(suite.isOcupado() || suite.getCapacidade() < hospede.getNumPessoas())
            System.out.println("Suíte indisponível.");
        else {
            Calendar calendar = Calendar.getInstance();
            this.suite = suite;
            this.ano = calendar.get(Calendar.YEAR);
            this.mes = calendar.get(Calendar.MONTH) + 1;
            this.dia = calendar.get(Calendar.DAY_OF_MONTH);
            this.hora = calendar.get(Calendar.HOUR_OF_DAY);
            this.minuto = calendar.get(Calendar.MINUTE);
            this.dataMilisegundos = calendar.getTimeInMillis();
            this.suite.setOcupado(true);
            this.checkinCompleto = true;
            System.out.println("Check-in concluído com sucesso!");
        }
    }
    public void fazerCheckin(Suite suite, int dia, int mes, int ano){
        if(checkinCompleto)
            System.out.println("Check-in já foi feito anteriormente.");
        else if(suite.isOcupado() || suite.getCapacidade() < hospede.getNumPessoas())
            System.out.println("Suíte indisponível.");
        else {
            Calendar calendar = Calendar.getInstance();
            this.suite = suite;
            calendar.set(Calendar.DAY_OF_MONTH, dia);
            calendar.set(Calendar.MONTH, mes-1);
            calendar.set(Calendar.YEAR, ano);
            this.ano = calendar.get(Calendar.YEAR);
            this.mes = calendar.get(Calendar.MONTH) + 1;
            this.dia = calendar.get(Calendar.DAY_OF_MONTH);
            this.hora = calendar.get(Calendar.HOUR_OF_DAY);
            this.minuto = calendar.get(Calendar.MINUTE);
            this.dataMilisegundos = calendar.getTimeInMillis();
            this.suite.setOcupado(true);
            this.checkinCompleto = true;
            System.out.println("Check-in concluído com sucesso!");
        }
    }
    public void setSuite(Suite suite){
        this.suite = suite;
    }
    public Suite getSuite(){
        return this.suite;
    }

    public Hospede getHospede() {
        return hospede;
    }

    public void setHospede(Hospede hospede) {
        this.hospede = hospede;
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

    public long getDataMilisegundos() {
        return dataMilisegundos;
    }

    public void setCheckinCompleto(boolean checkinCompleto) {
        this.checkinCompleto = checkinCompleto;
    }

    public boolean isCheckinCompleto() {
        return checkinCompleto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Checkin checkin = (Checkin) o;
        return Objects.equals(hospede, checkin.hospede);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hospede);
    }

    @Override
    public String toString(){
        return "Checkin{" +
                "hospede=" + this.hospede +
                ", suite=" + this.suite +
                ", recepcionista=" + this.recepcionista +
                ", data=" + this.dia + "/" + this.mes + "/" + this.ano +
                ", horário=" + this.hora + "h" + this.minuto +
                ", checkinCompleto=" + this.checkinCompleto +
                "}";

    }
}
