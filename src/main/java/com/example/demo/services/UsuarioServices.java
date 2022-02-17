package com.example.demo.services;

import com.example.demo.models.UsuarioModel;
import com.example.demo.repositories.UsuarioRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

/**
 * UsuarioServices es una clase de tipo Service, esta para poder implementar el repository, inicializamos una variable de tipo
 * UsuarioRepositories y le ponemos @AutoWired para que java sepa que ya existe una instancia y que es esta de la cual debe instanciar la variable.
 */

@Service
public class UsuarioServices {
    @Autowired
    UsuarioRepositories usuarioRepositories;

    public ArrayList<UsuarioModel> obtenerUsuarios(){
        return (ArrayList<UsuarioModel>) usuarioRepositories.findAll();
    }

    public UsuarioModel guardarUsuario(UsuarioModel usuario){
        return usuarioRepositories.save(usuario);
    }

    public Optional<UsuarioModel> obtenerPorId(Long id){
        return usuarioRepositories.findById(id);
    }

    public boolean borrarTodosUsuarios(){
        try {
            usuarioRepositories.deleteAll();
            return true;
        }catch (Exception err){
            return false;
        }

    }

    public ArrayList<UsuarioModel> obtenerPorPrioridad(Integer prioridad){
        return usuarioRepositories.findByPrioridad(prioridad);
    }

    public boolean elimnarUsuario(Long id){
        try{
            usuarioRepositories.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }

}
