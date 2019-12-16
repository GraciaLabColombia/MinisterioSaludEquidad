package controllerentity;

import java.io.Serializable;

public class ServicioAfiliacionControllerEntity implements Serializable
{
    private String name;

    public ServicioAfiliacionControllerEntity() { }

    public String getName()
    {
        return this.name;
    }

    @Override
    public String toString()
    {
        return "ServicioAfiliacionControllerEntity{" +
                "name='" + name + '\'' +
                '}';
    }
}
