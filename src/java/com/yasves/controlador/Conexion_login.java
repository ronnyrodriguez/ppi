/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yasves.controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Rocby
 */
public class Conexion_login {
    private String username = "postgres";
    private String password = "postgres";
    private String classname = "org.postgresql.Driver";
    private String url ="jdbc:postgresql://localhost:5432/001proint";
    private Connection con;

    public Conexion_login() {
        try {
            con=DriverManager.getConnection(url,username,password);
       
        } catch (Exception e) {
            System.err.println("Error"+e);
        }
    }
    
    public Connection getConexion(){
     return con;
    }
    public static void main(String[] args) {
        Conexion_login con=new Conexion_login();
    }
}
