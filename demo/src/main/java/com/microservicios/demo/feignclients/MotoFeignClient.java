package com.microservicios.demo.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.microservicios.demo.modelos.Moto;

@FeignClient(name = "moto-service", url = "http://localhost:8002")
public interface MotoFeignClient {

    @PostMapping("/moto/guardarMoto")
    public Moto save(@RequestBody Moto moto);
}
