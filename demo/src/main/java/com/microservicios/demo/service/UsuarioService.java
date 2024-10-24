package com.microservicios.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservicios.demo.entity.Usuario;
import com.microservicios.demo.feignclients.AutoFeignClient;
import com.microservicios.demo.feignclients.MotoFeignClient;
import com.microservicios.demo.modelos.Auto;
import com.microservicios.demo.modelos.Moto;
import com.microservicios.demo.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepo;

    @Autowired
    private AutoFeignClient autoFeign;

    @Autowired
    private MotoFeignClient motoFeign;

    public List<Usuario> getAll(){
        return usuarioRepo.findAll();
    }

    public Usuario save(Usuario usuario){
        Usuario nuevoUsuario = usuarioRepo.save(usuario);
        return nuevoUsuario;
    }

    public Usuario getUsuario(int id){
        return usuarioRepo.findById(id).orElse(null);
    }

    public Auto saveAuto(int userId, Auto auto){
        auto.setUserId(userId);
        Auto nuevoAuto = autoFeign.save(auto);
        return nuevoAuto;
    }

    public Moto saveMoto(int userId, Moto moto) {
        moto.setUserId(userId);
        Moto nuevaMoto = motoFeign.save(moto);
        return nuevaMoto;
    }
}
