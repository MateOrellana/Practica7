/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.practica.laboratorio.cinco.modelo;

import java.util.Objects;

/**
 *
 * @author mateo
 */
public class Disco {
    //Atributos clase Disco
    private int codigo;
    private String nombre;
    private int anioDeLanzamiento;

    //Constructor vacio
    public Disco() {
    }

    //Constructor de los datos de la clase Disco
    public Disco(int codigo, String nombre, int anioDeLanzamiento) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.anioDeLanzamiento = anioDeLanzamiento;
    }

    //Getters y setters de encapsulamiento de atributos
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAnioDeLanzamiento() {
        return anioDeLanzamiento;
    }

    public void setAnioDeLanzamiento(int anioDeLanzamiento) {
        this.anioDeLanzamiento = anioDeLanzamiento;
    }

    //Metodo hashCode 
    //Compara los objetos pasados, devolviendo un numero entero 
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + this.codigo;
        hash = 17 * hash + Objects.hashCode(this.nombre);
        hash = 17 * hash + this.anioDeLanzamiento;
        return hash;
    }

    //Metodo equals
    //Compara si los objetos son del mismo tipo
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
        final Disco other = (Disco) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (this.anioDeLanzamiento != other.anioDeLanzamiento) {
            return false;
        }
        return Objects.equals(this.nombre, other.nombre);
    }

    //Metodo to String
    @Override
    public String toString() {
        return "Disco{" + "codigo=" + codigo + ", nombre=" + nombre + ", anioDeLanzamiento=" + anioDeLanzamiento + '}';
    }

}
