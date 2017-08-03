/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yasves.controlador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Rocby
 */
public class consultas extends Conexion_login {
    public boolean autenticacion(String usuario, String contraseña){
        PreparedStatement pst= null;
        ResultSet rs= null;
        
        try {
            String consulta = "Select *from public.user where nombre = ? and password=? ";
            
        } catch (Exception e) {
        }
        
        return false;
    }
    
}
