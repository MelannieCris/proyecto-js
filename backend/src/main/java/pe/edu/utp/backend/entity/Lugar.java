package pe.edu.utp.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Lugar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_lugar;

    @Column(length = 150)
    private String nombre;
    @Column(length = 150)
    private String direccion;
    @Column(length = 150)
    private String ciudad;
    private Integer capacidad_total;
}
