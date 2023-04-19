package br.edu.fesfafic.hotel.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Hotel {
    public String nome;
    public List<Suite> suites;
    public List<Recepcionista> recepcionistas;
    public List<Camareira> camareiras;
    public RegistroHospedes registroHospedes;
    public Restaurante restaurante;

    public Hotel(String nome, Restaurante restaurante){
        this.nome = nome;
        this.restaurante = restaurante;
        this.suites = new ArrayList<>();
        this.camareiras = new ArrayList<>();
        this.recepcionistas = new ArrayList<>();
        this.registroHospedes = new RegistroHospedes();
    }
    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void addSuite(Suite suite){
        this.suites.add(suite);
    }

    public void removerSuite(Suite suite){
        this.suites.remove(suite);
    }
    public void addRecepcionista(Recepcionista recepcionista){
        this.recepcionistas.add(recepcionista);
    }
    public void removerRecepcionista(Recepcionista recepcionista){
        this.recepcionistas.remove(recepcionista);
    }
    public void addCamareira(Camareira camareira){
        this.camareiras.add(camareira);
    }
    public void removerCamareira(Camareira camareira){
        this.camareiras.remove(camareira);
    }
    public List<Suite> getSuites() {
        return suites;
    }

    public List<Recepcionista> getRecepcionistas() {
        return recepcionistas;
    }

    public List<Camareira> getCamareiras() {
        return camareiras;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    public RegistroHospedes getRegistroHospedes() {
        return registroHospedes;
    }

    public void setRegistroHospedes(RegistroHospedes registroHospedes) {
        this.registroHospedes = registroHospedes;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "nome='" + nome + '\'' +
                ", suites=" + suites +
                ", recepcionistas=" + recepcionistas +
                ", camareiras=" + camareiras +
                ", restaurante=" + restaurante +
                '}';
    }
}
