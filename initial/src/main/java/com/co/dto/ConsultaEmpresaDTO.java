package com.co.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties({"numero_documento_empleador", "tipo_documento_empleador", "tipo_reporte",
        "fecha_solicitud", "consecutivo_nit_descentralizado", "fecha_fin_afiliacion"})
public class ConsultaEmpresaDTO
{
    private String TipoDocumentoEmpleador;

    private String NumeroDocumentoEmpleador;

    private String ConsecutivoNitDescentralizado;

    private String FechaSolicitud;

    private String FechaFinAfiliacion;

    private String TipoReporte;

    public ConsultaEmpresaDTO() {
    }

    public String getTipoDocumentoEmpleador() {
        return TipoDocumentoEmpleador;
    }

    @JsonProperty("TipoDocumentoEmpleador")
    public void setTipoDocumentoEmpleador(String tipoDocumentoEmpleador) {
        TipoDocumentoEmpleador = tipoDocumentoEmpleador;
    }

    public String getNumeroDocumentoEmpleador() {
        return NumeroDocumentoEmpleador;
    }

    @JsonProperty("NumeroDocumentoEmpleador")
    public void setNumeroDocumentoEmpleador(String numeroDocumentoEmpleador) {
        NumeroDocumentoEmpleador = numeroDocumentoEmpleador;
    }

    public String getConsecutivoNitDescentralizado() {
        return ConsecutivoNitDescentralizado;
    }

    @JsonProperty("ConsecutivoNitDescentralizado")
    public void setConsecutivoNitDescentralizado(String consecutivoNitDescentralizado) {
        ConsecutivoNitDescentralizado = consecutivoNitDescentralizado;
    }

    public String getFechaSolicitud() {
        return FechaSolicitud;
    }

    @JsonProperty("FechaSolicitud")
    public void setFechaSolicitud(String fechaSolicitud) {
        FechaSolicitud = fechaSolicitud;
    }

    public String getFechaFinAfiliacion() {
        return FechaFinAfiliacion;
    }

    @JsonProperty("FechaFinAfiliacion")
    public void setFechaFinAfiliacion(String fechaFinAfiliacion) {
        FechaFinAfiliacion = fechaFinAfiliacion;
    }

    public String getTipoReporte() {
        return TipoReporte;
    }

    @JsonProperty("TipoReporte")
    public void setTipoReporte(String tipoReporte) {
        TipoReporte = tipoReporte;
    }
}
