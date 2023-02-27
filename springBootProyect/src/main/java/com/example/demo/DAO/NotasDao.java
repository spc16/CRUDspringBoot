package com.example.demo.DAO;

import com.example.demo.modelo.ModeloNotas;
import java.util.List;


public interface NotasDao {
    List<ModeloNotas> getNotas();

    void insertarNotas(String nombre, String apellido, int nota);


    void modificarNotas(String nombre, String apellido, int nota, String id);

    void borrarNotas(int id);
}
