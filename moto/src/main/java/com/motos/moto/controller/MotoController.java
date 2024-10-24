package com.motos.moto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.motos.moto.service.MotoService;

import com.motos.moto.entity.Moto;

@RestController
@RequestMapping("/moto")
public class MotoController {


    @Autowired
    MotoService motoService;

     @GetMapping("/motos")
    public ResponseEntity<List<Moto>> listarMotos() {
        List<Moto> listaMotos = motoService.getAll();
        ResponseEntity<List<Moto>> salida;

        if (listaMotos.isEmpty()) {
            salida = ResponseEntity.noContent().build();
        }
        salida = ResponseEntity.ok(listaMotos);

        return salida;
        }

        @PostMapping("/guardarMoto")
        public ResponseEntity<Moto> guardarMoto(@RequestBody Moto moto){
            Moto nuevaMoto = motoService.save(moto);
            return ResponseEntity.ok(nuevaMoto);
        }

        @GetMapping("/moto/{id}")
        public ResponseEntity<Moto> obtenerMoto(@PathVariable("id") int id){
            Moto moto = motoService.getMoto(id);
            ResponseEntity<Moto> salida;
            
            if (moto == null) {
                salida = ResponseEntity.notFound().build();
            }
            salida = ResponseEntity.ok(moto);

            return salida;
        }
}
