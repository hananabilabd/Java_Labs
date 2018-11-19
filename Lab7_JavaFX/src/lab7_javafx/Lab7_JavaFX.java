
package lab7_javafx;

//import java.awt.Rectangle;
import java.io.File;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.effect.Reflection; 
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

public class Lab7_JavaFX extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Text txt =new Text("Hello World");
       txt.setFill(Color.RED);
       txt.setFont(Font.font(35));
        Rectangle r = new Rectangle(300,300);
        r.setId("r");
        /*
        Stop[] stops = new Stop[] { new Stop(0, Color.BLACK), new Stop(1, Color.WHITE)};
        LinearGradient lg1 = new LinearGradient(0, 0, 0, 0.5, true,CycleMethod.REFLECT, stops);
        r.setFill(lg1);
        */
        Reflection reflection = new Reflection();
        reflection.setBottomOpacity(0.0); 
        reflection.setTopOpacity(0.5); 
        //setting the top offset of the reflection 
        reflection.setTopOffset(0.0);
        //Setting the fraction of the reflection 
        reflection.setFraction(2); 
        txt.setEffect(reflection);
      
        StackPane root = new StackPane();
        root.getChildren().addAll(r,txt);
        //File f = new File("src/styles/style.css");
        Scene scene = new Scene(root, 300, 250);
        
        //scene.getStylesheets().add(getClass().getResource("styles/style.css").toString());
        //scene.getStylesheets().add("file:///"+f.getAbsolutePath().replace("\\", "/"));
        scene.getStylesheets().add("styles/style.css");
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
