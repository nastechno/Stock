/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stock.controller;

import com.stock.connexion.ConnexionEcole;
import com.stock.dao.DAO;
import com.stock.model.Produit;
import com.stock.objetDao.ProduitDao;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author narcisse
 */
public class ProduitController {
   
 DAO<Produit> pdao = new ProduitDao(ConnexionEcole.getInstance());
 
   public void save(){
       pdao.save();
    }
    public void afficher(){
       // pdtdao.afficher();
    }
    public void clearData(){
        
    }
   
   
    
}
