package braulio.sassi.atividade04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.lang.model.type.ArrayType;

public class Teste {

    private static  Passeio passeio = new Passeio();
    private static Carga carga = new Carga();
    private static Passeio vetPasseio[] = new Passeio[5];
    private static Carga vetCarga[] = new Carga[5];
    private static  ArrayList<Passeio> listaPasseio = new ArrayList<>();

    private static Leitura l = new Leitura();


    public static void main(String[] args) {

        System.out.println("");
        System.out.println("");
        System.out.println("");       

        boolean continua = true;
        int opcao = 0;

        //MENU INICIAL
        while (continua) {
            System.out.println("\n\t\t\tMENU INICIAL");
            System.out.println("\t(1) Cadastrar veiculo PASSEIO");
            System.out.println("\t(2) Cadastrar veiculo CARGA");
            System.out.println("\t(3) Imprimir todos os veiculos PASSEIO");
            System.out.println("\t(4) Imprimir todos os veiculos CARGA");
            System.out.println("\t(5) Imprimir veiculo PASSEIO pela placa");
            System.out.println("\t(6) Imprimir veiculo CARGA pela placa");
            System.out.println("\t(7) SAIR DO SISTEMA");

            try {
                opcao = Integer.parseInt(l.entDados("\n\tEscolha uma opcao"));
            } catch (NumberFormatException nfe) {
                System.out.println("DEve ser um valor inteiro - press<ENTER>");
                l.entDados("");
                continue;
            }

            switch (opcao) {
                case 1:
                    for (int i = achaVagoPasseio(); i < vetPasseio.length; i++) {                       
                        if (i == -1) {
                            l.entDados("\nVetor de PASSEIO esta cheio!! press<ENTER>");
                            break;
                        }
                        passeio = new Passeio();
                        vetPasseio[i] = cadPasseio(passeio);

                        //listaPasseio = new ArrayList<>();
                        listaPasseio.add(i, vetPasseio[i]);                       
                        
                        l.entDados("\nPASSEIO armazenado na posicao " + i + " do vetor- press<ENTER>");

                        String respPass = l.entDados("\nDeseja cadastrar outro PASSEIO?<s/n>");

                        if (respPass.equalsIgnoreCase("n")) {
                            break;
                        }
                        if (achaVagoPasseio() == -1) {
                            l.entDados("\nVetor de PASSEIO esta cheio!! - press<ENTER>");
                            break;
                        }
                    }


                    break;
                case 2:
                    for (int i = achaVagoCarga(); i < vetCarga.length; i++) {
                        if (i == -1) {
                            l.entDados("\nVetor de CARGA esta cheio!! - press<ENTER>");
                            break;
                        }

                        carga = new Carga();
                        vetCarga[i] = cadCarga(carga);
                        l.entDados("\nCARGA armazanedo na posicao " + i + " do vetor - press<ENTER>");

                        String respCarga = l.entDados("\nDeseja cadastrar outro CARGA?<s/n>");

                        if (respCarga.equalsIgnoreCase("n")) {
                            break;
                        }

                        if (achaVagoCarga() == -1) {
                            l.entDados("\nVetor de CARGA esta cheio!! - press<ENTER>");
                            break;
                        }
                    }
                    break;

                case 3:
                    System.out.println("\nPASSEIO - Impressao de TODOS veiculos");
                    System.out.println("======================================");                  
                        
                        for (int i = 0; i < vetPasseio.length; i++) {
                            if (vetPasseio[i] != null) {    
                                impPasseio(vetPasseio[i], i);
                            } else { 
                                l.entDados("\nSem mais VEICULOS PASSEIO para imprimir - press<ENTER>");
                                break;
                            }
                        }

                    System.out.println("================================================================");
                    break;

                case 4:
                    System.out.println("\nCARGA - Impressao de TODOS veiculos");
                    System.out.println("======================================");
                    for (int i = 0; i < vetCarga.length; i++) {
                        if (vetCarga[i] != null) {
                            impCarga(vetCarga[i], i);
                        } else {
                            l.entDados("\nSem mais VEICULOS Carga para imprimir - press<ENTER>");
                            break;
                        }
                    }

                    System.out.println("================================================================");
                    break;

                case 5:
                    System.out.println("\nConsulta pela PLACA - veiculos de PASSEIO");
                    System.out.println("================================================================");

                    boolean existPlacaPasseio = false;
                    passeio = new Passeio();
                    String placaPass = l.entDados("\nInforme a placa a ser pesquisada> ");
                    passeio.setPlaca(placaPass);

                for (int i = 0; i < vetPasseio.length; i++) {
                    if(existPlacaPasseio == false){
                        if(vetPasseio[i].getPlaca().equalsIgnoreCase(placaPass)){
                          impPasseio(vetPasseio[i], i);
                            existPlacaPasseio = true;
                       }
                    }   

                }    
                    if (!existPlacaPasseio) {
                        l.entDados("\n\n\t\t\t====== NAO existi veiculo de PASSEIO com esta placa - press<ENTER>");
                           
                    }    

                    break;
                case 6:
                    System.out.println("\nConsulta pela PLACA - veiculos de CARGA");
                    System.out.println("================================================================");

                    carga = new Carga();
                    boolean existPlacaCarga = false;
                    String placaCarga = l.entDados("\nInforme a placa a ser pesquisada> ");
                    carga.setPlaca(placaCarga);

                    for (int i = 0; i < vetCarga.length; i++) {
                        if(existPlacaCarga = false){
                             if (vetCarga[i].getPlaca().equalsIgnoreCase(carga.getPlaca())) {
                                  impCarga(vetCarga[i], i);
                                   existPlacaCarga = true;
                            }
                        }

                        if (!existPlacaCarga) {
                            l.entDados("\n\n\t\t\t====== NAO existi veiculo de CARGA com esta placa - press<ENTER>");
                        }
                    }
                    break;

                case 7:
                    continua = false;
                    break;
                default:
                    l.entDados("\nO valor deve ser >= 1 e <= 7- press<ENTER>");
                    break;

            }
        }
    }
    public static int achaVagoPasseio(){
        int i = 0;
        for(Passeio vet: vetPasseio){
            if(vetPasseio[i] == null){
                return i;
            }
            i++;
        }
        return -1;
    }

    public static int achaVagoCarga(){
        for(int i = 0; i < vetCarga.length; i++){
            if(vetCarga[i] == null){
                return i;
            }
        }
        return -1;
    }

    public static Passeio cadPasseio(Passeio passeio){
        System.out.println("\n\n================================");
        System.out.println("Cadastro de Veiculos PASSEIO");
        System.out.println("\n\n================================");
        passeio.setQtdPassageiros(Integer.parseInt(l.entDados("QTD de Passageiros::")));
        verificaPlacaPasseio();     
        passeio.setMarca(l.entDados("\nMarca:::::"));
        passeio.setModelo(l.entDados("\nModelo::::"));
        passeio.setCor(l.entDados("\nCor:::::::::"));
        passeio.setQtdRodas(Integer.parseInt(l.entDados("Qtde de Rodas:::::")));
        passeio.setVelocMax(Integer.parseInt(l.entDados("Velocidade Maxima:::")));
        passeio.getMotor().setQtdPis(Integer.parseInt(l.entDados("Qtd de Pistoes:::")));
        passeio.getMotor().setPotencia(Integer.parseInt(l.entDados("Potencia do motor:::")));
        
        return passeio;
        
    }

    public static Carga cadCarga(Carga carga){
        System.out.println("\n\n================================");
        System.out.println("Cadastro de Veiculos CARGA");
        System.out.println("\n\n================================");
        carga.setTara(Integer.parseInt(l.entDados("TARA::")));
        carga.setCargaMax(Integer.parseInt(l.entDados("Carga Maxima...:")));
        verificaPlacaCarga(); 
        carga.setMarca(l.entDados("\nMarca:::::"));
        carga.setModelo(l.entDados("\nModelo::::"));
        carga.setCor(l.entDados("\nCor:::::::::"));
        carga.setQtdRodas(Integer.parseInt(l.entDados("Qtde de Rodas:::::")));
        carga.setVelocMax(Integer.parseInt(l.entDados("Velocidade Maxima:::")));
        carga.getMotor().setQtdPis(Integer.parseInt(l.entDados("Qtd de Pistoes:::")));
        carga.getMotor().setPotencia(Integer.parseInt(l.entDados("Potencia do motor:::")));

        return carga;
    }

    public static void impPasseio(Passeio passeio, int i){
        System.out.println("\nPasseio armazenado no endereco....: "+ i +" (do vetor vetPasseio)");
        System.out.println("\nQtd de Passageiros....:"+passeio.getQtdPassageiros());
        System.out.println("\nPlaca...:"+passeio.getPlaca());
        System.out.println("\nMarca...:"+passeio.getMarca());
        System.out.println("\nModelo....:"+passeio.getModelo());
        System.out.println("\nCor....:"+passeio.getCor());
        System.out.println("\nQtd de Rodas....:"+passeio.getQtdRodas());
        System.out.println("\nVelocidade Maxima....:"+passeio.getVelocMax());
        System.out.println("\nPistoes do Motor....:"+passeio.getMotor().getQtdPis());
        System.out.println("\nPotencia do Motor....:"+passeio.getMotor().getPotencia());
        System.out.println("\nQtd. de Letras......:"+passeio.calcular());
        passeio.calcVel();

    }

    public static void impCarga(Carga carga, int i){
        System.out.println("\nCarga armazenado no endereco....:"+i+"(do vetor vetCarga)");
        System.out.println("\nTara....:"+carga.getTara());
        System.out.println("\nCarga Maxima....:"+carga.getCargaMax());
        System.out.println("\nPlaca...:"+carga.getPlaca());
        System.out.println("\nMarca...:"+carga.getMarca());
        System.out.println("\nModelo....:"+carga.getModelo());
        System.out.println("\nCor....:"+passeio.getCor());
        System.out.println("\nQtd de Rodas....:"+carga.getQtdRodas());
        System.out.println("\nVelocidade Maxima....:"+carga.getVelocMax());
        System.out.println("\nPistoes do Motor....:"+carga.getMotor().getQtdPis());
        System.out.println("\nPotencia do Motor....:"+carga.getMotor().getPotencia());
        System.out.println("\nQtd. de Letras......:"+carga.calcular());
        carga.calcVel();
    }

    public  static void verificaPlacaPasseio(){
        boolean placaExiste = false;
        
        String placaVerificada = l.entDados("\nPlaca:::::");
        
            for(int i = 0; i < vetPasseio.length; i++) {  
                if(vetPasseio[i] != null) {            
                    if(vetPasseio[i].getPlaca().equals(placaVerificada)){                     
                         placaExiste = true;
                         break;
                    }  else {
                        placaExiste = false;
                        passeio.setPlaca(placaVerificada); 
                    
                    }

                } 

            } 
        if(passeio.getPlaca().isEmpty() && placaExiste == false){                
            passeio.setPlaca(placaVerificada);             
        }

        do{
            placaVerificada =  l.entDados("Digite outra placa....:::");
            for(int j = 0; j < vetPasseio.length; j++) { 
                if(vetPasseio[j] != null) {
                    if(vetPasseio[j].getPlaca().equals(placaVerificada)){                     
                        placaExiste = true;
                        break;
                    } else {
                        placaExiste = false;
                        
                    } 
                }
            }    
            passeio.setPlaca(placaVerificada); 
        }  while (placaExiste == true );  
                       
    }  

    public  static void verificaPlacaCarga(){
        boolean placaExiste = false;
        
        String placaVerificada = l.entDados("\nPlaca:::::");
        
            for(int i = 0; i < vetCarga.length; i++) {  
                if(vetCarga[i] != null) {            
                    if(vetCarga[i].getPlaca().equals(placaVerificada)){                     
                         placaExiste = true;
                         break;
                    }  else {
                        placaExiste = false;
                        carga.setPlaca(placaVerificada); 
                    
                    }

                } 

            } 
        if(carga.getPlaca().isEmpty() && placaExiste == false){      
            carga.setPlaca(placaVerificada);             
        }

        do{
            placaVerificada =  l.entDados("Digite outra placa....:::");
            for(int j = 0; j < vetCarga.length; j++) { 
                if(vetCarga[j] != null) {
                    if(vetCarga[j].getPlaca().equals(placaVerificada)){                     
                        placaExiste = true;
                        break;
                    } else {
                        placaExiste = false;
                        
                    } 
                }
            }    
            carga.setPlaca(placaVerificada); 
        }  while (placaExiste == true);  
                       
    }  

} 


    


