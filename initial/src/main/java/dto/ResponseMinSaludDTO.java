package dto;

public class ResponseMinSaludDTO
{
    private int status_code;
    private int resultado;

    private String mensaje;

    private String codigo;

    public int getResultado() {
        return resultado;
    }

    public String getMensaje() {
        return mensaje;
    }

    public String getCodigo() {
        return codigo;
    }

    public int getStatus_code() {
        return status_code;
    }
}
