package front.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.stream.Stream;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        var javaVersion = SystemInfo.javaVersion();
        var javafxVersion = SystemInfo.javafxVersion();
        var textArea = new TextArea();
        String inline= "";

        try {
            URL url = new URL("http://localhost:8080/animals");
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            int responsecode = conn.getResponseCode();

            if (responsecode !=200){
                throw new RuntimeException("HttpResponseCode: "+responsecode);
            }
            else {
                Scanner scanner = new Scanner(url.openStream());
                while (scanner.hasNext()){
                    inline+=scanner.nextLine();
                }
                textArea.setText(inline);
            }
        } catch (IOException e) {

        }

        //var label = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
        var label2 = new Label("Kocham Cię");
        var stackPane = new StackPane();
        //stackPane.getChildren().add(label);
        stackPane.getChildren().add(textArea);
        var scene = new Scene(stackPane, 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}