/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stock.view;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author narcisse
 */
public class MenuView extends Parent{
    
    private ProduitView ev;
    
    public MenuView(){
  
    Button btn1 = new Button("Show Products");
    btn1.setOnAction(e->{
        ev = new ProduitView();
        this.getChildren().add(ev);
    });
    
    Button btn2 = new Button("Show Groups    ");
    Button btn3 = new Button("Show User");
    Button btn4 = new Button("Login");
     
    final HBox hbox = new HBox();
     hbox.setSpacing(0);
     hbox.setPadding(new Insets(30, 0, 0, 310));
     hbox.getChildren().addAll(btn1, btn2, btn3, btn4);
     this.getChildren().add(hbox);
    }
    
}
