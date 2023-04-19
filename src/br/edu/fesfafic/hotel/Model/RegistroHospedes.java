package br.edu.fesfafic.hotel.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class RegistroHospedes {

    public List<Checkin> checkinsAtv;
    public List<Checkin> regCheckins;
    public List<Checkout> regCheckout;

    public RegistroHospedes(){
        this.checkinsAtv = new ArrayList<>();
        this.regCheckins = new ArrayList<>();
        this.regCheckout = new ArrayList<>();
    }

    public void addCheckinAtv(Checkin checkin){
        if(checkin.isCheckinCompleto())
            this.checkinsAtv.add(checkin);
        else
            System.out.println("O checkin ainda não foi finalizado.");
    }
    public void removeCheckinAtv(Checkin checkin){
        this.checkinsAtv.remove(checkin);
    }

    public void exibirCheckinsAtv(){
        System.out.println("Checkins Ativos: ");
        if(this.checkinsAtv.isEmpty())
            System.out.println("Nenhum hóspede no hotel.");
        else {
            ListIterator<Checkin> enumerate = this.checkinsAtv.listIterator();
            while(enumerate.hasNext()) {
                System.out.println(enumerate.nextIndex() + " - " + enumerate.next());
            }
        }
    }
    public void addRegCheckin(Checkin checkin){
        this.regCheckins.add(checkin);
    }
    public void addRegCheckout(Checkout checkout){
        this.regCheckout.add(checkout);
    }
    public List<Checkin> getCheckinsAtv() {
        return checkinsAtv;
    }

    public List<Checkin> getRegCheckins() {
        return regCheckins;
    }

    public List<Checkout> getRegCheckout() {
        return regCheckout;
    }
}
