package persistence;

import entities.TerminacionLaboral;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TerminacionLaboralRepository extends CrudRepository<TerminacionLaboral, Long> {}
