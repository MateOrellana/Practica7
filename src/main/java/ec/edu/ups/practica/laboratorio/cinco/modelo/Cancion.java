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
public class Cancion {

    private int codigo;
    private String titulo;
    private String letra;
    private double tiempoEnMinutos;
    private boolean top100Billboard;

    public Cancion(int codigo, String titulo, String letra, double tiempoEnMinutos) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.letra = letra;
        this.tiempoEnMinutos = tiempoEnMinutos;
        this.top100Billboard = false;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    public double getTiempoEnMinutos() {
        return tiempoEnMinutos;
    }

    public void setTiempoEnMinutos(double tiempoEnMinutos) {
        this.tiempoEnMinutos = tiempoEnMinutos;
    }

    public boolean isTop100Billboard() {
        return top100Billboard;
    }

    public void setTop100Billboard(boolean top100Billboard) {
        this.top100Billboard = top100Billboard;
    }
    
    //Metodo hashCode 
    //Compara los objetos pasados, devolviendo un numero entero 
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.codigo;
        hash = 59 * hash + Objects.hashCode(this.titulo);
        hash = 59 * hash + Objects.hashCode(this.letra);
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.tiempoEnMinutos) ^ (Double.doubleToLongBits(this.tiempoEnMinutos) >>> 32));
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
        final Cancion other = (Cancion) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (Double.doubleToLongBits(this.tiempoEnMinutos) != Double.doubleToLongBits(other.tiempoEnMinutos)) {
            return false;
        }
        if (!Objects.equals(this.titulo, other.titulo)) {
            return false;
        }
        return Objects.equals(this.letra, other.letra);
    }

    //Generar to String
    @Override
    public String toString() {
        return "Cancion{" + "codigo =" + codigo + ", titulo=" + titulo + ", letra=" + letra + ", tiempoEnMinutos=" + tiempoEnMinutos + '}';
    }
}
