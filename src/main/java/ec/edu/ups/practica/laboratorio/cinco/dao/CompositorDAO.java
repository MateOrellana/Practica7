/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.practica.laboratorio.cinco.dao;

import ec.edu.ups.practica.laboratorio.cinco.modelo.Compositor;
import java.util.List;
import ec.edu.ups.practica.laboratorio.cinco.idao.ICompositorDAO;
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
public class CompositorDAO implements ICompositorDAO{
    private static final int MAX_COMPOSITORES = 10;
    private static final String COMPOSITOR_FILE = "compositores.bin";

    private List<Compositor> compositores;

    public CompositorDAO() {
        this.compositores = new ArrayList<>();
        loadCompositoresFromFile();
    }

    @Override
    public void create(Compositor compositor) {
        if (compositores.size() < MAX_COMPOSITORES) {
            compositores.add(compositor);
            saveCompositoresToFile();
        } else {
            System.out.println("No es posible agregar más compositores. Límite alcanzado.");
        }
    }

    @Override
    public Compositor read(int codigo) {
        for (Compositor compositor : compositores) {
            if (compositor.getCodigo() == codigo) {
                return compositor;
            }
        }
        return null;
    }

    @Override
    public void update(Compositor compositor) {
        for (int i = 0; i < compositores.size(); i++) {
            if (compositores.get(i).getCodigo() == compositor.getCodigo()) {
                compositores.set(i, compositor);
                saveCompositoresToFile();
                break;
            }
        }
    }

    @Override
    public void delete(int codigo) {
        compositores.removeIf(compositor -> compositor.getCodigo() == codigo);
        saveCompositoresToFile();
    }

    @Override
    public List<Compositor> getAll() {
        return compositores;
    }

    private void loadCompositoresFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(COMPOSITOR_FILE))) {
            compositores = (List<Compositor>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            compositores = new ArrayList<>();
        }
    }

    private void saveCompositoresToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(COMPOSITOR_FILE))) {
            oos.writeObject(compositores);
        } catch (IOException e) {
            System.out.println("Error al guardar compositores en el archivo.");
        }
    }
}
