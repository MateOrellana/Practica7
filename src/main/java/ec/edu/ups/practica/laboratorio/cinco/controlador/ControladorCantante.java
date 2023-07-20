/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.practica.laboratorio.cinco.controlador;

import ec.edu.ups.practica.laboratorio.cinco.modelo.Cantante;
import ec.edu.ups.practica.laboratorio.cinco.modelo.Disco;
import java.util.List;
import ec.edu.ups.practica.laboratorio.cinco.idao.ICantanteDAO;

/**
 *
 * @author mateo
 */
public class ControladorCantante {
    private ICantanteDAO cantanteDAO;

    public ControladorCantante(ICantanteDAO cantanteDAO) {
        this.cantanteDAO = cantanteDAO;
    }

    public void agregarCantante(int codigo, String nombre, String apellido, int edad, String nacionalidad,
                                double salario, String nombreArtistico, String generoMusical,
                                int numeroDeSencillos, int numeroDeConciertos, int numeroDeGiras) {
        Cantante cantante = new Cantante(codigo, nombre, apellido, edad, nacionalidad, salario, nombreArtistico,
                generoMusical, numeroDeSencillos, numeroDeConciertos, numeroDeGiras);
        cantanteDAO.create(cantante);
    }

    public boolean actualizarCantante(int codigo, String nombre, String apellido, int edad, String nacionalidad,
                                   double salario, String nombreArtistico, String generoMusical,
                                   int numeroDeSencillos, int numeroDeConciertos, int numeroDeGiras) {
        Cantante cantante = cantanteDAO.read(codigo);
        if (cantante != null) {
            cantante.setNombre(nombre);
            cantante.setApellido(apellido);
            cantante.setEdad(edad);
            cantante.setNacionalidad(nacionalidad);
            cantante.setSalario(salario);
            cantante.setNombreArtistico(nombreArtistico);
            cantante.setGeneroMusical(generoMusical);
            cantante.setNumeroDeSencillos(numeroDeSencillos);
            cantante.setNumeroDeConciertos(numeroDeConciertos);
            cantante.setNumeroDeGiras(numeroDeGiras);
            cantanteDAO.update(cantante);
            return true;
        }
        return false;
    }

    public boolean eliminarCantante(int codigo) {
        Cantante cantante = cantanteDAO.read(codigo);
        if (cantante != null) {
            cantanteDAO.delete(codigo);
            return true;
        }
        return false;
    }
    
    public Cantante buscarCantantePorCodigo(int codigo) {
        return cantanteDAO.read(codigo);
    }
    
    public Cantante buscarCantantePorNombreDisco(String nombreDisco) {
        List<Cantante> cantantes = cantanteDAO.getAll();
        for (Cantante cantante : cantantes) {
            List<Disco> discografia = cantante.getDiscografia();
            for (Disco disco : discografia) {
                if (disco.getNombre().equalsIgnoreCase(nombreDisco)) {
                    return cantante;
                }
            }
        }
        return null;
    }

    public List<Cantante> listar(){
        return cantanteDAO.getAll();
    }
}
