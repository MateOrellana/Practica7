/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ec.edu.ups.practica.laboratorio.cinco.idao;

import ec.edu.ups.practica.laboratorio.cinco.modelo.Cantante;
import java.util.List;

/**
 *
 * @author mateo
 */
public interface ICantanteDAO {
    void create(Cantante cantante);

    Cantante read(int codigo);

    void update(Cantante cantante);

    void delete(int codigo);

    List<Cantante> getAll();
}
