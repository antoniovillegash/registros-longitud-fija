/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.PeliculasDTO;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author 7053
 */
public class ProductoFDAO {
    
    private final File f; 
    private final RandomAccessFile raf;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    private int numRegistro;
    
    public ProductoFDAO() throws IOException {
        f=new File("peliculas.txt");
        if(!f.exists()){
            f.createNewFile();
        }
        raf=new RandomAccessFile(f, "rw");
    }
    
    public synchronized boolean agregar(PeliculasDTO dto) throws IOException{
        raf.seek(raf.length());
        raf.writeUTF(dto.toStringFile());
        raf.seek(0);
        return true;
    }
    public boolean actualizar(PeliculasDTO dto) throws IOException{
        raf.seek(0);
        int row=0;
        while(row<numRegistro){
            raf.readLine();
            row++;
        }
        raf.writeUTF(dto.toStringFile());
        raf.seek(0);
        System.out.println(dto+" actualizado en la posicion "+numRegistro);
        return true;     
    }
    
    public boolean eliminar(PeliculasDTO dto) throws IOException{
        raf.seek(0);
        int row=0;
        while(row<numRegistro){
            raf.readLine();
            row++;
        }
        raf.writeUTF(new PeliculasDTO().toStringFile());
        raf.seek(0);
        System.out.println(dto+" borrado en la posicion "+numRegistro);
        return true;
    }
   
    public PeliculasDTO obtenerPorId(PeliculasDTO dto) throws IOException, ClassNotFoundException{
        PeliculasDTO pelicula=null;
        String registro=null;
        numRegistro=0;
        do{
            registro=raf.readLine();
            pelicula=new PeliculasDTO(registro);
            if(pelicula.equals(dto)){
                System.out.println(pelicula+" encontrado en la posicion "+numRegistro);
                break;
            }
            numRegistro++;            
        }while(registro!=null);
        raf.seek(0);
        return pelicula;
    }
    
    public List<PeliculasDTO> obtenerTodos() throws IOException, ClassNotFoundException{
        List<PeliculasDTO> peliculas=new ArrayList<>();
        PeliculasDTO pelicula=null;
        String registro=null;
        raf.seek(0);
        do{
            registro=raf.readLine();
            pelicula=new PeliculasDTO(registro);
            peliculas.add(pelicula);
        }while(registro!=null);
        raf.seek(0);
        return peliculas;
    }
    
    public void cerrarArchivo() throws IOException{
        raf.close();
    }
        
}
