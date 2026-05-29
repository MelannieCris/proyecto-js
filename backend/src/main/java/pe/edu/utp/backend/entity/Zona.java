package pe.edu.utp.backend.entity;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Zona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id_zona;

    @Column(length = 50, nullable = false)

    private String nombre_zona;

    private Integer capacidad;

    @Column(length = 30)

    private String estado;
}