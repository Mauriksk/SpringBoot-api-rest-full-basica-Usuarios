package com.example.demo.models;


import javax.persistence.*;


/**
 * En UsuarioModel creamos la representacion de la tabla en la base de datos mySQL
 * Con la etiqueta Entity le decimos a java que es un modelo real
 * Con la etiqueta Table renombramos el nombre que va a tener la tabla, que hubiera sido UsuarioModel, pero ahora
 * Pasa a ser usuario.
 */

@Entity
@Table(name = "usuario")
public class UsuarioModel {


    /**
     * Es un id, Se genera automaticamente, es unico y no puede ser null
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    private String nombre;
    private String email;
    private Integer prioridad;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    public Integer getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(Integer prioridad) {
        this.prioridad = prioridad;
    }
}
