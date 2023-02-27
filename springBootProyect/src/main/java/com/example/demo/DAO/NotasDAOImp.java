package com.example.demo.DAO;

import com.example.demo.modelo.ModeloNotas;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository

@Transactional
public class NotasDAOImp implements NotasDao{

    @PersistenceContext
    EntityManager entityManager;
    @Override
    public List<ModeloNotas> getNotas() {
        String query="FROM ModeloNotas";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void insertarNotas(String nombre, String apellido, int nota) {
        ModeloNotas modeloNotas = new ModeloNotas(nombre, apellido,nota);
        modeloNotas.setNombre(nombre);
        modeloNotas.setApellido(apellido);
        modeloNotas.setNota(nota);
        entityManager.persist(modeloNotas);
    }

    @Override
    public void modificarNotas(String nombre, String apellido, int nota, String id) {
        ModeloNotas modeloNotas = entityManager.find(ModeloNotas.class, Integer.parseInt(id));
        modeloNotas.setNombre(nombre);
        modeloNotas.setApellido(apellido);
        modeloNotas.setNota(nota);
        entityManager.merge(modeloNotas);
    }

    @Override
    public void borrarNotas(int id) {
        ModeloNotas modeloNotas = entityManager.find(ModeloNotas.class, id);
        entityManager.remove(modeloNotas);
    }
}
