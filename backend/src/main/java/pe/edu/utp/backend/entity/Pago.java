package pe.edu.utp.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_pago;
    @Column(length = 150)
    private String metodo_pago;
    private Double monto ;
    private LocalDateTime fecha_pago ;
    @Column(length = 150)
    private String estado ;
    @Column(length = 150)
    private String codigo_transaccion;
    @OneToMany
    private Set<Compra> compras;
}
