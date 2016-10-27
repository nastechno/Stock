/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stock.connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Nas
 */
public class ConnexionEcole {
    
private static String url ="jdbc:postgresql://localhost:5432/GestionStock";
/**
* Nom du user
*/
private static String user = "postgres";
/**
* Mot de passe du user
*/
private static String passwd = "man1985";
/**
* Objet Connection
*/
private static Connection connect;
/**
* Méthode qui va retourner notre instance
* et la créer si elle n'existe pas...
* @return
*/
public static Connection getInstance(){
if(connect == null){
try {
connect = DriverManager.getConnection(url, user, passwd);
} catch (SQLException e) {
    e.getMessage();
JOptionPane.showMessageDialog(null, e.getMessage(), "ERREUR DE CONNEXION ! ", JOptionPane.ERROR_MESSAGE);
}
}
return connect;
}
}

