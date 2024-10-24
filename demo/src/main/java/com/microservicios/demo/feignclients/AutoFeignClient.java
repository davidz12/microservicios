package com.microservicios.demo.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.microservicios.demo.modelos.Auto;

@FeignClient(name="auto-service", url = "http://localhost:8001")
public interface AutoFeignClient {

    @PostMapping("/auto/guardarAuto")
    public Auto save(@RequestBody Auto auto);

}
