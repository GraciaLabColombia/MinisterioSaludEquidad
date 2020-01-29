package com.co.persistence;

import com.co.entities.ConsultaEmpresa;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface ConsultaEmpresaRepository extends CrudRepository<ConsultaEmpresa, Long>
{
    @Query("SELECT a FROM ConsultaEmpresa a WHERE a.fecIniCobertura BETWEEN :fecToday AND :today")
    List<ConsultaEmpresa> consultaEmpresaPorFechaCobertura( @Param("fecToday") String fecToday, @Param("today") String today);

    @Query("SELECT a FROM ConsultaEmpresa a WHERE a.tipoDocumentoEmpleador = :tipoDocumento AND a.numeroDocumentoEmpleador = :numeroDocumentoEmpleador")
    ConsultaEmpresa consultaEmpresaPorTipoYNumeroDocumento(@Param("tipoDocumento") String tipoDocumento, @Param("numeroDocumentoEmpleador") String numeroDocumentoEmpleador);
}
