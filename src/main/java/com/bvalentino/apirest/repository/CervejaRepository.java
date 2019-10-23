package com.bvalentino.apirest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bvalentino.apirest.model.Cerveja;

public interface CervejaRepository extends JpaRepository<Cerveja, Long>{

	Optional<Cerveja> findById(Long id);
}
