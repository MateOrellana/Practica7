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
public class Compositor extends Persona {

    //Atributos de la clase Compositor
    private int numeroDeComposiciones;
    private List<Cancion> canciones;
    private List<Cantante> clientes;

    //Constructor vacio
    public Compositor() {
        canciones = new ArrayList<>();
        clientes = new ArrayList<>();
    }

    //Constructor donde se obtiene datos de la clase Compositor
    public Compositor(int codigo, String nombre, String apellido, int edad, String nacionalidad, double salario,
            int numeroDeComposiciones) {
        super(codigo, nombre, apellido, edad, nacionalidad, salario);
        this.numeroDeComposiciones = numeroDeComposiciones;
        this.canciones = new ArrayList<>();
        this.clientes = new ArrayList<>();
    }

   //Getters y setters de encapsulamiento de atributos

    public int getNumeroDeComposiciones() {
        return numeroDeComposiciones;
    }

    public void setNumeroDeComposiciones(int numeroDeComposiciones) {
        this.numeroDeComposiciones = numeroDeComposiciones;
    }

    public List<Cancion> getCanciones() {
        return canciones;
    }

    public void setCanciones(List<Cancion> canciones) {
        this.canciones = canciones;
    }

    public List<Cantante> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cantante> clientes) {
        this.clientes = clientes;
    }
    
    
    public void agregarCancion(int codigo, String titulo, String letra, double tiempoEnMinutos) {
        Cancion cancion = new Cancion(codigo, titulo, letra, tiempoEnMinutos);
        canciones.add(cancion);
    }

    public void agregarCliente(Cantante cliente) {
        clientes.add(cliente);
    }

    @Override
    public double calcularSalario() {
        double salarioFinal = getSalario();

        // Aplicar regalía si el compositor tiene más de 5 composiciones
        if (numeroDeComposiciones > 5) {
            salarioFinal += 300;
        }

        // Obtener la cantidad de canciones en el top 100 de billboard
        int cancionesTop100Billboard = 0;
        for (Cancion cancion : canciones) {
            if (cancion.isTop100Billboard()) {
                cancionesTop100Billboard++;
            }
        }

        // Aplicar aumento según la cantidad de canciones en el top 100 de billboard
        if (cancionesTop100Billboard >= 1 && cancionesTop100Billboard <= 3) {
            salarioFinal *= 1.10;
        } else if (cancionesTop100Billboard >= 4 && cancionesTop100Billboard <= 6) {
            salarioFinal *= 1.20;
        } else if (cancionesTop100Billboard > 6) {
            salarioFinal *= 1.30;
        }

        return salarioFinal;
    }

    //Metodo hashCode 
    //Compara los objetos pasados, devolviendo un numero entero
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + this.numeroDeComposiciones;
        hash = 17 * hash + Objects.hashCode(this.canciones);
        hash = 17 * hash + Objects.hashCode(this.clientes);
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
        final Compositor other = (Compositor) obj;
        if (this.numeroDeComposiciones != other.numeroDeComposiciones) {
            return false;
        }
        if (!Objects.equals(this.canciones, other.canciones)) {
            return false;
        }
        return Objects.equals(this.clientes, other.clientes);
    }

    //Generar to String 

    @Override
    public String toString() {
        return "Compositor{" + "numeroDeComposiciones=" + numeroDeComposiciones + ", canciones=" + canciones + ", clientes=" + clientes + '}';
    }
    
}

