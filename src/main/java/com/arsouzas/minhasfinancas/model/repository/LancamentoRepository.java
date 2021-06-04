package com.arsouzas.minhasfinancas.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arsouzas.minhasfinancas.model.entity.Lancamento;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long>{

}
