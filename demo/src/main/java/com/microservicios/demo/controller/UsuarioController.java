package com.microservicios.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservicios.demo.entity.Usuario;
import com.microservicios.demo.modelos.Auto;
import com.microservicios.demo.modelos.Moto;
import com.microservicios.demo.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/usuarios")
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        List<Usuario> listaUsuarios = usuarioService.getAll();
        ResponseEntity<List<Usuario>> salida;

        if (listaUsuarios.isEmpty()) {
            salida = ResponseEntity.noContent().build();
        }
        salida = ResponseEntity.ok(listaUsuarios);

        return salida;
        }

        @PostMapping("/guardarUsuario")
        public ResponseEntity<Usuario> guardarUsuario(@RequestBody Usuario usuario){
            Usuario nuevoUsuario = usuarioService.save(usuario);
            return ResponseEntity.ok(nuevoUsuario);
        }

        @GetMapping("/usuario/{id}")
        public ResponseEntity<Usuario> obtenerUsuario(@PathVariable("id") int id){
            Usuario usuario = usuarioService.getUsuario(id);
            ResponseEntity<Usuario> salida;
            
            if (usuario == null) {
                salida = ResponseEntity.notFound().build();
            }
            salida = ResponseEntity.ok(usuario);

            return salida;
        }


        @PostMapping("/guardarAuto/{userId}")
        public ResponseEntity<Auto>  saveAuto(@PathVariable("userId") int userId, @RequestBody Auto auto){
            auto.setUserId(userId);
            Auto nuevoAuto = usuarioService.saveAuto(userId, auto);
            return ResponseEntity.ok(nuevoAuto);
        }

        @PostMapping("/guardarMoto/{userId}")
        public ResponseEntity<Moto> saveMoto(@PathVariable("userId") int userId, @RequestBody Moto moto){
            moto.setUserId(userId);
            Moto nuevaMoto = usuarioService.saveMoto(userId, moto);
            return ResponseEntity.ok(nuevaMoto);
        }
}
