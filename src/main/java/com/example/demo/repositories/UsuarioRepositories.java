package com.example.demo.repositories;

import com.example.demo.models.UsuarioModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * El UsuarioRepositories es el que se encargara de implementar la interaccion con la base de datos, como va a implementar metodos
 * es una interface. Y esta la extendemos de CrudRepository el cual nos proporciona todos los metodos que necesitamos de
 * manera muy agil y practica. A este solo debemos indicarle que tipo de dato es (El cual es de tipo UsuarioModel) y el tipo
 * de identificador que es un tipo Long.
 */

@Repository
public interface UsuarioRepositories extends CrudRepository<UsuarioModel, Long> {
    /**
     * Toma todos los usuarios y los filtra por prioridad
     * @param prioridad
     * @return Retorna los usuarios con la prioridad asignada
     */
    public abstract ArrayList<UsuarioModel> findByPrioridad(Integer prioridad);
}
