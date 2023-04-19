package br.edu.fesfafic.hotel.Main;

import br.edu.fesfafic.hotel.Model.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    /*System.out.print("Nome do restaurante: ");
    Scanner scanner = new Scanner(System.in);
    String nomeRestaurante = scanner.next();*/

        Restaurante tristeza = new Restaurante("Tristeza");

        Mesa m1 = new Mesa(1,false,false);
        Mesa m2 = new Mesa(2,true,false);
        tristeza.addMesa(m1);
        tristeza.addMesa(m2);

        Cozinheiro jeremias = new Cozinheiro("Jeremias", "834834955", "2834056");
        Cozinheiro suzana = new Cozinheiro("Suzana", "823984398", "3854343");
        tristeza.addCozinheiro(jeremias);
        tristeza.addCozinheiro(suzana);

        tristeza.addPrato("Macarrão");
        tristeza.removePrato("Macarrão");
        tristeza.addPrato("Arroz");
        tristeza.addPrato("Feijão");

        Hotel alegria = new Hotel("Alegria", tristeza);

        Suite s101 = new Suite(101, 300, new MobiliaEVaranda(1, 3, true,
                true, false));
        alegria.addSuite(s101);
        Suite s102 = new Suite(102, 200, new MobiliaEVaranda(0, 3, true,
                false, false));
        alegria.addSuite(s102);
        Suite s103 = new Suite(103, 300, new MobiliaEVaranda(1, 0, true,
                true, true));
        alegria.addSuite(s103);
        Suite s104 = new Suite(104, 100, new MobiliaEVaranda(0, 1, false,
                false, false));
        alegria.addSuite(s104);
        Suite s105 = new Suite(105, 350, new MobiliaEVaranda(1, 3, true,
                true, true));
        alegria.addSuite(s105);
        Suite s106 = new Suite(106, 200, new MobiliaEVaranda(1, 2, false,
                false, true));
        alegria.addSuite(s106);

        Recepcionista juliana = new Recepcionista("Juliana", "837287328", "7387423");
        Recepcionista joao = new Recepcionista("João", "834727774", "9384276");
        Camareira marta = new Camareira("Marta", "832938269", "7382753");
        marta.addSuite(s101);
        marta.addSuite(s102);
        marta.addSuite(s103);
        Camareira sheila = new Camareira("Sheila", "283728332", "4738748");
        sheila.addSuite(s104);
        sheila.addSuite(s105);
        sheila.addSuite(s106);
        alegria.addRecepcionista(juliana);
        alegria.addRecepcionista(joao);
        alegria.addCamareira(marta);
        alegria.addCamareira(sheila);

        Hospede francisco = new Hospede("Francisco","398274838", "8372742", 4);

        Scanner input = new Scanner(System.in);
        int opcao=0;
        while(opcao!=4){
            System.out.println("-- Seja bem-vindo ao hotel " + alegria.getNome() + ", o que deseja fazer? --");
            System.out.println("""
                    1 - Checkin
                    2 - Lista de hóspedes
                    3 - Checkout
                    4 - Sair
                    Sua opção:
                    """);
            opcao = input.nextInt();
            switch (opcao) {
                case 1 -> {
                    boolean jaHospedado = false;
                    for (Checkin hospedado : alegria.getRegistroHospedes().getCheckinsAtv()) {
                        if (francisco.equals(hospedado.getHospede())) {
                            jaHospedado = true;
                            System.out.println(hospedado.getHospede().getNome() + " já está hospedado.");
                            break;
                        }
                    }
                    if (!jaHospedado) {
                        Checkin checkin = new Checkin(francisco, juliana);
                        SuitesDisponiveis.exibirDisponiveisFormatado(francisco, alegria);
                        if (SuitesDisponiveis.suitesDisponiveis(francisco, alegria).isEmpty())
                            break;

                        System.out.println("Qual suíte deseja? ");
                        int suite = input.nextInt();
                        System.out.println("""
                                Deseja fazer check-in hoje ou reservar para outra data?
                                1 - hoje
                                2 - outra data
                                Sua opção:
                                """);
                        int opcao2 = input.nextInt();
                        switch (opcao2) {
                            case 1 -> {
                                checkin.fazerCheckin(SuitesDisponiveis.suitesDisponiveis(francisco, alegria).get(suite));
                                alegria.getRegistroHospedes().addCheckinAtv(checkin);
                                alegria.getRegistroHospedes().addRegCheckin(checkin);
                            }
                            case 2 -> {
                                System.out.print("Dia: ");
                                int dia = input.nextInt();
                                System.out.print("Mês: ");
                                int mes = input.nextInt();
                                System.out.print("Ano: ");
                                int ano = input.nextInt();
                                checkin.fazerCheckin(SuitesDisponiveis.suitesDisponiveis(francisco, alegria).get(suite),
                                        dia, mes, ano);
                                alegria.getRegistroHospedes().addCheckinAtv(checkin);
                                alegria.getRegistroHospedes().addRegCheckin(checkin);
                            }
                        }
                    }
                }
                case 2 -> alegria.getRegistroHospedes().exibirCheckinsAtv();
                case 3 -> {
                    alegria.getRegistroHospedes().exibirCheckinsAtv();
                    if(alegria.getRegistroHospedes().getCheckinsAtv().isEmpty()){
                        System.out.println("Operação impossível.");
                        break;
                    }
                    System.out.println("De qual hóspede acima deseja fazer check-out? ");
                    int checkin = input.nextInt();
                    Checkout checkout = new Checkout(new Conta(alegria.getRegistroHospedes().getCheckinsAtv().get(checkin),
                            "Pix", 45), joao);
                    System.out.println("""
                            Deseja fazer check-out hoje ou usar outra data?
                            1 - hoje
                            2 - outra data
                            Sua opção:
                            """);
                    int opcao2 = input.nextInt();
                    switch (opcao2) {
                        case 1 -> {
                            checkout.getConta().exibirContaFormatada();
                            checkout.getConta().setPago(true);
                            checkout.fazerCheckout();
                            alegria.getRegistroHospedes().removeCheckinAtv(alegria.getRegistroHospedes().
                                    getCheckinsAtv().get(checkin));
                            alegria.getRegistroHospedes().addRegCheckout(checkout);
                        }
                        case 2 -> {
                            System.out.print("Dia: ");
                            int dia = input.nextInt();
                            System.out.print("Mês: ");
                            int mes = input.nextInt();
                            System.out.print("Ano: ");
                            int ano = input.nextInt();
                            checkout.getConta().exibirContaFormatada(dia, mes, ano);
                            checkout.getConta().setPago(true);
                            checkout.fazerCheckout(dia, mes, ano);
                            alegria.getRegistroHospedes().addRegCheckout(checkout);
                            alegria.getRegistroHospedes().removeCheckinAtv(alegria.getRegistroHospedes().
                                    getCheckinsAtv().get(checkin));
                        }
                    }
                }
                case 4 -> System.out.println("Encerrando o programa.");
            }
        }
    }
}
