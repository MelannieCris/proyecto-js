package pe.edu.utp.backend.entity;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id_evento;

    @Column(length = 150, nullable = false)

    private String titulo;

    private String descripcion;

    private LocalDate fecha_evento;

    private LocalTime hora_evento;

    private String imagen;

    @Column(length = 30)

    private String estado;

    private LocalDateTime fecha_creacion;

    @ManyToOne

    @JoinColumn(name = "id_lugar")

    private Lugar lugar;
}