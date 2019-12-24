package persistence;

import entities.AfiliacionEmpresa;
import org.springframework.data.repository.CrudRepository;

public interface AfiliacionRepository extends CrudRepository<AfiliacionEmpresa, Long>
{
}
