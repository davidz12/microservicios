package com.auto.auto.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.auto.auto.entity.Auto;
import com.auto.auto.repository.AutoRepositoryI;

@Service
public class AutoService {

    @Autowired
    AutoRepositoryI autoRepo;


    public List<Auto> getAll(){
        return autoRepo.findAll();
    }

    public Auto save(Auto auto){
        Auto nuevoAuto = autoRepo.save(auto);
        return nuevoAuto;
    }

    public Auto getAuto(int id){
        return autoRepo.findById(id).orElse(null);
    }
}

