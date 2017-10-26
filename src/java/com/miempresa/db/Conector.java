/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miempresa.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jason
 */
public class Conector {

    Connection conector;

    public Conector(Connection conector) {
        this.conector = conector;
    }
    

    public Conector() {
    }

    public void conectar() {
        //java se conecta con postgres necesito el servidor , puerto , nombre de la base de datos ,usuario,contraseña

        String cadenaConexion = "jdbc:postgresql://localhost:5432/crudPrueba";
        String usuario = "postgres";
        String pass = "hola";

        try {
            Class.forName("org.postgresql.Driver");                              //que driver ocupo para postgres
            this.conector = DriverManager.getConnection(cadenaConexion, usuario, pass);     //abro  la conexion
            System.out.println("conecto satisfactoriamente");

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("No se pudo conectar a la base de datos " + ex);
        }

    }

    public Connection getConexion() {
        return this.conector;
    }

}
