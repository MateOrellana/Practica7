/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.practica.laboratorio.cinco.controlador;

import ec.edu.ups.practica.laboratorio.cinco.modelo.Cancion;
import ec.edu.ups.practica.laboratorio.cinco.modelo.Compositor;
import java.util.List;
import ec.edu.ups.practica.laboratorio.cinco.idao.ICompositorDAO;

/**
 *
 * @author mateo
 */
public class ControladorCompositor {
    private ICompositorDAO compositorDAO;

    public ControladorCompositor(ICompositorDAO compositorDAO) {
        this.compositorDAO = compositorDAO;
    }

    public void agregarCompositor(int codigo, String nombre, String apellido, int edad, String nacionalidad,
                                  double salario, int numeroDeComposiciones) {
        Compositor compositor = new Compositor(codigo, nombre, apellido, edad, nacionalidad, salario, numeroDeComposiciones);
        compositorDAO.create(compositor);
    }

    public boolean actualizarCompositor(int codigo, String nombre, String apellido, int edad, String nacionalidad,
                                     double salario, int numeroDeComposiciones) {
        Compositor compositor = compositorDAO.read(codigo);
        if (compositor != null) {
            compositor.setNombre(nombre);
            compositor.setApellido(apellido);
            compositor.setEdad(edad);
            compositor.setNacionalidad(nacionalidad);
            compositor.setSalario(salario);
            compositor.setNumeroDeComposiciones(numeroDeComposiciones);
            compositorDAO.update(compositor);
            return true;
        }
        return false;
    }

    public boolean eliminarCompositor(int codigo) {
        Compositor compositor = compositorDAO.read(codigo);
        if (compositor != null) {
            compositorDAO.delete(codigo);
            return true;
        }
        return false;
    }
    
    public Compositor buscarCompositorPorCodigo(int codigo) {
        return compositorDAO.read(codigo);
    }
    
    public Compositor buscarCompositorPorNombreCancion(String nombreCancion) {
        List<Compositor> compositores = compositorDAO.getAll();
        for (Compositor compositor : compositores) {
            List<Cancion> canciones = compositor.getCanciones();
            for (Cancion cancion : canciones) {
                if (cancion.getTitulo().equalsIgnoreCase(nombreCancion)) {
                    return compositor;
                }
            }
        }
        return null;
    }

    public List<Compositor> listar() {
        return compositorDAO.getAll();
    }
}
