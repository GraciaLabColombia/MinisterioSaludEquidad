package com.co.persistence;

import com.co.entities.CentroTrabajo;
import com.co.entities.Sede;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface CentroRepository extends CrudRepository<CentroTrabajo, Long> {
    @Query("SELECT a FROM CentroTrabajo a WHERE a.sede.id IN :id")
    List<CentroTrabajo> getCentroBySedeId(@Param("id") BigDecimal id);
}
