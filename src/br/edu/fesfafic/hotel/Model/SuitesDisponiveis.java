package br.edu.fesfafic.hotel.Model;

import java.util.ArrayList;
import java.util.List;

public abstract class SuitesDisponiveis {

    public static List<Suite> suitesDisponiveis(Hospede hospede, Hotel hotel){
        List<Suite> disponiveis = new ArrayList<>();
        for(Suite suite: hotel.getSuites()){
            if(!suite.isOcupado() && suite.getCapacidade()>= hospede.getNumPessoas())
                disponiveis.add(suite);
        }
        return disponiveis;
    }

    public static void exibirDisponiveisFormatado(Hospede hospede, Hotel hotel){
        System.out.println("Quartos disponíveis: ");
        List<Suite> disponiveis = suitesDisponiveis(hospede, hotel);
        if(disponiveis.isEmpty())
            System.out.println("Nenhum quarto disponível.");
        else {
            for(int i=0; i<disponiveis.size(); i++){
                System.out.printf("%d - %s\n", i,disponiveis.get(i));
            }
        }
    }
}
