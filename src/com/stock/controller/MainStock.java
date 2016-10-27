/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stock.controller;


import com.stock.view.ConnexionView;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


/**
 *
 * @author narcisse
 */
/**
 *
 * @author Nas
 */
public class MainStock extends Application {
 
 
 private BorderPane root;
 
    
 
    @Override
    
    public void start(Stage primaryStage) {
          
   root = new BorderPane();
   ConnexionView con = new ConnexionView(primaryStage);
   root.setCenter(con);
   
  
        
        Scene scene=new Scene(root, 320, 220, Color.rgb(0, 0, 0, 0.55));
        scene.getStylesheets().add(getClass().getResource("/com/stock/view/css/style.css").toExternalForm());
        
        primaryStage.setTitle("Connexion");
        
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
     }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}