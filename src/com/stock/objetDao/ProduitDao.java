/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stock.objetDao;


import com.stock.connexion.ConnexionEcole;
import com.stock.controller.ProduitController;
import com.stock.dao.DAO;
import com.stock.model.Produit;
import com.stock.view.ProduitView;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;


/**
 *
 * @author Nas
 */
public class ProduitDao extends DAO<Produit>{
 Produit produit;
Connection conn;
 PreparedStatement pst;
 DatePicker dat;
 TextField rf,qte,pr;
 TableView<Produit>table;
 ObservableList<Produit> datax;
 Label label;
 ProduitView pdt = new ProduitView(rf,qte,pr,dat,table, datax,label);
 
public ProduitDao(Connection conn){
super(conn);
}

public void save(){
        
       try{
          
          produit = new Produit();
          String query = "insert into Produit (refPdt, qte, prixPdt,dateExp) values (?, ?,?,?)";  
          pst = conn.prepareStatement(query);
          
          pst.setString(1, rf.getText());
          pst.setInt(2, Integer.parseInt(qte.getText().toString()));
          pst.setDouble(3, Double.parseDouble(pr.getText().toString()));
          pst.setDate(4, Date.valueOf(dat.getValue()));
            
          Alert alert = new Alert(Alert.AlertType.INFORMATION);
          alert.setTitle("Information Dialog");
          alert.setHeaderText(null);
          alert.setContentText("Sauvegarde reussite !!!");
          alert.showAndWait();
          pst.execute(query);
          pst.close();
          pdt.renitialiser();
        
        }catch (Exception el){
           Alert alert = new Alert(Alert.AlertType.ERROR);
           alert.setTitle("Error Dialog");
           alert.setHeaderText(null);
           alert.setContentText("Erreur sql !!!");
           alert.showAndWait();
            System.err.println(el);
            pdt.renitialiser();
                   
        }
}
        
        public void afficher(){
   
       /* try{
              String query = "select* from Produit";
              pst = conn.prepareStatement(query);
              rs = pst.executeQuery();
              while(rs.next()){
                 data.add(new Produit(
                 rs.getInt("id_pdt"),
                 rs.getString("refPdt"),
                 rs.getInt("qte"),
                 rs.getInt("prixPdt"),
                 rs.getString("dateExp")
                 ));
                 tableView.setItems(data);
              }
              pst.close();
              rs.close();
            }catch (Exception e2){
                System.out.println(e2);
            }*/
    }
}

    

