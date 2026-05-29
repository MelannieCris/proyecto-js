package pe.edu.utp.backend.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class EventoZonaPrecioDTO {

    private Long id;

    private String tipoPrecio;

    private BigDecimal precio;

    private Integer stock;

    private Integer stockDisponible;

    private Boolean activo;

    private LocalDateTime fechaInicio;

    private LocalDateTime fechaFin;

    private Long idEvento;

    private Long idZona;
}