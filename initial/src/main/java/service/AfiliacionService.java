package service;

import entities.AfiliacionEmpresa;
import exception.MinSaludBusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import persistence.AfiliacionRepository;
import java.util.List;

@Component
public class AfiliacionService
{
    @Autowired
    AfiliacionRepository repository;
    public void add(AfiliacionEmpresa afiliacionEmpresa)
    {
        this.repository.save(afiliacionEmpresa);
    }

    public List<AfiliacionEmpresa> afiliaciones()
    {
        return this.repository.findAll();
    }

    public List<AfiliacionEmpresa> afiliacionPorEstado(String... estados) throws MinSaludBusinessException {
        List<AfiliacionEmpresa> result = this.repository.afiliacionesPorProcesarQuery(estados);
        if (result.size() == 0)  throw new MinSaludBusinessException("No existen afiliaciones a tratar"); else return result;
    }
}
