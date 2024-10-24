package com.motos.moto.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.motos.moto.entity.Moto;

@Repository
public interface MotoRepositoryI extends JpaRepository<Moto,Integer>{
    Optional<Moto> findById(int id);

}
