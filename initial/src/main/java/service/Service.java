package service;

import entities.AfiliacionEmpresa;
import entities.InicioLaboral;
import entities.TerminacionLaboral;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import persistence.AfiliacionRepository;
import persistence.InicioLaboralRepository;
import persistence.TerminacionLaboralRepository;

import java.util.List;

@Component
public class Service
{
    @Autowired
    AfiliacionRepository repository;

    @Autowired
    InicioLaboralRepository inicioLaboralRepository;

    @Autowired
    TerminacionLaboralRepository terminacionLaboralRepository;

    public void add(AfiliacionEmpresa afiliacionEmpresa)
    {
        this.repository.save(afiliacionEmpresa);
    }

    public List<AfiliacionEmpresa> afiliaciones()
    {
        return (List<AfiliacionEmpresa>) this.repository.findAll();
    }

    public void add(InicioLaboral inicioLaboral)
    {
        this.inicioLaboralRepository.save(inicioLaboral);
    }

    public List<InicioLaboral> inicioLaborales()
    {
        return (List<InicioLaboral>) this.inicioLaboralRepository.findAll();
    }

    public void add(TerminacionLaboral terminacionLaboral)
    {
        this.terminacionLaboralRepository.save(terminacionLaboral);
    }

    public List<TerminacionLaboral> terminacionLaborales()
    {
        return (List<TerminacionLaboral>) this.terminacionLaboralRepository.findAll();
    }
}
