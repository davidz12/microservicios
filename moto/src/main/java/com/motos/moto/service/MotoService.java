package com.motos.moto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.motos.moto.repository.MotoRepositoryI;
import com.motos.moto.entity.Moto;

@Service
public class MotoService {

    @Autowired
    MotoRepositoryI motoRepo;

    public List<Moto> getAll(){
        return motoRepo.findAll();
    }

    public Moto save(Moto usuario){
        Moto nuevaMoto = motoRepo.save(usuario);
        return nuevaMoto;
    }

    public Moto getMoto(int id){
        return motoRepo.findById(id).orElse(null);
    }
}
