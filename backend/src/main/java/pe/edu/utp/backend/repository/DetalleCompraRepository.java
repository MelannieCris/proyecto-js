package pe.edu.utp.backend.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.utp.backend.entity.DetalleCompra;
@Repository
public interface DetalleCompraRepository extends JpaRepository<DetalleCompra, Long> {
}
