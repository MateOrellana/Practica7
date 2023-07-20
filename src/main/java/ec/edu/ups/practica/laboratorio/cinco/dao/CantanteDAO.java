/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.practica.laboratorio.cinco.dao;

import ec.edu.ups.practica.laboratorio.cinco.modelo.Cantante;
import java.util.List;
import ec.edu.ups.practica.laboratorio.cinco.idao.ICantanteDAO;
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
public class CantanteDAO implements ICantanteDAO{
    private static final int MAX_CANTANTES = 10;
    private static final String CANTANTE_FILE = "cantantes.bin";

    private List<Cantante> cantantes;

    public CantanteDAO() {
        this.cantantes = new ArrayList<>();
        loadCantantesFromFile();
    }

    @Override
    public void create(Cantante cantante) {
        if (cantantes.size() < MAX_CANTANTES) {
            cantantes.add(cantante);
            saveCantantesToFile();
        } else {
            System.out.println("No es posible agregar más cantantes. Límite alcanzado.");
        }
    }

    @Override
    public Cantante read(int codigo) {
        for (Cantante cantante : cantantes) {
            if (cantante.getCodigo() == codigo) {
                return cantante;
            }
        }
        return null;
    }

    @Override
    public void update(Cantante cantante) {
        for (int i = 0; i < cantantes.size(); i++) {
            if (cantantes.get(i).getCodigo() == cantante.getCodigo()) {
                cantantes.set(i, cantante);
                saveCantantesToFile();
                break;
            }
        }
    }

    @Override
    public void delete(int codigo) {
        cantantes.removeIf(cantante -> cantante.getCodigo() == codigo);
        saveCantantesToFile();
    }

    @Override
    public List<Cantante> getAll() {
        return cantantes;
    }

    private void loadCantantesFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(CANTANTE_FILE))) {
            cantantes = (List<Cantante>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            cantantes = new ArrayList<>();
        }
    }

    private void saveCantantesToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(CANTANTE_FILE))) {
            oos.writeObject(cantantes);
        } catch (IOException e) {
            System.out.println("Error al guardar cantantes en el archivo.");
        }
    }
}
