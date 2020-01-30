package com.co.persistence;

import com.co.entities.ConsultaEmpresa;
import com.co.entities.EstructuraEmpresa;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


@Transactional
@Repository
public interface EstructuraEmpresaRepository extends CrudRepository<EstructuraEmpresa, Long>
{
    @Query("SELECT a FROM EstructuraEmpresa a WHERE a.empreId = :empreId AND a.empreTipDoc = :empreTipDoc")
    EstructuraEmpresa consultaEstructuraEmpresa(@Param("empreId") String empreId, @Param("empreTipDoc") String empreTipDoc);

    @Query("SELECT a FROM EstructuraEmpresa a WHERE a.empreId = :empreId AND a.docRepresentante = :docRepresentante")
    EstructuraEmpresa consultaEstructuraEmpresaDocRepresentante(@Param("empreId") String empreId, @Param("docRepresentante") String docRepresentante);
}
