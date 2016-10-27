/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stock.view;
import com.stock.connexion.ConnexionEcole;
import com.stock.controller.MainStock;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author narcisse
 */
public class ConnexionView extends Parent{
    
  private PreparedStatement pst;
  private ResultSet rs;
  private Connection conn;
  private Stage stage;
  private BorderPane layout;
  private ProduitView pdtview;
  private TextField name;
  private PasswordField pwd;
  private Stage stage2;
  private MenuView menu;
    
    public ConnexionView(Stage stage2){
        this.stage2=stage2;
        checkConnection();
         MenuBar menuBar = new MenuBar();
        Menu menuFile = new Menu("File");
        Menu menuEdit = new Menu("Edit");
        Menu menuView = new Menu("Menu");
  menuBar.getMenus().addAll(menuFile, menuEdit, menuView);
 
        Rectangle r = new Rectangle(320, 220);
        Color foreground = Color.rgb(255, 255, 255, 0.9);
        r.setX(0);
        r.setY(0);
        r.setArcHeight(15);
        r.setArcWidth(15);
        r.setFill(Color.rgb(0, 0, 0, 0.55));
        r.setStroke(foreground);
        r.setStrokeWidth(1.5);
       
        
        VBox vbox = new VBox(5);
        vbox.setSpacing(15);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        Label label = new Label("");
        label.setTextFill(Color.WHITESMOKE);
        label.setFont(new Font("sanserif", 20));
        
        name = new TextField();
        name.setFont(new Font("sanserif", 15));
        name.setPromptText("Username");
        name.getStyleClass().add("field-background");
        
        pwd = new PasswordField();
        pwd.setFont(new Font("sanserif", 15));
        pwd.setPromptText("Password");
        pwd.getStyleClass().add("field-background");
       
        
        Button btn = new Button("Login");
        btn.setFont(Font.font("sanserif", 15));
        btn.setOnAction(e->{
           try{
               
                String query = "select * from utilisateur where username = ? and motdepasse = ?";
                pst = conn.prepareStatement(query);
                pst.setString(1, name.getText());
                pst.setString(2, pwd.getText());
                rs = pst.executeQuery();
                if (rs.next()){
               clearChamp();
          
               stage = new Stage();
               layout = new BorderPane();
               pdtview = new ProduitView();
              // menu = new MenuView();
               layout.setTop(menuBar);
               layout.getChildren().add(pdtview);     
               Scene sceneview = new Scene(layout, 870, 520, Color.rgb(0, 0, 0,0));
               stage.setScene(sceneview);
               stage.setTitle("NAS-TECH << Gestion de Stock >>");
               stage.setResizable(false);   
               stage.show();
               this.stage2.close();
              
                }else{
                   
                   clearChamp();
                   Alert alerte = new Alert(Alert.AlertType.ERROR);
                   alerte.setTitle("Warning Dialog");
                   alerte.setHeaderText(null);
                   alerte.setContentText("Echec de la connexion !!!");
                   alerte.showAndWait();
                   label.setText("Connectez vous.");
                    
                }
               
           }catch (Exception el){
               clearChamp();
              label.setText("Erreur sql");
              System.err.println(el);      
           } 
        });
        vbox.getChildren().addAll(label, name, pwd, btn);
        this.getChildren().addAll(r, vbox);
     
   }
    public void checkConnection(){
     conn=ConnexionEcole.getInstance();
    }
    public void clearChamp(){
       pwd.clear();
       name.clear();
       
    }
}
