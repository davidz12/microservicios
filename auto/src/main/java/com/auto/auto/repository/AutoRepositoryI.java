package com.auto.auto.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.auto.auto.entity.Auto;

@Repository
public interface AutoRepositoryI extends JpaRepository<Auto,Integer>{
    Optional<Auto> findById(int id);

}
