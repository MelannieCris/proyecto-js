package pe.edu.utp.backend.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class DetalleCompraDTO {

    private Long idDetalle;

    private Integer cantidad;

    private BigDecimal precioUnitario;

    private BigDecimal subtotal;

    private Long idCompra;

    private Long idEventoZonaPrecio;
}