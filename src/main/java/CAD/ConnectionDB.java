/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CAD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ANDRE
 */
public class ConnectionDB{
    
    public Connection conexion;
    
    public Connection conectar(){
        
        try{
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            String nombre_servidor = "127.0.0.1";
            String numero_puerto   = "1521";
            String sid = "XE";
            String url = "jdbc:oracle:thin:@"+nombre_servidor+":"+numero_puerto+":"+sid;
            
            //nombres y usuarios
            String usuario = "JOSE";
            String password = "54295430";
            
            conexion = DriverManager.getConnection(url,usuario,password);
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return conexion;
       
    }

    public Connection getConexion(){
        return conexion;
    }
    
    public void cerrar(){
        
        try{
        
            if(conexion !=null){
        
                if(conexion.isClosed() == false){
                    conexion.close();
                }
            }
                    
        }catch(Exception e){
            Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, e);
        }
        
    }
}