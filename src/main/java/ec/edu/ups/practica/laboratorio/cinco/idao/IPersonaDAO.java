/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ec.edu.ups.practica.laboratorio.cinco.idao;

import ec.edu.ups.practica.laboratorio.cinco.modelo.Persona;
import java.util.List;

/**
 *
 * @author mateo
 */
public interface IPersonaDAO {
    void create(Persona persona);
    
    Persona read(int codigo);
    
    void update(Persona persona);
    
    void delete(int codigo);
    
    List<Persona> getAll();
}
