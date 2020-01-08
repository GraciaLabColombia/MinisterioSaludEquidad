package com.co.persistence;

import com.co.entities.AfiliacionEmpresa;
import com.co.entities.RespuestaSATARL;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

@Transactional
@Repository
public interface RespuestaSATARLRepository extends CrudRepository<RespuestaSATARL, Long>
{
    @Query("SELECT a FROM RespuestaSATARL a WHERE a.srvId = :srv AND a.estadoMin IN :estados")
    List<RespuestaSATARL> getFallidosPorSrvId(@Param("srv") BigDecimal srvId, @Param("estados") BigDecimal... estados);
}

