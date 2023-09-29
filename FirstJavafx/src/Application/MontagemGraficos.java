package Application;
import java.util.ArrayList;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MontagemGraficos {
    
    protected void montagem(ArrayList<Estatistica> dados, ArrayList<String> jogadores, ArrayList<String> jogadoresUnicos, ArrayList<String> nomesCampeonatos,ArrayList<Number>dadoAlvo, String nomeGrafico, String nomeDado){
        final int dimY = 600;
        final int dimX = 900;
        //Leitura do arquivo csv, armazenamento dos dados e criação dos objetos utilizados na geração do gráfico
            
            int contagemExtra = 0;
            int qtdJogador = Estatistica.qtdJogador(dados);
            
            //instanciação dos eixos x e y
            NumberAxis yAxis = new NumberAxis();
            CategoryAxis xAxis = new CategoryAxis();
            
            //instanciação do gráfico de linha
            LineChart<String,Number> lineChart = new LineChart<>(xAxis,yAxis);
            
            //loop que adiciona todos os dados no gráfico
            String jogadorDaVez = " ";
            for(int i = 0; i < qtdJogador; i++){
                XYChart.Series<String,Number> series = new XYChart.Series<>();
                ArrayList<Estatistica> jogadorAtual = new ArrayList<>();
                    for(Estatistica e : dados){
                        if(e.getJogador().equals(jogadoresUnicos.get(i))){
                            jogadorAtual.add(e);
                        }
                    }
                    
                    for(int j = 0; j < jogadorAtual.size(); j++){
                        series.getData().add(new XYChart.Data<>(jogadorAtual.get(j).getCampeonato(), dadoAlvo.get(contagemExtra)));
                        contagemExtra++;
                    }
                lineChart.getData().add(series);
                jogadorDaVez += " " + "-" + jogadoresUnicos.get(i);
            }

            lineChart.setTitle(jogadorDaVez);
 
            
            Stage stage = new Stage();
            
            stage.setTitle(nomeGrafico);

            Label dataInfoLabel = (labelToData(lineChart,jogadores,nomesCampeonatos, nomeDado));
          
            StackPane stackPane = new StackPane(lineChart, dataInfoLabel);
            
            Scene scene = new Scene(stackPane, dimX, dimY);
            stage.setScene(scene);
            stage.show();
        }
    

    protected Label labelToData(LineChart<?,?> lineChart,ArrayList<String> jogadores,ArrayList<String> nomesCampeonatos, String nomeDado){
        //Criação e personalização de um label para tratar o evento de passada de mouse
        Label dataInfoLabel = new Label("");
        dataInfoLabel.setStyle("-fx-background-color: lightgray; -fx-padding: 5px;");
        dataInfoLabel.setVisible(false);
        //loop que adiciona o label personalizado a cada node
        int contagemInterna=0;
        for (XYChart.Series<?,?> s : lineChart.getData()) {
            
            for(XYChart.Data<?,?> data : s.getData()){
            final int outraContagemExtra = contagemInterna;
            data.getNode().setOnMouseEntered(event -> {
                String nomeJogador = jogadores.get(outraContagemExtra);
                String nomeCamp = nomesCampeonatos.get(outraContagemExtra);
                dataInfoLabel.setText(""+ nomeJogador  + "(" +nomeCamp + ")" + " " + nomeDado + ":" + " " +data.getYValue());            
                dataInfoLabel.setVisible(true);
        });

            data.getNode().setOnMouseExited(event -> {
                dataInfoLabel.setVisible(false);
        });
        contagemInterna++;
    }
    }

    return dataInfoLabel;
}
}

