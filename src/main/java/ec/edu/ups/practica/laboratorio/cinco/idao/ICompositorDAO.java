/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ec.edu.ups.practica.laboratorio.cinco.idao;

import ec.edu.ups.practica.laboratorio.cinco.modelo.Compositor;
import java.util.List;

/**
 *
 * @author mateo
 */
public interface ICompositorDAO {
    void create(Compositor compositor);

    Compositor read(int codigo);

    void update(Compositor compositor);

    void delete(int codigo);

    List<Compositor> getAll();
}
