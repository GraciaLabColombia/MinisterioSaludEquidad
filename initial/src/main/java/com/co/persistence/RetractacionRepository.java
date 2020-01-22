package com.co.persistence;

import com.co.entities.RetiroDefinitivoSGRL;
import com.co.entities.Retractacion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

@Transactional
@Repository
public interface RetractacionRepository extends CrudRepository<Retractacion, Long> {
    @Query("SELECT a FROM Retractacion a WHERE a.estadoMin IN :estados")
    List<Retractacion> getAllRetractacionEstado(BigDecimal... estados);
}
