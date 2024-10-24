package com.auto.auto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auto.auto.service.AutoService;
import com.auto.auto.entity.Auto;

@RestController
@RequestMapping("/auto")
public class AutoController {

    @Autowired
    AutoService autoService;

    @GetMapping("/autos")
    public ResponseEntity<List<Auto>> listarAutos() {
        List<Auto> listaAutos = autoService.getAll();
        ResponseEntity<List<Auto>> salida;

        if (listaAutos.isEmpty()) {
            salida = ResponseEntity.noContent().build();
        }
        salida = ResponseEntity.ok(listaAutos);

        return salida;
        }

        @PostMapping("/guardarAuto")
        public ResponseEntity<Auto> guardarAuto(@RequestBody Auto auto){
            Auto nuevoAuto = autoService.save(auto);
            return ResponseEntity.ok(nuevoAuto);
        }

        @GetMapping("/auto/{id}")
        public ResponseEntity<Auto> obtenerAuto(@PathVariable("id") int id){
            Auto auto = autoService.getAuto(id);
            ResponseEntity<Auto> salida;
            
            if (auto == null) {
                salida = ResponseEntity.notFound().build();
            }
            salida = ResponseEntity.ok(auto);

            return salida;
        }
}
