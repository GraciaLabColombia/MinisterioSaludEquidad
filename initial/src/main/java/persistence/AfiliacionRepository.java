package persistence;

import entities.AfiliacionEmpresa;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AfiliacionRepository extends CrudRepository<AfiliacionEmpresa, Long> {}
