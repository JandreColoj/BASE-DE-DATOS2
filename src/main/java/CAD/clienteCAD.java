/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CAD;

import DTO.cliente;
import DTO.correo;
import DTO.departamento;
import DTO.municipio;
import DTO.telefono;
import DTO.tipo_cliente;
import DTO.tipo_telefono;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ANDRE
 */
public class clienteCAD extends ConnectionDB {
    
    
    private static List<cliente> rs = null;
    private static List<municipio> mn = null;
    private static List<departamento> depto = null;
    private static List<tipo_cliente> tipoCli = null;
    private static List<tipo_telefono> tipoTel = null;
    private static List<telefono> tel = null;
     private static List<correo> correo = null;
    int id_cliente;

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public List<cliente> listadoClientes()throws  Exception{      
        
        try {
            
            Connection miConexion = this.conectar();
            
            String sql = "select * from cliente C inner join tipo_cliente T on T.ID=C.ID_TIPO_CLIENTE WHERE C.ESTADO=1";
            
            Statement sentencia = miConexion.createStatement();
            ResultSet resultado = sentencia.executeQuery(sql);
            System.out.println(sql);
            
            this.rs = new ArrayList<cliente>();
            
            while(resultado.next()){
                
                cliente cli = new cliente();
                cli.setIdCliente(resultado.getInt(1));
                cli.setNombre(resultado.getString(2));
                cli.setApellidos(resultado.getString(3));
                cli.setNit(resultado.getString(4));
                cli.setDireccion(resultado.getString(5));
                cli.setMunicipio(resultado.getInt(6));
                cli.setFecha_nacimient(resultado.getDate(7));
                cli.setTipoCliente(resultado.getString(10));
                
                this.rs.add(cli);                
            }
            
        } catch (Exception sqle) {
            Throwable t = sqle.getCause();
        
        }finally{
            this.cerrar();
        }
           
           
        return rs;
    }

    public int insertarCliente(cliente cli)throws  Exception{
        
        try {
            
            SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
            String date = sdf.format(cli.getFecha_nacimient()); 
            System.out.println(date); //15/10/2013*/
        
            Connection miConexion = this.conectar();
            
            String sql = "INSERT INTO CLIENTE (\"ID\",\"NOMBRE\", \"APELLIDOS\", \"NIT\", \"DIRECCION\", \"MUNICIPIO\", \"FECHA_NACIMIENTO\", \"ID_TIPO_CLIENTE\") \n" +
                          "VALUES (sec_cliente.nextval, '"+cli.getNombre()+"', '"+cli.getApellidos()+"','"+cli.getNit()+"','"+cli.getDireccion()+"',"+cli.getMunicipio()+",'"+date+"',"+cli.getTipo_cliente()+")";
            
            Statement sentencia = miConexion.createStatement();
            System.out.print(sql);
            
            int resultado = sentencia.executeUpdate(sql);
            getConexion().commit();

            if (resultado==1) {
                ResultSet secuencia = sentencia.executeQuery("select sec_cliente.CURRVAL  from dual");
                
                while(secuencia.next()){
                    this.setId_cliente(secuencia.getInt(1));
                }
                
                // INSERTAR TELEFONO
                String sqlTelefono = "INSERT INTO TELEFONO_CLIENTE (\"ID\",\"NUMERO\", \"ID_TIPO_TELEFONO\", \"ID_CLIENTE\") \n" +
                          "VALUES (sec_telefono.nextval, '"+cli.getTelefono()+"', "+cli.getTipo_telefono()+","+this.getId_cliente()+")";
                sentencia.executeUpdate(sqlTelefono);
                
                // INSERTAR CORREO
                String sqlCorreo = "INSERT INTO CORREO_CLIENTE (\"ID\",\"CORREO\", \"ID_CLIENTE\", \"ESTADO\") \n" +
                          "VALUES (sec_correo.nextval, '"+cli.getCorreo()+"', "+this.getId_cliente()+",1)";
                sentencia.executeUpdate(sqlCorreo);
                
                getConexion().commit();
                
            }
            
            return  resultado;
           
            
        } catch (Exception sqle) {
            Throwable t = sqle.getCause();
        
        }finally{
            this.cerrar();
        }
           
           
        return 0;
    }
       
    public int actualizarCliente(cliente cli)throws  Exception{      
            
        int retorno = 0;
        
        try {
            
            Connection miConexion = this.conectar();
            
            String sql = "UPDATE CLIENTE" +
                         " SET \"NOMBRE\" = ?, \"APELLIDOS\" = ?, \"NIT\" = ?, \"DIRECCION\" = ?, \"ID_TIPO_CLIENTE\" = ?"  +
                         " WHERE \"ID\" = "+cli.getIdCliente();
            
            System.out.println("NOMBRE PARA ACTUALIZAR "+cli.getNombre()+ " ID "+ cli.getIdCliente());
            
            PreparedStatement sentencia = miConexion.prepareStatement(sql);
            sentencia.setString(1, cli.getNombre());
            sentencia.setString(2, cli.getApellidos());
            sentencia.setString(3, cli.getNit());
            sentencia.setString(4, cli.getDireccion());
            sentencia.setInt(5, cli.getTipo_cliente());
            
            sentencia.execute();
            System.out.println(sql);
            
            retorno = 1;
  
        } catch (Exception sqle) {
            Throwable t = sqle.getCause();
            System.out.println(sqle.getMessage());
        
        }finally{
            this.cerrar();
        }
           
           
        return retorno;
    }
    
    public int eliminarCliente(int id_cliente)throws  Exception{      
        
        try {
            
            Connection miConexion = this.conectar();
            
            String sql = "UPDATE CLIENTE\n" + "SET \"ESTADO\" = 0" + "WHERE \"ID\" = "+id_cliente;
                    
            PreparedStatement sentencia = miConexion.prepareStatement(sql);
            int retorno = sentencia.executeUpdate();
  
        } catch (Exception sqle) {
            Throwable t = sqle.getCause();
            System.out.println(sqle.getMessage());
        
        }finally{
            this.cerrar();
        }
           
           
        return 0;
    }
    
    public List<municipio> municipios(int depto)throws  Exception{      
        
        try {
            
            this.mn = new ArrayList<municipio>();
            Connection conn = this.conectar();
            String sql;
            
            if (depto==0) {
                sql = "SELECT * FROM MUNICIPIO";
            }else{
                sql = "SELECT * FROM MUNICIPIO WHERE ID_DEPTO="+depto;
            }            
            
            Statement stmt = conn.createStatement();
            ResultSet rs;
            
            rs = stmt.executeQuery(sql);
                        
            while(rs.next()){
                
                System.out.println("id:"+rs.getInt(1));
               
                municipio muni = new municipio();
                muni.setId(rs.getInt(1));
                muni.setNombre(rs.getString(2));
                muni.setId_depto(rs.getInt(3));                 
                this.mn.add(muni);           
            }
            
        }catch(Exception sqle) {
            Throwable t = sqle.getCause();
        }finally{
            this.cerrar();
        }
           
        return mn;
    }
    
    public List<departamento> departamentos()throws  Exception{      
        
        try {
            
            this.depto = new ArrayList<departamento>();
            Connection conn = this.conectar();
            
            String sql = "SELECT * FROM DEPARTAMENTO";
            
            Statement stmt = conn.createStatement();
            ResultSet rs;
            
            rs = stmt.executeQuery(sql);
                        
            while(rs.next()){
                
                System.out.println("id:"+rs.getInt(1));
               
                departamento dep = new departamento();
                dep.setId(rs.getInt(1));
                dep.setNombre(rs.getString(2));             
                this.depto.add(dep);           
            }
            
        }catch(Exception sqle) {
            Throwable t = sqle.getCause();
        }finally{
            this.cerrar();
        }
           
        return depto;
    }
    
    public List<tipo_cliente> tipo_cliente()throws  Exception{      
                    
        try {
             this.tipoCli = new ArrayList<tipo_cliente>();
             
            Connection conn = this.conectar();
            
            String sql = "SELECT * FROM TIPO_CLIENTE";
            
            Statement stmt = conn.createStatement();
            ResultSet rs;
               
            rs = stmt.executeQuery(sql);
            
            while(rs.next()){
                
                System.out.println("id"+rs.getInt(4));
                tipo_cliente cli = new tipo_cliente();
                cli.setId(rs.getInt(5));
                cli.setNombre(rs.getString(1)); 
                cli.setDescripcion(rs.getString(2)); 
                cli.setDescuento(rs.getFloat(3));
                this.tipoCli.add(cli);  
            }
            
        }catch(Exception sqle) {
            Throwable t = sqle.getCause();
        }finally{
            this.cerrar();
        }
           
        return this.tipoCli;
    }
    
    public List<tipo_telefono> tipo_telefono()throws  Exception{      
        
        try {
            
            this.tipoTel = new ArrayList<tipo_telefono>();
            Connection conn = this.conectar();
            
            String sql = "SELECT * FROM TIPO_TELEFONO";
            
            Statement stmt = conn.createStatement();
            ResultSet rs;
            
            rs = stmt.executeQuery(sql);
                        
            while(rs.next()){
                tipo_telefono tel = new tipo_telefono();
                tel.setId(rs.getInt(1));
                tel.setNombre(rs.getString(2));             
                this.tipoTel.add(tel);           
            }
            
        }catch(Exception sqle) {
            Throwable t = sqle.getCause();
        }finally{
            this.cerrar();
        }
           
        return tipoTel;
    }
    
    public List<telefono> getTelefonos(int id)throws  Exception{      
        
        try {
            
            this.tel = new ArrayList<telefono>();
            Connection conn = this.conectar();
            
            String sql = "SELECT T.ID, T.NUMERO, TT.TIPO FROM TELEFONO_CLIENTE T INNER JOIN TIPO_TELEFONO TT ON T.ID_TIPO_TELEFONO=TT.ID WHERE T.ID_CLIENTE="+id;
            System.out.println(sql);
            Statement stmt = conn.createStatement();
            ResultSet rs;
            
            rs = stmt.executeQuery(sql);
                        
            while(rs.next()){
                telefono tel = new telefono();
                tel.setId(rs.getInt(1));
                tel.setNumero(rs.getString(2));   
                tel.setTipoTelefono(rs.getString(3));
                this.tel.add(tel);           
            }
            
        }catch(Exception sqle) {
            Throwable t = sqle.getCause();
        }finally{
            this.cerrar();
        }
           
        return tel;
    }

    public List<correo> getCorreos(int id)throws  Exception{      
        
        try {
            
            this.correo = new ArrayList<correo>();
            Connection conn = this.conectar();
            
            String sql = "SELECT * FROM CORREO_CLIENTE WHERE ID_CLIENTE="+id;
            Statement stmt = conn.createStatement();
            ResultSet rs;
            
            System.out.println(sql);
            rs = stmt.executeQuery(sql);
                        
            while(rs.next()){
                 System.out.println("correo"+rs.getString(2));
                correo cor = new correo();
                cor.setId(rs.getInt(1));
                cor.setCorreo(rs.getString(2));   
                this.correo.add(cor);           
            }
            
        }catch(Exception sqle) {
            Throwable t = sqle.getCause();
        }finally{
            this.cerrar();
        }
           
        return correo;
    }
}
