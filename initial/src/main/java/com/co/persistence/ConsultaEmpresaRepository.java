package com.co.persistence;

import com.co.entities.ConsultaEmpresa;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface ConsultaEmpresaRepository extends CrudRepository<ConsultaEmpresa, Long> { }
