package pe.edu.utp.backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "promociones")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Promocion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_promocion")
    private Integer idPromocion;

    @Column(nullable = false, unique = true, length = 50)
    private String codigo;

    @Column(nullable = false, precision = 5, scale = 2)
    private BigDecimal descuentoPorcentaje;

    @Column(nullable = false)
    private LocalDate fechaInicio;

    @Column(nullable = false)
    private LocalDate fechaFin;

    @Column(nullable = false, length = 20)
    private String estado;

    @Column(nullable = false)
    private Integer cantidadUsos = 0;

    @Column(nullable = false)
    private Integer maximoUsos;
}