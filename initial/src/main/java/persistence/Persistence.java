package persistence;

import entities.AfiliacionEmpresa;

public abstract class Persistence
{
    public static void saveAfilicion(AfiliacionRepository repository, AfiliacionEmpresa afiliacion_empresa)
    {
        repository.save(afiliacion_empresa);
    }
}
