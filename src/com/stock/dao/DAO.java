/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stock.dao;
import com.stock.connexion.ConnexionEcole;
import java.sql.Connection;
/**
 *
 * @author Nas
 */

public abstract class DAO<T> {
   protected Connection connect=null;
   
   public DAO(Connection conn){
       this.connect=conn;
   }
public abstract void save();

public abstract void afficher();
}
