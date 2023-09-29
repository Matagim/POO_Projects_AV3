package Application;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

//Classe que realiza a leitura do arquivo csv e armazena os dados em um ArrayList de estatísticas com o auxílio da classe Estatísticas
public class Leitor {
    //dado necessário para realização de um método da classe Estatística
    protected static String campeonatoBase;
    protected static ArrayList<Estatistica> dados = new ArrayList<>();;
    protected static ArrayList<String> jogadores = new ArrayList<>();
    protected static ArrayList<String> jogadoresUnicos = new ArrayList<>();
    protected static ArrayList<String> nomesCampeonatos = new ArrayList<>();
    protected static ArrayList<Number> tk = new ArrayList<>();
    protected static ArrayList<Number> impacto = new ArrayList<>();
    protected static ArrayList<Number> rating = new ArrayList<>();
    protected static ArrayList<Number> adr = new ArrayList<>();
    protected static ArrayList<Number> mapas = new ArrayList<>();
    protected static ArrayList<Number> abates = new ArrayList<>();
    
    
    
    
    public static void ler(String csvFile){
        dados.clear();
        tk.clear();
        abates.clear();
        mapas.clear();
        adr.clear();
        impacto.clear();
        rating.clear();
        jogadoresUnicos.clear();
        jogadores.clear();
        nomesCampeonatos.clear();
        String path = csvFile;
        
        FileReader reader;
        BufferedReader buffer;
        //Bloco try para tratar IOException
        try{
            reader = new FileReader(path);
            buffer = new BufferedReader(reader);
            int contagemÚnica = 0;
            String linha;
            //pula a primeira linha, uma vez que não interessa os dados nela.
            linha = buffer.readLine();
            while((linha = buffer.readLine()) != null){
                
                String[] temp = linha.split(";");
                if(contagemÚnica == 0){
                    campeonatoBase = temp[0];
                    contagemÚnica = 1; 
                }
                Estatistica stats = new Estatistica();
                stats.setCampeonato(temp[0]);
                stats.setJogador(temp[1]);
                stats.setAbates(Integer.parseInt(temp[2]));
                stats.setImpacto(Double.parseDouble(temp[4]));
                stats.setTotalMapas(Integer.parseInt(temp[6]));
                stats.setTk(Double.parseDouble(temp[7]));
                stats.setRating(Double.parseDouble(temp[5]));
                stats.setAdr(Double.parseDouble(temp[3]));
                stats.setData(Double.parseDouble(temp[8]));
                dados.add(stats);
            }

            
        }catch(IOException e){
            System.out.println("Erro: " +e.getMessage());
        }
        
        Collections.sort(dados, new Estatistica());
        tk = new ArrayList<>(Estatistica.allTk(dados));
        abates = new ArrayList<>(Estatistica.allAbates(dados));
        mapas = new ArrayList<>(Estatistica.allMapas(dados));
        adr = new ArrayList<>(Estatistica.allAdr(dados));
        impacto = new ArrayList<>(Estatistica.allImpacto(dados));
        rating = new ArrayList<>(Estatistica.allRating(dados));
        jogadoresUnicos = (Estatistica.JogadoresUnicos(dados));
        Collections.sort(jogadoresUnicos);
        
        for(Estatistica n : dados){
            jogadores.add(n.getJogador());
            nomesCampeonatos.add(n.getCampeonato());
        }

        
    }
}
