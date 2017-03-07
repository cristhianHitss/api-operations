package com.spring.hitss.api.operations.dto.operation;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

/**
 * Created by HItss on 20/12/2016.
 */
@Component
@Document(collection = "Operation")
public class OperationDto {

    @Id
    private String id;
    private Integer Id_Compania;
    private Integer Id_LineaNegocio;
    private Integer Id_TipoVenta;
    private Integer Id_ZonaGeografica;
    private Integer Id_Sector;
    private Integer Id_Proveedor;
    private Integer Id_Asociado;
    private Integer Id_AgrupacionResumen;
    private Integer Id_AgrupacionResumen2;
    private Integer Id_Cliente;
    private Integer Id_Proyecto;
    private Integer Id_RecursoHumano;
    private Integer Id_Vector;
    private Integer Id_Moneda;
    private Integer Id_MonedaNomina;
    private String Compania;
    private String Linea_Negocio;
    private String Agrupacion;
    private String PaisOperacion;
    private String SucursalOperacion;
    private String PaisVenta;
    private String SucursalVenta;
    private String PaisFacturacion;
    private String SucursalFacturacion;
    private String PaisCompra;
    private String SucursalCompra;
    private String Sector;
    private String Proveedor;
    private String Asociado;
    private String Asociacion;
    private String Asociacion2;
    private String Cliente;
    private String Proyecto;
    private String Tipo_Proyecto;
    private String Tipo_Venta;
    private String Estatus_Operativo;
    private String Concepto;
    private String Recurso;
    private Boolean Overhead;
    private Boolean Cobrable;
    private String Rol_de_Gasto;
    private Double NoRRHH;
    private String Fec_Inicio;
    private String Fec_Fin;
    private String Forma_Venta;
    private String Moneda;
    private String Moneda_Nomina;
    private String Fec_Tipo_Cambio;
    private Integer Horas;
    private Double Tarifa;
    private Double Ingreso;
    private Double Ingreso_Base;
    private Integer Incidencia;
    private Integer Incidencia_Base;
    private Integer Num_Incidencias;
    private Double Ingreso_Total;
    private Double Ingreso_Total_Base;
    private Double Costo;
    private Double Costo_Base;
    private Double Costo_Total;
    private Double Costo_Total_Base;
    private Double Margen;
    private Double Margen_Porc;
    private Double CostoReal;
    private Double CostoRealBase;
    private String Director_Comercial;
    private String Ejecutivo_Cuenta;
    private String Gerente_Operaciones;
    private String Director_Operaciones;
    private String Comentario;
    private Integer Mes;
    private Integer Anio;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getId_Compania() {
        return Id_Compania;
    }

    public void setId_Compania(Integer id_Compania) {
        Id_Compania = id_Compania;
    }

    public Integer getId_TipoVenta() {
        return Id_TipoVenta;
    }

    public void setId_TipoVenta(Integer id_TipoVenta) {
        Id_TipoVenta = id_TipoVenta;
    }

    public Integer getId_LineaNegocio() {
        return Id_LineaNegocio;
    }

    public void setId_LineaNegocio(Integer id_LineaNegocio) {
        Id_LineaNegocio = id_LineaNegocio;
    }

    public Integer getId_ZonaGeografica() {
        return Id_ZonaGeografica;
    }

    public void setId_ZonaGeografica(Integer id_ZonaGeografica) {
        Id_ZonaGeografica = id_ZonaGeografica;
    }

    public Integer getId_Sector() {
        return Id_Sector;
    }

    public void setId_Sector(Integer id_Sector) {
        Id_Sector = id_Sector;
    }

    public Integer getId_Proveedor() {
        return Id_Proveedor;
    }

    public void setId_Proveedor(Integer id_Proveedor) {
        Id_Proveedor = id_Proveedor;
    }

    public Integer getId_Asociado() {
        return Id_Asociado;
    }

    public void setId_Asociado(Integer id_Asociado) {
        Id_Asociado = id_Asociado;
    }

    public Integer getId_AgrupacionResumen() {
        return Id_AgrupacionResumen;
    }

    public void setId_AgrupacionResumen(Integer id_AgrupacionResumen) {
        Id_AgrupacionResumen = id_AgrupacionResumen;
    }

    public Integer getId_AgrupacionResumen2() {
        return Id_AgrupacionResumen2;
    }

    public void setId_AgrupacionResumen2(Integer id_AgrupacionResumen2) {
        Id_AgrupacionResumen2 = id_AgrupacionResumen2;
    }

    public Integer getId_Cliente() {
        return Id_Cliente;
    }

    public void setId_Cliente(Integer id_Cliente) {
        Id_Cliente = id_Cliente;
    }

    public Integer getId_Proyecto() {
        return Id_Proyecto;
    }

    public void setId_Proyecto(Integer id_Proyecto) {
        Id_Proyecto = id_Proyecto;
    }

    public Integer getId_RecursoHumano() {
        return Id_RecursoHumano;
    }

    public void setId_RecursoHumano(Integer id_RecursoHumano) {
        Id_RecursoHumano = id_RecursoHumano;
    }

    public Integer getId_Vector() {
        return Id_Vector;
    }

    public void setId_Vector(Integer id_Vector) {
        Id_Vector = id_Vector;
    }

    public Integer getId_Moneda() {
        return Id_Moneda;
    }

    public void setId_Moneda(Integer id_Moneda) {
        Id_Moneda = id_Moneda;
    }

    public Integer getId_MonedaNomina() {
        return Id_MonedaNomina;
    }

    public void setId_MonedaNomina(Integer id_MonedaNomina) {
        Id_MonedaNomina = id_MonedaNomina;
    }

    public String getCompania() {
        return Compania;
    }

    public void setCompania(String compania) {
        Compania = compania;
    }

    public String getLinea_Negocio() {
        return Linea_Negocio;
    }

    public void setLinea_Negocio(String linea_Negocio) {
        Linea_Negocio = linea_Negocio;
    }

    public String getAgrupacion() {
        return Agrupacion;
    }

    public void setAgrupacion(String agrupacion) {
        Agrupacion = agrupacion;
    }

    public String getSucursalOperacion() {
        return SucursalOperacion;
    }

    public void setSucursalOperacion(String sucursalOperacion) {
        SucursalOperacion = sucursalOperacion;
    }

    public String getPaisOperacion() {
        return PaisOperacion;
    }

    public void setPaisOperacion(String paisOperacion) {
        PaisOperacion = paisOperacion;
    }

    public String getPaisVenta() {
        return PaisVenta;
    }

    public void setPaisVenta(String paisVenta) {
        PaisVenta = paisVenta;
    }

    public String getSucursalVenta() {
        return SucursalVenta;
    }

    public void setSucursalVenta(String sucursalVenta) {
        SucursalVenta = sucursalVenta;
    }

    public String getPaisFacturacion() {
        return PaisFacturacion;
    }

    public void setPaisFacturacion(String paisFacturacion) {
        PaisFacturacion = paisFacturacion;
    }

    public String getSucursalFacturacion() {
        return SucursalFacturacion;
    }

    public void setSucursalFacturacion(String sucursalFacturacion) {
        SucursalFacturacion = sucursalFacturacion;
    }

    public String getPaisCompra() {
        return PaisCompra;
    }

    public void setPaisCompra(String paisCompra) {
        PaisCompra = paisCompra;
    }

    public String getSucursalCompra() {
        return SucursalCompra;
    }

    public void setSucursalCompra(String sucursalCompra) {
        SucursalCompra = sucursalCompra;
    }

    public String getSector() {
        return Sector;
    }

    public void setSector(String sector) {
        Sector = sector;
    }

    public String getProveedor() {
        return Proveedor;
    }

    public void setProveedor(String proveedor) {
        Proveedor = proveedor;
    }

    public String getAsociado() {
        return Asociado;
    }

    public void setAsociado(String asociado) {
        Asociado = asociado;
    }

    public String getAsociacion() {
        return Asociacion;
    }

    public void setAsociacion(String asociacion) {
        Asociacion = asociacion;
    }

    public String getAsociacion2() {
        return Asociacion2;
    }

    public void setAsociacion2(String asociacion2) {
        Asociacion2 = asociacion2;
    }

    public String getCliente() {
        return Cliente;
    }

    public void setCliente(String cliente) {
        Cliente = cliente;
    }

    public String getTipo_Proyecto() {
        return Tipo_Proyecto;
    }

    public void setTipo_Proyecto(String tipo_Proyecto) {
        Tipo_Proyecto = tipo_Proyecto;
    }

    public String getProyecto() {
        return Proyecto;
    }

    public void setProyecto(String proyecto) {
        Proyecto = proyecto;
    }

    public String getConcepto() {
        return Concepto;
    }

    public void setConcepto(String concepto) {
        Concepto = concepto;
    }

    public String getTipo_Venta() {
        return Tipo_Venta;
    }

    public void setTipo_Venta(String tipo_Venta) {
        Tipo_Venta = tipo_Venta;
    }

    public String getEstatus_Operativo() {
        return Estatus_Operativo;
    }

    public void setEstatus_Operativo(String estatus_Operativo) {
        Estatus_Operativo = estatus_Operativo;
    }

    public String getRecurso() {
        return Recurso;
    }

    public void setRecurso(String recurso) {
        Recurso = recurso;
    }

    public Boolean getOverhead() {
        return Overhead;
    }

    public void setOverhead(Boolean overhead) {
        Overhead = overhead;
    }

    public Boolean getCobrable() {
        return Cobrable;
    }

    public void setCobrable(Boolean cobrable) {
        Cobrable = cobrable;
    }

    public String getRol_de_Gasto() {
        return Rol_de_Gasto;
    }

    public void setRol_de_Gasto(String rol_de_Gasto) {
        Rol_de_Gasto = rol_de_Gasto;
    }

    public Double getNoRRHH() {
        return NoRRHH;
    }

    public void setNoRRHH(Double noRRHH) {
        NoRRHH = noRRHH;
    }

    public String getFec_Inicio() {
        return Fec_Inicio;
    }

    public void setFec_Inicio(String fec_Inicio) {
        Fec_Inicio = fec_Inicio;
    }

    public String getFec_Fin() {
        return Fec_Fin;
    }

    public void setFec_Fin(String fec_Fin) {
        Fec_Fin = fec_Fin;
    }

    public String getForma_Venta() {
        return Forma_Venta;
    }

    public void setForma_Venta(String forma_Venta) {
        Forma_Venta = forma_Venta;
    }

    public String getMoneda() {
        return Moneda;
    }

    public void setMoneda(String moneda) {
        Moneda = moneda;
    }

    public Integer getHoras() {
        return Horas;
    }

    public void setHoras(Integer horas) {
        Horas = horas;
    }

    public String getFec_Tipo_Cambio() {
        return Fec_Tipo_Cambio;
    }

    public void setFec_Tipo_Cambio(String fec_Tipo_Cambio) {
        Fec_Tipo_Cambio = fec_Tipo_Cambio;
    }

    public String getMoneda_Nomina() {
        return Moneda_Nomina;
    }

    public void setMoneda_Nomina(String moneda_Nomina) {
        Moneda_Nomina = moneda_Nomina;
    }

    public Double getTarifa() {
        return Tarifa;
    }

    public void setTarifa(Double tarifa) {
        Tarifa = tarifa;
    }

    public Double getIngreso() {
        return Ingreso;
    }

    public void setIngreso(Double ingreso) {
        Ingreso = ingreso;
    }

    public Double getIngreso_Base() {
        return Ingreso_Base;
    }

    public void setIngreso_Base(Double ingreso_Base) {
        Ingreso_Base = ingreso_Base;
    }

    public Integer getIncidencia() {
        return Incidencia;
    }

    public void setIncidencia(Integer incidencia) {
        Incidencia = incidencia;
    }

    public Integer getIncidencia_Base() {
        return Incidencia_Base;
    }

    public void setIncidencia_Base(Integer incidencia_Base) {
        Incidencia_Base = incidencia_Base;
    }

    public Integer getNum_Incidencias() {
        return Num_Incidencias;
    }

    public void setNum_Incidencias(Integer num_Incidencias) {
        Num_Incidencias = num_Incidencias;
    }

    public Double getIngreso_Total_Base() {
        return Ingreso_Total_Base;
    }

    public void setIngreso_Total_Base(Double ingreso_Total_Base) {
        Ingreso_Total_Base = ingreso_Total_Base;
    }

    public Double getIngreso_Total() {
        return Ingreso_Total;
    }

    public void setIngreso_Total(Double ingreso_Total) {
        Ingreso_Total = ingreso_Total;
    }

    public Double getCosto() {
        return Costo;
    }

    public void setCosto(Double costo) {
        Costo = costo;
    }

    public Double getCosto_Base() {
        return Costo_Base;
    }

    public void setCosto_Base(Double costo_Base) {
        Costo_Base = costo_Base;
    }

    public Double getCosto_Total() {
        return Costo_Total;
    }

    public void setCosto_Total(Double costo_Total) {
        Costo_Total = costo_Total;
    }

    public Double getCosto_Total_Base() {
        return Costo_Total_Base;
    }

    public void setCosto_Total_Base(Double costo_Total_Base) {
        Costo_Total_Base = costo_Total_Base;
    }

    public Double getMargen() {
        return Margen;
    }

    public void setMargen(Double margen) {
        Margen = margen;
    }

    public Double getCostoReal() {
        return CostoReal;
    }

    public void setCostoReal(Double costoReal) {
        CostoReal = costoReal;
    }

    public Double getMargen_Porc() {
        return Margen_Porc;
    }

    public void setMargen_Porc(Double margen_Porc) {
        Margen_Porc = margen_Porc;
    }

    public Double getCostoRealBase() {
        return CostoRealBase;
    }

    public void setCostoRealBase(Double costoRealBase) {
        CostoRealBase = costoRealBase;
    }

    public String getDirector_Comercial() {
        return Director_Comercial;
    }

    public void setDirector_Comercial(String director_Comercial) {
        Director_Comercial = director_Comercial;
    }

    public String getGerente_Operaciones() {
        return Gerente_Operaciones;
    }

    public void setGerente_Operaciones(String gerente_Operaciones) {
        Gerente_Operaciones = gerente_Operaciones;
    }

    public String getDirector_Operaciones() {
        return Director_Operaciones;
    }

    public void setDirector_Operaciones(String director_Operaciones) {
        Director_Operaciones = director_Operaciones;
    }

    public String getEjecutivo_Cuenta() {
        return Ejecutivo_Cuenta;
    }

    public void setEjecutivo_Cuenta(String ejecutivo_Cuenta) {
        Ejecutivo_Cuenta = ejecutivo_Cuenta;
    }

    public String getComentario() {
        return Comentario;
    }

    public void setComentario(String comentario) {
        Comentario = comentario;
    }

    public Integer getMes() {
        return Mes;
    }

    public void setMes(Integer mes) {
        Mes = mes;
    }

    public Integer getAnio() {
        return Anio;
    }

    public void setAnio(Integer anio) {
        Anio = anio;
    }

    @Override
    public String toString() {
        return "OperationDto{" +
                "id='" + id + '\'' +
                ", Id_Compania=" + Id_Compania +
                ", Id_LineaNegocio=" + Id_LineaNegocio +
                ", Id_TipoVenta=" + Id_TipoVenta +
                ", Id_ZonaGeografica=" + Id_ZonaGeografica +
                ", Id_Sector=" + Id_Sector +
                ", Id_Proveedor=" + Id_Proveedor +
                ", Id_Asociado=" + Id_Asociado +
                ", Id_AgrupacionResumen=" + Id_AgrupacionResumen +
                ", Id_AgrupacionResumen2=" + Id_AgrupacionResumen2 +
                ", Id_Cliente=" + Id_Cliente +
                ", Id_Proyecto=" + Id_Proyecto +
                ", Id_RecursoHumano=" + Id_RecursoHumano +
                ", Id_Vector=" + Id_Vector +
                ", Id_Moneda=" + Id_Moneda +
                ", Id_MonedaNomina=" + Id_MonedaNomina +
                ", Compania='" + Compania + '\'' +
                ", Linea_Negocio='" + Linea_Negocio + '\'' +
                ", Agrupacion='" + Agrupacion + '\'' +
                ", PaisOperacion='" + PaisOperacion + '\'' +
                ", SucursalOperacion='" + SucursalOperacion + '\'' +
                ", PaisVenta='" + PaisVenta + '\'' +
                ", SucursalVenta='" + SucursalVenta + '\'' +
                ", PaisFacturacion='" + PaisFacturacion + '\'' +
                ", SucursalFacturacion='" + SucursalFacturacion + '\'' +
                ", PaisCompra='" + PaisCompra + '\'' +
                ", SucursalCompra='" + SucursalCompra + '\'' +
                ", Sector='" + Sector + '\'' +
                ", Proveedor='" + Proveedor + '\'' +
                ", Asociado='" + Asociado + '\'' +
                ", Asociacion='" + Asociacion + '\'' +
                ", Asociacion2='" + Asociacion2 + '\'' +
                ", Cliente='" + Cliente + '\'' +
                ", Proyecto='" + Proyecto + '\'' +
                ", Tipo_Proyecto='" + Tipo_Proyecto + '\'' +
                ", Tipo_Venta='" + Tipo_Venta + '\'' +
                ", Estatus_Operativo='" + Estatus_Operativo + '\'' +
                ", Concepto='" + Concepto + '\'' +
                ", Recurso='" + Recurso + '\'' +
                ", Overhead=" + Overhead +
                ", Cobrable=" + Cobrable +
                ", Rol_de_Gasto='" + Rol_de_Gasto + '\'' +
                ", NoRRHH=" + NoRRHH +
                ", Fec_Inicio='" + Fec_Inicio + '\'' +
                ", Fec_Fin='" + Fec_Fin + '\'' +
                ", Forma_Venta='" + Forma_Venta + '\'' +
                ", Moneda='" + Moneda + '\'' +
                ", Moneda_Nomina='" + Moneda_Nomina + '\'' +
                ", Fec_Tipo_Cambio='" + Fec_Tipo_Cambio + '\'' +
                ", Horas=" + Horas +
                ", Tarifa=" + Tarifa +
                ", Ingreso=" + Ingreso +
                ", Ingreso_Base=" + Ingreso_Base +
                ", Incidencia=" + Incidencia +
                ", Incidencia_Base=" + Incidencia_Base +
                ", Num_Incidencias=" + Num_Incidencias +
                ", Ingreso_Total=" + Ingreso_Total +
                ", Ingreso_Total_Base=" + Ingreso_Total_Base +
                ", Costo=" + Costo +
                ", Costo_Base=" + Costo_Base +
                ", Costo_Total=" + Costo_Total +
                ", Costo_Total_Base=" + Costo_Total_Base +
                ", Margen=" + Margen +
                ", Margen_Porc=" + Margen_Porc +
                ", CostoReal=" + CostoReal +
                ", CostoRealBase=" + CostoRealBase +
                ", Director_Comercial='" + Director_Comercial + '\'' +
                ", Ejecutivo_Cuenta='" + Ejecutivo_Cuenta + '\'' +
                ", Gerente_Operaciones='" + Gerente_Operaciones + '\'' +
                ", Director_Operaciones='" + Director_Operaciones + '\'' +
                ", Comentario='" + Comentario + '\'' +
                ", Mes=" + Mes +
                ", Anio=" + Anio +
                '}';
    }
}