package com.co.persistence;

import com.co.entities.ReclasificacionCentroTrabajo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface ReclasificacionCentroTrabajoRepository extends CrudRepository<ReclasificacionCentroTrabajo, Long> {
}
