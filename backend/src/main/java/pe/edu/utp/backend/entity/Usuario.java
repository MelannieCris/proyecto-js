package pe.edu.utp.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_usuario;

    @Column(length = 100, nullable = false)
    private String nombre;
    @Column(length = 100, nullable = false)
    private String apellido;
    @Column(length = 150, unique = true)
    private String correo;
    @Column(length = 100, nullable = false)
    private String contrasena;
    @Column(length = 10 )
    private String telefono;
    @Column(length = 20 )
    private String estado;

    private LocalDate fecha_registro;

    @ManyToOne
    @JoinColumn(name = "id_rol")
    private Rol rol;
}
