package Application;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;



//Classe principal
public class App extends Application {
    
    
    
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage arg0)  throws Exception{
        //Leitura do arquivo FXML do Scene Builder
        FXMLLoader loader = new FXMLLoader(getClass().getResource("TelaBotoes.fxml"));

        Parent root = loader.load();
        

        final int dimXJanelaPrincipal = 1920;
        final int dimYJanelaPrincipal = 1080;
        Scene scene1 = new Scene(root,dimXJanelaPrincipal,dimYJanelaPrincipal);
        
        arg0.setScene(scene1);
        arg0.setTitle("Counter-Strike: Graphic Overview");
        arg0.show();
        
    }

}
    

