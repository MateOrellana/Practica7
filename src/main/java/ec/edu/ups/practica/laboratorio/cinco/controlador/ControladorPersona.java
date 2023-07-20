/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.practica.laboratorio.cinco.controlador;

import ec.edu.ups.practica.laboratorio.cinco.modelo.Cancion;
import ec.edu.ups.practica.laboratorio.cinco.modelo.Cantante;
import ec.edu.ups.practica.laboratorio.cinco.modelo.Compositor;
import ec.edu.ups.practica.laboratorio.cinco.modelo.Disco;
import ec.edu.ups.practica.laboratorio.cinco.modelo.Persona;
import java.util.ArrayList;
import java.util.List;
import ec.edu.ups.practica.laboratorio.cinco.idao.IPersonaDAO;

/**
 *
 * @author mateo
 */
public class ControladorPersona {
    private IPersonaDAO personaDAO;

    public ControladorPersona(IPersonaDAO personaDAO) {
        this.personaDAO = personaDAO;
    }

    public void agregarCantante(int codigo, String nombre, String apellido, int edad, String nacionalidad,
            double salario, String nombreArtistico, String generoMusical, int numeroDeSencillos,
            int numeroDeConciertos, int numeroDeGiras) {
        Cantante cantante = new Cantante(codigo, nombre, apellido, edad, nacionalidad, salario, nombreArtistico,
                generoMusical, numeroDeSencillos, numeroDeConciertos, numeroDeGiras);
        personaDAO.create(cantante);
    }

    public void agregarCompositor(int codigo, String nombre, String apellido, int edad, String nacionalidad,
            double salario, int numeroDeComposiciones) {
        Compositor compositor = new Compositor(codigo, nombre, apellido, edad, nacionalidad, salario,
                numeroDeComposiciones);
        personaDAO.create(compositor);
    }

    public void agregarCliente(int codigoCompositor, int codigoCantante) {
        Persona compositor = personaDAO.read(codigoCompositor);
        Persona cantante = personaDAO.read(codigoCantante);

        if (compositor instanceof Compositor && cantante instanceof Cantante) {
            ((Compositor) compositor).agregarCliente((Cantante) cantante);
            personaDAO.update(compositor);
        }
    }

    public void imprimirPersonas() {
        List<Persona> personas = personaDAO.getAll();
        for (Persona persona : personas) {
            System.out.println("Nombre: " + persona.getNombre() + " " + persona.getApellido());
        }
    }

    public List<Persona> buscarCantantePorNombreDeDisco(String nombreDisco) {
        List<Persona> cantantesEncontrados = new ArrayList<>();

        List<Persona> personas = personaDAO.getAll();
        for (Persona persona : personas) {
            if (persona instanceof Cantante) {
                Cantante cantante = (Cantante) persona;
                List<Disco> discografia = cantante.getDiscografia();
                for (Disco disco : discografia) {
                    if (disco.getNombre().equals(nombreDisco)) {
                        cantantesEncontrados.add(cantante);
                        break;
                    }
                }
            }
        }

        return cantantesEncontrados;
    }

    public List<Persona> buscarCompositorPorTituloDeCancion(String tituloCancion) {
        List<Persona> compositoresEncontrados = new ArrayList<>();

        List<Persona> personas = personaDAO.getAll();
        for (Persona persona : personas) {
            if (persona instanceof Compositor) {
                Compositor compositor = (Compositor) persona;
                List<Cancion> canciones = compositor.getCanciones();
                for (Cancion cancion : canciones) {
                    if (cancion.getTitulo().equals(tituloCancion)) {
                        compositoresEncontrados.add(compositor);
                        break;
                    }
                }
            }
        }

        return compositoresEncontrados;
    }
    
}
