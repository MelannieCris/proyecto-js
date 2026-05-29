package pe.edu.utp.backend.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PromocionResponse {

    private boolean valido;
    private String mensaje;
    private BigDecimal descuento;

}