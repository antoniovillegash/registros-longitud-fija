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
public class PeliculasDTO implements Serializable{
    
    private static final Logger LOG = Logger.getLogger(ProductoDTO.class.getName());
    public static final int longitud=40+Long.BYTES+Double.BYTES+Integer.BYTES+12;
    
    private Long id;
    private StringBuffer nombre;
    private Integer año;
    private StringBuffer genero;
    private StringBuffer pais;
    private StringBuffer director;
    private Integer duracion;
    private StringBuffer clasificacion;
    private StringBuffer estudio;

    public PeliculasDTO() {
        setId(0L);
        setNombre(new StringBuffer(""));
        setAño(new Integer(0));
        setGenero(new StringBuffer(""));
        setPais(new StringBuffer(""));
        setDirector(new StringBuffer(""));
        setDuracion(new Integer(0));
        setClasificacion(new StringBuffer(""));
        setEstudio(new StringBuffer(""));
    }

    public PeliculasDTO(Long id, StringBuffer nombre, Integer año, StringBuffer genero, StringBuffer pais, StringBuffer director, Integer duracion, StringBuffer clasificacion, StringBuffer estudio) {
        this.id = id;
        this.nombre = nombre;
        this.año = año;
        this.genero = genero;
        this.pais = pais;
        this.director = director;
        this.duracion = duracion;
        this.clasificacion = clasificacion;
        this.estudio = estudio;
    }

    
    
    public PeliculasDTO(String registro){
        registro=registro.substring(3);
        registro=registro.replace("}", "");
        String datos[]=registro.split(",");
        id=Long.parseLong(datos[0]);
        nombre=new StringBuffer(datos[1].trim());
        año=new Integer(datos[2].trim());
        genero=new StringBuffer(datos[3].trim());
        pais=new StringBuffer(datos[4].trim());
        director=new StringBuffer(datos[5].trim());
        duracion=new Integer(datos[6].trim());
        clasificacion=new StringBuffer(datos[7].trim());
        estudio=new StringBuffer(datos[8].trim());
        
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
    public void setAño(Integer año) {
        this.año = año;
    }

    public void setGenero(StringBuffer genero) {
        this.genero = genero;
        
        for (int i = genero.length(); i < 20; i++) {
            this.genero.append(" ");
        }
    }

    public void setPais(StringBuffer pais) {
        this.pais = pais;
        for (int i = pais.length(); i < 20; i++) {
            this.pais.append(" ");
        }
    }

    public void setDirector(StringBuffer director) {
        this.director = director;
        for (int i = director.length(); i < 20; i++) {
            this.director.append(" ");
        }
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    public void setClasificacion(StringBuffer clasificacion) {
        this.clasificacion = clasificacion;
        for (int i = clasificacion.length(); i < 20; i++) {
            this.clasificacion.append(" ");
        }
    }

    public void setEstudio(StringBuffer estudio) {
        this.estudio = estudio;
        for (int i = estudio.length(); i < 20; i++) {
            this.estudio.append(" ");
        }
    }

    public static int getLongitud() {
        return longitud;
    }

    public Integer getAño() {
        return año;
    }

    public StringBuffer getGenero() {
        return genero;
    }

    public StringBuffer getPais() {
        return pais;
    }

    public StringBuffer getDirector() {
        return director;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public StringBuffer getClasificacion() {
        return clasificacion;
    }

    public StringBuffer getEstudio() {
        return estudio;
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
        final PeliculasDTO other = (PeliculasDTO) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Pelicula{" + "id=" + id + ", nombre=" + nombre + ", año=" + año + ", genero=" + genero 
                +", pais="+pais+", director="+director+", duracion="+duracion+", clasificacion="+ clasificacion
                +", estudio="+estudio+'}';
    }
    
    public String toStringFile(){
        String idS=""+id;
        String añoS=""+año;
        String duracionS=""+duracion;
        switch(idS.length()){
            case 1: idS="00"+id; break;
            case 2: idS="0"+id; break;            
        }
        return "{" + idS + "," + nombre + "," + añoS 
                + "," + genero + ","+ pais + "," + director
                + ","+ duracionS + "," + clasificacion+ "," + estudio + "}\n";
    }
    
}

