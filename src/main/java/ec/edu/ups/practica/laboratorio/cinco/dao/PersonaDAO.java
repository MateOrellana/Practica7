/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.practica.laboratorio.cinco.dao;

import ec.edu.ups.practica.laboratorio.cinco.modelo.Persona;
import java.util.List;
import ec.edu.ups.practica.laboratorio.cinco.idao.IPersonaDAO;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author mateo
 */
public class PersonaDAO implements IPersonaDAO{
    private static final int MAX_PERSONAS = 10;
    private static final String PERSONA_FILE = "personas.bin";

    private List<Persona> personas;

    public PersonaDAO() {
        this.personas = new ArrayList<>();
        loadPersonasFromFile();
    }

    @Override
    public void create(Persona persona) {
        if (personas.size() < MAX_PERSONAS) {
            personas.add(persona);
            savePersonasToFile();
        } else {
            System.out.println("No es posible agregar más personas. Límite alcanzado.");
        }
    }

    @Override
    public Persona read(int codigo) {
        for (Persona persona : personas) {
            if (persona.getCodigo() == codigo) {
                return persona;
            }
        }
        return null;
    }

    @Override
    public void update(Persona persona) {
        for (int i = 0; i < personas.size(); i++) {
            if (personas.get(i).getCodigo() == persona.getCodigo()) {
                personas.set(i, persona);
                savePersonasToFile();
                break;
            }
        }
    }

    @Override
    public void delete(int codigo) {
        personas.removeIf(persona -> persona.getCodigo() == codigo);
        savePersonasToFile();
    }

    @Override
    public List<Persona> getAll() {
        return personas;
    }

    private void loadPersonasFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(PERSONA_FILE))) {
            personas = (List<Persona>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            personas = new ArrayList<>();
        }
    }

    private void savePersonasToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(PERSONA_FILE))) {
            oos.writeObject(personas);
        } catch (IOException e) {
            System.out.println("Error al guardar personas en el archivo.");
        }
    }
}
