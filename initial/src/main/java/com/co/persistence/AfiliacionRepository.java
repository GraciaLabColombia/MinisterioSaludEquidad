package com.co.persistence;

import com.co.entities.AfiliacionEmpresa;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

@Transactional
@Repository
public interface AfiliacionRepository extends CrudRepository<AfiliacionEmpresa, Long>
{
    @Query("SELECT a FROM AfiliacionEmpresa a WHERE a.estadoMin IN :estados")
    List<AfiliacionEmpresa> afiliacionesPorProcesarQuery(@Param("estados") BigDecimal... estados);
}
