/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab8_notepad_javafx;
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
/**
 *
 * @author Hanna Nabil
 */
public class Lab8_NotePad_JavaFX extends Application {
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
        
        
        
        TextArea textArea = new TextArea();
        MenuBar bar = new MenuBar();
        Menu file = new Menu("File");
        MenuItem newItem = new MenuItem("New");
        newItem.setAccelerator(KeyCombination.keyCombination("Ctrl+n"));
        newItem.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle (ActionEvent e){
                //htmlEditor.setHtmlText("");
                textArea.clear();
            }
        });
        MenuItem openItem = new MenuItem("Open");
        openItem.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                FileChooser fileOpener = new FileChooser();
                fileOpener.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.txt"),new FileChooser.ExtensionFilter("HTML Files", "*.htm"));
                File file =fileOpener.showOpenDialog(primaryStage);
                 if(file != null){
                    textArea.setText(readFile(file));
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
                    saveTextToFile(textArea.getText(), file);
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
        Menu edit = new Menu("Edit");
        MenuItem undoItem = new MenuItem("Undo");
        undoItem.setAccelerator(KeyCombination.keyCombination("Ctrl+z"));
        undoItem.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle (ActionEvent e){
                //htmlEditor.setHtmlText("");
                textArea.undo();
            }
        });
        MenuItem cutItem = new MenuItem("Cut");
        cutItem.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle (ActionEvent e){
                //htmlEditor.setHtmlText("");
                textArea.cut();
            }
        });
        MenuItem copyItem = new MenuItem("Copy");
        copyItem.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle (ActionEvent e){
                //htmlEditor.setHtmlText("");
                textArea.copy();
            }
        });
        MenuItem pasteItem = new MenuItem("Paste");
        pasteItem.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle (ActionEvent e){
                //htmlEditor.setHtmlText("");
                textArea.paste();
            }
        });
        MenuItem deleteItem = new MenuItem("Delete");
        deleteItem.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle (ActionEvent e){
                //htmlEditor.setHtmlText("");
                boolean isSelection = textArea.getSelection().getLength() != 0;
                if (isSelection){
                    textArea.deleteText(textArea.getSelection());
                }
            }
        });
        MenuItem selectAllItem = new MenuItem("Select All");
        selectAllItem.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle (ActionEvent e){
                //htmlEditor.setHtmlText("");
               textArea.selectAll();
               
            }
        });
        edit.getItems().addAll(undoItem,cutItem,copyItem,pasteItem,deleteItem,selectAllItem);
       
        bar.getMenus().addAll(file,edit);
        
        
        
        BorderPane borderPane = new BorderPane();
        //borderPane.getChildren().addAll();
        borderPane.setTop(bar);
        borderPane.setCenter(textArea);
        
        
        
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
