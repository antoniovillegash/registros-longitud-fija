/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.logging.Logger;

/**
 *
 * @author 7053
 */
public class ProductoDTO implements Serializable{
    
    private static final Logger LOG = Logger.getLogger(ProductoDTO.class.getName());
    public static final int longitud=40+Long.BYTES+Double.BYTES+Integer.BYTES+12;
    
    Long id;
    private StringBuffer nombre;
    private BigDecimal precio;
    private Integer existencia;

    public ProductoDTO() {
        setId(0L);
        setNombre(new StringBuffer(""));
        setPrecio(new BigDecimal(0.0));
        setExistencia(0);
    }

    public ProductoDTO(Long id, StringBuffer nombre, BigDecimal precio, Integer cantidad) {
        setId(id);
        setNombre(nombre);
        setPrecio(precio);
        setExistencia(cantidad);
    }
    
    public ProductoDTO(String registro){
        registro=registro.substring(3);
        registro=registro.replace("}", "");
        String datos[]=registro.split(",");
        id=Long.parseLong(datos[0]);
        nombre=new StringBuffer(datos[1].trim());
        precio=BigDecimal.valueOf(Double.parseDouble(datos[2]));
        existencia=Integer.parseInt(datos[3]);
    }

    public Integer getExistencia() {
        return existencia;
    }

    public void setExistencia(Integer existencia) {
        this.existencia = existencia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StringBuffer getNombre() {
        return nombre;
    }

    public void setNombre(StringBuffer nombre) {
        this.nombre = nombre;
        //this.nombre.setLength(20);
        for (int i = nombre.length(); i < 20; i++) {
            this.nombre.append(" ");
        }
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ProductoDTO other = (ProductoDTO) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Producto{" + "id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", cantidad=" + existencia + '}';
    }
    
    public String toStringFile(){
        String idS=""+id;
        String precioS=""+precio;
        String existenciaS=""+existencia;
        switch(idS.length()){
            case 1: idS="00"+id; break;
            case 2: idS="0"+id; break;            
        }
        switch(precioS.length()){
            case 1: precioS="00"+precio+".0"; break;
            case 2: precioS="0"+precio+".0"; break;            
            case 3: precioS="00"+precio; break;
            case 4: precioS="0"+precio; break;            
        }
        switch(existenciaS.length()){
            case 1: existenciaS="00"+existencia; break;
            case 2: existenciaS="0"+existencia; break;            
        }
        return "{" + idS + "," + nombre + "," + precioS + "," + existenciaS + "}\n";
    }
    
}
