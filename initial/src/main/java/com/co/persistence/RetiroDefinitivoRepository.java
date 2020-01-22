package com.co.persistence;

import com.co.entities.RespuestaSATARL;
import com.co.entities.RetiroDefinitivoSGRL;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface RetiroDefinitivoRepository extends CrudRepository<RetiroDefinitivoSGRL, Long> {
}
