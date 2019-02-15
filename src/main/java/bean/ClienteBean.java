
package bean;

import CAD.clienteCAD;
import DTO.cliente;
import DTO.correo;
import DTO.departamento;
import DTO.municipio;
import DTO.telefono;
import DTO.tipo_cliente;
import DTO.tipo_telefono;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author ANDRE
 */
@ManagedBean 
@RequestScoped
@Named(value = "ClienteBean")

public class ClienteBean {
    
    //private static List<producto> lista = new ArrayList();
    private static List<cliente> lista;
    private static List<municipio> ListaMunicipios;
    private static List<departamento> ListaDepartamentos;
    private static List<tipo_cliente> ListaTipoCliente;
    private static List<tipo_telefono> ListaTipoTelefono;
    private static List<telefono> ListaTelefono;
    private static List<correo> ListaCorreo;

    private String nombre;
    private String apellidos;
    private String telefono;
    private String direccion;
    private String nit;
    private String correo;
    private Date fecha_nac;
    private int tipo_cliente;
    private int municipio;
    private int departamento = 0;
    private int tipo_telefono;
    
    //variables para edicion
    private String nombreEdit;
    private static String apellidoEdit;
    private static String telefonoEdit;
    private static String direccionEdit;
    private static String nitEdit;
    private static String correEdit;
    private static Date fecha_nacEdit;
    private static int municipioEdit;
    private static int tipoTelefonoEdit;
    private static String tipoClienteEdit;
    
    private static int id;  
    private static int idCliente;

    public  String getTipoClienteEdit() {
        return tipoClienteEdit;
    }

    public  void setTipoClienteEdit(String tipoClienteEdit) {
        ClienteBean.tipoClienteEdit = tipoClienteEdit;
    }

    
    public int getTipo_telefono() {
        return tipo_telefono;
    }

    public void setTipo_telefono(int tipo_telefono) {
        this.tipo_telefono = tipo_telefono;
    }
    
    public Date getFecha_nac() {
        return fecha_nac;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setFecha_nac(Date fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public int getDepartamento() {
        return departamento;
    }

    public void setDepartamento(int departamento) {
        this.departamento = departamento;
    }

    public int getTipo_cliente() {
        return tipo_cliente;
    }

    public void setTipo_cliente(int tipo_cliente) {
        this.tipo_cliente = tipo_cliente;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }


    public String getNitEdit() {
        return nitEdit;
    }

    public void setNitEdit(String nitEdit) {
        this.nitEdit = nitEdit;
    }

    public String getCorreEdit() {
        return correEdit;
    }

    public void setCorreEdit(String correEdit) {
        ClienteBean.correEdit = correEdit;
    }

    public static Date getFecha_nacEdit() {
        return fecha_nacEdit;
    }

    public static void setFecha_nacEdit(Date fecha_nacEdit) {
        ClienteBean.fecha_nacEdit = fecha_nacEdit;
    }

    public static int getMunicipioEdit() {
        return municipioEdit;
    }

    public static void setMunicipioEdit(int municipioEdit) {
        ClienteBean.municipioEdit = municipioEdit;
    }



    public static int getTipoTelefonoEdit() {
        return tipoTelefonoEdit;
    }

    public static void setTipoTelefonoEdit(int tipoTelefonoEdit) {
        ClienteBean.tipoTelefonoEdit = tipoTelefonoEdit;
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

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStockEdit() {
        return stockEdit;
    }

    public void setStockEdit(int stockEdit) {
        this.stockEdit = stockEdit;
    }
    private int stockEdit;


    public String getNombreEdit() {
        return nombreEdit;
    }

    public String getApellidoEdit() {
        return apellidoEdit;
    }

    public void setApellidoEdit(String apellidoEdit) {
        this.apellidoEdit = apellidoEdit;
    }

    public String getTelefonoEdit() {
        return telefonoEdit;
    }

    public void setTelefonoEdit(String telefonoEdit) {
        this.telefonoEdit = telefonoEdit;
    }

    public String getDireccionEdit() {
        return direccionEdit;
    }

    public void setDireccionEdit(String direccionEdit) {
        this.direccionEdit = direccionEdit;
    }

    public void setNombreEdit(String nombreEdit) {
        this.nombreEdit = nombreEdit;
    }
    
    public List<cliente> getLista() {
        return lista;
    }

    public void setLista(List<cliente> lista) {
        this.lista = lista;
    }

    public List<municipio> getListaMunicipios() {
        return ListaMunicipios;
    }

    public void setListaMunicipios(List<municipio> ListaMunicipios) {
        ClienteBean.ListaMunicipios = ListaMunicipios;
    }

    public  List<departamento> getListaDepartamentos() {
        return ListaDepartamentos;
    }

    public void setListaDepartamentos(List<departamento> ListaDepartamentos) {
        ClienteBean.ListaDepartamentos = ListaDepartamentos;
    }

    public  List<tipo_cliente> getListaTipoCliente() {
        return ListaTipoCliente;
    }

    public void setListaTipoCliente(List<tipo_cliente> ListaTipoCliente) {
        ClienteBean.ListaTipoCliente = ListaTipoCliente;
    }

    public  List<tipo_telefono> getListaTipoTelefono() {
        return ListaTipoTelefono;
    }

    public void setListaTipoTelefono(List<tipo_telefono> ListaTipoTelefono) {
        ClienteBean.ListaTipoTelefono = ListaTipoTelefono;
    }
    
    public int getMunicipio() {
        return municipio;
    }

    public void setMunicipio(int municipio) {
        this.municipio = municipio;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public  List<telefono> getListaTelefono() {
        return ListaTelefono;
    }

    public  void setListaTelefono(List<telefono> ListaTelefono) {
        ClienteBean.ListaTelefono = ListaTelefono;
    }

    public  List<correo> getListaCorreo() {
        return ListaCorreo;
    }

    public  void setListaCorreo(List<correo> ListaCorreo) {
        ClienteBean.ListaCorreo = ListaCorreo;
    }
    
    
    
    
    @PostConstruct
    public void init() {
        this.listar();
        this.municipios();
        this.departamentos();
        this.tipoCliente();
        this.tipoTelefono();
    }
    
    public void listar(){        
        
        clienteCAD cliente = new clienteCAD();
    
        try {
            this.setLista(cliente.listadoClientes());
        }catch(Exception ex){
            
        }
      
    }
    
    public void municipios(){
        
        clienteCAD cliente = new clienteCAD();
        
        try{
            this.setListaMunicipios(cliente.municipios(this.getDepartamento()));
        }catch(Exception ex){
            
        }
       
    }    
    
    public void departamentos(){
        
        clienteCAD cliente = new clienteCAD();
        
        try{
            this.setListaDepartamentos(cliente.departamentos()); 
        }catch(Exception ex){
            
        }
       
    }
    
    public void tipoTelefono(){
        
        clienteCAD cliente = new clienteCAD();
        
        try{
            this.setListaTipoTelefono(cliente.tipo_telefono()); 
        }catch(Exception ex){
            
        }
       
    }
        
    public void tipoCliente(){
        
        clienteCAD cliente = new clienteCAD();
        
        try{
            this.setListaTipoCliente(cliente.tipo_cliente());
        }catch(Exception ex){
            
        }
       
    }
        
    public void insertar(){
        
        clienteCAD cli = new clienteCAD();
        
        cliente cliente = new cliente();
        cliente.setNombre(this.getNombre());
        cliente.setApellidos(this.getApellidos());
        cliente.setDireccion(this.getDireccion());
        cliente.setTelefono(this.getTelefono());
        cliente.setNit(this.getNit());
        cliente.setFecha_nacimient(this.getFecha_nac());
        cliente.setTipo_cliente(this.getTipo_cliente());
        cliente.setMunicipio(this.getMunicipio());
        cliente.setCorreo(this.getCorreo());
        cliente.setTipo_telefono(this.getTipo_telefono());

        int response;
        
        try {
            
            response = cli.insertarCliente(cliente);
            this.limpiar();
            
        }catch (Exception ex) {
        }
      
        this.listar();
    }
    
    public void limpiar(){
        this.setNombre("");
        this.setApellidos("");
        this.setDireccion("");
        this.setTelefono("");
        this.setNit("");
        this.setCorreo("");
        this.setFecha_nac(null);
        this.setTipo_cliente(0);
        this.setTipo_telefono(0);
    }
    
    public void actualizar(){
        
        clienteCAD cli = new clienteCAD();
        
        cliente cliente = new cliente();      
        cliente.setTipo_cliente(Integer.parseInt(this.getTipoClienteEdit()));
        cliente.setNombre(this.getNombreEdit());
        cliente.setApellidos(this.getApellidoEdit());
        cliente.setDireccion(this.getDireccionEdit());
        cliente.setNit(this.getNitEdit());
        
        cliente.setIdCliente(this.getIdCliente());
        
        try {
            cli.actualizarCliente(cliente);
            
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Successful", "Actualizado correctamente"));
            
           
        }catch (Exception ex) {
        }
        
        this.listar();
    }
    
    public void cancelar(RowEditEvent event){
        
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Cancelado", "Cancelado"));
    }
    
    public void eliminar(){
        
        clienteCAD cli = new clienteCAD();
        
        try {
            cli.eliminarCliente(this.getIdCliente());
            
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Eliminado", "eliminado correctamente"));
        }catch (Exception ex) {
        }
        
         this.listar();
    }
    
    public void btnEditar(cliente cli){
        
        this.setNombreEdit(cli.getNombre());
        this.setApellidoEdit(cli.getApellidos());
        this.setTelefonoEdit(cli.getTelefono());
        this.setDireccionEdit(cli.getDireccion());
        this.setNitEdit(cli.getNit());
        this.setIdCliente(cli.getIdCliente());
        this.setTipoClienteEdit(Integer.toString(cli.getTipo_cliente()));
        
    }
    
    public void listTelefonos(int id_cliente){
        
         clienteCAD cliente = new clienteCAD();
        
        try{
            this.setListaTelefono(cliente.getTelefonos(id_cliente));
        }catch(Exception ex){
            
        }
        
    }
    
    public void listCorreos(int id_cliente){
        
         clienteCAD cliente = new clienteCAD();
        
        try{
            this.setListaCorreo(cliente.getCorreos(id_cliente));
        }catch(Exception ex){
            
        }
        
    }
    
    public void btnEliminar(int idCliente){
        this.setIdCliente(idCliente);
    }
    
}
