package com.example.demo.modelo;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;


@Data
@Table(name="dbalumnos")
@Entity
@ToString
@EqualsAndHashCode
public class ModeloNotas {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "Nombre")
    private String nombre;

    @Column(name = "Apellidos")
    private String apellido;

    @Column(name = "Nota")
    private int nota;

    public ModeloNotas(int id, String nombre, String apellido, int nota) {
    }

    public ModeloNotas(String nombre, String apellido, int nota) {
    }

    public ModeloNotas() {
    }
}
