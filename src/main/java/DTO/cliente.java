/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.Date;

/**
 *
 * @author ANDRE
 */
public class cliente {
    
    private int idCliente;
    private String nombre;
    private String apellidos;
    private String telefono;
    private String direccion;
    private String direccionActual;
    private String correo;
    private Date fecha_nacimient;
    private int tipo_cliente;
    private int municipio;
    private String nit;
    private int tipo_telefono;
    private String tipoCliente;

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public int getTipo_telefono() {
        return tipo_telefono;
    }

    public void setTipo_telefono(int tipo_telefono) {
        this.tipo_telefono = tipo_telefono;
    }
    
    

    public Date getFecha_nacimient() {
        return fecha_nacimient;
    }

    public void setFecha_nacimient(Date fecha_nacimient) {
        this.fecha_nacimient = fecha_nacimient;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getTipo_cliente() {
        return tipo_cliente;
    }

    public void setTipo_cliente(int tipo_cliente) {
        this.tipo_cliente = tipo_cliente;
    }

    public int getMunicipio() {
        return municipio;
    }

    public void setMunicipio(int municipio) {
        this.municipio = municipio;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }
    private int estado;

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDireccionActual() {
        return direccionActual;
    }

    public void setDireccionActual(String direccionActual) {
        this.direccionActual = direccionActual;
    }

}
