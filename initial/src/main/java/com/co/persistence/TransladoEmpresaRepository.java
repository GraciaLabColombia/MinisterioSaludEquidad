package com.co.persistence;

import com.co.entities.TerminacionLaboral;
import com.co.entities.TransladoEmpresaArl;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

@Transactional
@Repository
public interface TransladoEmpresaRepository extends CrudRepository<TransladoEmpresaArl, Long>
{
    @Query("SELECT a FROM TransladoEmpresaArl a WHERE a.estadoMin IN :estados")
    List<TransladoEmpresaArl> getTransladoEmpresaArl(@Param("estados") BigDecimal... estado);
}