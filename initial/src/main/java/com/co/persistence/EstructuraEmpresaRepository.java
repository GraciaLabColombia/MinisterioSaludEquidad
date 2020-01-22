package com.co.persistence;

import com.co.entities.EstructuraEmpresa;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Transactional
@Repository
public interface EstructuraEmpresaRepository extends CrudRepository<EstructuraEmpresa, Long> { }
