/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author ANDRE
 */
public class municipio {
    
    private int id;
    private String nombre;
    private int id_depto;

    public int getId_depto() {
        return id_depto;
    }

    public void setId_depto(int id_depto) {
        this.id_depto = id_depto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
