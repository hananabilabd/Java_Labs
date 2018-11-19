/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab8_notePadHTMLEditor_javaFX;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.web.HTMLEditor;
import javafx.stage.Stage;
import javafx.stage.FileChooser;
import javafx.scene.web.WebEngine; 
import javafx.scene.web.WebView; 
/**
 *
 * @author Hanna Nabil
 */
public class Lab8_NotePadHTMLEditor_JavaFX extends Application {
    public WebView webView;
    private static final String JS_GET_SELECTED_TEXT = 
                    "(function getSelectionText() {\n" + 
                    "    var text = \"\";\n" + 
                    "    if (window.getSelection) {\n" + 
                    "        text = window.getSelection().toString();\n" + 
                    "    } else if (document.selection && document.selection.type != \"Control\") {\n" + 
                    "        text = document.selection.createRange().text;\n" + 
                    "    }\n" + 
                    "    return text;\n" + 
                    "})()"; 
    public String getSelectedText() { 
        if (webView == null) return ""; 
        return (String)webView.getEngine().executeScript(JS_GET_SELECTED_TEXT); 
    } 
     private String readFile(File file){
        StringBuilder stringBuffer = new StringBuilder();
        BufferedReader bufferedReader = null;
         
        try {
 
            bufferedReader = new BufferedReader(new FileReader(file));
             
            String text;
            while ((text = bufferedReader.readLine()) != null) {
                stringBuffer.append(text+"\n");
            }
 
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return stringBuffer.toString();
    }
    
    private void saveTextToFile(String content, File file) {
        try {
            PrintWriter writer;
            writer = new PrintWriter(file);
            writer.println(content);
            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    
    
    @Override
    public void start(Stage primaryStage) {
        HTMLEditor htmlEditor =new HTMLEditor();
        //TextArea textArea = new TextArea();
        MenuBar bar = new MenuBar();
        Menu file = new Menu("File");
        MenuItem newItem = new MenuItem("New");
        newItem.setAccelerator(KeyCombination.keyCombination("Ctrl+n"));
        newItem.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle (ActionEvent e){
                htmlEditor.setHtmlText("");
            }
        });
        MenuItem openItem = new MenuItem("Open");
        openItem.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                FileChooser fileOpener = new FileChooser();
                fileOpener.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.txt"),new FileChooser.ExtensionFilter("HTML Files", "*.htm"));
                File file =fileOpener.showOpenDialog(primaryStage);
                 if(file != null){
                    htmlEditor.setHtmlText(readFile(file));
                }
                
            }
        });
        MenuItem saveItem = new MenuItem("Save");
        saveItem.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                FileChooser fileSaver = new FileChooser();
                fileSaver.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.txt"),new FileChooser.ExtensionFilter("HTML Files", "*.htm"));
                File file =fileSaver.showSaveDialog(primaryStage);
                
                if(file != null){
                    saveTextToFile(htmlEditor.getHtmlText(), file);
                }
                 
                }
            
        });
        MenuItem exitItem = new MenuItem("Exit");
        exitItem.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                primaryStage.close();
            }
        });
        file.getItems().addAll(newItem ,openItem,saveItem,exitItem);
        /////////////////////////////////////////////////
      
    
       
        bar.getMenus().addAll(file);
        
        
        
        BorderPane borderPane = new BorderPane();
        //borderPane.getChildren().addAll();
        borderPane.setTop(bar);
        borderPane.setCenter(htmlEditor);
        
        
        
        Scene scene = new Scene(borderPane, 300, 250);
        
        primaryStage.setTitle("NotePad");
     
        primaryStage.getIcons().add(new Image("notepad.png"));
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
