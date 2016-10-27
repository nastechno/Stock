/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stock.view;


import com.stock.controller.ProduitController;
import com.stock.model.Produit;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.util.StringConverter;

/**
 *
 * @author Nas
 */
public class ProduitView extends Parent{
    
   
    private final TextField rf,qte,pr;
    private final DatePicker dat;
    private final String pattern = "dd-MM-yyyy";
    Label label3;
    private final TableView<Produit> tableView;
    private final ObservableList<Produit> data;
    private ProduitController pdtc = new ProduitController();

    public ProduitView(TextField rf, TextField qte, TextField pr, DatePicker dat, TableView<Produit> tableView, ObservableList<Produit> data, Label label) {
        this.rf = rf;
        this.qte = qte;
        this.pr = pr;
        this.dat = dat;
        this.tableView = tableView;
        this.data = data;
        this.label3=label;
    }

    
    public ProduitView(){
          
        //Premier bloc à droite..........................................................................................
        
        tableView = new TableView<>();
        data = FXCollections.observableArrayList();  
        tableView.setEditable(true);
        final Label label = new Label(" ");
        tableView.setTableMenuButtonVisible(true);
        label.setFont(new Font("Arial", 20));
        
        TableColumn numero = new TableColumn("ID");
        numero.setMinWidth(10);
        numero.setCellValueFactory(new PropertyValueFactory<>("idPdt"));
        
        TableColumn reference = new TableColumn("Reférence");
        reference.setMinWidth(180);
        reference.setCellValueFactory(new PropertyValueFactory<>("nomPdt"));
        
        TableColumn quantite = new TableColumn("Quantité");
        quantite.setMinWidth(50);
        quantite.setCellValueFactory(new PropertyValueFactory<>("qtePdt")); 
        
         TableColumn prix = new TableColumn("Prix Unité");
        prix.setMinWidth(70);
        prix.setCellValueFactory(new PropertyValueFactory<>("prixPdt"));
        
        TableColumn date = new TableColumn("Expire le:");
        date.setMinWidth(120);
        date.setCellValueFactory(new PropertyValueFactory<>("dateExpiration")); 
        
        tableView.getColumns().addAll(numero, reference, quantite, prix, date); 
        
         //Button load
       
        Button load = new Button("load table");
        load.setLayoutX(510);
        load.setLayoutY(5);
        load.setFont(Font.font("sans serif", 15));
        
        load.setOnAction(e ->{
            if (data.isEmpty()){
            //pdtc.afficher();
            }
        });   
        
        //Button clear
        Button btn2 = new Button("close table");
        btn2.setFont(Font.font("sans serif", 15));
         btn2.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent event){
                data.clear();
                
            } 
        });
     final HBox hbox = new HBox();
     hbox.setSpacing(10);
     hbox.setPadding(new Insets(0, 0, 0, 0));
     hbox.getChildren().addAll(load, btn2);
     
     final VBox vbox = new VBox();
     vbox.setSpacing(5);
     vbox.setPadding(new Insets(10, 10, 0, 10));
     vbox.setTranslateX(300);
     vbox.setTranslateY(25);
  
     vbox.getChildren().addAll(label, tableView, hbox);
     
   
     
     //deuxième bloc à gauche.................................................................    
     
     Label label2 = new Label(" ");
     label3 = new Label();
     label3.setFont(new Font("Arial", 15));
 
     final HBox hbox2 = new HBox();
     hbox2.setSpacing(5);
     hbox2.setPadding(new Insets(0, 0, 0, 175));
     
   rf = new TextField();
   rf.setPromptText("Reference");
   qte = new TextField();
   qte.setPromptText("Quantité");
  
   pr = new TextField();
   pr.setPromptText("Prix (0.000)");
   
     //Button save
     Button btnSave = new Button("save");
     btnSave.setFont(Font.font("sans serif", 15)) ;
     
     btnSave.setOnAction(e->{
     if (!rf.getText().isEmpty()){
            //pdtc.save();
        }else{
          Alert alert2 = new Alert(Alert.AlertType.WARNING);
          alert2.setTitle("Warning Dialog");
          alert2.setHeaderText(null);
          alert2.setContentText("Echec de la sauvegarde !!!");
          alert2.showAndWait();
        }
        
    });
      hbox2.getChildren().addAll(btnSave);
    
   
   
   
  dat = new DatePicker();
  dat.setPromptText("Date d'expiration");
   StringConverter converter = new StringConverter<LocalDate>() {
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern);
            @Override
            public String toString(LocalDate date) {
                if (date != null) {
                    return dateFormatter.format(date);
                } else {
                    return "";
                }
            }
            @Override
            public LocalDate fromString(String string) {
                if (string != null && !string.isEmpty()) {
                    return LocalDate.parse(string, dateFormatter);
                } else {
                    return null;
                }
            }
        };             
        dat.setConverter(converter);
        //dat.setPromptText(pattern.toLowerCase());
   
   final VBox vbox2 = new VBox();
   vbox2.setSpacing(5);
   vbox2.setPadding(new Insets(10, 0, 0, 10)); 
   vbox2.getChildren().addAll(label2, rf, qte,pr,dat, hbox2, label3);
   vbox2.setTranslateY(25);
   
   this.getChildren().addAll(vbox, vbox2);
        
    }

  public void renitialiser(){
        rf.clear();
        qte.clear();
        pr.clear();
        dat.setValue(null);
    }
   
        
 
 
    
}
    
