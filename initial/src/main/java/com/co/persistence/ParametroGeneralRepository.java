package com.co.persistence;

import com.co.entities.ParametroGeneral;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.math.BigDecimal;

@Transactional
@Repository
public interface ParametroGeneralRepository extends CrudRepository<ParametroGeneral, Long> {

    @Query("SELECT a FROM ParametroGeneral a WHERE a.parametro = :parametro AND a.activo = :activo AND a.documento = :documento")
    ParametroGeneral getParametroGeneralPorParametroAndDocumento(@Param("parametro") String parametro, @Param("activo") BigDecimal activo, @Param("documento") String documento);
}
