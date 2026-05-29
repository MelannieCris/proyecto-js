package pe.edu.utp.backend.service;
import pe.edu.utp.backend.entity.Pago;
import java.util.List;
import java.util.Optional;
public interface PagoService {

    Pago guardarpago (Pago Pago);
    Optional<Pago> getId(Long id);
    List<Pago> getall();

}