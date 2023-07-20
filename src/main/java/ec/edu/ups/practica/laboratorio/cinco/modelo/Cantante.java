/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.practica.laboratorio.cinco.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author mateo
 */
public class Cantante extends Persona {

    //Atributos de la clase Cantante
    private String nombreArtistico;
    private String generoMusical;
    private int numeroDeSencillos;
    private int numeroDeConciertos;
    private int numeroDeGiras;
    private List<Disco> discografia;

    //Constructor vacio
    public Cantante() {
        discografia = new ArrayList<>();
    }

    //Constructor donde se obtiene datos de la clase persona 
    public Cantante(int codigo, String nombre, String apellido, int edad, String nacionalidad, double salario,
            String nombreArtistico, String generoMusical, int numeroDeSencillos, int numeroDeConciertos,
            int numeroDeGiras) {
        super(codigo, nombre, apellido, edad, nacionalidad, salario);
        this.nombreArtistico = nombreArtistico;
        this.generoMusical = generoMusical;
        this.numeroDeSencillos = numeroDeSencillos;
        this.numeroDeConciertos = numeroDeConciertos;
        this.numeroDeGiras = numeroDeGiras;
        this.discografia = new ArrayList<>();
    }

    //Getters y setters de encapsulamiento de atributos
    public String getNombreArtistico() {
        return nombreArtistico;
    }

    public void setNombreArtistico(String nombreArtistico) {
        this.nombreArtistico = nombreArtistico;
    }

    public String getGeneroMusical() {
        return generoMusical;
    }

    public void setGeneroMusical(String generoMusical) {
        this.generoMusical = generoMusical;
    }

    public int getNumeroDeSencillos() {
        return numeroDeSencillos;
    }

    public void setNumeroDeSencillos(int numeroDeSencillos) {
        this.numeroDeSencillos = numeroDeSencillos;
    }

    public int getNumeroDeConciertos() {
        return numeroDeConciertos;
    }

    public void setNumeroDeConciertos(int numeroDeConciertos) {
        this.numeroDeConciertos = numeroDeConciertos;
    }

    public int getNumeroDeGiras() {
        return numeroDeGiras;
    }

    public void setNumeroDeGiras(int numeroDeGiras) {
        this.numeroDeGiras = numeroDeGiras;
    }
    
    public List<Disco> getDiscografia() {
        return discografia;
    }

    public void setDiscografia(List<Disco> discografia) {
        this.discografia = discografia;
    }
    
     public void agregarDisco(int codigo, String nombre, int anioDeLanzamiento) {
        Disco disco = new Disco(codigo, nombre, anioDeLanzamiento);
        discografia.add(disco);
    }

    @Override
    public double calcularSalario() {
        double salarioFinal = getSalario();

        // Otorgar regalía y aumentos según las condiciones
        if (numeroDeSencillos > 10 && numeroDeGiras > 3) {
            salarioFinal += 1000;
        }
        if (numeroDeSencillos >= 1 && numeroDeSencillos <= 10) {
            salarioFinal *= 1.05;
        }
        if (numeroDeGiras >= 1 && numeroDeGiras <= 3) {
            salarioFinal *= 1.03;
        }
        if (discografia.size() >= 5) {
            salarioFinal += 2000;
        }
        return salarioFinal;
    }

    //Metodo hashCode 
    //Compara los objetos pasados, devolviendo un numero entero
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.nombreArtistico);
        hash = 83 * hash + Objects.hashCode(this.generoMusical);
        hash = 83 * hash + this.numeroDeSencillos;
        hash = 83 * hash + this.numeroDeConciertos;
        hash = 83 * hash + this.numeroDeGiras;
        hash = 83 * hash + Objects.hashCode(this.discografia);
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
        final Cantante other = (Cantante) obj;
        if (this.numeroDeSencillos != other.numeroDeSencillos) {
            return false;
        }
        if (this.numeroDeConciertos != other.numeroDeConciertos) {
            return false;
        }
        if (this.numeroDeGiras != other.numeroDeGiras) {
            return false;
        }
        if (!Objects.equals(this.nombreArtistico, other.nombreArtistico)) {
            return false;
        }
        if (!Objects.equals(this.generoMusical, other.generoMusical)) {
            return false;
        }
        return Objects.equals(this.discografia, other.discografia);
    }

    //Generar to String
    @Override
    public String toString() {
        return "Cantante{" + "nombreArtistico=" + nombreArtistico + ", generoMusical=" + generoMusical + ", numeroDeSencillos=" + numeroDeSencillos + ", numeroDeConciertos=" + numeroDeConciertos + ", numeroDeGiras=" + numeroDeGiras + ", discografia=" + discografia + '}';
    }
}
