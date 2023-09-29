package Application;

import java.io.File;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

//classe que possui os métodos acionados pelo click dos botões
public class BotoesController {
    
    @FXML
    protected Button abates;
    @FXML
    private Button adr;
    @FXML
    private Button impacto;
    @FXML
    private Button mapas;
    @FXML
    private Button rating;
    @FXML
    private Button tk;
    @FXML
    private Button arquivo;
    final int dimY = 600;
    final int dimX = 900;


    @FXML
    protected void selecionador(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Arquivos CSV", "*.csv"));
        File selectedFile = fileChooser.showOpenDialog(new Stage());

        if (selectedFile != null) {
            String csvFilePath = selectedFile.getAbsolutePath();
            Leitor.ler(csvFilePath);
            
    }
    }
    @FXML
    protected void graficoTk(){
           MontagemGraficos tk = new MontagemGraficos();
           tk.montagem(Leitor.dados,Leitor.jogadores,Leitor.jogadoresUnicos, Leitor.nomesCampeonatos,Leitor.tk,"Gráfico do total de abates/total de mapas  em cada campeonato","Tk/TM");

    };
    @FXML
    protected void graficoAbates(){
           MontagemGraficos abates = new MontagemGraficos();
           abates.montagem(Leitor.dados,Leitor.jogadores,Leitor.jogadoresUnicos, Leitor.nomesCampeonatos,Leitor.abates,"Gráfico de abates em cada campeonato", "abates");
    }
    @FXML
    protected void graficoAdr(){
            MontagemGraficos adr = new MontagemGraficos();
            adr.montagem(Leitor.dados,Leitor.jogadores,Leitor.jogadoresUnicos, Leitor.nomesCampeonatos, Leitor.adr,"Gráfico de adr em cada campeonato", "adr");
        }
    @FXML
    protected void graficoImpacto(){
        MontagemGraficos impacto = new MontagemGraficos();
           impacto.montagem(Leitor.dados,Leitor.jogadores,Leitor.jogadoresUnicos, Leitor.nomesCampeonatos, Leitor.impacto,"Gráfico de impacto em cada campeonato","impacto");
        }
    @FXML
    protected void graficoMapas(){
        MontagemGraficos mapas = new MontagemGraficos();
           mapas.montagem(Leitor.dados,Leitor.jogadores,Leitor.jogadoresUnicos, Leitor.nomesCampeonatos, Leitor.mapas,"Gráfico de mapas em cada campeonato","mapas");
    }
    @FXML
    protected void graficoRating(){
       MontagemGraficos rating = new MontagemGraficos();
           rating.montagem(Leitor.dados,Leitor.jogadores,Leitor.jogadoresUnicos, Leitor.nomesCampeonatos, Leitor.rating,"Gráfico de rating em cada campeonato","rating");
    }


}
