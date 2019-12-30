package persistence;

import entities.ParametroGeneral;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ParametrosGeneralesRepository extends CrudRepository<ParametroGeneral, Long>
{
    List<ParametroGeneral> keyParameters(@Param("key") String key);
}
