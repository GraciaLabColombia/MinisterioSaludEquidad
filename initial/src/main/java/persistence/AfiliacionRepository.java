package persistence;

import entities.AfiliacionEmpresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AfiliacionRepository extends JpaRepository<AfiliacionEmpresa, Long>
{
    List<AfiliacionEmpresa> afiliacionesPorProcesarQuery(@Param("estados") String... estados);
}
