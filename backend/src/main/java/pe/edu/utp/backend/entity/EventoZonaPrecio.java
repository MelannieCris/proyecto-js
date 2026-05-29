package pe.edu.utp.backend.entity;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

import java.time.LocalDateTime;

@Entity

@Table(name = "evento_zona_precio")

@AllArgsConstructor
@NoArgsConstructor
@Data

public class EventoZonaPrecio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    // PREVENTA - FULL - INTERBANK
    private String tipoPrecio;

    // PRECIO DE LA ENTRADA
    private BigDecimal precio;

    // STOCK TOTAL
    private Integer stock;

    // STOCK DISPONIBLE
    private Integer stockDisponible;

    // SI ESTÁ ACTIVO
    private Boolean activo;

    // FECHA INICIO VENTA
    private LocalDateTime fechaInicio;

    // FECHA FIN VENTA
    private LocalDateTime fechaFin;

    // EVENTO
    @ManyToOne

    @JoinColumn(name = "id_evento")

    private Evento evento;

    // ZONA
    @ManyToOne

    @JoinColumn(name = "id_zona")

    private Zona zona;
}