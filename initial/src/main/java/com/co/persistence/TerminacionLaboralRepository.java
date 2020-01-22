package com.co.persistence;

import com.co.entities.InicioLaboral;
import com.co.entities.TerminacionLaboral;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;


@Transactional
@Repository
public interface TerminacionLaboralRepository extends CrudRepository<TerminacionLaboral, Long>
{
    @Query("SELECT a FROM TerminacionLaboral a WHERE a.estadoMin IN :estados")
    List<TerminacionLaboral> getTerminacionesLaborales(@Param("estados") BigDecimal... estado);
}
