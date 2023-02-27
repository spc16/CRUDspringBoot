package com.example.demo.controlador;

import com.example.demo.DAO.NotasDao;
import com.example.demo.modelo.ModeloNotas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NotasControlador {

    @Autowired
    private NotasDao notasDAO;

    @GetMapping("/listar")
    public List<ModeloNotas> getNotas(){
        return notasDAO.getNotas();
    }

    @GetMapping("/insertar/{nombre}/{apellido}/{nota}")
    public void insertarNotas(@PathVariable("nombre") String nombre, @PathVariable("apellido") String apellido, @PathVariable("nota") int nota){
        ModeloNotas modeloNotas = new ModeloNotas(nombre, apellido,nota);
        notasDAO.insertarNotas(nombre, apellido, nota);
    }

    @PutMapping("/modificar/{nombre}/{apellido}/{nota}/{id}")
    public void modificarNotas(@PathVariable("nombre") String nombre, @PathVariable("apellido") String apellido, @PathVariable("nota") int nota,  @PathVariable("id") String id){
        ModeloNotas modeloNotas = new ModeloNotas();
        modeloNotas.setNombre(nombre);
        modeloNotas.setApellido(apellido);
        modeloNotas.setNota(nota);
        modeloNotas.setId(Integer.parseInt(id));
        notasDAO.modificarNotas(nombre, apellido, nota, id);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarNotas(@PathVariable("id") String id){
        notasDAO.borrarNotas(Integer.parseInt(id));
    }




}


