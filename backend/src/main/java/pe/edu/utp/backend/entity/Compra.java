package pe.edu.utp.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_compra;

    private LocalDate fecha_compra;

    private Double total;

    @Column(length = 20)
    private String estado;

    @ManyToMany
    private Set<Usuario> usuarios;

    @ManyToOne
    @JoinColumn(name = "id_promocion")
    private Promocion promocion;
}
