package com.example.demo.controllers;

import com.example.demo.models.UsuarioModel;
import com.example.demo.services.UsuarioServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;


/**
 * Para indicar que es un controller le agregamos la etiqueta RestController, y RequestMapping para idicar en que EndPoint tiene incluencia este controller
 * Traemos el UsuarioServices para acceder a todos los services permitidos. Y en el controller le especificamos a cada metodo a que tipo de metodo
 * del protocolo HTTP tiene que responder.
 */

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    UsuarioServices usuarioServices;

    /**
     * @return Retorna todos los usuarios
     */

    @GetMapping()
    public ArrayList<UsuarioModel> obtenerUsuarios(){
        return usuarioServices.obtenerUsuarios();
    }

    /**
     * Resive un usuario sin id, para tomar la informacion del cuerpo de la solicitud HTTP metodo POST usamos el RequestBody y lo guardamos en el parametro usuario.
     * @param usuario
     * @return Retorna un Usuario Con ID
     */

    @PostMapping()
    public UsuarioModel guardarUsuario(@RequestBody UsuarioModel usuario){
        return this.usuarioServices.guardarUsuario(usuario);
    }

    /**
     * De manera opcional toma un usuario por id Ej http://localhost:8080/usuario/1
     * @param id
     * @return Retorna un Usaurio que corresponde con el id indicado
     */

    @GetMapping( path = "/{id}" )
    public Optional<UsuarioModel> obtenerUsuarioPorId(@PathVariable("id") Long id){
        return this.usuarioServices.obtenerPorId(id);
    }

    /**
     * Obtenemos usuario por prioridad y lo especificamos en el query Ej
     * http://localhost8080/usuario/query?prioridad=5 despues del signo de interrogacion ponemos la variable y a que es igual su valor
     * @param prioridad
     * @return Retorana los usuarios con la prioridad indicada
     */

    @GetMapping("/query")
    public ArrayList<UsuarioModel> obtenerUsuarioPorPrioridad(@RequestParam("prioridad") Integer prioridad){
        return this.usuarioServices.obtenerPorPrioridad(prioridad);
    }


    /**
     * Elimina un usuario segun el id ingresado
     * @param id
     * @return No retorna nada solo elimina el usuario, si la eliminacion falla retorna el err
     */

    @DeleteMapping( path = "/{id}" )
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok = this.usuarioServices.elimnarUsuario(id);
        if(ok){
            return "Se elimino el usuario con id " + id;
        }else{
            return  "No pudo eliminar el ususario con id " + id;
        }
    }

}
