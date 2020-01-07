package com.co.persistence;

import com.co.entities.RespuestaSATARL;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface RespuestaSATARLRepository extends CrudRepository<RespuestaSATARL, Long>
{
}

