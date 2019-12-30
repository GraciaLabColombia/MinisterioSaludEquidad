package enums;

public enum EstadosEnum {

    EN_TRAMITE("EN_TRAMITE"), EXITOSO("EXITOSO"), FALLIDO("FALLIDO");

    private String name;

    private EstadosEnum(String name) {
        this.name = name;
    }
}
