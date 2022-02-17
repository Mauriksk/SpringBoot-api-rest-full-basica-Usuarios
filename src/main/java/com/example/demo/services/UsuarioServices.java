package com.example.demo.services;

import com.example.demo.models.UsuarioModel;
import com.example.demo.repositories.UsuarioRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

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
