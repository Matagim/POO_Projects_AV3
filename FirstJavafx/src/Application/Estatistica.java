package Application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

//Classe que armazena as estatisticas do csv
class Estatistica implements Comparator<Estatistica>{

    //estatisticas desejadas
    private String campeonato;
    private String jogador;
    private Integer abates;
    private Double impacto;
    private Integer totalMapas;
    private Double rating;
    private Double tk;
    private Double adr;
    private Double data;


    public Double getData() {
        return data;
    }

    public void setData(Double data) {
        this.data = data;
    }

    public Estatistica(){
    }

    public Estatistica(String campeonato, String jogador, Double tk, Double adr){
        this.campeonato = campeonato;
        this.jogador = jogador;
        this.tk = tk;
        this.adr = adr;
    }

    public String getCampeonato() {
        return campeonato;
    }

    public void setCampeonato(String campeonato) {
        this.campeonato = campeonato;
    }

    public String getJogador() {
        return jogador;
    }

    public void setJogador(String jogador) {
        this.jogador = jogador;
    }

    public Double getTk() {
        return tk;
    }

    public void setTk(Double tk) {
        this.tk = tk;
    }

    public Double getAdr() {
        return adr;
    }

    public void setAdr(Double adr) {
        this.adr = adr;
    }

    @Override
    public String toString() {
        return "Estatistica [campeonato=" + campeonato + ", jogador=" + jogador + ", tk=" + tk + ", adr=" + adr + "]";
    }

    //Método que retorna a quantidade de jogadores baseado na repetição do campeonato base
    public static int qtdJogador(ArrayList<Estatistica> dados){
        Set<String> jogadores = new HashSet<>();

        for(Estatistica e : dados){
            jogadores.add(e.getJogador());
        }

        return jogadores.size();
    }

    //Método que retorna a quantidade de campeonatos únicos do csv
    public static int qtdCampeonatosUnicos(ArrayList<Estatistica> dados){
        Set<String> campeonatos = new HashSet<>();

        for(Estatistica e : dados){
            campeonatos.add(e.getCampeonato());
        }

        return campeonatos.size();
    }

    //Método que realiza a comparação das estatisticas no array
    @Override
    public int compare(Estatistica o1, Estatistica o2) {
        int jogadorComparacao = o1.getJogador().compareTo(o2.getJogador());
        if (jogadorComparacao != 0) {
            return jogadorComparacao;
        }
        return o1.getData().compareTo(o2.getData());
    }

    public Integer getAbates() {
        return abates;
    }

    public void setAbates(Integer abates) {
        this.abates = abates;
    }

    public Double getImpacto() {
        return impacto;
    }

    public void setImpacto(Double impacto) {
        this.impacto = impacto;
    }

    public Integer getTotalMapas() {
        return totalMapas;
    }

    public void setTotalMapas(Integer totalMapas) {
        this.totalMapas = totalMapas;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    //Método que retorna a quantidade de jogadores únicos do csv
    public static ArrayList<String> JogadoresUnicos(ArrayList<Estatistica> dados){
        Set<String> jogadoresUnicos = new HashSet<>();
        for(Estatistica n : dados){
            jogadoresUnicos.add(n.getJogador());
        }
        ArrayList<String> jogadoresUnicosEmOrdem = new ArrayList<>();
        for(String n : jogadoresUnicos){
            jogadoresUnicosEmOrdem.add(n);
        }
        Collections.sort(dados, new Estatistica());
        return jogadoresUnicosEmOrdem;
    }
    
    //Método que retorna os campeonatos únicos do csv
    public static ArrayList<String> CampeonatosUnicos(ArrayList<Estatistica> dados){
        Set<String> campeonatosUnicos = new HashSet<>();
        for(Estatistica n : dados){
            campeonatosUnicos.add(n.getCampeonato());
        }
        ArrayList<String> campeonatosUnicosEmOrdem = new ArrayList<>();
        for(String n : campeonatosUnicos){
            campeonatosUnicosEmOrdem.add(n);
        }
        Collections.sort(dados, new Estatistica());
        return campeonatosUnicosEmOrdem;
    }

    public static ArrayList<Double> allTk(ArrayList<Estatistica> dados){
        ArrayList<Double> dadoAlvo = new ArrayList<>();
        for(Estatistica n : dados){
            dadoAlvo.add(n.getTk());
        }
        return dadoAlvo;
    }

    public static ArrayList<Double> allAdr(ArrayList<Estatistica> dados){
        ArrayList<Double> dadoAlvo = new ArrayList<>();
        for(Estatistica n : dados){
            dadoAlvo.add(n.getAdr());
        }
        return dadoAlvo;
    }

    public static ArrayList<Integer> allAbates(ArrayList<Estatistica> dados){
        ArrayList<Integer> dadoAlvo = new ArrayList<>();
        for(Estatistica n : dados){
            dadoAlvo.add(n.getAbates());
        }
        return dadoAlvo;
    }

    public static ArrayList<Double> allImpacto(ArrayList<Estatistica> dados){
        ArrayList<Double> dadoAlvo = new ArrayList<>();
        for(Estatistica n : dados){
            dadoAlvo.add(n.getImpacto());
        }
        return dadoAlvo;
    }

    public static ArrayList<Integer> allMapas(ArrayList<Estatistica> dados){
        ArrayList<Integer> dadoAlvo = new ArrayList<>();
        for(Estatistica n : dados){
            dadoAlvo.add(n.getTotalMapas());
        }
        return dadoAlvo;
    }

    public static ArrayList<Double> allRating(ArrayList<Estatistica> dados){
        ArrayList<Double> dadoAlvo = new ArrayList<>();
        for(Estatistica n : dados){
            dadoAlvo.add(n.getRating());
        }
        return dadoAlvo;
    } 

    
}
