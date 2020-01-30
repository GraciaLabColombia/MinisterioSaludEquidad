package com.co.persistence;

import com.co.entities.Empleado;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface EmpleadoRepository extends CrudRepository<Empleado, Long> {
    @Query("SELECT a FROM Empleado a WHERE a.centro.id IN :id")
    List<Empleado> getCentroBySedeId(@Param("id") BigDecimal id);
}
